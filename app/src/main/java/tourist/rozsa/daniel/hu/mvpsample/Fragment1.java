package tourist.rozsa.daniel.hu.mvpsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import tourist.rozsa.daniel.hu.presenter.feature1.Feature1Contract;

public class Fragment1 extends Fragment implements Feature1Contract.View {
    @Override
    public void setPresenter(Feature1Contract.Presenter viewPresenter) {

    }

    public static Fragment1 newInstance() {

        Bundle args = new Bundle();

        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public ViewType getViewType() {
        return ViewType.FRAGMENT;
    }
}
