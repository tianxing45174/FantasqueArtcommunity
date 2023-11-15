package com.fantasque.fanmall.product.fallback;

import com.fantasque.common.exception.BizCodeEnum;
import com.fantasque.common.utils.R;
import com.fantasque.fanmall.product.feign.SeckillFeignService;
import org.springframework.stereotype.Component;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Component
public class SeckillFeignServiceFallBack implements SeckillFeignService {
    @Override
    public R getSkuSeckilInfo(Long skuId) {
        return R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(),BizCodeEnum.TO_MANY_REQUEST.getMsg());
    }
}
