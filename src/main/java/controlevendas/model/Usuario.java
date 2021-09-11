package controlevendas.model;

public class Usuario {
    protected int cod;
    protected String nome;
    protected String email;
    protected String telefone;
    protected String cpf;
    protected String tipo = "usuario";
    protected String dataCadastro;
    
    /**
     * CONSTRUTOR QUE NÃO RECEBE PARÂMETROS
     */
    public Usuario() {
        this.cod = 0;
        this.nome = new String();
        this.email = new String();
        this.telefone = new String();
        this.cpf = new String(); 
        this.dataCadastro = new String();
    }
   
    /**
     * CONSTRUTOR QUE RECEBE TODOS OS PARÂMETROS EXCETO O CODIGO DO USUARIO
     * @param nome
     * @param email
     * @param telefone
     * @param cpf
     */
    public Usuario(String nome, String email, String telefone, String cpf) {
        this.cod = 0;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.dataCadastro = new String();
    }
    
    /**
     * CONSTRUTOR QUE RECEBE TODOS OS PARÂMETROS
     * @param cod
     * @param nome
     * @param email
     * @param telefone
     * @param cpf
     */
    public Usuario(int cod, String nome, String email, String telefone, String cpf) {
        this.cod = cod;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.dataCadastro = new String();
    }
    
    public Usuario(int cod, String nome, String email, String telefone, String cpf, String tipo, String dataCadastro) {
        this.cod = cod;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.tipo = tipo;
        this.dataCadastro = dataCadastro;
    }
    
   /*======================================================================
    * MÉTODOS GETTERS E SETTERS
    ======================================================================*/
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}