package edu.digytal.aulas.conexao.professores.jdbc;

import edu.digytal.aulas.conexao.professores.jdbc.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ProfessorCrud {

    //estava variável será útil em toda a classe
    private Connection conexao;

    public ProfessorCrud() {
        //ao criar o objeto, uma conexão será informada uma única vez
        conexao = FabricaConexao.getConexao();
    }

    public Integer save (Professor professor){
        try {
            // String sql = "INSERT INTO professores (nome) VALUES (?)";
            String sql = """
                INSERT INTO professores
                (nome,
                data_nascimento,
               
                valor_hora,
                fl_estrangeiro,
                horas_disponiveis,
                biografia,
                data_hora_cadastro)
                VALUES
                (?, ?, ?, ?, ?, ?, ? )                    
                    """;
// carga_horaria,
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, professor.nome);
            statement.setString(2, professor.dataNascimento.toString());
            //statement.setString(3, professor.cargaHoraria != null?professor.cargaHoraria.toString(): "");
            statement.setString(3, professor.valorHora.toString());
            statement.setString(4, professor.flEstrangeiro.booleanValue()?"1":"0" );
            statement.setString(5, professor.horasDisponiveis.toString());
            statement.setString(6, professor.biografia);
            statement.setString(7, professor.dataHoraCadastro.toString());


            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Um novo professor foi salvo com sucesso!");
                /*
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }*/
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void update(Professor professor){
        try {
            String sql = "UPDATE professores SET nome = ? WHERE codigo = ?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, professor.nome);
            statement.setInt(2, professor.id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("professor alterado com sucesso!");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public int delete(Integer id){
        int rowsDeleted=0;
        try {
            String sql = "DELETE FROM professores WHERE id = ?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);
            rowsDeleted = statement.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  rowsDeleted;
    }

    public Professor findById(Integer id){
        Professor professor = null;
        try {
            String sql = "SELECT * FROM professores WHERE id = ?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,id);

            ResultSet result = statement.executeQuery();

            while (result.next()){
                professor = new Professor();
                professor.id = result.getInt("id");
                professor.nome = result.getString("nome");
                professor.dataNascimento = result.getDate("data_nascimento").toLocalDate();
                // professor.cargaHoraria = LocalTime.parse(result.getTime("carga_horaria").toString());
                professor.valorHora = result.getDouble("valor_hora");
                professor.flEstrangeiro = result.getBoolean("fl_estrangeiro");
                professor.horasDisponiveis = result.getInt("horas_disponiveis");
                professor.biografia = result.getString("biografia");
                professor.dataHoraCadastro = result.getTimestamp("data_hora_cadastro").toLocalDateTime();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return professor;
    }

    public List<Professor> findAll(){
        List<Professor> registros = new ArrayList<>();
        try {
            String sql = "SELECT * FROM professores";
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                Professor professor = new Professor();
                professor.id = result.getInt("id");
                professor.nome = result.getString("nome");
                professor.dataNascimento = result.getDate("data_nascimento").toLocalDate();
                // professor.cargaHoraria = LocalTime.parse(result.getTime("carga_horaria").toString());
                professor.valorHora = result.getDouble("valor_hora");
                professor.flEstrangeiro = result.getBoolean("fl_estrangeiro");
                professor.horasDisponiveis = result.getInt("horas_disponiveis");
                professor.biografia = result.getString("biografia");
                professor.dataHoraCadastro = result.getTimestamp("data_hora_cadastro").toLocalDateTime();
                registros.add(professor);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return registros;
    }

    
}
