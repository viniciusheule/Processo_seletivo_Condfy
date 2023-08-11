package com.controle.camera.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.controle.camera.entities.Camera;
import com.controle.camera.entities.Canal;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Long>{

	@Query("SELECT DISTINCT obj FROM Camera obj INNER JOIN obj.canais cans WHERE "
			+ "(COALESCE(:canais) IS NULL OR cans IN :canais) AND "
			+ "(:nome = '' OR LOWER(obj.nome) LIKE LOWER(CONCAT('%',:nome,'%'))) ")
	Page<Camera> find(List<Canal> canais, String nome, Pageable pageable);
	
	@Query("SELECT obj FROM Camera obj JOIN FETCH obj.canais WHERE obj IN :cameras")
	List<Camera> findCameraWithCategories(List<Camera> cameras);
}
