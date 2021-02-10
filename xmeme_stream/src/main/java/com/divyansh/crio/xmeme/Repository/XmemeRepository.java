package com.divyansh.crio.xmeme.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divyansh.crio.xmeme.Entity.XmemeEntity;

/**
 * This interface extends JpaRepository which deals with API of CRUD Repository 
 * 
 * @author Divyansh Rahangdale
 *
 */
@Repository
public interface XmemeRepository extends JpaRepository<XmemeEntity, Long> {

	/**
	 * This method runs Database Query to find meme owner name
	 * @param name - name of Meme Owner
	 * 
	 */
	Optional<XmemeEntity> findByName(String name);

	/**
	 * This method runs Database Query to find meme url 
	 * @param url - url of Meme
	 * 
	 */
	Optional<XmemeEntity> findByUrl(String url);

	/**
	 * This method runs Database Query to find meme caption
	 * @param caption - caption of Meme
	 * 
	 */
	Optional<XmemeEntity> findByCaption(String caption);

	/**
	 * This method runs Database Query to find meme id
	 * @param id - id of Meme
	 * 
	 */
	Optional<XmemeEntity> findById(String id);

	// This method runs Database Query to retrieve latest 100 Memes
	List<XmemeEntity> findTop100ByOrderByIdDesc(); 

	// Checks user name from parameter is available on database or not and return bool value
	Boolean existsByName(String name);


	// Checks url from parameter is available on database or not and return bool value
	Boolean existsByUrl(String url);

	// Checks caption from parameter is available on database or not and return bool value
	Boolean existsByCaption(String caption);

}
