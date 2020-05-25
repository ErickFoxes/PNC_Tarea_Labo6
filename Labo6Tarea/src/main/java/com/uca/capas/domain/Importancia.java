package com.uca.capas.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(schema="public",name="importancia")
public class Importancia {
	
	public Importancia() {}
	
	@Id
	@Column(name="c_importancia")
	private Integer cimportancia;
	
	@Column(name="s_importancia")
	private String importancia;
	
	public Integer getCimportancia() {
		return cimportancia;
	}

	public void setCimportancia(Integer cimportancia) {
		this.cimportancia = cimportancia;
	}

	public String getImportancia() {
		return importancia;
	}

	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}
	
	
	
}
