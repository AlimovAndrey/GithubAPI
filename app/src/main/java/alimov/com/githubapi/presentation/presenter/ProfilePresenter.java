package alimov.com.githubapi.presentation.presenter;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import alimov.com.githubapi.App;
import alimov.com.githubapi.api.callback.RepositoriesCallback;
import alimov.com.githubapi.data.MainRepository;
import alimov.com.githubapi.entity.Repository;
import alimov.com.githubapi.entity.User;
import alimov.com.githubapi.presentation.contract.ProfileContract;

/**
 * Created by Andrey on 21.12.2016.
 */

public class ProfilePresenter implements ProfileContract.Presenter {

    @NonNull
    private final ProfileContract.View mProfileView;

    @NonNull
    MainRepository mMainRepository;

    private User mUser;

    @Inject
    public ProfilePresenter(ProfileContract.View profileView) {
        mProfileView = profileView;
        mMainRepository = App.getmMainRepository();
    }

    @Override
    public void start() {

    }


    @Override
    public void loadUser(String name) {
        User user = mMainRepository.getUser(name);
        mUser = user;
        if (user != null) {
            mProfileView.fillUserContent(user);
        }
    }

    @Override
    public void openInBrowser() {
        mProfileView.openInBrowser(mUser.getmLogin());
    }

    @Override
    public void saveUser() {
        // already saved
        mProfileView.showToast();
    }

    @Override
    public void share() {
        mProfileView.openShare(mUser.getmLogin());
    }

    @Override
    public void loadUserRepositories(String login) {
        mMainRepository.getRepositories(login, new RepositoriesCallback() {
            @Override
            public void onGet(List<Repository> repositories) {
                mProfileView.fillUserRepositories(repositories);
            }

            @Override
            public void onError() {

            }
        });
    }
}
