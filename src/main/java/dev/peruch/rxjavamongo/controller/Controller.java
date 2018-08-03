package dev.peruch.rxjavamongo.controller;

import dev.peruch.rxjavamongo.controller.dto.PagamentoDto;
import dev.peruch.rxjavamongo.entity.EstornoEntity;
import dev.peruch.rxjavamongo.entity.Message;
import dev.peruch.rxjavamongo.entity.PagamentoEntity;
import dev.peruch.rxjavamongo.repositories.PagamentoRepository;
import dev.peruch.rxjavamongo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rx.subjects.PublishSubject;

import java.util.List;
import java.util.Random;

@RestController
public class Controller {

    @Autowired
    PublishSubject publishSubject;

    @Autowired
    PagamentoRepository pagamentoRepository;

    @PostMapping("/pagamento")
    public ResponseEntity solicitarPagamento(@RequestBody PagamentoDto pagamentoDto){

        int idTransacao = new Random().nextInt(200);

        PagamentoEntity event = new PagamentoEntity(String.valueOf(idTransacao), "Pagamento Aceito", pagamentoDto);

        publishSubject.subscribe(e -> {
            pagamentoRepository.save(event);
        });

        publishSubject.onNext(event);

        return ResponseEntity.ok(idTransacao);
    }

    @GetMapping("/pagamento/{idTransacao}")
    public ResponseEntity listCustomers(@PathVariable String idTransacao){
        List<Message> response = pagamentoRepository.findOneByIdTransacaoOrderByIdDesc(idTransacao);
        response.forEach(r -> System.out.println(r.getType()));
        return ResponseEntity.ok(response.get(0));
    }

    @DeleteMapping("/pagamento/{idTransacao}")
    public ResponseEntity solicitarEstorno(@PathVariable String idTransacao){

        EstornoEntity event = new EstornoEntity(idTransacao, "Estorno Aceito", "Estornado por x, y, z.");

        publishSubject.subscribe(e -> {
            pagamentoRepository.save(event);
        });
        publishSubject.onNext(event);
        return ResponseEntity.ok("Ok");
    }
}
