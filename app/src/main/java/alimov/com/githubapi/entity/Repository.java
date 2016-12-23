package alimov.com.githubapi.entity;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Andrey on 22.12.2016.
 */

public class Repository extends RealmObject{

    @PrimaryKey
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("language")
    private String mLanguage;
    @SerializedName("stargazers_count")
    private String mCountStars;
    @SerializedName("forks_count")
    private String mCountForks;

    public Repository(String mId, String mCountForks, String mCountStars, String mLanguage, String mName) {
        this.mId = mId;
        this.mCountForks = mCountForks;
        this.mCountStars = mCountStars;
        this.mLanguage = mLanguage;
        this.mName = mName;
    }

    public Repository() {
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmCountForks() {
        return mCountForks;
    }

    public void setmCountForks(String mCountForks) {
        this.mCountForks = mCountForks;
    }

    public String getmCountStars() {
        return mCountStars;
    }

    public void setmCountStars(String mCountStars) {
        this.mCountStars = mCountStars;
    }

    public String getmLanguage() {
        return mLanguage;
    }

    public void setmLanguage(String mLanguage) {
        this.mLanguage = mLanguage;
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

        Repository that = (Repository) o;

        if (mId != null ? !mId.equals(that.mId) : that.mId != null) return false;
        if (mName != null ? !mName.equals(that.mName) : that.mName != null) return false;
        if (mLanguage != null ? !mLanguage.equals(that.mLanguage) : that.mLanguage != null)
            return false;
        if (mCountStars != null ? !mCountStars.equals(that.mCountStars) : that.mCountStars != null)
            return false;
        return mCountForks != null ? mCountForks.equals(that.mCountForks) : that.mCountForks == null;

    }

    @Override
    public int hashCode() {
        int result = mId != null ? mId.hashCode() : 0;
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (mLanguage != null ? mLanguage.hashCode() : 0);
        result = 31 * result + (mCountStars != null ? mCountStars.hashCode() : 0);
        result = 31 * result + (mCountForks != null ? mCountForks.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "mId='" + mId + '\'' +
                ", mName='" + mName + '\'' +
                ", mLanguage='" + mLanguage + '\'' +
                ", mCountStars='" + mCountStars + '\'' +
                ", mCountForks='" + mCountForks + '\'' +
                '}';
    }
}
