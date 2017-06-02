package tourist.rozsa.daniel.hu.mvpsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import tourist.rozsa.daniel.hu.presenter.feature2.Feature2Contract;
import tourist.rozsa.daniel.hu.presenter.feature2.Feature2Presenter;

public class Fragment2 extends Fragment implements Feature2Contract.View {

    private final Feature2Contract.Presenter presenter = new Feature2Presenter(this);


    public static Fragment2 newInstance() {

        Bundle args = new Bundle();

        Fragment2 fragment = new Fragment2();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void refreshUiAfterLiveStreamClosed() {

    }

    @Override
    public void refreshUiAfterLiveStreamOpened() {

    }
}
