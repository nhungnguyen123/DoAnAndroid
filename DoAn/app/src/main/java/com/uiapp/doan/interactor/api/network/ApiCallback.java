package com.uiapp.doan.interactor.api.network;

import com.uiapp.doan.interactor.api.response.BaseResponse;

import okhttp3.ResponseBody;

/**
 * Created by hongnhung on 10/27/16.
 */

public abstract class ApiCallback<T extends BaseResponse> {
    public abstract void success(T res);
    public abstract void failure(RestError error);
}
