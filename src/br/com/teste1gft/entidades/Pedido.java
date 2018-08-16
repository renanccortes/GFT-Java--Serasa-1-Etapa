/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste1gft.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renan
 */
public class Pedido {

    private EnumPeriodo periodo;

    private List<ItemPedido> itensPedido;

    public Pedido(EnumPeriodo periodo) {
        this.periodo = periodo;
        itensPedido = new ArrayList<>();
    }
    
     

    public void adicionarItemPedido(ItemPedido itemPedido) {
        if (itensPedido.contains(itemPedido)) {

            itemPedido = itensPedido.get(itensPedido.indexOf(itemPedido));
            itemPedido.adicionaQuantidade();
        } else {
            itensPedido.add(itemPedido);
        }
    }

    public void adicionarItemPedido(Pratos prato) {
        ItemPedido itemPedido = new ItemPedido(prato);
        adicionarItemPedido(itemPedido);
    }

    public EnumPeriodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(EnumPeriodo periodo) {
        this.periodo = periodo;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();

        //inclui todos os pedidos na string
        for (ItemPedido item : itensPedido) {
            if (!retorno.toString().isEmpty()) {
                retorno.append(", ");
            }
            retorno.append(item.toString());
        }

        return retorno.toString();
    }

}
