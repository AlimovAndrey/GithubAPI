package alimov.com.githubapi.di.module;

import alimov.com.githubapi.presentation.contract.ProfileContract;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Andrey on 21.12.2016.
 */

@Module
public class ProfilePresenterModule {

    private final ProfileContract.View mView;

    public ProfilePresenterModule(ProfileContract.View view) {
        mView = view;
    }

    @Provides
    ProfileContract.View provideSearchContractView() {
        return mView;
    }

}
