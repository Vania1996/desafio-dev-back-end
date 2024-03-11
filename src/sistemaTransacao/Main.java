package sistemaTransacao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		SistemaBancario sistemaBancario = new SistemaBancario();
		SistemaBancario sistemaBancario1 = new SistemaBancario();

		// Adicionando uma empresa
		sistemaBancario.adicionarEmpresa("Empresa XPTO", "12.345.678/0001-91", new BigDecimal("100000.00"),
				new BigDecimal("0.02"));

		// Adicionando clientes
		sistemaBancario.adicionarCliente("José Silva", "123.456.789-09");
		sistemaBancario.adicionarCliente("Maria Souza", "987.654.321-00");

		// Realizando operações como depósito e saque
		sistemaBancario.realizarDeposito("12.345.678/0001-91", "123.456.789-09", new BigDecimal("500.00"));
		sistemaBancario.realizarSaque("12.345.678/0001-91", "987.654.321-00", new BigDecimal("200.00"));

		// Imprimindo saldo da empresa após as transações
		sistemaBancario.imprimirSaldoEmpresa("12.345.678/0001-91");

		
		
		
		//Adicionando nova empresa e cliente, fazendo saques e depositos 
		
		sistemaBancario1.adicionarEmpresa("Empresa Cardoso", "65.589.795/0001-54", new BigDecimal("300000.00"),new BigDecimal("0.02"));
		sistemaBancario1.imprimirSaldoEmpresa("65.589.795/0001-54");
		sistemaBancario1.adicionarCliente("Jessivania Barbosa da Silva", "444.263.528-51");
		sistemaBancario1.realizarSaque("65.589.795/0001-54", "444.263.528-51", new BigDecimal("200.00"));
		sistemaBancario1.realizarDeposito("65.589.795/0001-54", "444.263.528-51", new BigDecimal("500.00"));
		sistemaBancario1.imprimirSaldoEmpresa("65.589.795/0001-54");
		
		
		
	}
}