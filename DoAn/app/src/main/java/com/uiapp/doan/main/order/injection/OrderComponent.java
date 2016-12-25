package com.uiapp.doan.main.order.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.injection.component.ApplicationComponent;
import com.uiapp.doan.main.order.view.OrderFragment;

import dagger.Component;

/**
 * Created by hongnhung on 11/1/16.
 */

@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = OrderModule.class)
public interface OrderComponent {
    void  inject(OrderFragment orderFragment);
}
