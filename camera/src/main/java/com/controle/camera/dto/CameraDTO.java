package com.controle.camera.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.controle.camera.entities.Camera;
import com.controle.camera.entities.Canal;

public class CameraDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Integer protocolo;
	private List<CanalDTO> canais = new ArrayList<>();

	public CameraDTO() {

	}

	public CameraDTO(Long id, String nome, Integer protocolo) {
		super();
		this.id = id;
		this.nome = nome;
		this.protocolo = protocolo;
	}

	public CameraDTO(Camera entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.protocolo = entity.getProtocolo();
	}
	
	public CameraDTO(Camera entity, Set<Canal> canais) {
		this(entity);
		canais.forEach(canal -> this.canais.add(new CanalDTO(canal)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(Integer protocolo) {
		this.protocolo = protocolo;
	}

	public List<CanalDTO> getCanais() {
		return canais;
	}

	public void setCanais(List<CanalDTO> canais) {
		this.canais = canais;
	}

}
