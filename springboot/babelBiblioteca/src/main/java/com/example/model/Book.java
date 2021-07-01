package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "titulo")
	private String titulo;

	@Column(name = "volumen")
	private int volumen;
	
	@Column(name ="estante")
	private String estante;
	
	@Column(name = "sala")
	private String sala;
	
	@Column(name="librero")
	private String librero;
	
	@Column(name="posicion")
	private String posicion;

	
	public Book() {}
	
	public Book(String titulo, int volumen, String estante, String sala, 
			String librero, String posicion) {
		this.titulo = titulo;
		this.volumen = volumen;
		this.estante = estante;
		this.sala = sala;
		this.librero = librero;
		this.posicion = posicion;
	}

	public long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getVolumen() {
		return volumen;
	}

	public String getEstante() {
		return estante;
	}

	public String getSala() {
		return sala;
	}

	public String getLibrero() {
		return librero;
	}

	public String getPosicion() {
		return posicion;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
 
	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}
	
	public void setEstante(String estante) {
		this.estante = estante;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public void setLibrero(String librero) {
		this.librero = librero;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", titulo=" + titulo + ", volumen=" + volumen +", estante ="+
	estante+", sala= "+sala+ ", librero= "+librero+", posicion="+posicion+"]";
	}
}
