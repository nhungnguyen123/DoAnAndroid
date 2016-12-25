package com.uiapp.doan.main.changepass.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.injection.component.ApplicationComponent;
import com.uiapp.doan.main.allstafforder.injection.AllStaffOrderModule;
import com.uiapp.doan.main.allstafforder.view.AllStaffOrderFragment;
import com.uiapp.doan.main.changepass.view.ChangePassFragment;

import dagger.Component;

/**
 * Created by hongnhung on 12/15/16.
 */


@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = ChangePassModule.class)
public interface ChangePassComponent {

    void inject(ChangePassFragment changePassFragment);
}
