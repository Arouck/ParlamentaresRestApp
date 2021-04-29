package br.com.devmedia.notas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Deputado {
    private Integer id;
    private String nome;
    private String siglaPartido;
    private String siglaUf;
    private String nomeCivil;
    private String dataNascimento;
    private String sexo;
    private String urlFoto;
    private UltimoStatus ultimoStatus;
    private Integer numeroDeVisualizacoes = 0;
    private List<Despesa> despesas;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getSiglaUf() { return siglaUf; }

    public void setSiglaUf(String siglaUf) { this.siglaUf = siglaUf; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public String getNomeCivil() {
        return nomeCivil;
    }

    public void setNomeCivil(String nomeCivil) {
        this.nomeCivil = nomeCivil;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public UltimoStatus getUltimoStatus() {
        return ultimoStatus;
    }

    public void setUltimoStatus(UltimoStatus ultimoStatus) {
        this.ultimoStatus = ultimoStatus;
    }

    public Integer getNumeroDeVisualizacoes() {
        return numeroDeVisualizacoes;
    }

    public void setNumeroDeVisualizacoes(Integer numeroDeVisualizacoes) {
        this.numeroDeVisualizacoes = numeroDeVisualizacoes;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    @Override
    public String toString() {
        return "Deputado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", siglaPartido='" + siglaPartido + '\'' +
                ", siglaUf='" + siglaUf + '\'' +
                ", nomeCivil='" + nomeCivil + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", sexo='" + sexo + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                ", ultimoStatus=" + ultimoStatus +
                ", numeroDeVisualizacoes=" + numeroDeVisualizacoes +
                '}';
    }
}
