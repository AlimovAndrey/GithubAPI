package alimov.com.githubapi.presentation.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Inject;

import alimov.com.githubapi.App;
import alimov.com.githubapi.api.callback.SearchCallback;
import alimov.com.githubapi.data.MainRepository;
import alimov.com.githubapi.entity.User;
import alimov.com.githubapi.presentation.contract.SearchContract;

/**
 * Created by Andrey on 21.12.2016.
 */

public class SearchPresenter implements SearchContract.Presenter {

    @NonNull
    private final SearchContract.View mSearchView;

    @NonNull
    MainRepository mMainRepository;

    @Inject
    public SearchPresenter(@NonNull SearchContract.View searchView) {
        mSearchView = searchView;
        mMainRepository = App.getmMainRepository();
    }

    @Override
    public void onSearch(String name) {
        mSearchView.showDialog();

        mMainRepository.search(name, new SearchCallback() {
            @Override
            public void onGet(User user) {
                mSearchView.hideDialog();
                Log.d("1111", " user = " + user.toString());
                mSearchView.startProfile(user.getmName(), user.getmLogin());
            }

            @Override
            public void onError() {
                mSearchView.hideDialog();
                mSearchView.showError("");

            }
        });
    }

    @Override
    public void start() {

    }
}
