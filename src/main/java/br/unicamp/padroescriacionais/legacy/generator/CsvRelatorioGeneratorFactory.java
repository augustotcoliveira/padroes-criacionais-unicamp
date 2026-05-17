/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unicamp.padroescriacionais.legacy.generator;

/**
 *
 * @author User
 */
public class CsvRelatorioGeneratorFactory implements RelatorioGeneratorFactory {
    
    @Override
    public RelatorioGenerator createGenerator(){
        return new CsvRelatorioGenerator();
    }
}
