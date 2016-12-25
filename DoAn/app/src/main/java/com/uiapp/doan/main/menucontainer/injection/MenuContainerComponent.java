package com.uiapp.doan.main.menucontainer.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.injection.component.ApplicationComponent;
import com.uiapp.doan.main.menucontainer.view.MenuContainerFragment;

import dagger.Component;

/**
 * Created by hongnhung on 10/23/16.
 */

@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = MenuContainerModule.class)
public interface MenuContainerComponent {
    void inject(MenuContainerFragment menuContainerFragment);
}
