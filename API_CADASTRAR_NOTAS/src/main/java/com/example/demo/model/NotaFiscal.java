package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class NotaFiscal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String data_nota;
	private String cnpj_fornecedor;
	private double valor_nota;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getData_nota() {
		return data_nota;
	}
	public void setData_nota(String data_nota) {
		this.data_nota = data_nota;
	}
	public String getCnpj_fornecedor() {
		return cnpj_fornecedor;
	}
	public void setCnpj_fornecedor(String cnpj_fornecedor) {
		this.cnpj_fornecedor = cnpj_fornecedor;
	}
	public double getValor_nota() {
		return valor_nota;
	}
	public void setValor_nota(double valor_nota) {
		this.valor_nota = valor_nota;
	}
	

	
}
