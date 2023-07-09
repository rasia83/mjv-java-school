package edu.digytal.aulas.conexao.professores.jdbc;

import java.sql.*;
import java.time.Duration;
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
                    data_hora_cadastro,
                    carga_horaria)
                    VALUES
                    (?, ?, ?, ?, ?, ?, ?, ? )                    
                    """;

            PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, professor.nome);
            statement.setDate(2, Date.valueOf(professor.dataNascimento));
            statement.setDouble(3, professor.valorHora);
            statement.setString(4, professor.flEstrangeiro.booleanValue()?"1":"0" );
            statement.setInt(5, professor.horasDisponiveis);
            statement.setString(6, professor.biografia);
            statement.setTimestamp(7, Timestamp.valueOf(professor.dataHoraCadastro));
            long hours = professor.cargaHoraria.toHours();
            long minutes = professor.cargaHoraria.toMinutes() % 60;
            long seconds = professor.cargaHoraria.toSeconds() % 60 % 60;
            statement.setString(8, String.format("%02d:%02d:%02d",hours, minutes, seconds));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Um novo professor foi salvo com sucesso!");

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    System.out.println(generatedKeys.getInt(1));
                    return generatedKeys.getInt(1);
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void update(Professor professor){
        try {
            String sql = """
                    UPDATE professores SET
                    nome = ? ,
                    data_nascimento = ? ,
                    valor_hora = ? ,
                    fl_estrangeiro = ? ,
                    horas_disponiveis = ? ,
                    biografia = ? ,
                    data_hora_cadastro = ? ,
                    carga_horaria = ? 
                    WHERE id = ?                   
                    """;

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, professor.nome);
            statement.setDate(2, Date.valueOf(professor.dataNascimento));
            statement.setDouble(3, professor.valorHora);
            statement.setString(4, professor.flEstrangeiro.booleanValue()?"1":"0" );
            statement.setInt(5, professor.horasDisponiveis);
            statement.setString(6, professor.biografia);
            statement.setTimestamp(7, Timestamp.valueOf(professor.dataHoraCadastro));
            long hours = professor.cargaHoraria.toHours();
            long minutes = professor.cargaHoraria.toMinutes() % 60;
            long seconds = professor.cargaHoraria.toSeconds() % 60 % 60;
            statement.setString(8, String.format("%02d:%02d:%02d",hours, minutes, seconds));

            statement.setInt(9, professor.id);

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
                //professor.cargaHoraria = result.getString("carga_horaria");
                //professor.cargaHoraria = result.getString("carga_horaria") != null ? result.getString("carga_horaria") : "";
                String stringTTime = result.getString("carga_horaria") != null ? result.getString("carga_horaria") : "00:00:00";
                Duration total = Duration.ZERO;
                String[] partes = stringTTime.split(":");
                professor.cargaHoraria = total.plusHours(Long.parseLong(partes[0]))
                        .plusMinutes(Long.parseLong(partes[1]))
                        .plusSeconds(Long.parseLong(partes[2]));

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
                //professor.cargaHoraria = result.getString("carga_horaria");
                //professor.cargaHoraria = result.getString("carga_horaria") != null ? result.getString("carga_horaria") : "";
                String stringTime = result.getString("carga_horaria") != null ? result.getString("carga_horaria") : "0:0:0";
                Duration total = Duration.ZERO;
                String[] partes = stringTime.split(":");
                professor.cargaHoraria = total.plusHours(Long.parseLong(partes[0]))
                                            .plusMinutes(Long.parseLong(partes[1]))
                                            .plusSeconds(Long.parseLong(partes[2]));

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
