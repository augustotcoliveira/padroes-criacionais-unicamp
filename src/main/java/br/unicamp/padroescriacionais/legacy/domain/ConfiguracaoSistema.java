package br.unicamp.padroescriacionais.legacy.domain;

public class ConfiguracaoSistema {

    private String nomeEmpresa;
    private String ambiente;
    private String diretorioExportacao;
    private boolean debugAtivo;

    private static ConfiguracaoSistema configuracao = new ConfiguracaoSistema();

    private ConfiguracaoSistema() {
        this.nomeEmpresa = "Nome da empresa aqui.";
        this.ambiente = "ambiente aqui (DEV ou PROD)";
        this.diretorioExportacao = "diretorio de exportacao aquiu (ex: '/tmp/relatorios')";
        this.debugAtivo = false;
    }

    public static ConfiguracaoSistema getInstance(){
        return configuracao;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getDiretorioExportacao() {
        return diretorioExportacao;
    }

    public void setDiretorioExportacao(String diretorioExportacao) {
        this.diretorioExportacao = diretorioExportacao;
    }

    public boolean isDebugAtivo() {
        return debugAtivo;
    }

    public void setDebugAtivo(boolean debugAtivo) {
        this.debugAtivo = debugAtivo;
    }
}
