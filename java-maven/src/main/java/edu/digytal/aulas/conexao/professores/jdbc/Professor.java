package edu.digytal.aulas.conexao.professores.jdbc;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Professor {
    Integer id;
    String nome;
    LocalDate dataNascimento;
    Duration cargaHoraria;
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
                ", cargaHoraria=" + formatDuration(cargaHoraria) +
                ", valorHora=" + valorHora +
                ", flEstrangeiro=" + flEstrangeiro +
                ", horasDisponiveis=" + horasDisponiveis +
                ", biografia='" + biografia + '\'' +
                ", dataHoraCadastro=" + dataHoraCadastro +
                '}';
    }



    public static String formatDuration(Duration duration) {
        if(duration == null)
            return "0:00";

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        return String.format("%02d:%02d", hours, minutes);
    }

}
