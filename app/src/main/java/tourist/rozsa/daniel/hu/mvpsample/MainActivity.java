package tourist.rozsa.daniel.hu.mvpsample;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import tourist.rozsa.daniel.hu.presenter.BaseFeatureContract;
import tourist.rozsa.daniel.hu.presenter.feature1.Feature1Presenter;

public class MainActivity extends AppCompatActivity {

    private BaseFeatureContract.Presenter baseFeaturePresenter;

    private void loadView(BaseFeatureContract.View viewToInflate) {

        switch (viewToInflate.getViewType()) {

            case FRAGMENT:
                loadFragment((Fragment) viewToInflate);
                break;

            case DIALOG:

                break;
        }

        setPresenter(viewToInflate);
    }

    private void setPresenter(BaseFeatureContract.View viewToInflate) {
        if (baseFeaturePresenter != null) {
            baseFeaturePresenter.onDestroy();
        }
        baseFeaturePresenter = new Feature1Presenter();
    }

    private void dispatchLocationChange(Location l) {
        baseFeaturePresenter.onLocationChanged(l);
    }

    private void loadFragment(Fragment targetFragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, targetFragment)
                .commit();

    }

    private void createPresenters() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView(Fragment1.newInstance());

        loadView(Fragment2.newInstance());
        createPresenters();
    }
}
