/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste1.gft;

import br.com.teste1gft.controle.ControlePedidos;
import java.util.Scanner;

/**
 *
 * @author Renan
 */
public class Teste1GFT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        while (iniciaAplicacao()) {

        }

    }

    public static boolean iniciaAplicacao() {
        Scanner s = new Scanner(System.in);
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
