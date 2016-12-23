package alimov.com.githubapi.presentation.contract;

import java.util.List;

import alimov.com.githubapi.entity.Repository;
import alimov.com.githubapi.entity.User;
import alimov.com.githubapi.presentation.presenter.BasePresenter;
import alimov.com.githubapi.presentation.ui.BaseView;

/**
 * Created by Andrey on 21.12.2016.
 */

public class ProfileContract {

    public interface View extends BaseView<Presenter> {

        void showToast();

        void openShare(String url);

        void openInBrowser(String login);

        void fillUserContent(User user);

        void fillUserRepositories(List<Repository> repositories);
    }

    public interface Presenter extends BasePresenter {

        void loadUser(String name);

        void openInBrowser();

        void saveUser();

        void share();

        void loadUserRepositories(String login);
    }

}

