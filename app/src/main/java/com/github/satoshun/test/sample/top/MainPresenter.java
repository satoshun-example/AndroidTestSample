package com.github.satoshun.test.sample.top;

import android.support.annotation.NonNull;

import com.github.satoshun.test.sample.data.user.User;
import com.github.satoshun.test.sample.data.user.UserDataSource;

public class MainPresenter implements MainContract.Presenter {

    @NonNull
    private final UserDataSource dataSource;

    @NonNull
    private final MainContract.View view;

    public MainPresenter(@NonNull UserDataSource dataSource, @NonNull MainContract.View view) {
        this.dataSource = dataSource;
        this.view = view;
    }

    @Override
    public void start() {
        view.showLoadingIndicator();

        dataSource.getUser(new UserDataSource.Callback() {
            @Override
            public void onUserLoaded(@NonNull User user) {
                view.hideLoadingIndicator();
                view.showUser(user);
            }

            @Override
            public void onNotAvailable() {
                view.hideLoadingIndicator();
                view.showNoUser();
            }
        });
    }
}
