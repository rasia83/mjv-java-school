package edu.digytal.aulas.conexao.professores.jdbc;

import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TestaProfessorCrud {

    public static void main(String[] args) {
        FabricaConexao.criarConexao();

        ProfessorCrud professorCrud = new ProfessorCrud();

        Professor professor = professorCrud.findById(1);
        System.out.println(professor + "\n\n");


        professor.nome = "teste";
        professorCrud.save(professor);

        List<Professor> professores = professorCrud.findAll();
        for (Professor p : professores) {
            System.out.println(p);
        }




    }


}
