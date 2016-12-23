package alimov.com.githubapi.presentation.contract;

import alimov.com.githubapi.presentation.presenter.BasePresenter;
import alimov.com.githubapi.presentation.ui.BaseView;

/**
 * Created by Andrey on 21.12.2016.
 */

public class SearchContract {

    public interface View extends BaseView<Presenter> {

        void startProfile(String name, String login);

        void showError(String url);

        void showDialog();

        void hideDialog();

    }

    public interface Presenter extends BasePresenter {

        void onSearch(String name);

    }

}
