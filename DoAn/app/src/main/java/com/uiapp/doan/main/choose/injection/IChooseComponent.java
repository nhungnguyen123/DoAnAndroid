package com.uiapp.doan.main.choose.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.injection.component.ApplicationComponent;
import com.uiapp.doan.main.choose.view.ChooseFragment;

import dagger.Component;

/**
 * Created by hongnhung on 10/23/16.
 */


@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = ChooseModule.class)
public interface IChooseComponent {
    void  inject(ChooseFragment chooseFragment);
}
