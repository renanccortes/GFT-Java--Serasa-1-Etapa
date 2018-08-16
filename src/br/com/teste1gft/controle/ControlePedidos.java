/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste1gft.controle;

import br.com.teste1gft.entidades.EnumPeriodo;
import br.com.teste1gft.entidades.EnumTipoPrato;
import br.com.teste1gft.entidades.ItemPedido;
import br.com.teste1gft.entidades.Pedido;
import br.com.teste1gft.entidades.Pratos;
import br.com.teste1gft.service.PratosService;
import com.sun.imageio.plugins.common.I18N;
import java.util.Collections;
import java.util.Map;

/**
 *
 * @author Renan
 */
public class ControlePedidos {

    private final PratosService pratoService;
    private Pedido novoPedido;

    public ControlePedidos() {
        pratoService = new PratosService();
    }

    public String getOpcoes() {
        StringBuilder opcoes = new StringBuilder();
        opcoes.append("Tipo de Prato  \t        Manhã \t Noite  \n");//cabecalho
        opcoes.append("-----------------------------------------\n");
        Map<EnumTipoPrato, Map<EnumPeriodo, Pratos>> todosPratos = pratoService.getTodosPratos();

        //criando linhas
        for (Map.Entry<EnumTipoPrato, Map<EnumPeriodo, Pratos>> entry : todosPratos.entrySet()) {

            Map<EnumPeriodo, Pratos> pratos = entry.getValue();

            opcoes.append(entry.getKey()).append(" (").append(entry.getKey().name()).append(") "); //coluna1  
            if (entry.getKey().name().length() <= 10) { //incluindo tabulação se for menor que 10 caracter
                opcoes.append("\t\t");
            } else {
                opcoes.append("     ");
            }

            opcoes.append(pratos.get(EnumPeriodo.MANHA).getNomeDoPrato()); //coluna2
            opcoes.append("\t ").append(pratos.get(EnumPeriodo.NOITE).getNomeDoPrato()); //coluna3
            opcoes.append("\n");

        }

        return opcoes.toString();
    }

    public String onFazerPedido(String pedidoDigitadoPeloUsuario) {

        //Pega os parametros passados por , retira os espaços e coloca tudo em lowercase
        String pedido = pedidoDigitadoPeloUsuario.toLowerCase().replace(" ", "");

        String[] opcoes = pedido.split(",");
        if (opcoes.length <= 1) {
            return getOpcoes().concat("\n\nerro:  argumentos inválidos, Ex: MANHÃ, 1, 2, 3");
        } else {

            return onFazerPedido(opcoes);
        }

    }

    private String onFazerPedido(String[] valores) {
        EnumPeriodo periodoEnum = null;
        try {
            periodoEnum = EnumPeriodo.fromString(valores[0]);
        } catch (java.lang.IllegalArgumentException e) {

        }
        if (periodoEnum == null) {
            return getOpcoes().concat("\n\nerro: periodo inválido\n");
        }

        novoPedido = new Pedido(periodoEnum);

        /*
            Converte os pratos pedidos e faz a busca pelo prato
         */
        for (int i = 1; i < valores.length; i++) {
            EnumTipoPrato tipoPratoEnum = null;
            try {
                tipoPratoEnum = EnumTipoPrato.fromString(valores[i].trim());
            } catch (java.lang.IllegalArgumentException e) {
            }
            if (tipoPratoEnum == null) {
                novoPedido.adicionarItemPedido(new Pratos());
            } else {
                Pratos prato = pratoService.getPrato(tipoPratoEnum, periodoEnum);
                ItemPedido itemPedido = new ItemPedido(prato);
                if (novoPedido.getItensPedido().contains(itemPedido) && !isPodeRepetirPrato(periodoEnum, tipoPratoEnum)) {
                    // não inclui pois não pode pedir mais de 1  

                } else {
                    novoPedido.adicionarItemPedido(itemPedido);
                }
            }
        }

        /*
        Cria o retorno já ordenado
         */
        Collections.sort(novoPedido.getItensPedido()); // ordena

        return novoPedido.toString().replace("nada", "erro");

    }

    /*
        Usado para definir quais pratos podem repetir
     */
    private boolean isPodeRepetirPrato(EnumPeriodo periodo, EnumTipoPrato tipoPrato) {
        if (periodo == EnumPeriodo.MANHA) {
            return tipoPrato == EnumTipoPrato.BEBIDA;
        }

        if (periodo == EnumPeriodo.NOITE) {
            return tipoPrato == EnumTipoPrato.ACOMPANHAMENTO;
        }

        //nunca deve ocorrer
        return false;
    }

}
