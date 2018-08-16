/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste1gft.entidades;

/**
 *
 * @author Renan
 */
public enum EnumPeriodo {

    MANHA("manhã"),
    NOITE("noite");

    private final String nome;

    private EnumPeriodo(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {

        return this.nome;
    }

    public static EnumPeriodo fromString(String name) {

        try {
            name = name.replace("ã", "a").toUpperCase();//aceita com e sem acentos...
            return EnumPeriodo.valueOf(name);
        } catch (IllegalArgumentException ex) {
        }

        return null;
    }

}
