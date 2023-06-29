package edu.digytal.aulas.panisys;

public class ImpressorCupom {
    public String imprimir(Cupom cupom){
        /**
         vamos somente impimir o resultado no console
         mas este mesmo conteúdo poderá proporicionar várias saidas
         logo a variável conteudo deveria ser retornada para outros "processadores"
         como gerador de arquivo txt, pdf ou até mesmo envio por e-mail
         */

        /*
        CONSIDERE O COMPRIMENTO MÁXIMO DE 50 CARACTERES EM CADA LINHA
        E APLIQUE O RESPECTIVO ALINHAMENTO
         */
        System.out.println();
        StringBuilder conteudo = new StringBuilder();
        conteudo.append(tracos());
        conteudo.append(String.format("%-50.50s \n" ,cupom.nomeFantasia));
        Endereco end = cupom.endereco;
        conteudo.append(String.format("%s Nº%s %s %s \n" , end.logradouro, end.numero, end.complemento, end.bairro ));
        conteudo.append(String.format("%-1.45s - %s \n" , end.cidade, end.uf ));
        conteudo.append(String.format("CPF/CNPJ: %-29.29s %s \n" , cupom.cpf, cupom.data ));
        conteudo.append(String.format("IE: %-37.37s %s \n" , cupom.ie, cupom.hora ));
        conteudo.append(String.format("IM: %-35.35s CCF:%s \n" , cupom.im, cupom.ccf ));
        conteudo.append(String.format("%39.39s CDD:%6.6s\n" ,"", cupom.cdd ));
        conteudo.append(tracos());
        conteudo.append("CUPOM FISCAL\n");
        //modelo para ser replicado
        conteudo.append(String.format("ITEM COD. %-30s%10s\n","DESC.","VALOR"));
        for(CupomItem item:cupom.itens){
            conteudo.append(String.format("%03d  %3s  %-17.17s %s%s X %s %,7.2f\n",
                    item.ordem, item.sku,item.descricao, item.quantidade, item.und, item.preco, item.subtotal));
        }
        conteudo.append(tracos());
        System.out.println(conteudo.toString());
        //em caso de resolver explorar algumas formas de apresentação
        return conteudo.toString();
    }
    private String tracos(){
        String repeated = new String(new char[50]).replace("\0", "-");
        return repeated + "\n";
    }
    private String cpfCnpj(String cpfCnpj){
        String newCnpj = "";
        if(cpfCnpj.length()==11)
            newCnpj = cpfCnpj.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        else
            newCnpj = cpfCnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
        return newCnpj;
    }
}


