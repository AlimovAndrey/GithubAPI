package alimov.com.githubapi.data.dao;

import java.util.List;

import alimov.com.githubapi.entity.Repository;
import alimov.com.githubapi.entity.User;
import io.realm.Realm;

/**
 * Created by Andrey on 23.12.2016.
 */

public class UserDAO {

    public static void addUser(final User user) {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(user);
            }
        });
    }

    public static User getUser(final String name) {
        return Realm.getDefaultInstance().where(User.class).equalTo("mName", name).findFirst();
    }

    public static void addRepositoriesToUser(String login, final List<Repository> repositories) {
        final Realm realm = Realm.getDefaultInstance();

        final User user = realm.where(User.class).equalTo("mLogin", login).findFirst();
        if (user != null) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    user.setmRepositories(repositories);
                    realm.copyToRealm(user);
                }
            });
        }
    }
}
