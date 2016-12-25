package com.uiapp.doan.main.signup.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.injection.component.ApplicationComponent;
import com.uiapp.doan.main.signup.view.SignUpFragment;

import javax.inject.Inject;

import dagger.Component;

/**
 * Created by hongnhung on 10/26/16.
 */

@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = SignUpModule.class)
public interface SignUpComponent {
    void inject(SignUpFragment fragment);
}
