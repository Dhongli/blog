package com.itshidu.blog.entity;
/**
 * 关注
 * @author Master.Xia
 *
 */

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

/**
 * 关注
 * @author Master.Xia
 */
@Entity
@Table(name="blog_follows")
public class Follow {
	
	private Long id;
	private User source;	//发起关注的人
	private User target;	//被关注的人
	private Date created;	//关注时间
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	@ManyToOne
	@JoinColumn(name="source_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	public User getSource() {
		return source;
	}
	@ManyToOne
	@JoinColumn(name="target_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	public User getTarget() {
		return target;
	}
	public Date getCreated() {
		return created;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setSource(User source) {
		this.source = source;
	}
	public void setTarget(User target) {
		this.target = target;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
}
