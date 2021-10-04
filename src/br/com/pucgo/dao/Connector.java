package br.com.pucgo.dao;

import java.sql.DriverManager;
import java.sql.Connection;

/**
 * Conexão de banco de dados usando JDBC
 */
public class Connector {
    private String driver = "mysql";
    private String host = "172.17.0.1";
    private String dbName = "survey";
    private Integer port = 3306;
    private String username = "puc";
    private String password = "puc";

    private String url = "jdbc:"+driver+"://"+host+":"+port+"/"+dbName+"?useSSL=false&allowPublicKeyRetrieval=true&userTimezone=true&serverTimezone=GMT";

    /**
     * Cria instância da classe Connection, garantia que o objeto seja
     * instanciado apenas uma vez.
     * 
     * @return Connection
     */
    public static Connector create() {
        Connector connected = null;

        if (connected == null) {
            connected = new Connector();
        }
        return connected;
    }
    
    /**
     * Efetiva conexão com banco de dados.
     */
    public Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com."+driver+".cj.jdbc.Driver");
            connection = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (Exception e) {
            System.err.println("Connection error: \n" + e);
        }

        return connection;
    }
}