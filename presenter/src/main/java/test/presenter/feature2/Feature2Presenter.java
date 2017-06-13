package test.presenter.feature2;

import test.presenter.event.DataEventBus;

public class Feature2Presenter implements DataEventBus.OnDataChanged {
    private final Feature2View view;

    public Feature2Presenter(Feature2View view, DataEventBus dataEventBus) {
        this.view = view;
        dataEventBus.subscribe(this);
    }


    @Override
    public void newData(String newData) {
        view.onDataArrived(newData);
    }
}
