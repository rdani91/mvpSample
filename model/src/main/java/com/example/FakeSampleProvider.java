package com.example;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

public class FakeSampleProvider implements SampleProvider {
    @Override
    public Observable<String> getData() {

        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("sample data");
            }
        });
    }

    @Override
    public Observable<String> getStringArray() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {

                for (int i = 0; i < 15; i++) {
                    Thread.sleep(400);
                    e.onNext("fake data : " + i);
                }
                e.onComplete();
            }
        });
    }
}
