package com.uiapp.doan.main.allstafforder.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.injection.component.ApplicationComponent;
import com.uiapp.doan.main.allstaff.injection.AllStaffModule;
import com.uiapp.doan.main.allstaff.view.AllStaffFragment;
import com.uiapp.doan.main.allstafforder.view.AllStaffOrderFragment;

import dagger.Component;

/**
 * Created by hongnhung on 11/22/16.
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = AllStaffOrderModule.class)
public interface AllStaffOrderComponent {
    void inject(AllStaffOrderFragment allStaffOrderFragment);
}
