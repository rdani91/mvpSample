package tourist.rozsa.daniel.hu.presenter;

import android.location.Location;

public interface BaseFeatureContract {


    interface View {


        ViewType getViewType();

        enum ViewType {
            DIALOG, FRAGMENT
        }
    }

    interface Presenter {

        void onLocationChanged(Location l);

        void onDestroy();
    }

}
