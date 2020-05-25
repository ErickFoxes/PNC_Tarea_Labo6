package com.uca.capas.domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(schema="public",name="contribuyente")
public class Contribuyente {

	public Contribuyente() {}

	@Id
	@Column(name="c_contribuyente")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ccontribuyente;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_importancia")
	private Importancia cimportancia;
	
	@Transient
	private Integer c_importancia;
	
	@Column(name="s_nombre")
	private String nombre;
	
	@Column(name="s_apellido")
	private String apellido;
	
	@Column(name="s_nit")
	private String nit;
	
	@Column(name="f_fecha_ingreso")
	private LocalDate  ffecha_ingreso;
	
	
	public Integer getC_importancia() {
		return c_importancia;
	}
	
	public void setC_importancia(Integer c_importancia) {
		this.c_importancia = c_importancia;
	}

	public Importancia getCimportancia() {
		return cimportancia;
	}


	public void setCimportancia(Importancia cimportancia) {
		this.cimportancia = cimportancia;
	}

	

	public void setCcontribuyente(Integer ccontribuyente) {
		this.ccontribuyente = ccontribuyente;
	}

	
	public Integer getCcontribuyente() {
		return ccontribuyente;
	}

	public void setCcontribuyente(int ccontribuyente) {
		this.ccontribuyente = ccontribuyente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getFfecha_ingreso() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(ffecha_ingreso);
	}

	public void setFfecha_ingreso(LocalDate ffecha_ingreso) {
		this.ffecha_ingreso = ffecha_ingreso;
	}
	
	public String getFechaDelegate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaI = dtf.format(this.ffecha_ingreso);
	    return fechaI;
	}

	
	
	
}
