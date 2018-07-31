package dev.peruch.rxjavamongo.subscribers;

import rx.Subscriber;

public class Negative {

    private Subscriber negative;

    public Negative() {
        this.negative = new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Object o) {
                System.out.println("Negative: " + (Integer) o);
            }
        };
    }

    public Subscriber getSubscriber() {
        return negative;
    }
}
