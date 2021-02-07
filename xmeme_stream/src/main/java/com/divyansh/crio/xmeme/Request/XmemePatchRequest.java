package com.divyansh.crio.xmeme.Request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Request to patch a Meme")
public class XmemePatchRequest {

	@NotNull
	@ApiModelProperty(notes = "*Unique new Meme URL must be image link", example = "https://netbasequid.com/wp-content/uploads/Brands%E2%80%99-Meme-Marketing-Makes-Sentiment-Analysis-More-Important-Than-Ever.png")
	String url;

	@NotNull
	@ApiModelProperty(notes = "*Unique new Meme Caption", example = "Good Meme works")
	String caption;

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

	public XmemePatchRequest(@NotNull String url, @NotNull String caption) {
		super();
		this.url = url;
		this.caption = caption;
	}

	@Override
	public String toString() {
		return "XmemeResponseRequest [name=" + url + ", caption=" + caption + "]";
	}
	
}
