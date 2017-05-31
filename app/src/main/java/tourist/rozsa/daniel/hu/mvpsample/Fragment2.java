package tourist.rozsa.daniel.hu.mvpsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import tourist.rozsa.daniel.hu.presenter.feature2.Feature2Contract;

public class Fragment2 extends Fragment implements Feature2Contract.View {
    @Override
    public void setPresenter(Feature2Contract.Presenter viewPresenter) {

    }

    @Override
    public ViewType getViewType() {
        return ViewType.FRAGMENT;
    }

    public static Fragment2 newInstance() {

        Bundle args = new Bundle();

        Fragment2 fragment = new Fragment2();
        fragment.setArguments(args);
        return fragment;
    }
}
