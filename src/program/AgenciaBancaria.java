package program;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		menuInicial();
	}

	private static void menuInicial() {
		int op = 0;
		
			System.out.println("--------------------------------------------");
			System.out.println("---------Agencia bancaria do vitoso---------");
			System.out.println("--------------------------------------------");
			System.out.println("--Selecione a operação que deseja realizar--");
			System.out.println("--------------------------------------------");
			System.out.println("| 1. Criar conta |");
			System.out.println("| 2. Depositar |");
			System.out.println("| 3. Sacar |");
			System.out.println("| 4. Transferir |");
			System.out.println("| 5. Listar |");
			System.out.println("| 6. Sair |");
			 op = sc.nextInt();
			 clearBuffer(sc);
		
		switch(op) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listar();
			break;
		case 6:
			System.out.println("Obrigado por utilizar a vitoso's banks");;
			System.exit(0);
		default: 
			menuInicial();
		}
	}
	
	public static void criarConta() {
		System.out.println("\nNome: ");
		String nome = sc.nextLine();
		System.out.println("\nCPF: ");
		String cpf = sc.next();
		System.out.println("\nEmail: ");
		String email = sc.next();
		
			Pessoa cliente = new Pessoa(nome, cpf, email);
			
			Conta Conta = new Conta(cliente);
			contasBancarias.add(Conta);
			System.out.println("Conta criada com exito!");
			menuInicial();
	}
	private static Conta acharConta(int numeroConta) {
		Conta conta = null;
		if(contasBancarias.size() > 0) {
			for(Conta c: contasBancarias) {
				if(c.getNumeroConta() == numeroConta);
				conta = c;
			}
		}
		return conta;
	}
	
	public static void depositar() {
		System.out.println("Numero da conta:");
			int numConta = sc.nextInt();
			
		Conta conta = acharConta(numConta);
		
		  if(conta != null) {
			System.out.println("valor para deposito: ");
			 Double valor = sc.nextDouble();
			conta.depositar(valor);
			System.out.println("Valor depositador com exito!");
			
		}else
			System.out.println("Conta não encontrada");
		menuInicial();
	}
	
	public static void sacar() {
		System.out.println("Numero da conta:");
		int numConta = sc.nextInt();
		Conta conta = acharConta(numConta);
		
		  if(conta != null) {
			System.out.println("valor para saque: ");
			 Double valor = sc.nextDouble();
			conta.depositar(valor);
			System.out.println("Saque depositador com exito!");
			
		}else
			System.out.println("Conta não encontrada");
		menuInicial();
	}
	public static void transferir() {
	System.out.println("Insira o numero da conta do remetente");
	int numContaRemetente = sc.nextInt();
	
	Conta contaRemetente = acharConta(numContaRemetente);
	
		if(contaRemetente != null) {
			System.out.println("Numero da conta do destinatario");
			int numContaDestinatario = sc.nextInt();
			Conta contaDestinatario = acharConta(numContaDestinatario);
			if(contaDestinatario != null) {
				System.out.println("valor da transferencia: ");
				 Double valor = sc.nextDouble();
				 
				 contaRemetente.transferir(contaDestinatario, valor);
			}
		}
		menuInicial();
  }
	public static void listar() {
		if(contasBancarias.size() > 0) {
			for(Conta conta: contasBancarias)
			System.out.println(conta);
			
		}else
			System.out.println("Não há contas cadastradas");
		menuInicial();

	}
	 private static void clearBuffer(Scanner scanner) {
	        if (scanner.hasNextLine()) {
	            scanner.nextLine();
	        }
	    }
}
