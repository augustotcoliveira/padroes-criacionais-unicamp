package br.unicamp.padroescriacionais.legacy;


import br.unicamp.padroescriacionais.legacy.domain.FormatoRelatorio;
import br.unicamp.padroescriacionais.legacy.generator.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RelatorioGeneratorFactoryTest {

    // --- TESTES DAS FÁBRICAS DIRETAMENTE ---

    @Test
    void pdfFactoryDeveCriarPdfGenerator() {
        RelatorioGeneratorFactory factory = new PdfRelatorioGeneratorFactory();
        RelatorioGenerator generator = factory.createGenerator();
        
        assertNotNull(generator);
        assertTrue(generator instanceof PdfRelatorioGenerator, "A fábrica de PDF deve retornar uma instância de PdfRelatorioGenerator");
    }

    @Test
    void csvFactoryDeveCriarCsvGenerator() {
        RelatorioGeneratorFactory factory = new CsvRelatorioGeneratorFactory();
        RelatorioGenerator generator = factory.createGenerator();
        
        assertNotNull(generator);
        assertTrue(generator instanceof CsvRelatorioGenerator, "A fábrica de CSV deve retornar uma instância de CsvRelatorioGenerator");
    }

    @Test
    void htmlFactoryDeveCriarHtmlGenerator() {
        RelatorioGeneratorFactory factory = new HtmlRelatorioGeneratorFactory();
        RelatorioGenerator generator = factory.createGenerator();
        
        assertNotNull(generator);
        assertTrue(generator instanceof HtmlRelatorioGenerator, "A fábrica de HTML deve retornar uma instância de HtmlRelatorioGenerator");
    }

    @Test
    void xmlFactoryDeveCriarXmlGenerator() {
        RelatorioGeneratorFactory factory = new XmlRelatorioGeneratorFactory();
        RelatorioGenerator generator = factory.createGenerator();
        
        assertNotNull(generator);
        assertTrue(generator instanceof XmlRelatorioGenerator, "A fábrica de XML deve retornar uma instância de XmlRelatorioGenerator");
    }

    // --- TESTES DO ENUM (O Roteador das Fábricas) ---

    @Test
    void enumPdfDeveRetornarPdfFactory() {
        RelatorioGeneratorFactory factory = FormatoRelatorio.PDF.getRelatorioGeneratorFactory();
        assertNotNull(factory);
        assertTrue(factory instanceof PdfRelatorioGeneratorFactory, "O Enum PDF deve rotear para PdfGeneratorFactory");
    }

    @Test
    void enumJsonDeveRetornarJsonFactory() {
        RelatorioGeneratorFactory factory = FormatoRelatorio.JSON.getRelatorioGeneratorFactory();
        assertNotNull(factory);
        assertTrue(factory instanceof JsonRelatorioGeneratorFactory, "O Enum JSON deve rotear para JsonGeneratorFactory");
    }

    @Test
    void enumCsvDeveRetornarJsonFactory() {
        RelatorioGeneratorFactory factory = FormatoRelatorio.CSV.getRelatorioGeneratorFactory();
        assertNotNull(factory);
        assertTrue(factory instanceof CsvRelatorioGeneratorFactory, "O Enum CSV deve rotear para CsvGeneratorFactory");
    }
    
    @Test
    void enumHtmlDeveRetornarJsonFactory() {
        RelatorioGeneratorFactory factory = FormatoRelatorio.HTML.getRelatorioGeneratorFactory();
        assertNotNull(factory);
        assertTrue(factory instanceof HtmlRelatorioGeneratorFactory, "O Enum HTML deve rotear para JsonGeneratorFactory");
    }
    
    @Test
    void enumXmlDeveRetornarJsonFactory() {
        RelatorioGeneratorFactory factory = FormatoRelatorio.XML.getRelatorioGeneratorFactory();
        assertNotNull(factory);
        assertTrue(factory instanceof XmlRelatorioGeneratorFactory, "O Enum XML deve rotear para JsonGeneratorFactory");
    }

}