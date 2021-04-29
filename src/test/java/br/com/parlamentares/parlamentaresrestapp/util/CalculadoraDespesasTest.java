package br.com.parlamentares.parlamentaresrestapp.util;

import br.com.parlamentares.parlamentaresrestapp.model.Despesa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculadoraDespesasTest {

    private CalculadoraDespesas calculadoraDespesas = new CalculadoraDespesas();

    @Test
    public void testCalcularTotalDeDespesas() {
        Despesa despesa1 = new Despesa();
        Despesa despesa2 = new Despesa();
        Despesa despesa3 = new Despesa();

        despesa1.setValorLiquido((float) 120.22);
        despesa2.setValorLiquido((float) 77.08);
        despesa3.setValorLiquido((float) 22.65);

        despesa1.setMes("1");
        despesa2.setMes("1");
        despesa3.setMes("1");

        List<List<Despesa>> despesas = new ArrayList<>();
        despesas.add(new ArrayList<>(Arrays.asList(despesa1, despesa2, despesa3)));

        List<Despesa> listaRecebida = calculadoraDespesas.calcularTotalDeDespesas(despesas);

        Assertions.assertEquals(219.95, listaRecebida.get(0).getValorLiquido(), 0.02);
    }
}
