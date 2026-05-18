package br.unicamp.padroescriacionais.legacy.domain;

import br.unicamp.padroescriacionais.legacy.generator.CsvRelatorioGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.generator.JsonRelatorioGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.generator.PdfRelatorioGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGeneratorFactory;

public enum FormatoRelatorio {
    PDF {
        @Override
        public RelatorioGeneratorFactory getRelatorioGeneratorFactory(){
            return new PdfRelatorioGeneratorFactory();
        }
    },
    CSV {
        @Override
        public RelatorioGeneratorFactory getRelatorioGeneratorFactory() {
            return new CsvRelatorioGeneratorFactory();
        }
    },
    JSON {
        @Override
        public RelatorioGeneratorFactory getRelatorioGeneratorFactory() {
            return new JsonRelatorioGeneratorFactory();
        }
    };
    
    // Método abstrato que obriga cada constante do Enum a retornar sua fábrica
    public abstract RelatorioGeneratorFactory getRelatorioGeneratorFactory();
}
