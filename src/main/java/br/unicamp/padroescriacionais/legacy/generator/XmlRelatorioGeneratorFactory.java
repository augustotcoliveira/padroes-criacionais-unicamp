package br.unicamp.padroescriacionais.legacy.generator;

public class XmlRelatorioGeneratorFactory implements RelatorioGeneratorFactory{
    
    @Override
    public RelatorioGenerator createGenerator(){
        return new XmlRelatorioGenerator();
    }
}
