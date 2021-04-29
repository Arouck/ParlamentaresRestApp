package br.com.devmedia.notas.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

public class RestApi {

    Client client;
    WebTarget webTarget;
    WebTarget deputadosListWebTarget;

    public RestApi() {
        this.client = ClientBuilder.newClient();
        this.webTarget = this.client.target("https://dadosabertos.camara.leg.br/api/v2");
        this.deputadosListWebTarget = this.webTarget.path("/deputados");
    }

    public RespostaListaDeputados getListaDeParlamentares() {
        Invocation.Builder invocationBuilder = deputadosListWebTarget.request(MediaType.APPLICATION_JSON);
        return invocationBuilder.get(RespostaListaDeputados.class);
    }

    public RespostaDetalhes getDetalhesDeParlamentar(Integer id) {
        WebTarget detalhesParlamentarWebTarget = deputadosListWebTarget.path(id.toString());
        Invocation.Builder invocationBuilder = detalhesParlamentarWebTarget.request(MediaType.APPLICATION_JSON);
        return invocationBuilder.get(RespostaDetalhes.class);
    }

    public RespostaListaDespesas getDespesas(Integer id) {
        LocalDate data = LocalDate.now();
        Integer anoFinal = data.minusMonths(1).getYear();
        Integer mes1 = data.minusMonths(1).getMonthValue();
        Integer mes2 = data.minusMonths(2).getMonthValue();

        WebTarget despesasWebTarget = deputadosListWebTarget.path(id.toString()).path("despesas")
                .queryParam("mes", mes1).queryParam("mes", mes2).queryParam("itens", Integer.MAX_VALUE)
                .queryParam("ano", anoFinal).queryParam("ordenarPor", "mes");
        Invocation.Builder invocationBuilder = despesasWebTarget.request(MediaType.APPLICATION_JSON);
        return invocationBuilder.get(RespostaListaDespesas.class);
    }
}
