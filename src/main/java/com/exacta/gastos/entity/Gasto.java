package com.exacta.gastos.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
	
@Entity(name = "TB_GASTO")
public class Gasto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NOME_PESSOA", length = 60)
	private String nomePessoa;
	
	@Column(name = "DESCRICAO_GASTO", length = 250)
	private String descricao;

	@Column(name = "DATA_HORA_GASTO")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dataHora;

	@Column(name = "VALOR_GASTO")
	private BigDecimal valor;

	@OneToMany(mappedBy = "gasto")
	private List<Tag> tags;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}
