package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRODUCTS")
public class ProductModel implements Serializable{
	private static final long serialVersionUIS = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    
	private UUID idProdutct;
	private String name;
	private BigDecimal value;
	public UUID getIdProdutct() {
		return idProdutct;
	}
	public void setIdProdutct(UUID idProdutct) {
		this.idProdutct = idProdutct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public static long getSerialversionuis() {
		return serialVersionUIS;
	}
	
	
	
}
