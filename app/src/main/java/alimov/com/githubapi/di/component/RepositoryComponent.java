package alimov.com.githubapi.di.component;

import javax.inject.Singleton;

import alimov.com.githubapi.data.MainRepository;
import alimov.com.githubapi.di.module.AppModule;
import dagger.Component;

/**
 * Created by Andrey on 22.12.2016.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface RepositoryComponent {

    MainRepository getRepository();
}
