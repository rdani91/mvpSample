package test.presenter.event;

public class EventBusInjector {

    private static DataEventBus dataEventBus;

    public static DataEventBus injectDataEventBus() {
        if (dataEventBus == null) {
            dataEventBus = new DataEventBus();
        }
        return dataEventBus;

    }
}
