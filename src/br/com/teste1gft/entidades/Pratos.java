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
public class Pratos {

    private EnumTipoPrato tipoDePrato;

    private EnumNomePrato nomeDoPrato;

    private EnumPeriodo periodo;

    //usado para erro, quando não identifica o  pedido
    public Pratos() {
        nomeDoPrato = EnumNomePrato.NADA;
    }

    //usado para erro porém com posicionamento
    public Pratos(EnumTipoPrato tipoDePrato) {
        this.tipoDePrato = tipoDePrato;
    }

    public Pratos(EnumTipoPrato tipoDePrato, EnumNomePrato nomeDoPrato, EnumPeriodo periodo) {
        this.tipoDePrato = tipoDePrato;
        this.nomeDoPrato = nomeDoPrato;
        this.periodo = periodo;
    }

    public EnumTipoPrato getTipoDePrato() {
        return tipoDePrato;
    }

    public void setTipoDePrato(EnumTipoPrato tipoDePrato) {
        this.tipoDePrato = tipoDePrato;
    }

    public EnumNomePrato getNomeDoPrato() {
        return nomeDoPrato;
    }

    public void setNomeDoPrato(EnumNomePrato nomeDoPrato) {
        this.nomeDoPrato = nomeDoPrato;
    }

    public EnumPeriodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(EnumPeriodo periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        if (nomeDoPrato == null) {
            return "erro";
        }
        return nomeDoPrato.toString();
    }

}
