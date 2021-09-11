package controlevendas.model;

import java.util.ArrayList;

public class Produto {
    private int cod;
    private String nome;
    private double preco;
    private int qtdEstoque;
    private double peso;
    private double largura;
    private String descricao;
    private String dataCadastro;
    private ArrayList<Categoria> categorias;
    
    public Produto() {
        this.cod = 0;
        this.nome = new String();
        this.preco = 0;
        this.qtdEstoque = 0;
        this.peso = 0;
        this.largura = 0;
        this.descricao = new String();
        this.dataCadastro = new String();
        this.categorias = new ArrayList<>();
    }

    public Produto(int cod, String nome, double preco, int qtdEstoque, double peso, double largura, String descricao, String dataCadastro, ArrayList<Categoria> categorias) {
        this.cod = cod;
        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.peso = peso;
        this.largura = largura;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.categorias = categorias;
    }
    
    public Produto(String nome, double preco, int qtdEstoque, double peso, double largura, String descricao, ArrayList<Categoria> categorias) {
        this.cod = 0;
        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.peso = peso;
        this.largura = largura;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.categorias = categorias;
    }
    
    public Produto(int cod, String nome, double preco, int qtdEstoque, double peso, double largura, String descricao, String dataCadastro) {
        this.cod = cod;
        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.peso = peso;
        this.largura = largura;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.categorias = new ArrayList<>();
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
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

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }
}
