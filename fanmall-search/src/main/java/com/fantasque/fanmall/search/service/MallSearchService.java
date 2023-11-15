package com.fantasque.fanmall.search.service;

import com.fantasque.fanmall.search.vo.SearchParam;
import com.fantasque.fanmall.search.vo.SearchResult;

/**
 * @author LaFantasque
 * @version 1.0
 */
public interface MallSearchService {
    SearchResult search(SearchParam param);

}
