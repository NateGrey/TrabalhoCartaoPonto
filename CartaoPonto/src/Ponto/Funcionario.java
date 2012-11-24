package Ponto;

public class Funcionario {
	
	private String codigoCartao;
	private String nome;
	private String cpf;
	private String endereco;
	private String cargo;
	
	public Funcionario(String codigo, String nome, String cpf, String endereco,String cargo) {
		super();
		this.codigoCartao = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cargo = cargo;
	}

	public String getCodigo() {
		return codigoCartao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return String.format("Funcionario [codigo=%s, nome=%s, cpf=%s, endereco=%s, cargo=%s]",
						codigoCartao, nome, cpf, endereco, cargo);
	}
	
}
