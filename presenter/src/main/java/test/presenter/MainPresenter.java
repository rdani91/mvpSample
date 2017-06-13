package test.presenter;

import com.example.SampleProvider;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {

    private final MainPresenterView view;
    private final SampleProvider    sampleProvider;

    public MainPresenter(MainPresenterView view, SampleProvider sampleProvider) {
        this.view = view;
        this.sampleProvider = sampleProvider;
    }


    public void onTopFabClicked() {
        sampleProvider.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        view.changeTopView(s);
                    }
                });
    }

    public void onBottomFabClicked() {
        view.changeBottomView();
        view.animateFab();
    }
}
