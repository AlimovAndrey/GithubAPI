package alimov.com.githubapi.di.component;

import alimov.com.githubapi.di.module.ProfilePresenterModule;
import alimov.com.githubapi.presentation.ui.activity.ProfileActivity;
import dagger.Component;

/**
 * Created by Andrey on 21.12.2016.
 */

@Component(modules = ProfilePresenterModule.class)
public interface ProfileComponent {
    void inject(ProfileActivity profileActivity);
}
