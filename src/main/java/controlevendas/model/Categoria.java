package controlevendas.model;

public class Categoria {
    private int codCategoria;
    private String nome;
    private String dataCadastro;
    private String descricao;
    
    public Categoria() {
        this.codCategoria = 0;
        this.nome = new String();
        this.descricao = new String();
        this.dataCadastro = new String();
    }
    
    public Categoria(String nome, String descricao, String dataCadastro) {
        this.codCategoria = 0;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.descricao = descricao;
    }
    
    public Categoria(int codCategoria, String nome, String descricao, String dataCadastro) {
        this.codCategoria = codCategoria;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.descricao = descricao;
    }
    
//    public Categoria(int codCategoria, String nome, String descricao) {
//        this.codCategoria = codCategoria;
//        this.nome = nome;
//        this.descricao = descricao;
//        this.dataCadastro = new String();
//    }
    
    /*======================================================================
    * MÉTODOS GETTERS E SETTERS
    ======================================================================*/
    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
