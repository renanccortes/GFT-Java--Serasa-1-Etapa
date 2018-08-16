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

    MANHA("Manhã"),
    NOITE("Noite");

    private final String nome;

    private EnumPeriodo(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {

        return this.nome;
    }

}
