package com.uiapp.doan.main.changepass.presenter;

import com.uiapp.doan.AppConstants;
import com.uiapp.doan.base.presenter.BasePresenter;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.api.network.ApiCallback;
import com.uiapp.doan.interactor.api.network.RestError;
import com.uiapp.doan.interactor.api.request.ChangePassRequest;
import com.uiapp.doan.interactor.api.response.ChangePassThoResponse;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.changepass.view.IViewChange;

import javax.inject.Inject;

/**
 * Created by hongnhung on 12/15/16.
 */

public class ChangePassPresenter extends BasePresenter<IViewChange> implements IChangePassPresenter {

    @Inject
    public ChangePassPresenter(ApiManager apiManager, PreferManager preferManager) {
        super(apiManager, preferManager);
    }

    //TODO thực hiện đưa passmoiws lên
    @Override
    public void changePassTho(ChangePassRequest changePassRequest) {
        getApiManager().changePassTho(getCmnd(), changePassRequest, new ApiCallback<ChangePassThoResponse>() {
            @Override
            public void success(ChangePassThoResponse res) {
                getView().changePasstThoSuccess();
            }

            @Override
            public void failure(RestError error) {
                getView().changePassThoError();
            }
        });
    }

    @Override
    public String getCmnd() {
        return getPreferManager().getKeyValueByKeyName(AppConstants.KEY_CMND);
    }

    @Override
    public String getQuyen() {
        return getPreferManager().getKeyValueByKeyName(AppConstants.KEY_ROLE_USER);
    }

    @Override
    public String getUsername() {
        return getPreferManager().getKeyValueByKeyName(AppConstants.KEY_NAME_DISPLAY);
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
}
