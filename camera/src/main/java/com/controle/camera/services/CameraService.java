package com.controle.camera.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controle.camera.dto.CameraDTO;
import com.controle.camera.dto.CanalDTO;
import com.controle.camera.entities.Camera;
import com.controle.camera.entities.Canal;
import com.controle.camera.repositories.CameraRepository;
import com.controle.camera.repositories.CanalRepository;
import com.controle.camera.services.exceptions.DatabaseException;
import com.controle.camera.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CameraService {

	@Autowired
	private CameraRepository repository;
	
	@Autowired
	private CanalRepository canalRepository;
	
	
	@Transactional(readOnly = true)
	public Page<CameraDTO> findAllPaged(Pageable pageable) {
		
		Page<Camera> page = repository.findAll(pageable);
		return page.map(x -> new CameraDTO(x, x.getCanais()));
	}

	@Transactional(readOnly = true)
	public CameraDTO findById(Long id) {
		Optional<Camera> obj = repository.findById(id);
		Camera entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new CameraDTO(entity, entity.getCanais());
	}
	
	@Transactional
	public CameraDTO insert(CameraDTO dto) {
		Camera entity = new Camera();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new CameraDTO(entity);
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public CameraDTO update(Long id, CameraDTO dto) {
		try {
			Camera entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new CameraDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}		
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	@SuppressWarnings("deprecation")
	private void copyDtoToEntity(CameraDTO dto, Camera entity) {

		entity.setNome(dto.getNome());
		entity.setProtocolo(dto.getProtocolo());
		
		entity.getCanais().clear();
		for (CanalDTO canalDto : dto.getCanais()) {
			Canal canal = canalRepository.getOne(canalDto.getId());
			entity.getCanais().add(canal);			
		}
	}
}
