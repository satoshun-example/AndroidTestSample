package com.github.satoshun.test.sample.top;

import com.github.satoshun.test.sample.data.user.User;
import com.github.satoshun.test.sample.data.user.UserDataSource;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MainPresenterTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private UserDataSource dataSource;

    @Mock
    private MainContract.View view;

    @Captor
    private ArgumentCaptor<UserDataSource.Callback> callbackCaptor;

    @Test
    public void showUser_successNetworkAccess() throws Exception {
        MainPresenter presenter = new MainPresenter(dataSource, view);
        User dummyUser = new User("dummy", "dummy");

        presenter.start();

        verify(dataSource).getUser(callbackCaptor.capture());
        callbackCaptor.getValue().onUserLoaded(dummyUser);

        verify(view, times(1)).showUser(dummyUser);
    }

    @Test
    public void showNoUser_failureNetworkAccess() throws Exception {
        MainPresenter presenter = new MainPresenter(dataSource, view);

        presenter.start();

        verify(dataSource).getUser(callbackCaptor.capture());
        callbackCaptor.getValue().onNotAvailable();

        verify(view, times(1)).showNoUser();
    }
}