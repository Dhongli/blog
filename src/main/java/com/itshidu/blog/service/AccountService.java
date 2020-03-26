package com.itshidu.blog.service;

import javax.servlet.http.HttpServletRequest;

import com.itshidu.blog.vo.Result;

public interface AccountService {
	
	Result updatePassword(String oldPassword,String newPassword);

	Result updateProfile(String nickname, String sign);
	
	Result updateAvatar(int x,int y,int width,int height,String path,HttpServletRequest request);

	Result saveFavor(long articleId,HttpServletRequest request);
	
	Result saveFollow(long userId);
	/** 当前登录用户检查是否关注了某个人 */
	Result followCheck(long userId);

	/** 取消关注某个人 */
	Result unfollow(long id);
}
