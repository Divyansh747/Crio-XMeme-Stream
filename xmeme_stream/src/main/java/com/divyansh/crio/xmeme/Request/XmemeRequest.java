package com.divyansh.crio.xmeme.Request;

import javax.validation.constraints.NotNull;

public class XmemeRequest {

	@NotNull
	private String name;

	@NotNull
	private String url;

	@NotNull
	private String caption;

	public XmemeRequest(final String name, final String url, final String caption) {
		super();
		this.name = name;
		this.url = url;
		this.caption = caption;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public String getCaption() {
		return caption;
	}

	@Override
	public String toString() {
		return "XmemeRequest [name=" + name + ", url=" + url + ", caption=" + caption + "]";
	}

}
