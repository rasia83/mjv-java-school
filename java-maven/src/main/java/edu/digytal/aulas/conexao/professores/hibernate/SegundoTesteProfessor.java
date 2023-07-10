package edu.digytal.aulas.conexao.professores.hibernate;

import edu.digytal.aulas.conexao.professores.hibernate.modelo.Professor;

import java.time.LocalDate;

public class SegundoTesteProfessor {

    public static void main(String[] args) {
        ProfessorDAO professorDAO = new ProfessorDAO();

        // Cria um novo professor
        Professor professor = new Professor();
        professor.setNome("João");
        professor.setDataNascimento(LocalDate.of(1980, 5, 15));
        // Defina os outros atributos...

        // Salva o professor no banco de dados
        professorDAO.salvar(professor);
        System.out.println("Professor salvo com sucesso!");

        // Busca um professor por ID
        Professor professorRecuperado = professorDAO.buscarPorId(professor.getId());
        System.out.println("Professor encontrado: " + professorRecuperado.getNome());

        // Atualiza o nome do professor
        professorRecuperado.setNome("João da Silva");
        professorDAO.atualizar(professorRecuperado);
        System.out.println("Professor atualizado com sucesso!");

        // Exclui o professor
        professorDAO.excluir(professorRecuperado);
        System.out.println("Professor excluído com sucesso!");
    }

}
