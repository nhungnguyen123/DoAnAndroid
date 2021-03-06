package com.uiapp.doan.main.allorder.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.injection.component.ApplicationComponent;
import com.uiapp.doan.main.allorder.view.AllOrderFragment;

import dagger.Component;

/**
 * Created by hongnhung on 10/25/16.
 */

@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = AllOrderModule.class)
public interface AllOrderPresenterComponent {
    void inject(AllOrderFragment allOrderFragment);
}
