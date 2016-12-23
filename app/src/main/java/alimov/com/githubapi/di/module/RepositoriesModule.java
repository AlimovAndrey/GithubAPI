package alimov.com.githubapi.di.module;

import javax.inject.Singleton;

import alimov.com.githubapi.data.MainRepository;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Andrey on 22.12.2016.
 */

@Module
public class RepositoriesModule {

    private final MainRepository mMainRepository;

    public RepositoriesModule(MainRepository mainRepository) {
        mMainRepository = mainRepository;
    }

    @Provides
    @Singleton
    MainRepository provideSearchRepository() {

        return mMainRepository;

    }
}
