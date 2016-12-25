package com.uiapp.doan.interactor.api.network;

import com.uiapp.doan.interactor.api.response.BaseResponse;
import com.uiapp.doan.utils.LogUtils;

import java.io.IOException;
import java.net.SocketTimeoutException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hongnhung on 10/27/16.
 */

public abstract class RestCallback<T extends BaseResponse> implements Callback<T> {
    private static final String TAG = LogUtils.makeLogTag(RestCallback.class);

    public abstract void success(T res);

    public abstract void failure(RestError error);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            T data = response.body();
            if (data.success) {
                LogUtils.logE(TAG, "Call back : " + data.code + "");
                success(data);
            } else {
                RestError error = new RestError(data.code, data.message);
                failure(error);
            }
        } else {
            RestError restError = null;
            if (response.errorBody().toString() != null) {
                restError = new RestError(response.code(), response.errorBody().toString());
            } else if (response.code() == 401) {
                restError = new RestError(RestError.API_ERROR_UNAUTHORIZED);
            } else if (response.code() == 404) {
                restError = new RestError(RestError.API_ERROR_NOT_FOUND);
            } else if (response.code() == 500) {
                restError = new RestError(RestError.API_ERROR_SERVER_ERROR);
            }
            failure(restError);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
        if (throwable != null && throwable.getMessage() != null)
            LogUtils.logE("TAG", throwable.getMessage());
        RestError restError;
        if (throwable instanceof IOException) {
            if (throwable instanceof SocketTimeoutException) {
                restError = new RestError(RestError.API_ERROR_TIMED_OUT);
            } else {
                restError = new RestError(RestError.API_ERROR_NO_NETWORK);
            }
        } else {
            restError = new RestError(RestError.API_ERROR_UNKNOWN);
        }
        failure(restError);
    }
}
