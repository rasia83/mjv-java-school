package edu.digytal.aulas.conexao.professores.jdbc;

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

            String driver   = "com.mysql.cj.jdbc.Driver";
            String url      = "jdbc:mysql://localhost/schoolsis";
            String username = "root";
            String password = "";

            Class.forName(driver).newInstance();
            conexao = DriverManager.getConnection(url, username, password);

        }catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException exception){
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
