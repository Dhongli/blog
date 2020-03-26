package com.itshidu.blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * 帖子，文章
 * @author Master.Xia
 */
@Entity
@Table(name="blog_article")
public class Article {
	
	private Long id;
	private User user;			//文章作者，发帖人
	private String title;		//文章标题
	private Date createTime;	//发布时间
	private Long hits;			//点击量
	private String content;		//文章正文内容
	private Forum forum;		//所属版块
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	@ManyToOne
	@JoinColumn(name="user_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	public User getUser() {
		return user;
	}
	@ManyToOne
	@JoinColumn(name="group_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	public Forum getForum() {
		return forum;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getHits() {
		return hits;
	}
	public void setHits(Long hits) {
		this.hits = hits;
	}
	@Column(columnDefinition="TEXT")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	
}
