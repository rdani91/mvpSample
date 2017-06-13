package test.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.presenter.event.EventBusInjector;
import test.presenter.feature2.Feature2Presenter;
import test.presenter.feature2.Feature2View;
import tourist.rozsa.daniel.hu.mvpsample.R;

public class Feature2Fragment extends Fragment implements Feature2View {

    @BindView(R.id.tvSelected)
    public TextView tvSelected;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feature_2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        Feature2Presenter presenter = new Feature2Presenter(this, EventBusInjector.injectDataEventBus());
    }


    @Override
    public void onDataArrived(String newData) {
        tvSelected.setText(newData);
    }
}
