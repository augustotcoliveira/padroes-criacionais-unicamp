package br.unicamp.padroescriacionais.legacy.service;

import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoSistema;
import br.unicamp.padroescriacionais.legacy.domain.FormatoRelatorio;
import br.unicamp.padroescriacionais.legacy.domain.Relatorio;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGeneratorFactory;

public class ExportacaoService {
    // Recuperamos a instancia criada internamente na classe ConfiguracaoSistema
    //e com os valores ja setados em ConfiguracaoService.
    private ConfiguracaoSistema configuracao = ConfiguracaoSistema.getInstance();

    public void exportar(Relatorio relatorio, FormatoRelatorio formato) {
        String conteudoFormatado;
        // Recupera em FormatoRelatorio qual factory deve ser usada
        RelatorioGeneratorFactory fabrica = formato.getRelatorioGeneratorFactory();
        // Cria o devido objeto conforme factory recuperada
        RelatorioGenerator geradorRelatorio = fabrica.createGenerator();
        // Gera relatorio conforme generator selecionado
        conteudoFormatado = geradorRelatorio.gerar(relatorio);

        String nomeArquivo = relatorio.getTitulo()
                .replace(" ", "_")
                .toLowerCase()
                + "." + formato.name().toLowerCase();

        String caminhoCompleto = configuracao.getDiretorioExportacao() + "/" + nomeArquivo;

        System.out.println("[EXPORTACAO] Empresa  : " + configuracao.getNomeEmpresa());
        System.out.println("[EXPORTACAO] Ambiente : " + configuracao.getAmbiente());
        System.out.println("[EXPORTACAO] Arquivo  : " + caminhoCompleto);
        System.out.println("[EXPORTACAO] Conteudo :");
        System.out.println(conteudoFormatado);
    }
}
