package alimov.com.githubapi.di.module;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andrey on 21.12.2016.
 */

@Module
public class AppModule {

    private final Context mAppContext;


    public AppModule(@NonNull final Context appContext) {
        this.mAppContext = appContext;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return mAppContext;
    }
}
