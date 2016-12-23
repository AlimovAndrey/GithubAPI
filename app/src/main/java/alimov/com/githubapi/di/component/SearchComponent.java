package alimov.com.githubapi.di.component;

import alimov.com.githubapi.di.module.SearchPresenterModule;
import alimov.com.githubapi.presentation.ui.activity.SearchActivity;
import dagger.Component;

/**
 * Created by Andrey on 21.12.2016.
 */

@Component(modules = SearchPresenterModule.class)
public interface SearchComponent {
    void inject(SearchActivity searchActivity);
}
