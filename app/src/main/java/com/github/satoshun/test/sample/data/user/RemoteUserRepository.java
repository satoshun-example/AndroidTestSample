package com.github.satoshun.test.sample.data.user;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

public class RemoteUserRepository implements UserDataSource {

    @Override
    public void getUser(@NonNull Callback callback) {
        Handler handler = new Handler(Looper.getMainLooper());
        // simulates network access
        handler.postDelayed(() -> {
            callback.onUserLoaded(new User("hoge", "fuga"));
        }, 3_000);
    }
}
