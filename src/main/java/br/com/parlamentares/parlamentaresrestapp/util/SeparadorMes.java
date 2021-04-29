package br.com.parlamentares.parlamentaresrestapp.util;

import br.com.parlamentares.parlamentaresrestapp.model.Despesa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class SeparadorMes {

    public List<List<Despesa>> separarMeses(List<Despesa> despesas) {
        List<List<Despesa>> despesasPorMes = new ArrayList<>();
        ArrayDeque<Integer> listaIndexes = new ArrayDeque<>();

        for(int i = 1; i < despesas.size(); i++) {
            if(!despesas.get(i).getMes().equals(despesas.get(i-1).getMes())) {
                listaIndexes.add(i);
            }
        }

        int indexInicial = 0;
        Integer indexFinal = 0;
        for (Integer indexAtual : listaIndexes) {
            indexFinal = indexAtual;
            despesasPorMes.add(despesas.subList(indexInicial, indexFinal));
            indexInicial = indexFinal;
        }
        despesasPorMes.add(despesas.subList(indexFinal, despesas.size()));

        return despesasPorMes;
    }
}
