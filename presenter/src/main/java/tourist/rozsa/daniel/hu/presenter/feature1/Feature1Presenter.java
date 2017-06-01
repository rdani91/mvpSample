package tourist.rozsa.daniel.hu.presenter.feature1;

public class Feature1Presenter implements Feature1Contract.Presenter {

    private final Feature1Contract.View view;

    public Feature1Presenter(Feature1Contract.View view) {
        this.view = view;
    }
}
