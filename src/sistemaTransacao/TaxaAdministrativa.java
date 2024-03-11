package sistemaTransacao;

import java.math.BigDecimal;

interface TaxaAdministrativa {
    BigDecimal calcularTaxa(BigDecimal valorTransacao);
}


