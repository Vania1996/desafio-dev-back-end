package sistemaTransacao;

import java.math.BigDecimal;

interface TransacaoCallback {
    void notificarTransacao(Empresa empresa, Cliente cliente, BigDecimal valor, String tipoTransacao);
}

