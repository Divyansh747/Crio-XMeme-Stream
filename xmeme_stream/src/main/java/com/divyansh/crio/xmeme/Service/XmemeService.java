package com.divyansh.crio.xmeme.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divyansh.crio.xmeme.Entity.XmemeEntity;
import com.divyansh.crio.xmeme.Exception.NotFoundException;
import com.divyansh.crio.xmeme.Exception.XmemeException;
import com.divyansh.crio.xmeme.Repository.XmemeRepository;
import com.divyansh.crio.xmeme.Request.XmemeRequest;

@Service
public class XmemeService {
	private XmemeRepository xmemeRepository;

	@Autowired
	public XmemeService(XmemeRepository xmemeRepository) {
		this.xmemeRepository = xmemeRepository;
	}

	public Optional<XmemeEntity> createMeme(XmemeRequest xmemeRequest) {

		if (xmemeRepository.existsByName(xmemeRequest.getName())) {
			throw new XmemeException("Owner Name already exists!");
		} else if (xmemeRepository.existsByUrl(xmemeRequest.getUrl())) {
			throw new XmemeException("Meme URL already exists!");
		} else if (xmemeRepository.existsByCaption(xmemeRequest.getCaption())) {
			throw new XmemeException("Duplicate Caption encounter!");
		}

		System.out.println("Data received: " + xmemeRequest.toString());

		XmemeEntity xmemeEntity = xmemeRepository
				.save(new XmemeEntity(xmemeRequest.getName(), xmemeRequest.getUrl(), xmemeRequest.getCaption()));

		return Optional.ofNullable(xmemeEntity);
	}

	public Optional<XmemeEntity> createMeme(XmemeEntity xmemeRequest) {
		if (xmemeRepository.existsByName(xmemeRequest.getName())) {
			throw new XmemeException("Owner Name already exists!");
		} else if (xmemeRepository.existsByUrl(xmemeRequest.getUrl())) {
			throw new XmemeException("Meme URL already exists!");
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


}
