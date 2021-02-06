package com.divyansh.crio.xmeme.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divyansh.crio.xmeme.Entity.XmemeEntity;

@Repository
public interface XmemeRepository extends JpaRepository<XmemeEntity, Long> {
	Optional<XmemeEntity> findByName(String name);

	Optional<XmemeEntity> findByUrl(String url);

	Optional<XmemeEntity> findByCaption(String caption);

	Optional<XmemeEntity> findById(Long id);

	List<XmemeEntity> findTop100ByOrderByIdDesc(); 

	Boolean existsByName(String name);

	Boolean existsByUrl(String url);

	Boolean existsByCaption(String caption);

}
