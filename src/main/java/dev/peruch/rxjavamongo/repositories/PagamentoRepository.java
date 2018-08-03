package dev.peruch.rxjavamongo.repositories;

import dev.peruch.rxjavamongo.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PagamentoRepository extends MongoRepository<Message, String>{

    Message save(Message message);
    List<Message> findOneByIdTransacaoOrderByIdDesc(String idTransacao);
}
