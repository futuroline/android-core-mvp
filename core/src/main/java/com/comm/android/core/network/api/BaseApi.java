package com.comm.android.core.network.api;

import com.comm.android.core.AppContext;
import com.comm.android.core.R;

/**
 * Created by kang on 16/12/9.
 */

public class BaseApi {
    public static String getHost() {
        return AppContext.getContext().getString(R.string.app_name);
    }


    public static BaseApi getInstance() {
        /*NetworkClient.ApiStores apiStores = NetworkClient.retrofit().create(AppClient.ApiStores.class);
        Observable<WeatherJson> observable = apiStores.getWeatherRxjava("101010100");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherJson>() {
                    @Override
                    public void onCompleted() {
                        Log.i("wxl", "onCompleted");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.i("wxl", "e=" + e.getMessage());
                    }
                    @Override
                    public void onNext(WeatherJson weatherJson) {
                        Log.i("wxl", "getWeatherinfo=" + weatherJson.getWeatherinfo().getCity());
                    }
                });
*/
        return null;
    }
}
