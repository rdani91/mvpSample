package test.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ProviderInjector;

import test.presenter.MainPresenter;
import test.presenter.MainPresenterView;
import tourist.rozsa.daniel.hu.mvpsample.R;


public class MainActivity extends AppCompatActivity implements MainPresenterView {

    private MainPresenter presenter;

    private View fabUp;
    private View fabDown;

    @Override
    public void changeTopView(String data) {
        loadTopFragment(Feature1Fragment.newInstance(data));
    }

    @Override
    public void changeBottomView() {
        loadBottomFragment(new Feature2Fragment());
    }

    @Override
    public void animateFab() {
        float currentAlpha = fabDown.getAlpha();
        fabDown.animate().alpha(currentAlpha == 1f ? 0.6f : 1f).setDuration(200).start();
    }

    private void loadUiElements() {
        fabUp = findViewById(R.id.fabUp);
        fabDown = findViewById(R.id.fabDown);
    }

    private void loadTopFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer1, fragment).commit();
    }

    private void loadBottomFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer2, fragment).commit();
    }

    private void setOnClickListeners() {
        fabUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onTopFabClicked();

            }
        });

        fabDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBottomFabClicked();

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadUiElements();
        setOnClickListeners();

        presenter = new MainPresenter(this, ProviderInjector.injectSampleProvider());
    }
}
