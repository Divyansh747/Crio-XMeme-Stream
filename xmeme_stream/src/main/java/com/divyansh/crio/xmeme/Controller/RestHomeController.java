package com.divyansh.crio.xmeme.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divyansh.crio.xmeme.Entity.XmemeEntity;
import com.divyansh.crio.xmeme.Repository.XmemeRepository;
import com.divyansh.crio.xmeme.Request.XmemeRequest;
import com.divyansh.crio.xmeme.Service.XmemeService;

@RestController
public class RestHomeController {

	@Autowired 
	XmemeRepository xmemeRepository;

	@Autowired
	private XmemeService xmemeService;

	@RequestMapping("/memes/{id}")
	public ResponseEntity<?> getByMeme(@PathVariable(value="id") Long id){
		return ResponseEntity.ok(xmemeService.findById(id));
	}

	@RequestMapping("/memes")
	public ResponseEntity<?> getAllMeme(){
		return ResponseEntity.ok(xmemeService.findTop100ByOrderByIdDesc());
	}

	@PostMapping("/memes")
	public ResponseEntity<?> createMeme(@Valid @RequestBody XmemeRequest xmemeRequest) {
		return ResponseEntity.ok(xmemeService.createMeme(xmemeRequest));
	}

	@PatchMapping("/memes/{id}")
	public XmemeEntity xmemeUpdate(@PathVariable("id") Long id, @RequestBody @Valid XmemeEntity patchMeme) {

		XmemeEntity xmemeEntity = xmemeService.findById(id);

		if(patchMeme.getUrl() != null) {
			xmemeEntity.setUrl(patchMeme.getUrl());
		}
		if(patchMeme.getCaption() != null) {
			xmemeEntity.setCaption(patchMeme.getCaption());
		}

		return xmemeRepository.save(xmemeEntity);
	}
}
