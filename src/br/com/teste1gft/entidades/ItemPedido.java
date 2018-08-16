/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste1gft.entidades;

import java.util.Objects;

/**
 *
 * @author Renan
 */
public class ItemPedido implements Comparable {

    private int quantidade;
    private Pratos prato;

    public ItemPedido(Pratos prato) {
        this.prato = prato;
    }

    public void adicionaQuantidade() {
        this.quantidade++;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pratos getPrato() {
        return prato;
    }

    public void setPrato(Pratos prato) {
        this.prato = prato;
    }

    @Override
    public String toString() {
        if (quantidade > 1) {
            return prato.getNomeDoPrato().toString() + " (" + quantidade + "x)";
        } else {
            return prato.getNomeDoPrato().toString();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.prato);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemPedido other = (ItemPedido) obj;
        if (!Objects.equals(this.prato, other.prato)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {

        if (o == null || prato == null || prato.getTipoDePrato() == null) {
            return 0;
        }

        if (o instanceof ItemPedido) {
            ItemPedido outroItem = (ItemPedido) o;
            if (outroItem.getPrato() == null || outroItem.getPrato().getTipoDePrato() == null) {
                return 0;
            }

            if (prato != null && prato.getTipoDePrato() != null) {

                if (prato.getTipoDePrato().getTipo() < outroItem.getPrato().getTipoDePrato().getTipo()) {
                    return -1;
                }
                if (prato.getTipoDePrato().getTipo() > outroItem.getPrato().getTipoDePrato().getTipo()) {
                    return 1;
                }
            }
        }

        return 0;
    }

}
