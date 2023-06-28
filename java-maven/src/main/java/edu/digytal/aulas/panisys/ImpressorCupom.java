package edu.digytal.aulas.panisys;

public class ImpressorCupom {
    public void imprimir(Cupom cupom){
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
        StringBuilder conteudo = new StringBuilder();
        conteudo.append(tracos());
        conteudo.append(cupom.nomeFantasia + "\n"); //preencher com espaços até ter 50 caracteres de comprimento
        Endereco end = cupom.endereco;
        conteudo.append(end.logradouro + " N. " + end.numero + " " + end.complemento + " " + end.bairro + " " + end.cidade + "-" + end.uf + "\n"); //como formatar vários campos
        conteudo.append("CPF/CNPJ:" + cupom.cpf + " " + cupom.data + "\n");//calcular os respectivos comprimentos e aplicar alinhamento
        conteudo.append("IE:" + cupom.ie + " " + cupom.hora + "\n");//calcular os respectivos comprimentos e aplicar alinhamento
        conteudo.append("IM:" + cupom.im + " " +  "CCF:" + cupom.ccf + "\n");//calcular os respectivos comprimentos e aplicar alinhamento
        conteudo.append("CDD:" + cupom.cdd + "\n");//aplicar alinhamento à direita
        conteudo.append(tracos());
        conteudo.append("CUPOM FISCAL\n");
        //modelo para ser replicado
        conteudo.append(String.format("ITEM COD. %-30s%10s\n","DESCRIÇÃO","VALOR"));
        for(CupomItem item:cupom.itens){
            // conteudo.append("DESCRICAO DE ACORDO COM CADA ITEM EXISTENTE\n");
            // alterações, adicionandos os campos dos itens
            conteudo.append(String.format("%9s %-40s\n",item.sku,item.descricao));
            conteudo.append(String.format("          R$ %7s  %-6s %-10s R$ %7s\n"
                    ,  item.preco, item.und, item.quantidade, item.subtotal));
        }
        conteudo.append(tracos());
        System.out.println(conteudo.toString());
        //em caso de resolver explorar algumas formas de apresentação
        //return conteudo.toString();
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


