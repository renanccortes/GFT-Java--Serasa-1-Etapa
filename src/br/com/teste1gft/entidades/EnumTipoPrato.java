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
public enum EnumTipoPrato {

    ENTRADA(1),
    ACOMPANHAMENTO(2),
    BEBIDA(3),
    SOBREMESA(4);

    private final int tipo;

    private EnumTipoPrato(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "" + tipo;
    }

}
