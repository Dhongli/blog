package com.itshidu.blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 文章评论
 * @author Master.Xia
 */
@Entity
@Table(name="blog_comment")
public class Comment {
	
	private Long id;
	private Article article;	//文章
	private Date created;		//评论时间
	private User author;		//评论者
	private String content;		//评论内容
	private Comment target;		//针对的目标，回复的目标
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	@Column(columnDefinition="TEXT")
	public String getContent() {
		return content;
	}
	@ManyToOne
	@JoinColumn(name="article_id")
	public Article getArticle() {
		return article;
	}
	@ManyToOne
	@JoinColumn(name="author_id")
	public User getAuthor() {
		return author;
	}
	@ManyToOne
	@JoinColumn(name="target_id")
	public Comment getTarget() {
		return target;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setArticle(Article article) {
		this.article = article;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public void setTarget(Comment target) {
		this.target = target;
	}
	
}
