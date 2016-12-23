package alimov.com.githubapi.data;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import alimov.com.githubapi.api.ApiServiceImp;
import alimov.com.githubapi.api.callback.RepositoriesCallback;
import alimov.com.githubapi.api.callback.SearchCallback;
import alimov.com.githubapi.data.dao.UserDAO;
import alimov.com.githubapi.entity.Repository;
import alimov.com.githubapi.entity.User;

/**
 * Created by Andrey on 22.12.2016.
 */

@Singleton
public class MainRepository {

    @Inject
    public MainRepository() {
    }

    public void search(String name, final SearchCallback callback) {
        ApiServiceImp.getInstance().getUser(name, new SearchCallback() {
            @Override
            public void onGet(User user) {
                UserDAO.addUser(user);
                callback.onGet(user);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });

    }

    public void getRepositories(final String login, @NonNull final RepositoriesCallback callback) {
        ApiServiceImp.getInstance().getRepositories(login, new RepositoriesCallback() {
            @Override
            public void onGet(List<Repository> repositories) {
                UserDAO.addRepositoriesToUser(login, repositories);
                callback.onGet(repositories);
            }

            @Override
            public void onError() {

            }
        });
    }


    public User getUser(String name) {
        if (UserDAO.getUser(name) != null) {
            return UserDAO.getUser(name);
        } else {
            // load from server again
        }
        return null;
    }
}
