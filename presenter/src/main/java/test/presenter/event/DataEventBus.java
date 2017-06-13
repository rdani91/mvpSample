package test.presenter.event;

import java.util.HashSet;
import java.util.Set;

public class DataEventBus {

    private Set<OnDataChanged> listeners = new HashSet<>();

    public void subscribe(OnDataChanged listener) {
        this.listeners.add(listener);
    }

    public void onDataChanged(String data) {
        for (OnDataChanged listener : listeners) {
            listener.newData(data);
        }
    }

    public interface OnDataChanged {

        void newData(String newData);
    }
}
