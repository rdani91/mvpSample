package test.presenter.feature1;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import test.presenter.SchedulerProvider;

public class TestSchedulerProvider implements SchedulerProvider {
    @Override
    public Scheduler ui() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler newThread() {
        return Schedulers.trampoline();
    }
}
