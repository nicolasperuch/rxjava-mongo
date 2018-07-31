package dev.peruch.rxjavamongo.subscribers;

import rx.Subscriber;

public class Database {

    private Subscriber database;

    public Database() {
        database = new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Object o) {
                System.out.println("Saving " + o + " into database!");
            }
        };
    }

    public Subscriber getSubscriber() {
        return database;
    }
}
