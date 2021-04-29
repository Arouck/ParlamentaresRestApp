package br.com.parlamentares.parlamentaresrestapp.managedbean;

import br.com.parlamentares.parlamentaresrestapp.model.Deputado;
import br.com.parlamentares.parlamentaresrestapp.rest.RestApi;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.*;

@ManagedBean
@ApplicationScoped
public class ParlamentaresBean {
    private List<Deputado> deputados;
    private RestApi restApi;

    public ParlamentaresBean() {
        this.restApi = new RestApi();
    }

    @PostConstruct
    public void init() {
        this.deputados = this.restApi.getListaDeParlamentares().getDados();
    }

    public String redirecionarParaDetalhes(Integer index) {
        return "detalhes.xhtml?index=" + index + "&faces-redirect=true";
    }

    public List<Deputado> getDeputados() {
        return deputados;
    }

    public void setDeputados(List<Deputado> deputados) {
        this.deputados = deputados;
    }

    public RestApi getRestApi() {
        return restApi;
    }

    public void setRestApi(RestApi restApi) {
        this.restApi = restApi;
    }
}
