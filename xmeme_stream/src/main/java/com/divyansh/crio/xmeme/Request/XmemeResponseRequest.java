package com.divyansh.crio.xmeme.Request;

import javax.validation.constraints.NotNull;

public class XmemeResponseRequest {

	@NotNull
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public XmemeResponseRequest(String id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "XmemeResponseRequest [id=" + id + "]";
	}


}
