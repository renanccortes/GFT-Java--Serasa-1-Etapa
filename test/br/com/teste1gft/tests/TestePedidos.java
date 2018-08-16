/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste1gft.tests;

import br.com.teste1gft.controle.ControlePedidos;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Renan
 */
public class TestePedidos extends TestCase {

    private List<SimulacoesPedido> simulacoes;

    public TestePedidos() {
        simulacoes = new ArrayList<>();
        simulacoes.add(new SimulacoesPedido("manha,1,2,3", "ovos,torrada,café", false));
        simulacoes.add(new SimulacoesPedido("manhã,2,1,3", "ovos,torrada,café", false));
        simulacoes.add(new SimulacoesPedido("MANHA,1,2,3,4", "ovos,torrada,café,erro", false));
        simulacoes.add(new SimulacoesPedido("Manha,1,2,3,3,3", "ovos,torrada,café(x3)", false));
        simulacoes.add(new SimulacoesPedido("noite,1,2,3,4", "carne,batata,vinho,bolo", false));
        simulacoes.add(new SimulacoesPedido("noite,1,2,2,4", "carne,batata(x2),bolo", false));
        simulacoes.add(new SimulacoesPedido("noite,1,3,2,2,4", "carne,batata(x2),vinho,bolo", false));

        simulacoes.add(new SimulacoesPedido("noites,1,3,2,2,4", "erro", true));
    }

    public void testeExecutaPedido() {
        ControlePedidos controlePedido = new ControlePedidos();
        for (SimulacoesPedido simulacao : simulacoes) {
            String retorno = controlePedido.onFazerPedido(simulacao.getComandoEnviado());

            System.out.println("Pedido: " + simulacao.getComandoEnviado());
            System.out.println("Retorno: " + retorno);
            System.out.println("\n");
            if (simulacao.isEsperadoFalha()) {
                assertThat(retorno, containsString(simulacao.getRetornoEsperado()));
            } else {
                retorno = retorno.replace(" ", ""); //tira os espaços
                assertEquals(retorno, simulacao.getRetornoEsperado());
            }
        }
    }

    private class SimulacoesPedido {

        private boolean esperadoFalha;
        private String comandoEnviado;
        private String retornoEsperado;

        public SimulacoesPedido(String comandoEnviado, String retornoEsperado, boolean esperadoFalha) {
            this.comandoEnviado = comandoEnviado;
            this.retornoEsperado = retornoEsperado;
            this.esperadoFalha = esperadoFalha;
        }

        public boolean isEsperadoFalha() {
            return esperadoFalha;
        }

        public void setEsperadoFalha(boolean esperadoFalha) {
            this.esperadoFalha = esperadoFalha;
        }

        public String getComandoEnviado() {
            return comandoEnviado;
        }

        public void setComandoEnviado(String comandoEnviado) {
            this.comandoEnviado = comandoEnviado;
        }

        public String getRetornoEsperado() {
            return retornoEsperado;
        }

        public void setRetornoEsperado(String retornoEsperado) {
            this.retornoEsperado = retornoEsperado;
        }

    }

}
