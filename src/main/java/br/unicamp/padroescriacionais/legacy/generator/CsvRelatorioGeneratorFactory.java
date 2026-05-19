package br.unicamp.padroescriacionais.legacy.generator;

public class CsvRelatorioGeneratorFactory implements RelatorioGeneratorFactory {
    
    @Override
    public RelatorioGenerator createGenerator(){
        return new CsvRelatorioGenerator();
    }
}
