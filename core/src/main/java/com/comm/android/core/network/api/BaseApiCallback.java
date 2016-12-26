package com.comm.android.core.network.api;

import com.comm.android.core.AppContext;
import com.comm.android.core.R;

/**
 * Created by kang on 16/12/26.
 */

public abstract class BaseApiCallback<T> implements ApiCallback<T> {

    public static String getHost() {
        return AppContext.getContext().getString(R.string.app_name);
    }

    @Override
    public void onApiStarted() {

    }

    @Override
    public void onFailure(int code, String msg) {

    }

    @Override
    public void onThrowable(Throwable t) {

    }

    @Override
    public void onFinish() {

    }
}
