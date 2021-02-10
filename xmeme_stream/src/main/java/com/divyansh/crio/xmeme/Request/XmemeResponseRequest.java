package com.divyansh.crio.xmeme.Request;

import javax.validation.constraints.NotNull;

/**
 * This Class handles response of create meme retrieve from API
 * 
 * @author Divyansh Rahangdale
 *
 */
public class XmemeResponseRequest {

	// Declare the id variable of newly created meme
	@NotNull
	private Long id;

	// GETTER method Id
	public Long getId() {
		return id;
	}

	// SETTER method Id
	public void setId(Long id) {
		this.id = id;
	}

	// Parameterized Constructor
	public XmemeResponseRequest(Long id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "XmemeResponseRequest [id=" + id + "]";
	}

}
