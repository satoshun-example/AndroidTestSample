package com.github.satoshun.test.sample.data.user;

import android.support.annotation.NonNull;

public interface UserDataSource {
    interface Callback {
        void onUserLoaded(@NonNull User user);

        void onNotAvailable();
    }

    void getUser(@NonNull Callback callback);
}
