package com.fantasque.artcommunity.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fantasque.artcommunity.entity.Artwork;
import org.springframework.ui.Model;

/**
* @author tianx
* @description 针对表【artwork】的数据库操作Service
* @createDate 2023-06-22 18:43:35
*/
public interface ArtworkService extends IService<Artwork> {

    public Page<Artwork> getAllPageToCurrPage(int currPage);

    public Page<Artwork> getPageById(int id);

    public void modelGetArtworkPage(Page<Artwork> page, Model model);

}
