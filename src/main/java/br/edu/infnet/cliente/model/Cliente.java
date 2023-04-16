package br.edu.infnet.cliente.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    private String cpf;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public Cliente() {

    }

    public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Sexo getSexo() {
		return sexo;
	}



	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}



	public Cliente(String cpf, String nome, Sexo sexo) {
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
	}



	public ClienteDto toDto(){
        return new ClienteDto(cpf, nome, sexo);
    }
}
