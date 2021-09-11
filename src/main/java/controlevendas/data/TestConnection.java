package controlevendas.data;

import controlevendas.model.Administrador;
import controlevendas.model.Categoria;
import controlevendas.model.Cliente;
import controlevendas.model.Pedido;
import controlevendas.model.Produto;
import controlevendas.model.Usuario;
import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TestConnection {
    
    
    
    
     public static void main(String[] args) {
         try {
            /*********************************************
             * TESTE USUÁRIO
             * *****************************************/
//            Usuario objUser = new Usuario("Lucas 002", "lucassoares@teste.com", "(17)9999-9999", "999.888.888-88");
//            UsuarioData objUserData = new UsuarioData();
//             if(objUserData.insert(objUser)> 0) {
//                 JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso, codigo = " + objUser.getCod());         
//             }


            /*********************************************
             * TESTE ADMINISTRADOR
             * *****************************************/
//             Administrador objAdmin = new Administrador("Lucas teste", "teste@teste.com", "(17)9999-9999", "999.888.888-88", "teste-senha");
//             
//             if(objUserData.insert(objAdmin)> 0) {
//                 JOptionPane.showMessageDialog(null, "Administrador cadastrado com sucesso, codigo = " + objAdmin.getCod());
//             }


             /*********************************************
             * TESTE CLIENTE
             * *****************************************/
//             Cliente objClient = new Cliente("Lucas Soares", "lucassoares@teste.com", "(17)9999-9999", "999.888.888-88", "2002-10-28");
//             
//             if(objUserData.insert(objClient)> 0) {
//                 JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso, codigo = " + objClient.getCod());
//             }


            /*********************************************
             * TESTE CATEGORIA
             * *****************************************/
//            Categoria objCategoria = new Categoria("Calças", "A melhor coleção de calças já vista");
            CategoriaData objCategoriaData = new CategoriaData();
   
            objCategoriaData.getCategories();

//            if(objCategoriaData.insert(objCategoria)> 0) {
//                JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso, codigo = " + objCategoria.getCodCategoria());
//            }
            

            /*********************************************
             * INSERINDO PRODUTOS
             * *****************************************/
            // ARRAYLIST COM AS CATEGORIAS DO PRODUTO
//            ArrayList<Categoria> arrayCategories = new ArrayList<>();
//            
//            for(int i=1; i<=4; i++) {
//                Categoria categoria = new Categoria(i, "teste", "descricao-teste");
//                arrayCategories.add(categoria);
//            }
//            
//            // INSTANCIANDO OS OBJETOS 
//            Produto objProduto = new Produto("Bermuda verão", 200, 3, 10, 15, "Lorem ipsum description Bermuda", arrayCategories);
            ProdutoData objProdutoData = new ProdutoData();
//            
//            // INSERINDO O PRODUTO NO BD                 
//            if(objProdutoData.insert(objProduto) > 0) {
//                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso, codigo = " + objProduto.getCod());
//            }
            

            /*********************************************
             * SELECIONANDO PRODUTOS
             * *****************************************/
            ArrayList<Produto> produtos = objProdutoData.getProducts();
            
            for(Produto product : produtos) {  
                // MONTANDO STRING DAS CATEGORIAS
                String sCategorias = "";                
                for(Categoria cat : product.getCategorias())
                    sCategorias += "\n" + cat.getNome();
                
                // EXIBINDO DADOS DO PRODUTO
                JOptionPane.showMessageDialog(null, "Produto id = " + product.getCod() + "\n" +
                                              "Título do produto: " + product.getNome() + "\n" +
                                              "Preço do produto: " + product.getPreco() + "\n" +
                                              "Peso do produto: " + product.getPeso()+ "\n" +
                                              "Largura do produto: " + product.getLargura() + "\n\n" +
                                              "Estoque do produto: " + product.getQtdEstoque() + "\n" +
                                              "Descricao do produto: " + product.getDescricao()+ "\n\n" +
                                              "Descricao do produto: " + product.getDataCadastro()+ "\n\n" +
                                              "========= Categorias ========== " + sCategorias);
            }
            
            
            /*********************************************
             * CADASTRANDO PEDIDOS
             * *****************************************/
//            PedidoData objPedidoData = new PedidoData();
//            Pedido objPedido = new Pedido();
//            ArrayList<Produto> arrayProducts = new ArrayList<>();
//            Double totalOrder = 0.00;
//            
//            for(int i=1; i<=3; i++) {
//                Produto prod = new Produto(i, "nome-produto-"+i, 10.20, 10, 11, 10, "descricao-teste", "2021-03-28");
//                totalOrder += prod.getPreco();
//                arrayProducts.add(prod);
//            }
//            
//            objPedido.setCodUsuario(6);
//            objPedido.setDescricao("Descricao do meu pedido terceiro pedido");
//            objPedido.setItens(arrayProducts);
//            objPedido.setTotal(totalOrder);
//            
//            objPedidoData.insert(objPedido);
            
//             System.out.println("teste");
         } catch (Exception ex) {             
             JOptionPane.showMessageDialog(null, "ERRO AO BUSCAR PRODUTOS: " + ex);
         }
    }
     
}
