package controlevendas.data;

import controlevendas.model.Administrador;
import controlevendas.model.Cliente;
import controlevendas.model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class UsuarioData extends Database {
    private final String TAB_USUARIOS = "usuarios";
    private final String TAB_CLIENTES = "clientes";
    private final String TAB_ADMINS = "administradores";
    
    /**
     * Método que trata os dados para insercao no banco de dados
     * @param objUser
     * @return
     * @throws SQLException
     */
    public int insert(Usuario objUser) throws SQLException {        
        objUser.setCod(insertData(dataUser(objUser), TAB_USUARIOS));
  
        if(objUser instanceof Administrador)
            insertDataAdmin((Administrador) objUser);
        
        if(objUser instanceof Cliente)
            insertDataClient((Cliente) objUser);
        
        getDatabase().commit();
        
        return objUser.getCod();
    }
    
    public int update(Usuario objUser) throws SQLException, Exception {        
        objUser.setCod(updateData(dataUser(objUser), objUser.getCod(), "cod_usuario", TAB_USUARIOS));
        getDatabase().commit();
        
        return objUser.getCod();
    }
    
    /**
     * VALIDAR LOGIN ADMINISTRADOR
     * @param email
     * @param password
     * @return Usuario
     * @throws Exception
     */
    public Usuario login(String email, String password) throws Exception {
        // PREPARANDO OS PARÂMETROS DA QUERY
        ArrayList<String> params = new ArrayList();
        params.add(email);
        params.add(password);
        
        // BUSCANDO ADMIN NO BD
        ArrayList<HashMap> getUsers = getData(TAB_USUARIOS, "",  TAB_ADMINS, "email_usuario=? AND senha_admin=?", params, "", 0);
        
        // RETORNANDO OBJETO COM OS DADOS
        for(HashMap user : getUsers) {   
            return new Administrador(
                Integer.parseInt((String) user.get("cod_usuario")),
                (String) user.get("nome_usuario"),
                (String) user.get("email_usuario"),
                (String) user.get("telefone__usuario"),
                (String) user.get("cpf_usuario"),
                (String) user.get("senha_admin")
            );
        }
        
        return null;
    }
    
    // RETORNA TODOS OS USUARIOS
    public ArrayList<Usuario> getUsers() throws Exception {
        return get("");
    }
    
    // RETORNA TODOS USUARIOS QUE CONTEM NOME OU EMAIL COM O VALOR DIGITADO
    public ArrayList<Usuario> getUsers(String nameEmailUser) throws Exception {
        return get("nome_usuario LIKE '%"+nameEmailUser+"%' OR email_usuario LIKE '%"+nameEmailUser+"%'");
    }
    
    private ArrayList<Usuario> get(String where) throws SQLException, Exception {
        ArrayList<HashMap> getUsers = getData(TAB_USUARIOS, "",  "", where, new ArrayList<>(), "", 0); // SELECIONANDO USUARIOS NO BD
        ArrayList<Usuario> users = new ArrayList<>(); // LISTA DE PRODUTOS
        
        // Percorre o HashMap de dados retornados do bd e cria(instancia) de usuarios
        for(HashMap user : getUsers) {
            users.add(new Usuario(
                Integer.parseInt((String) user.get("cod_usuario")),
                (String) user.get("nome_usuario"),
                (String) user.get("email_usuario"),
                (String) user.get("telefone__usuario"),
                (String) user.get("cpf_usuario"),
                (String) user.get("tipo_usuario"),
                (String) user.get("data_cadastro_usuario")
            ));
        }
        
        return users;
    }
    
    /**
     * DELETAR USUÁRIO
     * @param cod
     * @param typeUser
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public boolean delete(int cod, String typeUser) throws SQLException, Exception {
        deleteData(cod, "cod_usuario", TAB_ADMINS);
        deleteData(cod, "cod_usuario", TAB_CLIENTES);
        deleteData(cod, "cod_usuario", TAB_USUARIOS);
        getDatabase().commit();
        
        return true;
    } 
    
    /******************************************************************************
     * FUNÇÕES ADICIONAIS
     ******************************************************************************/
    private HashMap<String, String> dataUser(Usuario objUser) {
        HashMap<String, String> dataUser = new HashMap<>();
        
        // CHAVE DO ARRAY É O NOME DA COLUNA NO BD E O VALOR DO CORRESPONDENTE
        dataUser.put("nome_usuario", objUser.getNome());
        dataUser.put("email_usuario", objUser.getEmail());
        dataUser.put("telefone__usuario", objUser.getTelefone());
        dataUser.put("cpf_usuario", objUser.getCpf());
        dataUser.put("tipo_usuario", objUser.getTipo());
        
        return dataUser;
    }
    
    private void insertDataAdmin(Administrador objAdmin) throws SQLException {
        HashMap<String, String> dataAdmin = new HashMap<>();
        dataAdmin.put("cod_usuario", String.valueOf(objAdmin.getCod()));
        dataAdmin.put("senha_admin", objAdmin.getSenha());
        
        insertData(dataAdmin, TAB_ADMINS);
    }
    
    private void insertDataClient(Cliente objClient) throws SQLException {
        HashMap<String, String> dataClient = new HashMap<>();
        dataClient.put("cod_usuario", String.valueOf(objClient.getCod()));
        dataClient.put("data_nascimento_cliente", objClient.getDataNascimento());
        
        insertData(dataClient, TAB_CLIENTES);
    }
}

