package edu.digytal.aulas.escolar.model.administrativo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Turma {
    private Integer id;
    private Integer anoLetivo;
    private String legenda;
    private List<GradeEscolar> grades = new ArrayList<>();
}
