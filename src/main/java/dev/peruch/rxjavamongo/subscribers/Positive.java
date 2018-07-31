package dev.peruch.rxjavamongo.subscribers;

import rx.Subscriber;

public class Positive {

    private Subscriber negative;

    public Positive() {
        this.negative = new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Object o) {
                System.out.println("Positive: " + (Integer) o);
            }
        };
    }

    public Subscriber getSubscriber() {
        return negative;
    }
}
