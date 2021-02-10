package com.divyansh.crio.xmeme.Request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This Class handles response of patched meme retrieve from API
 * 
 * @author Divyansh Rahangdale
 *
 */
@ApiModel(description = "Request to patch a Meme")
public class XmemePatchRequest {

	//Declare the url variable which will store meme url
	@NotNull
	@ApiModelProperty(notes = "*Unique new Meme URL must be image link", example = "https://netbasequid.com/wp-content/uploads/Brands%E2%80%99-Meme-Marketing-Makes-Sentiment-Analysis-More-Important-Than-Ever.png")
	String url;

	//Declare the caption variable which will store meme caption
	@NotNull
	@ApiModelProperty(notes = "*Unique new Meme Caption", example = "Good Meme works")
	String caption;

	// GETTER method Url
	public String getUrl() {
		return url;
	}

	// SETTER method Url
	public void setUrl(String url) {
		this.url = url;
	}

	// GETTER method Caption
	public String getCaption() {
		return caption;
	}

	// SETTER method Caption
	public void setCaption(String caption) {
		this.caption = caption;
	}

	// Parameterized Constructor
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
