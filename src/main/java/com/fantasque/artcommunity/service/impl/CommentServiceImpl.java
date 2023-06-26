package com.fantasque.artcommunity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fantasque.artcommunity.entity.Comment;
import com.fantasque.artcommunity.service.CommentService;
import com.fantasque.artcommunity.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author tianx
* @description 针对表【comment】的数据库操作Service实现
* @createDate 2023-06-23 19:56:16
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




