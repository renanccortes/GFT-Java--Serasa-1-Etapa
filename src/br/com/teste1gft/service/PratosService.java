/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste1gft.service;

import br.com.teste1gft.entidades.EnumNomePrato;
import br.com.teste1gft.entidades.EnumPeriodo;
import br.com.teste1gft.entidades.EnumTipoPrato;
import br.com.teste1gft.entidades.Pratos;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Renan
 */
public class PratosService {

    private Map<EnumTipoPrato, Map<EnumPeriodo, Pratos>> todosPratos;

    public PratosService() {
        carregaOpcoesDePratos();
    }

    public Map<EnumTipoPrato, Map<EnumPeriodo, Pratos>> getTodosPratos() {
        return todosPratos;
    }


    public Pratos getPrato(EnumTipoPrato tipoPrato, EnumPeriodo tipoPeriodo) {
        Map<EnumPeriodo, Pratos> pratoPorTipo = todosPratos.get(tipoPrato);
        Pratos prato = pratoPorTipo.get(tipoPeriodo);
        return prato;
    }

    private void carregaOpcoesDePratos() {
        todosPratos = new LinkedHashMap<>();

        Map<EnumPeriodo, Pratos> pratosEntrada = new HashMap<>();
        pratosEntrada.put(EnumPeriodo.MANHA, new Pratos(EnumTipoPrato.ENTRADA, EnumNomePrato.OVOS, EnumPeriodo.MANHA));
        pratosEntrada.put(EnumPeriodo.NOITE, new Pratos(EnumTipoPrato.ENTRADA, EnumNomePrato.CARNE, EnumPeriodo.NOITE));

        todosPratos.put(EnumTipoPrato.ENTRADA, pratosEntrada);

        Map<EnumPeriodo, Pratos> pratosAcompanhamento = new HashMap<>();
        pratosAcompanhamento.put(EnumPeriodo.MANHA, new Pratos(EnumTipoPrato.ACOMPANHAMENTO, EnumNomePrato.TORRADA, EnumPeriodo.MANHA));
        pratosAcompanhamento.put(EnumPeriodo.NOITE, new Pratos(EnumTipoPrato.ACOMPANHAMENTO, EnumNomePrato.BATATA, EnumPeriodo.NOITE));

        todosPratos.put(EnumTipoPrato.ACOMPANHAMENTO, pratosAcompanhamento);

        Map<EnumPeriodo, Pratos> pratosBebidas = new HashMap<>();
        pratosBebidas.put(EnumPeriodo.MANHA, new Pratos(EnumTipoPrato.BEBIDA, EnumNomePrato.CAFE, EnumPeriodo.MANHA));
        pratosBebidas.put(EnumPeriodo.NOITE, new Pratos(EnumTipoPrato.BEBIDA, EnumNomePrato.VINHO, EnumPeriodo.NOITE));

        todosPratos.put(EnumTipoPrato.BEBIDA, pratosBebidas);

        Map<EnumPeriodo, Pratos> pratosSobremesa = new HashMap<>();
        pratosSobremesa.put(EnumPeriodo.MANHA, new Pratos());
        pratosSobremesa.put(EnumPeriodo.NOITE, new Pratos(EnumTipoPrato.SOBREMESA, EnumNomePrato.BOLO, EnumPeriodo.NOITE));

        todosPratos.put(EnumTipoPrato.SOBREMESA, pratosSobremesa);

    }

}
