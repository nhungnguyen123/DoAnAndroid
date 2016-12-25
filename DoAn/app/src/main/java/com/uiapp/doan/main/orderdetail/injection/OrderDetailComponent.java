package com.uiapp.doan.main.orderdetail.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.injection.component.ApplicationComponent;
import com.uiapp.doan.main.allstaff.injection.AllStaffModule;
import com.uiapp.doan.main.allstaff.view.AllStaffFragment;
import com.uiapp.doan.main.orderdetail.view.OrderDetailFragment;

import dagger.Component;

/**
 * Created by hongnhung on 11/19/16.
 */

@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = OrderDetailModule.class)
public interface OrderDetailComponent {
    void inject(OrderDetailFragment orderDetailFragment);
}
