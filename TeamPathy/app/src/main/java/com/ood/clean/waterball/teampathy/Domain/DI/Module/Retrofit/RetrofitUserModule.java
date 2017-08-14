package com.ood.clean.waterball.teampathy.Domain.DI.Module.Retrofit;

import com.ood.clean.waterball.teampathy.Domain.DI.Scope.UserScope;
import com.ood.clean.waterball.teampathy.Domain.Exception.ConverterFactory.ExceptionConverter;
import com.ood.clean.waterball.teampathy.Domain.Model.User;
import com.ood.clean.waterball.teampathy.Domain.Repository.ProjectRepository;
import com.ood.clean.waterball.teampathy.Framework.Retrofit.Repository.ProjectRetrofitRepository;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
public class RetrofitUserModule {
    private User user;

    public RetrofitUserModule(User user) {
        this.user = user;
    }

    @Provides
    @UserScope
    public User provideUser(){
        return user;
    }

    @Provides @UserScope
    public ProjectRepository provideProjectRepository(Retrofit retrofit, ExceptionConverter exceptionConverter){
        return new ProjectRetrofitRepository(retrofit, exceptionConverter, user);
    }

}