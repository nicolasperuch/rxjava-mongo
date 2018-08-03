package dev.peruch.rxjavamongo.entity;

import dev.peruch.rxjavamongo.controller.dto.PagamentoDto;

public class PagamentoEntity extends Message{

    private PagamentoDto pagamentoDto;

    public PagamentoEntity(String idTransacao, String type, PagamentoDto pagamentoDto) {
        super(idTransacao, type);
        this.pagamentoDto = pagamentoDto;
    }
}
