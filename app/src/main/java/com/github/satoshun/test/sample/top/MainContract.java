package com.github.satoshun.test.sample.top;

import android.support.annotation.NonNull;

import com.github.satoshun.test.sample.data.user.User;

public interface MainContract {

    interface View {
        void showUser(@NonNull User user);

        void showNoUser();

        void showLoadingIndicator();

        void hideLoadingIndicator();
    }

    interface Presenter {
        void start();
    }
}
