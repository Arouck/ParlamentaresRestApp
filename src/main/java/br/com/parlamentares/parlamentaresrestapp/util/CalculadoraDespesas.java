package br.com.parlamentares.parlamentaresrestapp.util;

import br.com.parlamentares.parlamentaresrestapp.model.Despesa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalculadoraDespesas {

    public static BigDecimal round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd;
    }

    public List<Despesa> calcularTotalDeDespesas(List<List<Despesa>> despesas) {
        List<Despesa> valorTotalPorMes = new ArrayList<>();
        for (List<Despesa> despesasNoMes : despesas) {
            float despesaTotal = 0;
            for (Despesa despesa : despesasNoMes) {
                despesaTotal += despesa.getValorLiquido();
            }
            BigDecimal result = round(despesaTotal,2);
            Despesa despesasTotais = new Despesa();
            despesasTotais.setValorLiquido(result.floatValue());
            despesasTotais.setMes(despesasNoMes.get(0).getMes());
            valorTotalPorMes.add(despesasTotais);
        }
        return valorTotalPorMes;
    }
}
