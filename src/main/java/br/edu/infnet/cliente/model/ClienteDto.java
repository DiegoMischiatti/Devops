package br.edu.infnet.cliente.model;

public class ClienteDto {
    private String cpf;
    private String nome;
    private Sexo sexo;

    public ClienteDto() {

    }

    public ClienteDto(String cpf, String nome, Sexo sexo) {
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
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


	public Cliente toCliente(){
        return new Cliente(cpf, nome, sexo);
    }
}
