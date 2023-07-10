package edu.digytal.aulas.conexao.professores.jdbc;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TestaProfessorCrud {

    public static void main(String[] args) {
        FabricaConexao.criarConexao();

        ProfessorCrud professorCrud = new ProfessorCrud();

        Professor professor = professorCrud.findById(2);
        System.out.println(professor + "\n\n");

        professorCrud.save(professor);


        professor.biografia = "teste UPDATE";
        professor.cargaHoraria = Duration.ofHours(17);

        professorCrud.update(professor);

        professorCrud.delete(15);

        List<Professor> professores = professorCrud.findAll();
        for (Professor p : professores) {
            System.out.println(p);
        }


    }


}
