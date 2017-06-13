package test.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ProviderInjector;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.presenter.event.EventBusInjector;
import test.presenter.feature1.Feature1Presenter;
import test.presenter.feature1.Feature1View;
import tourist.rozsa.daniel.hu.mvpsample.R;

public class Feature1Fragment extends Fragment implements Feature1View {

    private static final String KEY = "key";


    @BindView(R.id.tvSample)
    public  TextView               tvSample;
    @BindView(R.id.list)
    public  ListView               listView;
    @BindView(R.id.progress)
    public  ProgressBar            progressBar;
    private Feature1Presenter      presenter;
    private Feature1ListViewHelper listViewHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feature_1, container, false);
    }

    public static Fragment newInstance(String data) {
        Feature1Fragment fragment = new Feature1Fragment();

        Bundle args = new Bundle();
        args.putString(KEY, data);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
        String extraData = getArguments().getString(KEY);
        tvSample.setText(String.format("%s came from the args", extraData));

        presenter = new Feature1Presenter(this, ProviderInjector.injectSampleProvider(), EventBusInjector.injectDataEventBus());

        presenter.onStart();

        listViewHelper = new Feature1ListViewHelper(listView, presenter);
    }

    @Override
    public void startAnimation() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void addData(String data) {
        listViewHelper.addData(data);
    }

    @Override
    public void stopAnimation() {
        progressBar.setVisibility(View.GONE);
    }
}
