package com.divyansh.crio.xmeme.Request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This Class handles inputs of meme data retrieve from API
 * 
 * @author Divyansh Rahangdale
 *
 */
@ApiModel(description = "Request to create a new Meme")
public class XmemeRequest {

	// Declare the name variable which will store meme owner name
	@NotNull
	@ApiModelProperty(notes = "*Unique Owner name for a Meme", example = "Divyansh")
	private String name;

	//Declare the url variable which will store meme url
	@NotNull
	@ApiModelProperty(notes = "*Unique Meme URL must be image link", example = "https://ichef.bbci.co.uk/images/ic/704xn/p072ms6r.jpg")
	private String url;

	//Declare the caption variable which will store meme caption
	@NotNull
	@ApiModelProperty(notes = "*Unique Meme Caption", example = "Spider Gone LOL")
	private String caption;

	// Parameterized constructor
	public XmemeRequest(final String name, final String url, final String caption) {
		super();
		this.name = name;
		this.url = url;
		this.caption = caption;
	}

	// GETTER method Name
	public String getName() {
		return name;
	}

	// GETTER method Url
	public String getUrl() {
		return url;
	}

	// GETTER method Caption
	public String getCaption() {
		return caption;
	}

	@Override
	public String toString() {
		return "XmemeRequest [name=" + name + ", url=" + url + ", caption=" + caption + "]";
	}

}
