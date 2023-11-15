package com.fantasque.fanmall.product.feign;

import com.fantasque.common.to.SkuEsModel;
import com.fantasque.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author LaFantasque
 * @version 1.0
 */
@FeignClient("fanmall-search")
public interface SearchFeignService {

    @PostMapping("/search/save/product")
    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels);
}
