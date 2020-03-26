package com.itshidu.blog.service;

import com.itshidu.blog.vo.Result;

public interface CommentService {

	Result save(Long articleId,Long targetCommentId,String text);

	Result list(Long articleId, int pageSize, int pn);
}
