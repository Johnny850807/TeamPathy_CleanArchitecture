package com.ood.clean.waterball.teampathy.Domain.UseCase.Wbs;

import com.ood.clean.waterball.teampathy.Domain.DI.Scope.WbsScope;
import com.ood.clean.waterball.teampathy.Domain.UseCase.Base.UseCase;
import com.ood.clean.waterball.teampathy.Domain.Model.WBS.TaskItem;
import com.ood.clean.waterball.teampathy.Domain.Repository.WbsRepository;
import com.ood.clean.waterball.teampathy.Threading.ThreadingObserverFactory;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

@WbsScope
public class UpdateWbs extends UseCase<TaskItem,TaskItem> {
    private WbsRepository wbsRepository;

    @Inject
    public UpdateWbs(ThreadingObserverFactory threadingObserverFactory,
                     WbsRepository wbsRepository) {
        super(threadingObserverFactory);
        this.wbsRepository = wbsRepository;
    }

    @Override
    protected Observable<TaskItem> buildUseCaseObservable(final TaskItem taskRoot) {
        return Observable.create(new ObservableOnSubscribe<TaskItem>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<TaskItem> e) throws Exception {
                e.onNext(wbsRepository.updateWbs(taskRoot));
                e.onComplete();
            }
        });
    }

}