package com.uiapp.doan.main.staffdetail.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.injection.component.ApplicationComponent;
import com.uiapp.doan.main.signupstaff.injection.SignUpStaffModule;
import com.uiapp.doan.main.signupstaff.view.SignUpStaffFragment;
import com.uiapp.doan.main.staffdetail.view.StaffDetailFragment;

import dagger.Component;

/**
 * Created by hongnhung on 11/19/16.
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = StaffDetailModule.class)
public interface StaffDetailComponent {
    void inject(StaffDetailFragment staffDetailFragment);
}
