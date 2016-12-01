package org.v1.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the Locacao database table.
 * 
 */
@Entity
public class Locacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="data_locacao")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataLocacao;
	
	private static SimpleDateFormat sData = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	//bi-directional many-to-many association to Avaria
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="locacao_avaria"
		, joinColumns={
			@JoinColumn(name="id_locacao")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_avaria")
			}
		)
	@JsonIgnore
	private List<Avaria> avarias;

	//bi-directional many-to-many association to Locacao
	@ManyToMany
	@JoinTable(
		name="locacao_multa"
		, joinColumns={
			@JoinColumn(name="id_multa")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_locacao")
			}
		)
	@JsonIgnore
	private List<Multa> multas;
	
	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name="id_funcionario_cad")
	private Funcionario funcionarioCad;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name="id_funcionario_rec")
	private Funcionario funcionarioRec;

	//bi-directional many-to-one association to Veiculo
	@ManyToOne
	@JoinColumn(name="id_veiculo")
	private Veiculo veiculo;

	public Locacao() {
	}
	
	public String getDataLocacao() {
		return sData.format(dataLocacao);
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public List<Avaria> getAvarias() {
		return this.avarias;
	}

	public void setAvarias(List<Avaria> avarias) {
		this.avarias = avarias;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Multa> getMultas() {
		return this.multas;
	}

	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}

	public Funcionario getFuncionarioCad() {
		return funcionarioCad;
	}

	public void setFuncionarioCad(Funcionario funcionarioCad) {
		this.funcionarioCad = funcionarioCad;
	}

	public Funcionario getFuncionarioRec() {
		return funcionarioRec;
	}

	public void setFuncionarioRec(Funcionario funcionarioRec) {
		this.funcionarioRec = funcionarioRec;
	}

	public Integer getId() {
		return id;
	}

}