package br.unicamp.padroescriacionais.legacy.generator;

public class HtmlRelatorioGeneratorFactory implements RelatorioGeneratorFactory {
    
    @Override
    public RelatorioGenerator createGenerator(){
        return new HtmlRelatorioGenerator();
    }
}
