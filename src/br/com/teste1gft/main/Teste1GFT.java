/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste1gft.main;

import br.com.teste1gft.controle.ControlePedidos;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan
 */
public class Teste1GFT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //intercepta para executar o teste
        if (args != null && args.length > 0) {
            if (args[0].equals("testes")) {
                TestePedidos testes = new TestePedidos();
                testes.testeExecutaPedido();
                return;
            }
        }
        try {
            //executa app normalmente
            while (iniciaAplicacao()) {

            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Teste1GFT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean iniciaAplicacao() throws UnsupportedEncodingException {
        Scanner s = new Scanner(System.in, "CP850");

        ControlePedidos controlePedidos = new ControlePedidos();
        //System.out.println(controlePedidos.getOpcoes());
        System.out.println("Informe seu pedido:");
        String pedido = s.nextLine();
        String retorno = controlePedidos.onFazerPedido(pedido);
        System.out.println(retorno);
        //return retorno.contains("erro");
        return true;
    }

}
