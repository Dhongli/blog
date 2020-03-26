package com.itshidu.blog.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="blog_favor")
public class Favor {
	
	private Long id;
	private User user;
	private Article article;
	private Date created;
	
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
	@JoinColumn(name="article_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	public Article getArticle() {
		return article;
	}
	public Date getCreated() {
		return created;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
}
