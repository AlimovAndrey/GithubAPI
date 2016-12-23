package alimov.com.githubapi.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Andrey on 23.12.2016.
 */

public class User extends RealmObject {

    @PrimaryKey
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("avatar_url")
    private String mAvatarUrl;
    @SerializedName("company")
    private String mCompany;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("login")
    private String mLogin;
    @SerializedName("followers")
    private String mFollowers;
    @SerializedName("following")
    private String mFollowing;
    @SerializedName("public_gists")
    private int mGists;
    @SerializedName("public_repos")
    private int mRepos;
    private RealmList<Repository> mRepositories;


    public User(String mId, int mRepos, int mGists, String mFollowing,
                String mFollowers, String mLogin, String mEmail,
                String mCompany, String mAvatarUrl, String mName) {
        this.mId = mId;
        this.mRepos = mRepos;
        this.mGists = mGists;
        this.mFollowing = mFollowing;
        this.mFollowers = mFollowers;
        this.mLogin = mLogin;
        this.mEmail = mEmail;
        this.mCompany = mCompany;
        this.mAvatarUrl = mAvatarUrl;
        this.mName = mName;
    }

    public User() {
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public int getmRepos() {
        return mRepos;
    }



    public void setmRepos(int mRepos) {
        this.mRepos = mRepos;
    }

    public int getmGists() {
        return mGists;
    }

    public void setmGists(int mGists) {
        this.mGists = mGists;
    }

    public String getmFollowing() {
        return mFollowing;
    }

    public void setmFollowing(String mFollowing) {
        this.mFollowing = mFollowing;
    }

    public String getmFollowers() {
        return mFollowers;
    }

    public void setmFollowers(String mFollowers) {
        this.mFollowers = mFollowers;
    }

    public String getmLogin() {
        return mLogin;
    }

    public void setmLogin(String mLogin) {
        this.mLogin = mLogin;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmAvatarUrl() {
        return mAvatarUrl;
    }

    public void setmAvatarUrl(String mAvatarUrl) {
        this.mAvatarUrl = mAvatarUrl;
    }

    public String getmCompany() {
        return mCompany;
    }

    public void setmCompany(String mCompany) {
        this.mCompany = mCompany;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (mId != null ? !mId.equals(user.mId) : user.mId != null) return false;
        return mName != null ? mName.equals(user.mName) : user.mName == null;

    }

    @Override
    public int hashCode() {
        int result = mId != null ? mId.hashCode() : 0;
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (mAvatarUrl != null ? mAvatarUrl.hashCode() : 0);
        result = 31 * result + (mCompany != null ? mCompany.hashCode() : 0);
        result = 31 * result + (mEmail != null ? mEmail.hashCode() : 0);
        result = 31 * result + (mLogin != null ? mLogin.hashCode() : 0);
        result = 31 * result + (mFollowers != null ? mFollowers.hashCode() : 0);
        result = 31 * result + (mFollowing != null ? mFollowing.hashCode() : 0);
        result = 31 * result + mGists;
        result = 31 * result + mRepos;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "mId='" + mId + '\'' +
                ", mName='" + mName + '\'' +
                ", mAvatarUrl='" + mAvatarUrl + '\'' +
                ", mCompany='" + mCompany + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mLogin='" + mLogin + '\'' +
                ", mFollowers='" + mFollowers + '\'' +
                ", mFollowing='" + mFollowing + '\'' +
                ", mGists=" + mGists +
                ", mRepos=" + mRepos +
                '}';
    }

    public List<Repository> getmRepositories() {
        List<Repository> repositories = new ArrayList<>();
        for (Repository rep : mRepositories) {
            repositories.add(rep);
        }
        return repositories;
    }

    public void setmRepositories(List<Repository> repositories) {
        mRepositories.clear();
        for (Repository rep : repositories) {
            mRepositories.add(rep);
        }

    }
}
