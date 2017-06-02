package tourist.rozsa.daniel.hu.presenter;

public interface LivestreamContract {


    interface View {

        void refreshUiAfterLiveStreamClosed();

        void refreshUiAfterLiveStreamOpened();

    }

    interface Presenter {

        void onLiveStreamStateChange(int newState);

        void onDestroy();
    }

}
