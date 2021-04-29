package br.com.parlamentares.parlamentaresrestapp.util;

import br.com.parlamentares.parlamentaresrestapp.model.Despesa;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FormatadorData {

    public String formatarData(String data) {
        String [] dataSplit = data.split("-");
        Collections.reverse(Arrays.asList(dataSplit));
        return String.join("/", dataSplit);
    }

    public void formatarData(List<Despesa> despesasNoMes) {
        for (Despesa despesa : despesasNoMes) {
            if(despesa.getDataDocumento() != null) {
                String [] data = despesa.getDataDocumento().split("-");
                Collections.reverse(Arrays.asList(data));
                despesa.setDataDocumento(String.join("/", data));
            }
        }
    }

    public void formatarMes(List<Despesa> despesasNoMes) {
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
        for(Despesa despesa : despesasNoMes) {
            despesa.setMes(
                    dateFormatSymbols.getMonths()[Integer.parseInt(despesa.getMes()) - 1]
            );
        }
    }
}
