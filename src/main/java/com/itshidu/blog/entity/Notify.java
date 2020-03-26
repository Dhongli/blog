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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="blog_notify")
public class Notify {
	
	private Long id;
	private String avatar;
	private String title;
	private String url;
	private Date created;
	private String content;
	private User user;	//通知的归属者，这是谁的通知
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public String getAvatar() {
		return avatar;
	}
	public String getTitle() {
		return title;
	}
	public Date getCreated() {
		return created;
	}
	@Column(columnDefinition="TEXT")
	public String getContent() {
		return content;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@ManyToOne
	@JoinColumn(name="user_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
