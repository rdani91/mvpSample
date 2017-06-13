package com.example;

public class ProviderInjector {
    public static SampleProvider injectSampleProvider() {
        return new FakeSampleProvider();
    }
}
