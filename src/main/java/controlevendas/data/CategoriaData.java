package controlevendas.data;

import controlevendas.model.Categoria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class CategoriaData extends Database {
    private final String TABLE = "categorias";
            
    public ArrayList<Categoria> getCategories() throws Exception {
        return get("");
    }
    
    public ArrayList<Categoria> getCategories(String name) throws Exception {
        return get(name);
    }
    
    private ArrayList<Categoria> get(String where) throws SQLException, Exception {
        where = (where != "") ? "nome_categoria LIKE '%"+ where +"%' OR descricao_categoria LIKE '%"+ where +"%'" : "";
        ArrayList<HashMap> getCategories = getData(TABLE, "",  "", where, new ArrayList(), "", 0); // SELECIONANDO CATEGORIAS NO BD
        ArrayList<Categoria> categories = new ArrayList<>(); // LISTA DE CATEGORIAS
        
        // ADICIONANDO CATEGORIAS NO ARRAYLIST
        for(HashMap category : getCategories) {
            categories.add(new Categoria(
                Integer.parseInt((String) category.get("cod_categoria")),
                (String) category.get("nome_categoria"),
                (String) category.get("descricao_categoria"),
                (String) category.get("data_cadastro_categoria")
            ));
        }
        
        return categories;
    }
    
    public int insert(Categoria objCategory) throws SQLException {
        HashMap<String, String> dataCategory = new HashMap<>();
            
        // CHAVE DO ARRAY É O NOME DA COLUNA NO BD E O VALOR DO CORRESPONDENTE
        dataCategory.put("nome_categoria", objCategory.getNome());
        dataCategory.put("descricao_categoria", objCategory.getDescricao());
        objCategory.setCodCategoria(insertData(dataCategory, TABLE));
        getDatabase().commit();
        
        return objCategory.getCodCategoria();
    }
    
    public int update(Categoria objCategory) throws SQLException, Exception {
        HashMap<String, String> dataCategory = new HashMap<>();
        
        // CHAVE DO ARRAY É O NOME DA COLUNA NO BD E O VALOR DO CORRESPONDENTE
        dataCategory.put("nome_categoria", objCategory.getNome());
        dataCategory.put("descricao_categoria", objCategory.getDescricao());
        dataCategory.put("cod_categoria", String.valueOf(objCategory.getCodCategoria()));
        objCategory.setCodCategoria(updateData(dataCategory, objCategory.getCodCategoria(), "cod_categoria", TABLE));
        getDatabase().commit();
        
        return objCategory.getCodCategoria();
    }
    
    public boolean delete(int cod) throws SQLException, Exception {
        deleteData(cod, "cod_categoria", TABLE);
        getDatabase().commit();
        
        return true;
    }
}
