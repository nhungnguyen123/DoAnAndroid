package com.uiapp.doan.main.login.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.injection.component.ApplicationComponent;
import com.uiapp.doan.main.choose.injection.ChooseModule;
import com.uiapp.doan.main.choose.view.ChooseFragment;
import com.uiapp.doan.main.login.view.LoginFragment;

import dagger.Component;

/**
 * Created by hongnhung on 10/24/16.
 */

@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = LoginModule.class)
public interface ILoginComponent {
    void inject(LoginFragment loginFragment);
}
