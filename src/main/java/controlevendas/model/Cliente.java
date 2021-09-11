package controlevendas.model;

public class Cliente extends Usuario {
    private String dataNascimento;

    public Cliente() {
        this.tipo = "cliente";
        this.dataNascimento = new String();
    }
    
    public Cliente(String dataNascimento) {
        this.tipo = "cliente";
        this.dataNascimento = dataNascimento;
    }

    public Cliente(String nome, String email, String telefone, String cpf, String dataNascimento) {
        super(nome, email, telefone, cpf);
        this.tipo = "cliente";
        this.dataNascimento = dataNascimento;
    }

    /*======================================================================
    * MÉTODOS GETTERS E SETTERS
    ======================================================================*/
    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
