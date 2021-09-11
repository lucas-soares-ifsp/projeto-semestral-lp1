package controlevendas.model;

import java.util.ArrayList;

public class Pedido {
    private int cod;
    private int codUsuario;
    private double total;
    private String descricao;
    private String data;
    private ArrayList<Produto> itens;
    
    public Pedido() {
        this.cod = 0;
        this.codUsuario = 0;
        this.total = 0;
        this.descricao = new String();
        this.data = new String();
        this.itens = new ArrayList<>();
    }

    public Pedido(int cod, int codUsuario, double total, String descricao, String data, ArrayList<Produto> itens) {
        this.cod = cod;
        this.codUsuario = codUsuario;
        this.total = total;
        this.descricao = descricao;
        this.data = data;
        this.itens = itens;
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

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Produto> itens) {
        this.itens = itens;
    }
}
