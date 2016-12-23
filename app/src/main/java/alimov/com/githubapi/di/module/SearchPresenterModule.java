package alimov.com.githubapi.di.module;

import alimov.com.githubapi.presentation.contract.SearchContract;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Andrey on 21.12.2016.
 */

@Module
public class SearchPresenterModule {

    private final SearchContract.View mView;

    public SearchPresenterModule(SearchContract.View view) {
        mView = view;
    }

    @Provides
    SearchContract.View provideSearchContractView() {
        return mView;
    }

}
