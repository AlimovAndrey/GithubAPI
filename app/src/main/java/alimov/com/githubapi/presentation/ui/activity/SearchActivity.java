package alimov.com.githubapi.presentation.ui.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import alimov.com.githubapi.R;
import alimov.com.githubapi.di.component.DaggerSearchComponent;
import alimov.com.githubapi.di.component.SearchComponent;
import alimov.com.githubapi.di.module.SearchPresenterModule;
import alimov.com.githubapi.presentation.presenter.SearchPresenter;
import alimov.com.githubapi.presentation.ui.fragment.SearchFragment;
import alimov.com.githubapi.util.ActivityUtils;


public class SearchActivity extends AppCompatActivity {

    @Inject
    SearchPresenter mSearchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().setIcon(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));

        SearchFragment searchFragment =
                (SearchFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (searchFragment == null) {
            searchFragment = SearchFragment.newInstance();
        }

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                searchFragment, R.id.contentFrame);

        SearchComponent component = DaggerSearchComponent.builder()
                .searchPresenterModule(new SearchPresenterModule(searchFragment))
                .build();
        component.inject(this);
        searchFragment.setPresenter(mSearchPresenter);

    }
}
