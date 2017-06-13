package test.presenter.feature1;

import com.example.SampleProvider;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import test.presenter.SchedulerProvider;
import test.presenter.event.DataEventBus;

public class Feature1Presenter {

    private final SchedulerProvider schedulerProvider;
    private final Feature1View      view;
    private final SampleProvider    sampleProvider;
    private final DataEventBus      dataEventBus;

    public Feature1Presenter(SchedulerProvider schedulerProvider, Feature1View view, SampleProvider sampleProvider, DataEventBus dataEventBus) {
        this.schedulerProvider = schedulerProvider;
        this.view = view;
        this.sampleProvider = sampleProvider;
        this.dataEventBus = dataEventBus;
    }

    public void onStart() {
        view.startAnimation();
        sampleProvider.getStringArray()
                .subscribeOn(schedulerProvider.newThread())
                .observeOn(schedulerProvider.ui())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        view.addData(s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        view.stopAnimation();
                    }
                });
    }

    public void onDataSelected(String item) {
        dataEventBus.onDataChanged(item);
    }
}
