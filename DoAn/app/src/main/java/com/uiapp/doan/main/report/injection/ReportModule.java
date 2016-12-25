package com.uiapp.doan.main.report.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.report.presenter.ReportPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hongnhung on 12/20/16.
 */

@Module
public class ReportModule {
    @Provides
    @PerFragment
    ReportPresenter ProvideReportPresenter(ApiManager apiManager, PreferManager preferManager){
        return  new ReportPresenter(apiManager, preferManager);
    }
}
