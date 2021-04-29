package br.com.parlamentares.parlamentaresrestapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UltimoStatus {
    private String siglaPartido;
    private String urlFoto;

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Override
    public String toString() {
        return "UltimoStatus{" +
                "siglaPartido='" + siglaPartido + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                '}';
    }
}
