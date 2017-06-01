package tourist.rozsa.daniel.hu.presenter;

import android.location.Location;

public interface ActivityContract {


    interface View {

    }

    interface Presenter {

        void onLocationChanged(Location l);

        void onDestroy();
    }

}
