package edu.digytal.aulas.conexao.professores.jdbc;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Professor {
    Integer id;
    String nome;
    LocalDate dataNascimento;
    LocalTime cargaHoraria;
    Double valorHora;
    Boolean flEstrangeiro;
    Integer horasDisponiveis;
    String biografia;
    LocalDateTime dataHoraCadastro;

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cargaHoraria=" + cargaHoraria +
                ", valorHora=" + valorHora +
                ", flEstrangeiro=" + flEstrangeiro +
                ", horasDisponiveis=" + horasDisponiveis +
                ", biografia='" + biografia + '\'' +
                ", dataHoraCadastro=" + dataHoraCadastro +
                '}';
    }
}
