package dev.peruch.rxjavamongo.controller.dto;

public class PagamentoDto {

    private String nsuOrigem;
    private String valor;
    private String data;
    private String idConta;

    public String getNsuOrigem() {
        return nsuOrigem;
    }

    public void setNsuOrigem(String nsuOrigem) {
        this.nsuOrigem = nsuOrigem;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIdConta() {
        return idConta;
    }

    public void setIdConta(String idConta) {
        this.idConta = idConta;
    }
}
