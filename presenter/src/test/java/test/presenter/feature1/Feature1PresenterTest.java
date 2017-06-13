package test.presenter.feature1;

import com.example.SampleProvider;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import io.reactivex.Observable;
import test.presenter.SchedulerProvider;
import test.presenter.event.DataEventBus;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Feature1PresenterTest {


    private final String test1 = "test1";
    private final String test2 = "test2";


    @Mock
    Feature1View   view     = Mockito.mock(Feature1View.class);
    @Mock
    SampleProvider provider = Mockito.mock(SampleProvider.class);
    SchedulerProvider schedulerProvider = new TestSchedulerProvider();
    DataEventBus      dataEventBus      = new DataEventBus();

    private Feature1Presenter presenter = new Feature1Presenter(schedulerProvider, view, provider, dataEventBus);

    @Test
    public void onStart() throws Exception {
        trainProviderToReturnValidArray();

        presenter.onStart();

        verify(view).startAnimation();
        verify(provider).getStringArray();
        verify(view).addData(test1);
        verify(view).addData(test2);
        verify(view).stopAnimation();
    }

    @Test
    public void onDataSelected() throws Exception {

        presenter.onDataSelected("test");

        verify(dataEventBus).onDataChanged("test");

    }

    private void trainProviderToReturnValidArray() {
        when(provider.getStringArray()).thenReturn(Observable.just(test1, test2));
    }

}