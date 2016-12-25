package com.uiapp.doan.main.signupstaff.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.injection.component.ApplicationComponent;
import com.uiapp.doan.main.signupstaff.view.SignUpStaffFragment;

import dagger.Component;

/**
 * Created by hongnhung on 11/3/16.
 */

@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = SignUpStaffModule.class)
public interface SignUpStaffComponent {
    void inject(SignUpStaffFragment signUpStaffFragment);
}
