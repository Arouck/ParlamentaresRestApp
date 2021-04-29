package br.com.parlamentares.parlamentaresrestapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Despesa implements Comparable<Despesa> {
    private String mes;
    private float valorLiquido;
    private String tipoDocumento;
    private String tipoDespesa;
    private String dataDocumento;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public float getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(float valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public String getDataDocumento() {
        return dataDocumento;
    }

    public void setDataDocumento(String dataDocumento) {
        this.dataDocumento = dataDocumento;
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "mes='" + mes + '\'' +
                ", valorLiquido=" + valorLiquido +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", tipoDespesa='" + tipoDespesa + '\'' +
                ", dataDocumento='" + dataDocumento + '\'' +
                '}';
    }

    @Override
    public int compareTo(Despesa o) {
        if(this.getDataDocumento() == null) {
            return Integer.MAX_VALUE;
        } else {
            if(o.getDataDocumento() == null) {
                return Integer.MIN_VALUE;
            } else {
                return -this.getDataDocumento().compareTo(o.getDataDocumento());
            }
        }
    }
}
