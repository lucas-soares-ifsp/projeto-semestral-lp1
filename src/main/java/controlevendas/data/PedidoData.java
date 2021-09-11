package controlevendas.data;

import controlevendas.model.Pedido;
import controlevendas.model.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class PedidoData extends Database {
    private final String TABLE_PEDIDOS = "pedidos";
    private final String TABLE_PRODUTOS = "produtos";
    private final String TABLE_ITEMS_PEDIDOS = "itens_pedidos";
    
    public int insert(Pedido order) throws SQLException {        
        // INSERINDO PEDIDO NO BD
        int codOrder = insertData(setValuesPedido(order), TABLE_PEDIDOS);
        
        // INSERIR ITENS DO PEDIDO        
        insertProdutosPedido(order, codOrder);
        
        getDatabase().commit();
        
        // SETANDO O CÓDIGO DO PEDIDO
        order.setCod(codOrder);
        
        return codOrder;
    }
    
    /**
     * Método que seta todos os valores do pedido em um HasMap
     * @param Pedido
     * @return HashMap
     */
    private HashMap<String, String> setValuesPedido(Pedido order) {
        HashMap<String, String> dataOrder = new HashMap<>();
        
        // CHAVE DO ARRAY É O NOME DA COLUNA NO BD E O VALOR DO CORRESPONDENTE
        dataOrder.put("cod_pedido", String.valueOf(order.getCod()));
        dataOrder.put("cod_usuario", String.valueOf(order.getCodUsuario()));
        dataOrder.put("total_pedido", String.valueOf(order.getTotal()));
        dataOrder.put("descricao_pedido", order.getDescricao());
        
        return dataOrder;
    }
    
    /**
     * Método insere os produtos no pedido
     * @param order
     * @param codOrder
     * @throws SQLException
     */
    private boolean insertProdutosPedido(Pedido order, int codOrder) throws SQLException {        
        // INSERIR ITENS DO PEDIDO        
        for(Produto product : order.getItens()) {
            HashMap<String, Integer> itemsOrder = new HashMap<>();
                
            itemsOrder.put("cod_pedido", codOrder);
            itemsOrder.put("cod_produto", product.getCod());
            insertData(itemsOrder, TABLE_ITEMS_PEDIDOS);
        }
        
        return true;
    }
    
    
    /**
     * Métodos que realizam a busca dos produtos no bd
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public ArrayList<Pedido> getOrders() throws SQLException, Exception {        
        return get(getData(TABLE_PEDIDOS, "",  "", "", new ArrayList(), "", 0)); // BUSCANDO OS PEDIDOS NO BD
    }
    
    public ArrayList<Pedido> getOrders(String value) throws SQLException, Exception {
        String where = (value != "") ? "descricao_pedido LIKE '%"+ value +"%'" : "";
        return get(getData(TABLE_PEDIDOS, "",  "", where, new ArrayList(), "", 0)); // BUSCANDO OS PEDIDOS NO BD
    }
    
    private ArrayList<Pedido> get(ArrayList<HashMap> getOrders) throws Exception {
        ArrayList<Pedido> orders = new ArrayList<>(); // LISTA DE PEDIDOS
        
        for(HashMap order : getOrders) {
            // SELECIONANDO OS ITENS DO PEDIDO
            ArrayList<HashMap> getItemsOrder = getData(TABLE_ITEMS_PEDIDOS, TABLE_ITEMS_PEDIDOS+".cod_pedido,"+
                                                       TABLE_PRODUTOS+".cod_produto, nome_produto, preco_produto, estoque,"+
                                                       "peso_produto, largura_produto, descricao_produto, data_cadastro_produto",
                                                       TABLE_PRODUTOS+" ON "+TABLE_ITEMS_PEDIDOS+".cod_pedido = "+ order.get("cod_pedido") +
                                                       " AND "+TABLE_ITEMS_PEDIDOS+".cod_produto = "+TABLE_PRODUTOS+".cod_produto", "", 
                                                       new ArrayList(), "", 0);
            
            ArrayList<Produto> itemsOrder = new ArrayList<>();
            
            // ADICIONANDO AS ITENS DO PEDIDO AO ARRAYLIST
            for(HashMap itemOrder : getItemsOrder) {                
                itemsOrder.add(new Produto(
                    Integer.parseInt((String) itemOrder.get("cod_produto")),
                    (String) itemOrder.get("nome_produto"),
                    Double.parseDouble((String) itemOrder.get("preco_produto")),
                    Integer.parseInt((String) itemOrder.get("estoque")),
                    Double.parseDouble((String) itemOrder.get("peso_produto")),
                    Double.parseDouble((String) itemOrder.get("largura_produto")),
                    (String) itemOrder.get("descricao_produto"),
                    (String) itemOrder.get("data_cadastro_produto")
                ));
            }
            
            // ADICIONANDO OS PEDIDOS NA LISTA DE PEDIDOS
            orders.add(new Pedido(
                Integer.parseInt((String) order.get("cod_pedido")),
                Integer.parseInt((String) order.get("cod_usuario")),
                Double.parseDouble((String) order.get("total_pedido")),
                (String) order.get("descricao_pedido"),
                (String) order.get("data_pedido"),
                itemsOrder
            ));
        }
        
        return orders;
    }
    
    /**
     * DELETA PEDIDO
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public boolean delete(int codPedido) throws SQLException, Exception {
        deleteData(codPedido, "cod_pedido", TABLE_ITEMS_PEDIDOS);
        deleteData(codPedido, "cod_pedido", TABLE_PEDIDOS);
        getDatabase().commit();
        
        return true;
    }
    
    /**
     * ATUALIZA O PEDIDO
     * @param objPedido
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public int update(Pedido objPedido) throws SQLException, Exception {
        // DELETANDO TODOS OS ITENS PERTENCENTES AO PEDIDO
        deleteData(objPedido.getCod(), "cod_pedido", TABLE_ITEMS_PEDIDOS);
        // ATUALIZANDO O PRODUTO
        updateData(setValuesPedido(objPedido), objPedido.getCod(), "cod_pedido", TABLE_PEDIDOS);
        // INSERINDO AS CATEGORIAS
        insertProdutosPedido(objPedido, objPedido.getCod());
        getDatabase().commit();
        
        return objPedido.getCod();
    }  
}