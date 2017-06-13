package com.example;

import io.reactivex.Observable;

public interface SampleProvider {

    Observable<String> getData();

    Observable<String> getStringArray();
}
