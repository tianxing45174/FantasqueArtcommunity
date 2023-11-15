package com.fantasque.fanmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fantasque.common.utils.PageUtils;
import com.fantasque.fanmall.ware.entity.WareOrderTaskDetailEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 15:31:14
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

