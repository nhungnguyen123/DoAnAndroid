package com.uiapp.doan.main.menucontainer.presenter;

import android.util.Log;

import com.uiapp.doan.AppConstants;
import com.uiapp.doan.base.presenter.BasePresenter;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.menucontainer.view.IMenuContainerView;

import javax.inject.Inject;

/**
 * Created by hongnhung on 10/23/16.
 */

public class MenuContainerPresenter extends BasePresenter<IMenuContainerView> implements IMenuContainerPresenter {
    @Inject
    public MenuContainerPresenter(ApiManager apiManager, PreferManager preferManager) {
        super(apiManager, preferManager);
    }


    @Override
    public void attachView(IMenuContainerView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void goLogOut() {
        getPreferManager().removeKeyValueByKeyName(AppConstants.KEY_USER_TOKEN);
        getPreferManager().removeKeyValueByKeyName(AppConstants.KEY_ROLE_USER);
        getPreferManager().removeKeyValueByKeyName(AppConstants.KEY_TAI_KHOAN);
        getPreferManager().removeKeyValueByKeyName(AppConstants.KEY_CMND);
        getPreferManager().removeKeyValueByKeyName(AppConstants.KEY_DIA_CHI);
        getPreferManager().removeKeyValueByKeyName(AppConstants.KEY_NAME_DISPLAY);
        getPreferManager().removeKeyValueByKeyName(AppConstants.EMAIL);
        getPreferManager().removeKeyValueByKeyName(AppConstants.HO_TEN);
        getPreferManager().removeKeyValueByKeyName(AppConstants.QUYEN);
    }

    @Override
    public void goLogin() {
        if (!isViewAttached()) return;
        getView().goLogin();
    }

    @Override
    public void goThongTin() {
        if (!isViewAttached()) return;
        getView().goThongTin();
    }

    @Override
    public void goDanhSachNguoiSua() {

    }

    @Override
    public void goQuanLyGiaoDich() {

    }

    @Override
    public void goTimNguoiSua() {

    }

    @Override
    public void setQuyen() {

    }

    @Override
    public String getQuyen() {
        if (getPreferManager().getKeyValueByKeyName(AppConstants.KEY_ROLE_USER) == null) {
            return "";
        } else {
            return getPreferManager().getKeyValueByKeyName(AppConstants.KEY_ROLE_USER);

        }
//        Log.e("chidung", getPreferManager().getKeyValueByKeyName(AppConstants.KEY_ROLE_USER));
    }
}
