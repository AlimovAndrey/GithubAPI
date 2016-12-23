package alimov.com.githubapi.api;

import java.util.List;

import alimov.com.githubapi.entity.Repository;
import alimov.com.githubapi.entity.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Andrey on 22.12.2016.
 */

public interface ApiService {

    String BASE_URL = "https://api.github.com/";

    @GET("users/{name}")
    Call<User> getUser(@Path("name") String name);

    @GET("users/{name}/repos")
    Call<List<Repository>> getUsersRepo(@Path("name") String name);
}
