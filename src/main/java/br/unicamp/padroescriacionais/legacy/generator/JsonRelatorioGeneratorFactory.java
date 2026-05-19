package br.unicamp.padroescriacionais.legacy.generator;

public class JsonRelatorioGeneratorFactory implements RelatorioGeneratorFactory{
    
    @Override
    public RelatorioGenerator createGenerator(){
        return new JsonRelatorioGenerator();
    }
}
