package program;

import utilitario.Utils;

public class Conta {
	private static int counterContas = 1;

	private int numeroConta;
	private Pessoa pessoa;
	private Double saldo = 0.0;

	public Conta( Pessoa pessoa) {
		
		this.numeroConta = counterContas;
		this.pessoa = pessoa;
		counterContas++;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String toString() {
		return "\nNúmero da conta: " + this.getNumeroConta()+
				"\nNome do cliente: "+ this.pessoa.getNome()+
				"\nCPF: "+ this.pessoa.getCpf()+
				"\nSaldo: " + Utils.doubleToString(this.getSaldo())+
		"\n";
	}
	public void depositar(Double valor) {
		if(valor >0) {
		setSaldo(getSaldo()+ valor);
		System.out.println("Deposito realizado com sucesso!");
		}else
			System.out.println("Não foi possivel realizar operação!");
		
	}
	public void sacar(Double valor) {
		if(valor > 0 && valor <= this.getSaldo()) {
			setSaldo(getSaldo()- valor);
			System.out.println("Saque realizado com sucesso!");
			
		}else
			System.out.println("Não foi possivel realizar a operação!");
	}
	
	public void transferir(Conta outraConta, Double valor) {
		if(valor > 0 && valor <= this.getSaldo()) {
			setSaldo(getSaldo()- valor);
			outraConta.saldo = outraConta.getSaldo() + valor;
			System.out.println("Operação realizada com sucesso");
		}else
			System.out.println("Operação não realizada");
	}
}
