package br.com.parlamentares.parlamentaresrestapp.util;

import br.com.parlamentares.parlamentaresrestapp.model.Despesa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FormatadorDataTest {

    FormatadorData formatadorData = new FormatadorData();

    @Test
    public void testFormatarDataString() {
        String data = "2021-12-31";
        String dataEsperada = "31/12/2021";

        String dataRecebida = formatadorData.formatarData(data);

        Assertions.assertEquals(dataEsperada, dataRecebida);
    }

    @Test
    public void testFormatarDataLista() {
        String data1 = "2021-12-31";
        String data2 = "2021-01-01";

        List<Despesa> despesasNoMes = new ArrayList<>();
        Despesa despesa1 = new Despesa();
        despesa1.setDataDocumento(data1);
        Despesa despesa2 = new Despesa();
        despesa2.setDataDocumento(data1);

        String[] datasEsperadas = new String[2];
        datasEsperadas[0] = "31/12/2021";
        datasEsperadas[1] = "01/01/2021";

        formatadorData.formatarData(despesasNoMes);

        for(int i = 0; i < despesasNoMes.size(); i++){
            Assertions.assertEquals(datasEsperadas[i], despesasNoMes.get(i).getDataDocumento());
        }
    }

    @Test
    public void testFormatarMes() {
        String mes1 = "12";
        String mes2 = "1";

        List<Despesa> despesasNoMes = new ArrayList<>();
        Despesa despesa1 = new Despesa();
        despesa1.setMes(mes1);
        Despesa despesa2 = new Despesa();
        despesa2.setMes(mes2);

        String[] datasEsperadas = new String[2];
        datasEsperadas[0] = "Dezembro";
        datasEsperadas[1] = "Janeiro";

        formatadorData.formatarData(despesasNoMes);

        for(int i = 0; i < despesasNoMes.size(); i++){
            Assertions.assertEquals(datasEsperadas[i], despesasNoMes.get(i).getMes());
        }
    }
}
