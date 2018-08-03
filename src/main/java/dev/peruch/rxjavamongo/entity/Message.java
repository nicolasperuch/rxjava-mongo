package dev.peruch.rxjavamongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "message")
public abstract class Message {

    @Id
    private String id;
    private String idTransacao;
    private String type;

    public Message(String idTransacao, String type) {
        this.idTransacao = idTransacao;
        this.type = type;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public String getType() {
        return type;
    }
}
