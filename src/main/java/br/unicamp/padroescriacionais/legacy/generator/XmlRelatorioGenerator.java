package br.unicamp.padroescriacionais.legacy.generator;

import br.unicamp.padroescriacionais.legacy.domain.Relatorio;

public class XmlRelatorioGenerator implements RelatorioGenerator {

    @Override
    public String gerar(Relatorio relatorio) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<relatorio formato=\"XML\">\n");
        sb.append("    <titulo>").append(relatorio.getTitulo()).append("</titulo>\n");
        sb.append("    <tipo>").append(relatorio.getTipo()).append("</tipo>\n");
        sb.append("    <dataGeracao>").append(relatorio.getDataGeracao()).append("</dataGeracao>\n");
        sb.append("    <conteudo>").append(relatorio.getConteudo()).append("</conteudo>\n");
        sb.append("</relatorio>\n");
        return sb.toString();
    }
}