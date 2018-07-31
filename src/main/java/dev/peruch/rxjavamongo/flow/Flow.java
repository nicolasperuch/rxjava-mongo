package dev.peruch.rxjavamongo.flow;

import rx.subjects.PublishSubject;

public class Flow {

    public static PublishSubject createFlow(){
        return PublishSubject.create();
    }
}
