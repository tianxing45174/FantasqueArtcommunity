package com.fantasque.fanmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fantasque.common.utils.PageUtils;
import com.fantasque.fanmall.ware.entity.WareInfoEntity;
import com.fantasque.fanmall.ware.vo.FareVo;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 15:31:13
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    FareVo getFare(Long addrId);

    PageUtils queryPage(Map<String, Object> params);
}

