package aplicacao;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("--------------");
			System.out.println("DADOS DA CONTA");
			System.out.println("--------------");
			System.out.println();
			System.out.print("Número da Conta: ");
			int numerodaconta = sc.nextInt();
			System.out.print("Titular da Conta: ");
			sc.nextLine();
			String titular = sc.nextLine();
			Conta conta = new Conta(numerodaconta, titular);
			
			System.out.print("Deposito inicial acima de R$500,00: ");
			double deposito = sc.nextDouble();
			Conta conta1 = new Conta(numerodaconta, titular, deposito, 300.00);

			System.out.print("Deseja fazer alguma operação?(s/n) ");
			char y = sc.next().charAt(0);
			if (y == 's') {
				do {
					System.out.print("Digite 1 para deposito, 2 para saque ou 3 para consulta:");
					char x = sc.next().charAt(0);
					switch (x) {
					case '1':
						System.out.print("Valor do depósito:");
						double valor = sc.nextDouble();
						conta.deposito(valor);
						break;
					case '2':
						System.out.print("Valor do saque:");
						valor = sc.nextDouble();
						conta.saque(valor);
						break;
					case '3':
						System.out.print(conta.toString());
						break;
					default:
						System.out.print("Dígito inválido");
						break;
					}
					System.out.print("Deseja fazer alguma operação?(s/n) ");
					y = sc.next().charAt(0);
				} while (y == 's');
			}

			System.out.print(conta.toString());
		}

		catch (ContaException e) {
			System.out.println(e.getMessage());
		}

	}
}
