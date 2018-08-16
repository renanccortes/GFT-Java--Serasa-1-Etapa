/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste1gft.controle;

import java.io.Serializable;

/**
 *
 * @author Renan
 */
public interface IControlePedidos extends Serializable {

    /**
     * RETORNA FORMATADO A LISTA DE OPÇÕES
     *
     * @return
     */
    public String getOpcoes();

    /**
     * FAZ O PEDIDO E INFORMA O RETORNO DO PEDIDO
     *
     * @param pedidoDigitadoPeloUsuario
     * @return
     */
    public String onFazerPedido(String pedidoDigitadoPeloUsuario);

}
