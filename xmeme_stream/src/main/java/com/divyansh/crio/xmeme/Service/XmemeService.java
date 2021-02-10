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

/**
 * This Service Class deals with backend logic working in Meme Application to 
 * create meme, find meme, update meme etc methods.
 * 
 * @author Divyansh Rahangdale
 *
 */
@Service
public class XmemeService {

	// Spring dependency injection for XmemeService
	@Autowired
	private XmemeRepository xmemeRepository;

	// XmemeService class Constructor
	@Autowired
	public XmemeService(XmemeRepository xmemeRepository) {
		this.xmemeRepository = xmemeRepository;
	}

	/**
	 * This method helps to create meme when RESTful api invoke
	 * This method also verify Duplicacy of Memes and generation Error accroding to it
	 * 
	 * @param xmemeRequest
	 * @return Response of newly created meme ID
	 */
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

	/**
	 * This method helps to find details of meme according to passed id
	 * 
	 * @param id - Long type id of Meme
	 * @return - response of findByid(id) 
	 */
	public XmemeEntity findById(Long id) {
		XmemeEntity xmemeEntity = xmemeRepository.findById(id).orElseThrow(() -> new NotFoundException("ID Not Found!"));
		return xmemeEntity;
	}

	/**
	 * 
	 * @return - Latest Top 100 Memes stored in Databse
	 */
	public List<XmemeEntity> findTop100ByOrderByIdDesc(){
		return xmemeRepository.findTop100ByOrderByIdDesc();
	}


	/**
	 * This method helps to create meme when RESTful api invoke from HTML FORM
	 * This method also verify Duplicacy of Memes and generation Error accroding to it
	 * 
	 * @param xmemeRequest
	 * @return Response of newly created meme
	 */
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

	/**
	 * This method helps to update meme from RESTful API request
	 * 
	 * @param id - Long type id of meme
	 * @param patchMeme - contains attribute of update meme 
	 * @return - response of updated meme
	 */
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

	/**
	 * This method helps to update meme from  HTML FORM using RestAPI
	 * 
	 * @param id - Long type id of meme
	 * @param patchMeme - contains attribute of update meme 
	 * @return - response of updated meme
	 */
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
