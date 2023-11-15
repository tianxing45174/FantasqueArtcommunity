package com.fantasque.fanmall.search.service;

import com.fantasque.common.to.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @author LaFantasque
 * @version 1.0
 */
public interface ProductSaveService {

    Boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;
}
