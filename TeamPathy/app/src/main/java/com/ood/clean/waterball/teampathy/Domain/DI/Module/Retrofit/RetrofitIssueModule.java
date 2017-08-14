package com.ood.clean.waterball.teampathy.Domain.DI.Module.Retrofit;

import com.ood.clean.waterball.teampathy.Domain.DI.Scope.IssueScope;
import com.ood.clean.waterball.teampathy.Domain.Exception.ConverterFactory.ExceptionConverter;
import com.ood.clean.waterball.teampathy.Domain.Model.Issue;
import com.ood.clean.waterball.teampathy.Domain.Model.Project;
import com.ood.clean.waterball.teampathy.Domain.Model.User;
import com.ood.clean.waterball.teampathy.Domain.Repository.IssueCommentRepository;
import com.ood.clean.waterball.teampathy.Framework.Retrofit.Repository.IssueCommentRetrofitRepository;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RetrofitIssueModule {
    private Issue issue;

    public RetrofitIssueModule(Issue issue) {
        this.issue = issue;
    }

    @Provides
    @IssueScope
    public Issue provideIssue(){
        return issue;
    }

    @Provides @IssueScope
    public IssueCommentRepository provideIssueCommentRepository(ExceptionConverter exceptionConverter,
                                                                User user,
                                                                Project project,
                                                                Retrofit retrofit){
        return new IssueCommentRetrofitRepository(exceptionConverter, user, project, issue, retrofit);
    }
}