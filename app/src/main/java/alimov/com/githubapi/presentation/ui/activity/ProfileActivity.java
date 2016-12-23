package alimov.com.githubapi.presentation.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import alimov.com.githubapi.R;
import alimov.com.githubapi.di.component.DaggerProfileComponent;
import alimov.com.githubapi.di.component.ProfileComponent;
import alimov.com.githubapi.di.module.ProfilePresenterModule;
import alimov.com.githubapi.presentation.presenter.ProfilePresenter;
import alimov.com.githubapi.presentation.ui.fragment.ProfileFragment;
import alimov.com.githubapi.util.ActivityUtils;

public class ProfileActivity extends AppCompatActivity {

    public final static String KEY_NAME = "name";
    public final static String KEY_LOGIN = "login";

    @Inject
    ProfilePresenter mProfilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ProfileFragment profileFragment =
                (ProfileFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (profileFragment == null) {
            profileFragment = ProfileFragment.newInstance();

        }

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                profileFragment, R.id.contentFrame);

        ProfileComponent searchComponent = DaggerProfileComponent.builder()
                .profilePresenterModule(new ProfilePresenterModule(profileFragment))
                .build();
        searchComponent.inject(this);
        profileFragment.setPresenter(mProfilePresenter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.item_open_in_browser:
                mProfilePresenter.openInBrowser();
                return true;
            case R.id.item_save:
                mProfilePresenter.saveUser();
                return true;
            case R.id.item_share:
                mProfilePresenter.share();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
