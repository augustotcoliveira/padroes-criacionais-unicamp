package br.unicamp.padroescriacionais.legacy.generator;

public class PdfRelatorioGeneratorFactory implements RelatorioGeneratorFactory{
    
    @Override
    public RelatorioGenerator createGenerator(){
        return new PdfRelatorioGenerator();
    }
}
