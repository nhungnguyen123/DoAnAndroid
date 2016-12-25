package com.uiapp.doan.main.report.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.injection.component.ApplicationComponent;
import com.uiapp.doan.main.orderdetail.injection.OrderDetailModule;
import com.uiapp.doan.main.orderdetail.view.OrderDetailFragment;
import com.uiapp.doan.main.report.view.ReportFragment;

import java.sql.PreparedStatement;

import dagger.Component;

/**
 * Created by hongnhung on 12/20/16.
 */

@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = ReportModule.class)
public interface ReprtComponent {
    void inject(ReportFragment reportFragment);
}
