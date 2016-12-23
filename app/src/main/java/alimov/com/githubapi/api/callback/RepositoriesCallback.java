package alimov.com.githubapi.api.callback;

import java.util.List;

import alimov.com.githubapi.entity.Repository;

/**
 * Created by Andrey on 22.12.2016.
 */

public interface RepositoriesCallback {

    void onGet(List<Repository> repositories);
    void onError();
}
