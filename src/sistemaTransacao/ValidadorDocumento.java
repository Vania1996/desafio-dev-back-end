package sistemaTransacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ValidadorDocumentos {
    public static boolean validarCPF(String cpf) {
        // Implementação da validação do CPF
 
        Pattern pattern = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}");
        Matcher matcher = pattern.matcher(cpf);
        return matcher.matches();
    }

    public static boolean validarCNPJ(String cnpj) {
        // Implementação da validação do CNPJ
      
        Pattern pattern = Pattern.compile("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}\\-\\d{2}");
        Matcher matcher = pattern.matcher(cnpj);
        return matcher.matches();
    }
}
