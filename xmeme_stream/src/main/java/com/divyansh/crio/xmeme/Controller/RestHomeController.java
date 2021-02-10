package com.divyansh.crio.xmeme.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.divyansh.crio.xmeme.Repository.XmemeRepository;
import com.divyansh.crio.xmeme.Request.XmemePatchRequest;
import com.divyansh.crio.xmeme.Request.XmemeRequest;
import com.divyansh.crio.xmeme.Service.XmemeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * REST Controller Class deals with all RESTful API used in XMEME STREAM WEB Application 
 * 
 * @author Divyansh Rahangdale
 *
 */
@RestController
@Api(tags = "Home Controller", description = "Controller for Meme Rest API")
public class RestHomeController {

	// Spring dependency injection for XmemeRepository
	@Autowired 
	XmemeRepository xmemeRepository;

	// Spring dependency injection for XmemeService
	@Autowired
	private XmemeService xmemeService;

	/**
	 * This function generating GET Method with mapped endpoint /memes/{id}
	 * Helps to retrieve memes with respect to it's id
	 * 
	 * @param id - String type parameter retrieve from PathVariable
	 * @return - Response of .findById(id) method
	 */
	@GetMapping("/memes/{id}")
	@ApiOperation(value = "getByMemeId method to find Meme by ID")
	public ResponseEntity<?> getByMemeId(@PathVariable(value="id") Long id){
		return ResponseEntity.ok(xmemeService.findById(id));
	}

	/**
	 * This function generating GET Method with mapped endpoint /memes
	 * Helps to retrieve Top 100 Recent Memes posted by users
	 * 
	 * @return - Top 100 recent Memes in reverse chronological order
	 */
	@GetMapping("/memes")
	@ApiOperation(value = "getAllMeme method to list all recent 100 Memes")
	public ResponseEntity<?> getAllMeme(){
		return ResponseEntity.ok(xmemeService.findTop100ByOrderByIdDesc());
	}

	/**
	 * This function generating POST Method with mapped endpoint /memes
	 * Helps to create meme using REST API
	 * 
	 * @return - Response id of created meme
	 */
	@PostMapping("/memes")
	@ApiOperation(value = "createMeme method to create new Meme")
	public ResponseEntity<?> createMeme(@Valid @RequestBody XmemeRequest xmemeRequest) {
		return ResponseEntity.ok(xmemeService.createMeme(xmemeRequest));
	}

	/**
	 * This function generating PATCH Method with mapped endpoint /memes/{Id}
	 * Helps to patch/update meme with respect to it's id
	 * 
	 * @param id - String type parameter retrieve from PathVariable
	 * @return - Response of meme details after patching
	 */
	@PatchMapping("/memes/{id}")
	@ApiOperation(value = "updateByMemeId method to patch Meme by ID")
	public ResponseEntity<?> updateByMemeId(
			@ApiParam("ID of Meme to patch it. Cannot be empty.") @PathVariable("id") Long id, 
			@RequestBody @Valid XmemePatchRequest patchMeme) {
		return ResponseEntity.ok(xmemeService.updateMeme(id, patchMeme));
	}
}
