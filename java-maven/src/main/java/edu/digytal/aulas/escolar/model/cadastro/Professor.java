package edu.digytal.aulas.escolar.model.cadastro;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Professor {
    private Integer id;
    private String nome;
    private Endereco endereco;
    private List<String> disciplinas = new ArrayList<>();

}
