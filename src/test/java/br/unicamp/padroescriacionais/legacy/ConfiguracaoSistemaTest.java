package br.unicamp.padroescriacionais.legacy;

import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoSistema;
import br.unicamp.padroescriacionais.legacy.service.ConfiguracaoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class ConfiguracaoSistemaTest {

    // Como o Singleton mantém os dados na memória, o método resetarEstadoDoSingleton roda antes de 
    // cada teste para garantir que um teste não interfira no resultado do outro.
    @BeforeEach
    void resetarEstadoDoSingleton() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstance();
        config.setNomeEmpresa("Empresa Padrão");
        config.setAmbiente("DEV");
        config.setDiretorioExportacao("/tmp");
        config.setDebugAtivo(false);
    }

    @Test
    void deveConfigurarValoresInformados() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstance();
        config.setNomeEmpresa("Empresa Teste");
        config.setAmbiente("DEV");
        config.setDiretorioExportacao("/tmp/test");
        config.setDebugAtivo(true);

        assertEquals("Empresa Teste", config.getNomeEmpresa());
        assertEquals("DEV", config.getAmbiente());
        assertEquals("/tmp/test", config.getDiretorioExportacao());
        assertTrue(config.isDebugAtivo());
    }

    @Test
    void devePermitirAlteracaoDeAmbiente() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstance();
        config.setAmbiente("PROD");

        assertEquals("PROD", config.getAmbiente());
    }

    @Test
    void devePermitirAlteracaoDeDebug() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstance();
        config.setDebugAtivo(true);

        assertTrue(config.isDebugAtivo());
    }

    @Test
    void devePermitirAlteracaoDeDiretorio() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstance();
        config.setDiretorioExportacao("/novo/diretorio");

        assertEquals("/novo/diretorio", config.getDiretorioExportacao());
    }

    @Test
    void deveGarantirInstanciaUnica() {
        // Pega a instância duas vezes
        ConfiguracaoSistema config1 = ConfiguracaoSistema.getInstance();
        ConfiguracaoSistema config2 = ConfiguracaoSistema.getInstance();

        // assertSame verifica se as duas variáveis apontam para o exato mesmo objeto na memória
        assertSame(config1, config2, "O Singleton falhou: variáveis apontam para instâncias diferentes");
    }

    @Test
    void alteracaoEmUmaReferenciaAfetaTodasAsOutras() {
        ConfiguracaoSistema config1 = ConfiguracaoSistema.getInstance();
        ConfiguracaoSistema config2 = ConfiguracaoSistema.getInstance();

        // Alteramos usando a primeira variável
        config1.setAmbiente("PROD");

        // Verificamos se a mudança refletiu na segunda variável (já que são a mesma instância)
        assertEquals("PROD", config2.getAmbiente(), "A alteração na config1 deveria refletir na config2");
    }

    @Test
    void configuracaoServiceDeveRetornarConfiguracaoNaoNula() {
        ConfiguracaoService service = new ConfiguracaoService();
        assertNotNull(service.getConfiguracao());
        assertFalse(service.getConfiguracao().getNomeEmpresa().isBlank());
    }
}
