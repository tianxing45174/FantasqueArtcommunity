package com.fantasque.artcommunity.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fantasque.artcommunity.entity.Artwork;
import com.fantasque.artcommunity.mapper.ArtworkMapper;
import com.fantasque.artcommunity.service.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
* @author tianx
* @description 针对表【artwork】的数据库操作Service实现
* @createDate 2023-06-22 18:43:35
*/
@Service("userService")
public class ArtworkServiceImpl extends ServiceImpl<ArtworkMapper, Artwork>
    implements ArtworkService {

    @Autowired
    private ArtworkMapper artworkMapper;

    /**
     * 查询所有的作品分页
     * @param currPage 当前页数
     * @return
     */
    public Page<Artwork> getAllPageToCurrPage(int currPage){
        return artworkMapper.selectPage(
                new Page<>(currPage, 12),
                null);
    }

    /**
     *
     * @param id 查询id的作品分页信息
     * @return 返回作品分页信息
     */
    @Override
    public Page<Artwork> getPageById(int id) {
       return artworkMapper.selectPage(
               new Page<>(1, 1<<16),
               new QueryWrapper<Artwork>()
                       .eq("userid",(id==0?null:id)));
    }

    /**
     * 将分页注入model
     * @param page 要注入的分页信息
     * @param model 注入的model
     * @return  返回注入完成的model
     */
    @Override
    public void modelGetArtworkPage(Page<Artwork> page, Model model) {
        model.addAttribute("page", page.getCurrent());
        model.addAttribute("pageSize", page.getSize());
        model.addAttribute("Total", page.getTotal());
        model.addAttribute("pages", page.getPages());
        model.addAttribute("hasPre", page.hasPrevious());
        model.addAttribute("hasNext", page.hasNext());
        model.addAttribute("records", page.getRecords());

//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println("当前页："+page.getCurrent());
//        System.out.println("每页显示的条数："+page.getSize());
//        System.out.println("总记录数："+page.getTotal());
//        System.out.println("总页数："+page.getPages());
//        System.out.println("是否有上一页："+page.hasPrevious());
//        System.out.println("是否有下一页："+page.hasNext());
//        System.out.println("记录:"+page.getRecords());
//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

    }

}




