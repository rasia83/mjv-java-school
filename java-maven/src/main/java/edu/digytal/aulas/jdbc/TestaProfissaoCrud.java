package edu.digytal.aulas.jdbc;

import java.sql.SQLException;
import java.util.List;

public class TestaProfissaoCrud {

    public static void main(String[] args) {

        Integer id;

        FabricaConexao.criarConexao();

        Profissao p1 = new Profissao();
        p1.nome = "Desenvolvedor de Software";

        Profissao p2 = new Profissao();
        p2.nome = "Engenheiro de Software";

        Profissao p3 = new Profissao();
        p3.nome = "Designer de UX/UI";

        Profissao p4 = new Profissao();
        p4.nome = "Administrador de Banco de Dados";

        Profissao p5 = new Profissao();
        p5.nome = "Gerente de Projetos de TI";

        ProfissaoCrud profissaoCrud = new ProfissaoCrud();

        profissaoCrud.save(p1);
        profissaoCrud.save(p2);
        profissaoCrud.save(p3);
        profissaoCrud.save(p4);
        id = profissaoCrud.save(p5);

        Profissao profissaoSalva = profissaoCrud.findById(id);
        System.out.println(String.format("Adicionado id: %03d - %s", profissaoSalva.codigo, profissaoSalva.nome));

        Profissao editarProfissao = profissaoCrud.findById(2);
        editarProfissao.nome = "Eng. de Software";
        profissaoCrud.update(editarProfissao);

        profissaoCrud.delete(3);

        List<Profissao> profissoes = profissaoCrud.findAll();
        for (Profissao profissao:profissoes) {
            System.out.println(String.format("id: %03d - %s", profissao.codigo, profissao.nome));
        }

    }
}
