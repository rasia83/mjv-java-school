package edu.digytal.aulas.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    /**
     Definimos uma variável estática para evitar
     a criar uma conexão a cada execução
     */
    private static Connection conexao;

    /**
     Este método devera ser chamado somente na inicialização do seu sistema
     através da sua classe principal (main)
     */
    public static void criarConexao(){
        try{
            //ao tentar conectar você poderá receber alguns erros
            //confira se adicionar a dependencia e informações do seu banco de dados
            /*
            String driver   = "org.postgresql.Driver";
            String url      = "jdbc:postgresql://HOST/DATABASE"; //-> exemplo: jdbc:postgresql://localhost:5432/sample
            String username = "USERNAME"; // -> postgres
            String password = "PASSWORD"; // -> postgres

            Class.forName(driver).newInstance();
            conexao = DriverManager.getConnection(url, username, password);*/

            //String url = "jdbc:sqlite:C:/sqlite/db/chinook.db";
            String url = "jdbc:sqlite:mjv-java-school.db";
            conexao = DriverManager.getConnection(url);
            //System.out.println("Connection to SQLite has been established.");
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }
    public static Connection getConexao(){
        //quando chamar o método a mesma conexão sempre será retomada
        return conexao;
    }


    public static void main(String[] args) {
        criarConexao();
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

}


