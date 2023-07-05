package edu.digytal.aulas.escolar.model.administrativo;

import edu.digytal.aulas.escolar.model.cadastro.Professor;
import lombok.Data;

@Data
public class GradeEscolar {
    private Integer id;
    private Disciplina disciplina;
    private Professor professor;
}
