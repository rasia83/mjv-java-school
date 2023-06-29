package edu.digytal.aulas.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfissaoCrud {
    //estava variável será útil em toda a classe
    private Connection conexao;

    public ProfissaoCrud() {
        //ao criar o objeto, uma conexão será informada uma única vez
        conexao = FabricaConexao.getConexao();
    }

    public Integer save (Profissao profissao){
        try {
            // String sql = "INSERT INTO tab_profissao (codigo, nome) VALUES (?,?)";
            String sql = "INSERT INTO tab_profissao (nome) VALUES (?)";

            PreparedStatement statement = conexao.prepareStatement(sql);
            //statement.setInt(1, profissao.codigo);
            statement.setString(1, profissao.nome);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Uma nova profissao foi salva com sucesso!");

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void update(Profissao profissao){
        try {
            String sql = "UPDATE tab_profissao SET nome = ? WHERE codigo = ?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, profissao.nome);
            statement.setInt(2, profissao.codigo);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Profissão alterada com sucesso!");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public int delete(Integer id){
        int rowsDeleted=0;
        try {
            String sql = "DELETE FROM tab_profissao WHERE codigo = ?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);
            rowsDeleted = statement.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  rowsDeleted;
    }

    public Profissao findById(Integer id){
        Profissao profissao = null;
        try {
            String sql = "SELECT * FROM tab_profissao WHERE codigo = ?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,id);

            ResultSet result = statement.executeQuery();

            while (result.next()){
                profissao = new Profissao();
                profissao.codigo = result.getInt("codigo");
                profissao.nome = result.getString("nome");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return profissao;
    }

    public List<Profissao> findAll(){
        List<Profissao> registros = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tab_profissao";
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                Profissao profissao = new Profissao();
                profissao.codigo = result.getInt("codigo");
                profissao.nome = result.getString("nome");
                registros.add(profissao);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return registros;
    }



}

