package br.com.parlamentares.parlamentaresrestapp.managedbean;

import br.com.parlamentares.parlamentaresrestapp.model.Deputado;
import br.com.parlamentares.parlamentaresrestapp.model.Despesa;
import br.com.parlamentares.parlamentaresrestapp.rest.RestApi;
import br.com.parlamentares.parlamentaresrestapp.util.CalculadoraDespesas;
import br.com.parlamentares.parlamentaresrestapp.util.FormatadorData;
import br.com.parlamentares.parlamentaresrestapp.util.SeparadorMes;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@ManagedBean
@ViewScoped
public class DetalhesBean {

    @ManagedProperty(value = "#{parlamentaresBean}")
    private ParlamentaresBean parlamentaresBean;
    private Integer id;
    private Deputado deputado;
    private RestApi restApi;
    private List<Despesa> despesasNoMes;
    private List<Despesa> todasDespesas;

    public DetalhesBean() {
        if(parlamentaresBean == null) {
            parlamentaresBean = new ParlamentaresBean();
        }
        this.restApi = new RestApi();
    }

    @PostConstruct
    public void init() {
        SeparadorMes separadorMes = new SeparadorMes();
        CalculadoraDespesas calculadoraDespesas = new CalculadoraDespesas();
        FormatadorData formatadorData = new FormatadorData();
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        int index = Integer.parseInt(params.get("index"));
        this.id = this.parlamentaresBean.getDeputados().get(index).getId();

        this.deputado = this.restApi.getDetalhesDeParlamentar(id).getDados();

        this.todasDespesas = this.restApi.getDespesas(id).getDados();

        this.deputado.setDespesas(calculadoraDespesas.calcularTotalDeDespesas(separadorMes.separarMeses(todasDespesas)));

        formatadorData.formatarMes(this.deputado.getDespesas());

        this.deputado.setDataNascimento(formatadorData.formatarData(this.deputado.getDataNascimento()));

        incrementarVisualizacoes(index);
    }

    public void incrementarVisualizacoes(Integer index) {
        Deputado deputado = this.parlamentaresBean.getDeputados().get(index);
        deputado.setNumeroDeVisualizacoes(deputado.getNumeroDeVisualizacoes() + 1);
    }

    public void detalharDespesasNoMes(int index) {
        FormatadorData formatadorData = new FormatadorData();
        SeparadorMes separadorMes = new SeparadorMes();
        despesasNoMes = separadorMes.separarMeses(todasDespesas).get(index);
        formatadorData.formatarData(despesasNoMes);
        Collections.sort(despesasNoMes);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Deputado getDeputado() {
        return deputado;
    }

    public void setDeputado(Deputado deputado) {
        this.deputado = deputado;
    }

    public RestApi getRestApi() {
        return restApi;
    }

    public void setRestApi(RestApi restApi) {
        this.restApi = restApi;
    }

    public List<Despesa> getDespesasNoMes() {
        return despesasNoMes;
    }

    public void setDespesasNoMes(List<Despesa> despesasNoMes) {
        this.despesasNoMes = despesasNoMes;
    }

    public List<Despesa> getTodasDespesas() {
        return todasDespesas;
    }

    public void setTodasDespesas(List<Despesa> todasDespesas) {
        this.todasDespesas = todasDespesas;
    }

    public void setParlamentaresBean(ParlamentaresBean parlamentaresBean) {
        this.parlamentaresBean = parlamentaresBean;
    }
}
