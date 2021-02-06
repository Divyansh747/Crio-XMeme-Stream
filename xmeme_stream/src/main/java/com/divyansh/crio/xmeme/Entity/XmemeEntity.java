package com.divyansh.crio.xmeme.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

@Entity
public class XmemeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, updatable = false, name = "id")
	private Long id;

	@NaturalId
	@Column(unique = true, nullable = false)
	private String name;

	@NaturalId
	@Column(unique = true, nullable = false)
	private String url;

	@NaturalId
	@Column(unique = true, nullable = false)
	private String caption;

	public XmemeEntity() {
	}

	public XmemeEntity(final String name, final String url, final String caption) {
		this.name = name;
		this.url = url;
		this.caption = caption;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}	

	@Override
	public String toString() {
		return "XmemeEntity {Id=" + id + ", name=" + name + ", url=" + url + ", caption=" + caption + "}";
	}

}
