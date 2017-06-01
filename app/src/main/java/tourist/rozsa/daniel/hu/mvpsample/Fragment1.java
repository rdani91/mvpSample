package tourist.rozsa.daniel.hu.mvpsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import tourist.rozsa.daniel.hu.presenter.feature1.Feature1Contract;
import tourist.rozsa.daniel.hu.presenter.feature1.Feature1Presenter;

public class Fragment1 extends Fragment implements Feature1Contract.View {

    Feature1Contract.Presenter presenter = new Feature1Presenter(this);


    public static Fragment1 newInstance() {

        Bundle args = new Bundle();

        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }


}
