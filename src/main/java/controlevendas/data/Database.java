package controlevendas.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Database {
    private Connection conn;
    
    /**
     * Realiza conexão com o banco de dados
     */
    public Database() {
        try {
            String dbName = "controle_vendas";
            String user = "root";
            String password = "Admin@123*";
            String server = "jdbc:mysql://localhost:3306/"+dbName+"?zeroDateTimeBehavior=CONVERT_TO_NULL";
            
            conn = DriverManager.getConnection(server, user, password);
        } catch (SQLException e) {
            System.err.println("ERROR CONNECTION: " + e.getMessage());
        }
    }

    /**
     * Método responsável por inserir dados no bd
     * @param datas - Dados que serão inseridos no bd. Vindo de um HashMap (Array com chaves e valores)
     * @param tableName
     * @return quantidade de linhas afetadas no BD
     * @throws SQLException
     */
    public int insertData(HashMap datas, String tableName) throws SQLException {
        String fieldsDatabase = (String) datas.keySet().stream().collect(Collectors.joining(","));
        String values = new String();

        for(int i=0; i<datas.size(); i++) {
            if(i == datas.size()-1)
                values += "?";
            else
                values += "?,"; 
        }
        
        String query = "INSERT INTO " + tableName + " (" + fieldsDatabase + ") VALUES (" + values + ")";
         
        return executeQuery(query, datas, 0);
    }
    
    /**
     *
     * @param datas - Dados que serão inseridos no bd. Vindo de um HashMap (Array com chaves e valores) 
     * @param cod - Código da linha que será atualizada no bd
     * @param nameColumnIdentify - Nome da coluna que possui o código de identificação
     * @param tableName - Nome da Tabela
     * @return 
     * @throws SQLException
     * @throws Exception
     */
    public int updateData(HashMap datas, int cod, String nameColumnIdentify, String tableName) throws SQLException, Exception {
        if(cod <= 0) throw new Exception("Não foi inserido o código dos dados que serão atualizados.");
                
        // TRATANDO OS DADOS
        String fieldsSetDatabase = (String) datas.keySet().stream().collect(Collectors.joining("=?,"));
        String query = "UPDATE " + tableName + " SET " + fieldsSetDatabase + "=? WHERE " + nameColumnIdentify + "=?";
         
        return executeQuery(query, datas, cod);
    }
    
    public int deleteData(int cod, String nameColumnIdentify, String tableName) throws SQLException, Exception {
        if(cod <= 0) throw new Exception("Não foi inserido o código dos dados que serão excluídos.");
        
        HashMap<String, Integer> datas = new HashMap<>();
        // GERANDO A QUERY
        String query = "DELETE FROM " + tableName + " WHERE " + nameColumnIdentify + "=?";
        datas.put("cod", cod);
         
        return executeQuery(query, datas, 0);
    }

    /**
     * @param tableName
     * @param join - Juncao (nome_tabela on nome_tabela1.nome_coluna = nome_da_tabela2.nome_coluna)
     * @param fields - Caso seja junção (nome_tabela.nome_coluna1...). Caso seja SELECT simples (nome_coluna1, nome_coluna2...)
     * @param where - Condição para seleção (codigo = 10)
     * @param order - Ordenação da seleção (nome_da_coluna_de_ordenacao asc || desc)
     * @param limitItems - Quantidade de itens que deseja no retorno
     * @return data - Retorna os dados retornados do BD
     * @throws java.sql.SQLException
     */
    public ArrayList<HashMap> getData(String tableName, String fields, String join, String where, ArrayList<String> params, String order, int limitItems) throws SQLException, Exception {
        fields = (!fields.isEmpty()) ? fields : "*";
        join = (!join.isEmpty()) ? "INNER JOIN " + join : "";
        where  = (!where.isEmpty()) ? "WHERE " + where : "";
        order  = (!order.isEmpty()) ? "ORDER BY " + order : "";
        String limit  = (limitItems > 0) ? "LIMIT " + limitItems : "";
        
        // EXECUTANDO QUERY
        String query = ("SELECT " +fields+ " FROM " +tableName+ " " +join+ " " +where+ " " +order+ " " +limit).trim();
        PreparedStatement statement = conn.prepareStatement(query);
        
        // SETANDO PARAMETROS DA QUERY
        if(params.size() > 0) {
            for(int i=0; i < params.size(); i++)
            statement.setObject(i+1, params.get(i));
        }
        
        ResultSet rs = statement.executeQuery();
        
        ArrayList<HashMap> data = new ArrayList<>();
        ResultSetMetaData metaData = rs.getMetaData(); // METADATA DA TABELA DOS DADOS RETORNADOS
        
        while (rs.next()) {
            HashMap<String, String> dataColumns = new HashMap<>();
            
            // PERCORRENDO TODAS AS COLUNAS/LINHAS DA TABELA
            for (int i = 1; i <= metaData.getColumnCount(); i++) { 
                dataColumns.put(metaData.getColumnLabel(i), rs.getString(i));
            }
            
            // ADICIONANDO OS DADOS PERCORRIDO AO ARRAYLIST DE DADOS
            data.add(dataColumns);
        }
        
        return data;
    }
    
    /**
     * Método responsável por executar as queries SQL dinâmicamente
     * @param query - Query SQL para execução
     * @param params - Parâmetros da SQL
     * @return int
     */
    private int executeQuery(String query, HashMap params, int cod) throws SQLException {
        int id = 0;
                
        try {
            conn.setAutoCommit(false); // CONTROLE DE TRANSAÇÃO
            
            ArrayList values = new ArrayList(params.values());
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            // SETANDO VALORES DOS PARAMETROS DA QUERY
            for(int i=0; i < params.size(); i++)
                statement.setObject(i+1, values.get(i));
            
            // SETANDO CÓDIGO DO WHERE
            if(cod > 0) statement.setInt(params.size()+1, cod);
            
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            
            while(rs.next()) {
                id = rs.getInt(1);
            }
            
            return id;
        } catch (SQLException ex) {
            conn.rollback();
            throw new SQLException(ex);
        }
    }
    
    /**
     * @return - Conexao DB
     */
    public Connection getDatabase() {
        return conn;
    }
}
