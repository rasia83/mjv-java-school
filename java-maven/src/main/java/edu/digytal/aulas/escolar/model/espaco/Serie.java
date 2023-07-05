package edu.digytal.aulas.escolar.model.espaco;

import edu.digytal.aulas.escolar.model.cadastro.GrauEscolaridade;
import lombok.Data;

@Data
public class Serie {
    private Integer id;
    private String nivel;
    private Integer idadeMinima;
    private Integer idadeMaxima;
    private GrauEscolaridade grauEscolaridade;

}
