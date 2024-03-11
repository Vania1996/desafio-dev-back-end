package sistemaTransacao;

class Cliente extends Usuario {
    private String cpf;

    
    
    public Cliente(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
