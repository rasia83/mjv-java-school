package edu.digytal.aulas.conexao.professores.hibernate;

import edu.digytal.aulas.conexao.professores.hibernate.modelo.Professor;
import org.hibernate.type.descriptor.java.LocalDateTimeJavaDescriptor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PrimeiroTesteProfessor {

    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.setNome("GLEYSON SAMPAIO");
        professor.setDataNascimento(LocalDate.of(1984,6,30));
        professor.setCargaHoraria(Duration.ofHours(20));
        professor.setValorHora(55.5);
        professor.setFlEstrangeiro(Boolean.FALSE);
        professor.setBiografia("É o cara ");
        professor.setHorasDisponiveis(3);
        professor.setDataHoraCadastro(LocalDateTime.now());


        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("schooljpa");

        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(professor);
        em.getTransaction().commit();
        em.close();
    }


}
