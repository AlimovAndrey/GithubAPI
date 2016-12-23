package alimov.com.githubapi.api.callback;

import alimov.com.githubapi.entity.User;

/**
 * Created by Andrey on 22.12.2016.
 */

public interface SearchCallback {

    void onGet(User user);
    void onError();
}
