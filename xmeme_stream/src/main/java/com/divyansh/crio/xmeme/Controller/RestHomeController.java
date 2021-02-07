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

@RestController
@Api(tags = "Home Controller", description = "Controller for Meme Rest API")
public class RestHomeController {

	@Autowired 
	XmemeRepository xmemeRepository;

	@Autowired
	private XmemeService xmemeService;

	@GetMapping("/memes/{id}")
    @ApiOperation(value = "getByMemeId method to find Meme by ID")
	public ResponseEntity<?> getByMemeId(@PathVariable(value="id") String id){
		return ResponseEntity.ok(xmemeService.findById(id));
	}

	@GetMapping("/memes")
	@ApiOperation(value = "getAllMeme method to list all recent 100 Memes")
	public ResponseEntity<?> getAllMeme(){
		return ResponseEntity.ok(xmemeService.findTop100ByOrderByIdDesc());
	}

	@PostMapping("/memes")
	@ApiOperation(value = "createMeme method to create new Meme")
	public ResponseEntity<?> createMeme(@Valid @RequestBody XmemeRequest xmemeRequest) {
		return ResponseEntity.ok(xmemeService.createMeme(xmemeRequest));
	}

	@PatchMapping("/memes/{id}")
	@ApiOperation(value = "updateByMemeId method to patch Meme by ID")
	public ResponseEntity<?> updateByMemeId(
			@ApiParam("ID of Meme to patch it. Cannot be empty.") @PathVariable("id") String id, 
			@RequestBody @Valid XmemePatchRequest patchMeme) {
		return ResponseEntity.ok(xmemeService.updateMeme(id, patchMeme));
	}
}
