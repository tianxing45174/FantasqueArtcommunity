package com.fantasque.fanmall.order.aop;

import com.fantasque.fanmall.order.annotation.Lock;
import com.fantasque.fanmall.order.annotation.ReadLock;
import com.fantasque.fanmall.order.annotation.WriteLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Aspect
@Component
public class LockAspect {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedissonClient redissonClient;

    /**
     * 加锁
     * @param joinPoint
     * @return
     */
    @Around("@annotation(com.fantasque.fanmall.order.annotation.Lock)")
    public Object Lock(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Lock lock = method.getAnnotation(Lock.class);
        String key = lock.key();
        RLock rLock = redissonClient.getLock(key);
        try {
            rLock.lock(); //阻塞式等待。默认加的锁都是30s
            System.out.println("加锁"+ Thread.currentThread().getId());

            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            rLock.unlock();
        }
    }

    /**
     * 加写锁
     * @param joinPoint
     * @return
     */
    @Around("@annotation(com.fantasque.fanmall.order.annotation.ReadLock)")
    public Object readLock(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ReadLock lock = method.getAnnotation(ReadLock.class);
        String key = lock.key();
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(key);
        //加读锁
        RLock rLock = readWriteLock.readLock();
        try {
            rLock.lock();
            System.out.println("加读锁"+ Thread.currentThread().getId());
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            rLock.unlock();
        }
    }

    /**
     * 加读锁
     * @param joinPoint
     * @return
     */
    @Around("@annotation(com.fantasque.fanmall.order.annotation.WriteLock)")
    public Object writeLock(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        WriteLock lock = method.getAnnotation(WriteLock.class);
        String key = lock.key();
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(key);
        RLock rLock = readWriteLock.writeLock();
        try {
            //1、改数据加写锁，读数据加读锁
            rLock.lock();
            System.out.println("加写锁"+ Thread.currentThread().getId());
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            rLock.unlock();
        }
    }
}
