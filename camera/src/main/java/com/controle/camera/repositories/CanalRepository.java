package com.controle.camera.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controle.camera.entities.Canal;

@Repository
public interface CanalRepository extends JpaRepository<Canal, Long>{

}
