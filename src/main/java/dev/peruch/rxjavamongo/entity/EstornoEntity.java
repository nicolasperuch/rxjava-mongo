package dev.peruch.rxjavamongo.entity;

public class EstornoEntity extends Message{

    private String estornoDescription;

    public EstornoEntity(String idTransacao, String type, String estornoDescription) {
        super(idTransacao, type);
        this.estornoDescription = estornoDescription;
    }
}
