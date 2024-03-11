package sistemaTransacao;

import java.math.BigDecimal;

class Notificador {
	
	
    // Simulando notificações
    static void notificarCliente(Cliente cliente, String mensagem) {
    	 System.out.println("");
        System.out.println("Notificando cliente " + cliente.getNome() + ": " + mensagem);
       
    }
    
    static void enviarCallbackEmpresa(TransacaoCallback callback, Empresa empresa, Cliente cliente, BigDecimal valor, String tipoTransacao) {
        callback.notificarTransacao(empresa, cliente, valor, tipoTransacao);
        
        
        // Simulando envio de callback (poderia ser uma chamada HTTP a um webhook, por exemplo)
        System.out.println("Enviando callback para a empresa " + empresa.getNome());
    }
}

