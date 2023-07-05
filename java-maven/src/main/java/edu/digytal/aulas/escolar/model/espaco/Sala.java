package edu.digytal.aulas.escolar.model.espaco;

import lombok.Data;

@Data
public class Sala {
    private Integer id;
    private String nome;
    private SalaTipo tipo;

}
