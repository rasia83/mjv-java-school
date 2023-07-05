package edu.digytal.aulas.escolar.model.cadastro;

import lombok.Data;

@Data
public class Parentesco {
    private Integer id;
    private String nome;
    private ParentescoGrau grau;
}
