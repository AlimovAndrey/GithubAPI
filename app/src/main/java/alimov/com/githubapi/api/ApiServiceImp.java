package alimov.com.githubapi.api;

import android.support.annotation.NonNull;

import java.util.List;

import alimov.com.githubapi.api.callback.RepositoriesCallback;
import alimov.com.githubapi.api.callback.SearchCallback;
import alimov.com.githubapi.entity.Repository;
import alimov.com.githubapi.entity.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andrey on 22.12.2016.
 */

public class ApiServiceImp {

    private static ApiService sApiService;
    private static ApiServiceImp sInstance = null;

    private ApiServiceImp() {
    }

    public static ApiServiceImp getInstance() {
        if (sInstance == null) {
            sInstance = new ApiServiceImp();
            sApiService = ServiceGenerator.createService(ApiService.class, ApiService.BASE_URL);
        }
        return sInstance;
    }

    public void getUser(final String name, @NonNull final SearchCallback callback) {

        Call<User> call = sApiService.getUser(name);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onGet(response.body());
                    }
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public void getRepositories(final String name, @NonNull final RepositoriesCallback callback) {

        Call<List<Repository>> call = sApiService.getUsersRepo(name);

        call.enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onGet(response.body());
                    }
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                callback.onError();
            }
        });
    }
}
