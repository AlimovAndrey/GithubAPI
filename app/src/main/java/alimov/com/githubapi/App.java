package alimov.com.githubapi;

import android.app.Application;

import alimov.com.githubapi.data.MainRepository;
import alimov.com.githubapi.di.component.DaggerRepositoryComponent;
import alimov.com.githubapi.di.module.AppModule;
import io.realm.Realm;

/**
 * Created by Andrey on 21.12.2016.
 */

public class App extends Application {

    private static MainRepository mMainRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());
        
        mMainRepository = DaggerRepositoryComponent.builder()
                .appModule(new AppModule((getApplicationContext())))
                .build().getRepository();

    }

    public static MainRepository getmMainRepository() {
        return mMainRepository;
    }

}
