package controlevendas.model;

public class Administrador extends Usuario {
    private String senha;

    public Administrador() {
        senha = new String();
        this.tipo = "administrador";
    }

    public Administrador(int cod, String nome, String email, String telefone, String cpf, String senha) {
        super(cod, nome, email, telefone, cpf);
        this.tipo = "administrador";
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
