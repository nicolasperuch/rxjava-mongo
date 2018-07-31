package dev.peruch.rxjavamongo;

import dev.peruch.rxjavamongo.subscribers.Database;
import dev.peruch.rxjavamongo.subscribers.Negative;
import dev.peruch.rxjavamongo.subscribers.Positive;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

import static dev.peruch.rxjavamongo.flow.Flow.createFlow;
import static java.util.concurrent.TimeUnit.SECONDS;

public class EntryPointFlow {

    PublishSubject entryPointFlow = createFlow();
    PublishSubject positiveFlow = createFlow();
    PublishSubject negativeFlow  = createFlow();

    public void firstTry() throws InterruptedException {

        entryPointFlow
                .subscribe(e -> System.out.println("Saving " + e + " into database"));

        entryPointFlow
                .observeOn(Schedulers.computation())
                .filter(e -> (Integer) e >= 0)
                .subscribe(e -> System.out.println("Positive: " + (Integer) e));

        entryPointFlow
                .observeOn(Schedulers.computation())
                .filter(e -> (Integer) e < 0)
                .subscribe(e -> System.out.println("Negative: " + (Integer) e));

        entryPointFlow.onNext(1);
        entryPointFlow.onNext(-8);
        entryPointFlow.onNext(0);
        entryPointFlow.onNext(-12);
        entryPointFlow.onNext(123);
        entryPointFlow.onNext(10);

        SECONDS.sleep(5);
    }

    public void secondTry() throws InterruptedException {
        positiveFlow
                .subscribe(e -> System.out.println("Positive: " + e));

        negativeFlow
                .subscribe(e -> System.out.println("Negative: " + e));

        entryPointFlow
                .subscribe(e -> System.out.println("Saving " + e + " into database"));

        entryPointFlow
                .observeOn(Schedulers.computation())
                .filter(e -> (Integer) e >= 0)
                .subscribe(e -> positiveFlow.onNext(e));

        entryPointFlow
                .observeOn(Schedulers.computation())
                .filter(e -> (Integer) e < 0)
                .subscribe(e -> negativeFlow.onNext(e));

        entryPointFlow.onNext(1);
        entryPointFlow.onNext(-8);
        entryPointFlow.onNext(0);
        entryPointFlow.onNext(-12);
        entryPointFlow.onNext(123);
        entryPointFlow.onNext(10);

        SECONDS.sleep(5);
    }

    public void thirdTry() throws InterruptedException {
        entryPointFlow
                .observeOn(Schedulers.computation())
                .subscribe(new Database().getSubscriber());

        positiveFlow
                .observeOn(Schedulers.computation())
                .subscribe(new Positive().getSubscriber());

        negativeFlow
                .observeOn(Schedulers.computation())
                .subscribe(new Negative().getSubscriber());

        entryPointFlow
                .filter(e -> (Integer) e >= 0)
                .subscribe(e -> positiveFlow.onNext(e));

        entryPointFlow
                .filter(e -> (Integer) e < 0)
                .subscribe(e -> negativeFlow.onNext(e));

        entryPointFlow.onNext(1);
        entryPointFlow.onNext(-8);
        entryPointFlow.onNext(0);
        entryPointFlow.onNext(-12);
        entryPointFlow.onNext(123);
        entryPointFlow.onNext(10);

        SECONDS.sleep(5);

    }
}
