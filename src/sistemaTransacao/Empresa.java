package sistemaTransacao;

import java.math.BigDecimal;

class Empresa extends Usuario implements TaxaAdministrativa {
    private String cnpj;
    private BigDecimal saldo;
    private BigDecimal taxa;

    public Empresa(String nome, String cnpj, BigDecimal saldo, BigDecimal taxa) {
        super(nome);
        this.cnpj = cnpj;
        this.saldo = saldo;
        this.taxa = taxa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void realizarDeposito(BigDecimal valor) {
        this.saldo = saldo.add(valor);
    }

    public void realizarSaque(BigDecimal valor) {
        this.saldo = saldo.subtract(valor).subtract(calcularTaxa(valor));
    }

    @Override
    public BigDecimal calcularTaxa(BigDecimal valorTransacao) {
        return valorTransacao.multiply(taxa);
    }
}

