package com.divyansh.crio.xmeme.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divyansh.crio.xmeme.Entity.XmemeEntity;
import com.divyansh.crio.xmeme.Exception.NotFoundException;
import com.divyansh.crio.xmeme.Exception.XmemeException;
import com.divyansh.crio.xmeme.Repository.XmemeRepository;
import com.divyansh.crio.xmeme.Request.XmemePatchRequest;
import com.divyansh.crio.xmeme.Request.XmemeRequest;
import com.divyansh.crio.xmeme.Request.XmemeResponseRequest;

@Service
public class XmemeService {
	private XmemeRepository xmemeRepository;

	@Autowired
	public XmemeService(XmemeRepository xmemeRepository) {
		this.xmemeRepository = xmemeRepository;
	}

	public Optional<XmemeResponseRequest> createMeme(XmemeRequest xmemeRequest) {

		if (xmemeRepository.existsByName(xmemeRequest.getName())) {
			throw new XmemeException("Duplicate Owner Name encounter!");
		} else if (xmemeRepository.existsByUrl(xmemeRequest.getUrl())) {
			throw new XmemeException("Duplicate  Meme URL encounter!");
		} else if (xmemeRepository.existsByCaption(xmemeRequest.getCaption())) {
			throw new XmemeException("Duplicate Caption encounter!");
		}

		System.out.println("Data received: " + xmemeRequest.toString());

		XmemeEntity xmemeEntity = xmemeRepository
				.save(new XmemeEntity(xmemeRequest.getName(), xmemeRequest.getUrl(), xmemeRequest.getCaption()));
		System.out.println(xmemeEntity);

		XmemeResponseRequest xmemeResponseRequest = new XmemeResponseRequest(xmemeEntity.getId());
		System.out.println(xmemeResponseRequest);

		return Optional.ofNullable(xmemeResponseRequest);
	}

	public Optional<XmemeEntity> createMeme(XmemeEntity xmemeRequest) {

		if (xmemeRepository.existsByName(xmemeRequest.getName())) {
			throw new XmemeException("Duplicate Owner Name encounter!");
		} else if (xmemeRepository.existsByUrl(xmemeRequest.getUrl())) {
			throw new XmemeException("Duplicate  Meme URL encounter!");
		} else if (xmemeRepository.existsByCaption(xmemeRequest.getCaption())) {
			throw new XmemeException("Duplicate Caption encounter!");
		}

		System.out.println("Data received: " + xmemeRequest.toString());

		XmemeEntity xmemeEntity = xmemeRepository
				.save(new XmemeEntity(xmemeRequest.getName(), xmemeRequest.getUrl(), xmemeRequest.getCaption()));

		return Optional.ofNullable(xmemeEntity);
	}

	public XmemeEntity findById(Long id) {
		XmemeEntity xmemeEntity = xmemeRepository.findById(id).orElseThrow(() -> new NotFoundException("ID Not Found!"));
		return xmemeEntity;
	}

	public List<XmemeEntity> findTop100ByOrderByIdDesc(){
		return xmemeRepository.findTop100ByOrderByIdDesc();
	}

	public Optional<XmemeEntity> updateMeme(Long id, XmemePatchRequest patchMeme) {

		XmemeEntity xmemeEntity = findById(id);

		System.out.println("BEFORE : " + xmemeEntity);

		if(patchMeme.getUrl() != null) {
			xmemeEntity.setUrl(patchMeme.getUrl());
		}
		if(patchMeme.getCaption() != null) {
			xmemeEntity.setCaption(patchMeme.getCaption());
		}

		System.out.println("After : " + xmemeEntity);
		return Optional.ofNullable(xmemeRepository.save(xmemeEntity));
	}

	public Optional<XmemeEntity> updateFormMeme(Long id, XmemeEntity patchMeme) {

		XmemeEntity xmemeEntity = findById(id);

		System.out.println("BEFORE : " + xmemeEntity);

		if(patchMeme.getUrl() != "") {
			xmemeEntity.setUrl(patchMeme.getUrl());
		}
		if(patchMeme.getCaption() != "") {
			xmemeEntity.setCaption(patchMeme.getCaption());
		}

		System.out.println("After : " + xmemeEntity);
		return Optional.ofNullable(xmemeRepository.save(xmemeEntity));
	}

}
