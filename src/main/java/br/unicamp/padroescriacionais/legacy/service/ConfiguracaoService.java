package br.unicamp.padroescriacionais.legacy.service;

import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoSistema;

public class ConfiguracaoService {
    // Recuperamos a instancia ja iniciada internamente na classe ConfiguracaoSistema
    private ConfiguracaoSistema configuracao = ConfiguracaoSistema.getInstance();

    // Setamos os valores atraves de um construtor
    public ConfiguracaoService() {
        configuracao.setNomeEmpresa("Empresa XPTO Ltda.");
        configuracao.setAmbiente("DEV");
        configuracao.setDiretorioExportacao("/tmp/relatorios");
        configuracao.setDebugAtivo(true);
    }

    public ConfiguracaoSistema getConfiguracao() {
        return configuracao;
    }

    public void exibirConfiguracao() {
        System.out.println("=== Configuracao do Sistema ===");
        System.out.println("Empresa    : " + configuracao.getNomeEmpresa());
        System.out.println("Ambiente   : " + configuracao.getAmbiente());
        System.out.println("Diretorio  : " + configuracao.getDiretorioExportacao());
        System.out.println("Debug ativo: " + configuracao.isDebugAtivo());
        System.out.println("================================");
    }
}
