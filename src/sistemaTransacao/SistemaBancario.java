package sistemaTransacao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

class SistemaBancario implements TransacaoCallback {
    private Map<String, Empresa> empresas;
    private Map<String, Cliente> clientes;

    public SistemaBancario() {
        empresas = new HashMap<>();
        clientes = new HashMap<>();
    }

    public void adicionarEmpresa(String nome, String cnpj, BigDecimal saldoInicial, BigDecimal taxa) {
        if (ValidadorDocumentos.validarCNPJ(cnpj)) {
            empresas.put(cnpj, new Empresa(nome, cnpj, saldoInicial, taxa));
        } else {
            System.out.println("CNPJ inválido.");
        }
    }

    public void adicionarCliente(String nome, String cpf) {
        if (ValidadorDocumentos.validarCPF(cpf)) {
            clientes.put(cpf, new Cliente(nome, cpf));
        } else {
            System.out.println("CPF inválido.");
        }
    }

    public void realizarDeposito(String cnpjEmpresa, String cpfCliente, BigDecimal valor) {
        Empresa empresa = empresas.get(cnpjEmpresa);
        Cliente cliente = clientes.get(cpfCliente);
        if (empresa != null && cliente != null) {
            empresa.realizarDeposito(valor);
            Notificador.enviarCallbackEmpresa(this, empresa, cliente, valor, "depósito");
            Notificador.notificarCliente(cliente, "Depósito realizado com sucesso.");
            System.out.println("");
        } else {
            System.out.println("Empresa ou cliente não encontrados.");
            System.out.println("");
        }
    }

    public void realizarSaque(String cnpjEmpresa, String cpfCliente, BigDecimal valor) {
        Empresa empresa = empresas.get(cnpjEmpresa);
        Cliente cliente = clientes.get(cpfCliente);
        if (empresa != null && cliente != null && empresa.getSaldo().compareTo(valor) >= 0) {
            empresa.realizarSaque(valor);
            Notificador.enviarCallbackEmpresa(this, empresa, cliente, valor, "saque");
            System.out.println("");
            Notificador.notificarCliente(cliente, "Saque realizado com sucesso.");
            System.out.println("");
        } else {
            System.out.println("Empresa ou cliente não encontrados ou saldo insuficiente.");
        }
    }

    @Override
    public void notificarTransacao(Empresa empresa, Cliente cliente, BigDecimal valor, String tipoTransacao) {
        // Implementação do callback
        System.out.println("Transação realizada: " + tipoTransacao + " de " + valor + " por " + cliente.getNome() + " na empresa " + empresa.getNome());
        System.out.println("");
    }

    // Método adicional para ver o saldo da empresa - apenas para fins de demonstração
    public void imprimirSaldoEmpresa(String cnpj) {
        Empresa empresa = empresas.get(cnpj);
        if (empresa != null) {
            System.out.println("Saldo da empresa " + empresa.getNome() + ": " + empresa.getSaldo());
            System.out.println("");
        }
    }
}
