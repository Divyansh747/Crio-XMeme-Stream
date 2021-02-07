package com.divyansh.crio.xmeme.Request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Request to create a new Meme")
public class XmemeRequest {

	@NotNull
    @ApiModelProperty(notes = "*Unique Owner name for a Meme", example = "Divyansh")
	private String name;

	@NotNull
	@ApiModelProperty(notes = "*Unique Meme URL must be image link", example = "https://ichef.bbci.co.uk/images/ic/704xn/p072ms6r.jpg")
	private String url;

	@NotNull
	@ApiModelProperty(notes = "*Unique Meme Caption", example = "Spider Gone LOL")
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
