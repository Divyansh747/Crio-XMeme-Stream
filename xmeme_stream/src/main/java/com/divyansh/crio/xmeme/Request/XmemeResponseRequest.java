package com.divyansh.crio.xmeme.Request;

import javax.validation.constraints.NotNull;

public class XmemeResponseRequest {

	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public XmemeResponseRequest(Long id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "XmemeResponseRequest [id=" + id + "]";
	}
	
}
