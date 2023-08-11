package com.controle.camera.dto;

import java.io.Serializable;

import com.controle.camera.entities.Canal;

public class CanalDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer numero;
	private String descricao;

	public CanalDTO() {

	}

	public CanalDTO(Long id, Integer numero, String descricao) {
		super();
		this.id = id;
		this.numero = numero;
		this.descricao = descricao;
	}
	
	public CanalDTO(Canal entity) {
		this.id = entity.getId();
		this.numero = entity.getNumero();
		this.descricao = entity.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
