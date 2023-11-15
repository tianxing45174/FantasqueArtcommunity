package com.fantasque.fanmall.product.feign;

import com.fantasque.common.to.SkuHasStockTo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author LaFantasque
 * @version 1.0
 */
@FeignClient("fanmall-ware")
public interface WareFeignService {
    @PostMapping("ware/waresku/hasStock")
    List<SkuHasStockTo> getSkusHasStock(@RequestBody List<Long> skuIds);
}
