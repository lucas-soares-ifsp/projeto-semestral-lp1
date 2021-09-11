package controlevendas.data;

import controlevendas.model.Categoria;
import controlevendas.model.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProdutoData extends Database {
    private final String TAB_PRODUTOS = "produtos";
    private final String TAB_PROD_CAT = "produto_categoria";
    private final String TAB_CATEGORIAS = "categorias";
    
    /**
     * Método que trata os dados para insercao no bd
     * @param objProduct
     * @return Codigo do produto
     * @throws SQLException
     */
    public int insert(Produto objProduct) throws SQLException, Exception {
        // INSERINDO PRODUTO NO BD
        int codProduct = insertData(setValuesProduct(objProduct), TAB_PRODUTOS); // Inserindo os dados no bd

        insertCategoriesProduct(objProduct, codProduct); // MÉTODO DE INSERÇÃO DAS CATEGORIAS DO PRODUTO
        getDatabase().commit();
        objProduct.setCod(codProduct);
        
        return codProduct;
    }
    
    /**
     * Método que atualiza os dados no bd
     * @param objProduct
     * @return Codigo do produto
     * @throws SQLException
     */    
    public int update(Produto objProduct) throws SQLException, Exception {
        // DELETANDO TODAS AS CATEGORIAS PERTENCENTES AO PRODUTO
        deleteProductCategories(objProduct.getCod());
        // ATUALIZANDO O PRODUTO
        updateData(setValuesProduct(objProduct), objProduct.getCod(), "cod_produto", TAB_PRODUTOS);
        // INSERINDO AS CATEGORIAS
        insertCategoriesProduct(objProduct, objProduct.getCod());
        getDatabase().commit();
        
        return objProduct.getCod();
    }
    
    /**
     * Método que seta todos os valores do produto em um HasMap
     * @param objProduct
     * @return HashMap
     */
    private HashMap<String, String> setValuesProduct(Produto objProduct) {
        HashMap<String, String> dataProduct = new HashMap<>();
        
        // CHAVE DO ARRAY É O NOME DA COLUNA NO BD E O VALOR DO CORRESPONDENTE
        dataProduct.put("nome_produto", objProduct.getNome());
        dataProduct.put("preco_produto", String.valueOf(objProduct.getPreco()));        
        dataProduct.put("estoque", String.valueOf(objProduct.getQtdEstoque()));        
        dataProduct.put("peso_produto", String.valueOf(objProduct.getQtdEstoque()));        
        dataProduct.put("largura_produto", String.valueOf(objProduct.getLargura()));        
        dataProduct.put("descricao_produto", objProduct.getDescricao());
        
        return dataProduct;
    }
    
    /**
     * Método insere as categorias do produto no bd
     * @param objProduct
     * @param codProduct
     * @throws SQLException
     */
    private boolean insertCategoriesProduct(Produto objProduct, int codProduct) throws SQLException {     
        for(Categoria category : objProduct.getCategorias()) {
            HashMap<String, Integer> categoriesProduct = new HashMap<>();

            categoriesProduct.put("cod_produto", codProduct);
            categoriesProduct.put("cod_categoria", category.getCodCategoria());

            insertData(categoriesProduct, TAB_PROD_CAT);
        }
        
        return true;
    }
    
    /**
     * Métodos que realizam a busca dos produtos no bd
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public ArrayList<Produto> getProducts() throws SQLException, Exception {        
        return get(getData(TAB_PRODUTOS, "",  "", "", new ArrayList(), "", 0)); // BUSCANDO PRODUTOS NO BD
    }
    
    public ArrayList<Produto> getProducts(String value) throws SQLException, Exception {
        String where = (value != "") ? "nome_produto LIKE '%"+ value +"%' OR descricao_produto LIKE '%"+ value +"%'" : "";
        return get(getData(TAB_PRODUTOS, "",  "", where, new ArrayList(), "", 0)); // BUSCANDO PRODUTOS NO BD
    }
    
    private ArrayList<Produto> get(ArrayList<HashMap> getProducts) throws Exception {
        ArrayList<Produto> products = new ArrayList<>(); // LISTA DE PRODUTOS
        
        // Percorre o HashMap de dados retornados do bd e cria(instancia) novos produtos
        for(HashMap product : getProducts) {
            // SELECIONANDO CATEGORIAS DO PRODUTO
            ArrayList<HashMap> getCategories = getData(TAB_PROD_CAT, TAB_PROD_CAT+".cod_categoria,"+
                                                       TAB_CATEGORIAS+".descricao_categoria,"+TAB_CATEGORIAS+".nome_categoria",
                                                       TAB_CATEGORIAS+" ON "+TAB_PROD_CAT+".cod_categoria = "+TAB_CATEGORIAS+".cod_categoria",
                                                       TAB_PROD_CAT+".cod_produto = "+Integer.parseInt((String) product.get("cod_produto")), 
                                                       new ArrayList(), "", 0);
            
            ArrayList<Categoria> categories = new ArrayList<>();
            
            // ADICIONANDO AS CATEGORIAS AO ARRAYLIST
            for(HashMap category : getCategories) {
                categories.add(new Categoria(Integer.parseInt((String) category.get("cod_categoria")),
                                             (String) category.get("nome_categoria"),
                                             (String) category.get("descricao_categoria"),
                                             (String) category.get("data_cadastro_categoria")
                                            ));
            }            
            
            products.add(new Produto(
                Integer.parseInt((String) product.get("cod_produto")),
                (String) product.get("nome_produto"),
                Double.parseDouble((String) product.get("preco_produto")),
                Integer.parseInt((String) product.get("estoque")),
                Double.parseDouble((String) product.get("peso_produto")),
                Double.parseDouble((String) product.get("largura_produto")),
                (String) product.get("descricao_produto"),
                (String) product.get("data_cadastro_produto"),
                categories
            ));
        }
        
        return products;
    }
    
    public boolean delete(int cod) throws SQLException, Exception {
        deleteData(cod, "cod_produto", TAB_PROD_CAT);
        deleteData(cod, "cod_produto", TAB_PRODUTOS);
        getDatabase().commit();
        
        return true;
    }
    
    private boolean deleteProductCategories(int cod) throws Exception {
        deleteData(cod, "cod_produto", TAB_PROD_CAT);
        //getDatabase().commit();
        
        return true;
    }
}
