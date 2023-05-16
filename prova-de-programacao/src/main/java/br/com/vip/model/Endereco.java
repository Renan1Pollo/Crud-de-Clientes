package br.com.vip.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "enderecos")
public class Endereco {

	@Id
	private int id;

	@SerializedName("logradouro")
	private String rua;

	private String numero;

	@SerializedName("complemento")
	private String complemento;

	@SerializedName("bairro")
	private String bairro;

	@SerializedName("localidade")
	private String cidade;

	@SerializedName("uf")
	private String estado;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public Endereco() {
	}

	public Endereco(int id, String rua, String numero, String complemento, String bairro, String cidade, String estado,
			Cliente cliente) {
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String toString() {
		return "Endereco{" + "rua='" + rua + '\'' + ", cidade='" + cidade + '\'' + '}';
	}
}
