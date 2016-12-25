package com.uiapp.doan.main.allstaff.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.injection.component.ApplicationComponent;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.allstaff.presenter.AllStaffPresenter;
import com.uiapp.doan.main.allstaff.view.AllStaffFragment;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by hongnhung on 10/25/16.
 */


@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = AllStaffModule.class)
public interface AllStaffComponent {
    void inject(AllStaffFragment allStaffFragment);


}
