package br.com.parlamentares.parlamentaresrestapp.util;

import br.com.parlamentares.parlamentaresrestapp.model.Despesa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeparadorMesUtilTest {

    private SeparadorMes separadorMes = new SeparadorMes();

    @Test
    public void testSepararMes() {
        Despesa despesa1 = new Despesa();
        Despesa despesa2 = new Despesa();
        despesa1.setMes("1");
        despesa2.setMes("2");

        List<Despesa> despesaList = new ArrayList<>(Arrays.asList(despesa1, despesa2));

        List<List<Despesa>> despesasPorMes = separadorMes.separarMeses(despesaList);

        for(int i = 0; i < despesasPorMes.size(); i++) {
            Assertions.assertEquals(despesaList.get(i).getMes(), despesasPorMes.get(i).get(0).getMes());
        }
    }
}
