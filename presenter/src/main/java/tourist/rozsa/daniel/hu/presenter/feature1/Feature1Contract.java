package tourist.rozsa.daniel.hu.presenter.feature1;

import tourist.rozsa.daniel.hu.presenter.BaseFeatureContract;

public interface Feature1Contract {

    interface View extends BaseFeatureContract.View {

        void setPresenter(Presenter viewPresenter);
    }

    interface Presenter extends BaseFeatureContract.Presenter {


        void setView(Feature1Contract.View view);
    }

}
