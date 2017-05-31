package tourist.rozsa.daniel.hu.presenter.feature2;

import tourist.rozsa.daniel.hu.presenter.BaseFeatureContract;

public interface Feature2Contract {


    interface View extends BaseFeatureContract.View {

        void setPresenter(Feature2Contract.Presenter viewPresenter);
    }

    interface Presenter extends BaseFeatureContract.Presenter {

        void setView(Feature2Contract.View view);
    }


}
