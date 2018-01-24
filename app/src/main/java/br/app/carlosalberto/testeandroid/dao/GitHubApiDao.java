package br.app.carlosalberto.testeandroid.dao;

import br.app.carlosalberto.testeandroid.model.GitHubApi;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.internal.IOException;

public class GitHubApiDao {

    public GitHubApi getSeriadosPorId(String Id) {
        Realm realm = Realm.getDefaultInstance();

        try {
            GitHubApi gitHubApi = realm.where(GitHubApi.class)
                    .beginsWith("id", Id).findFirst();

            // Check if the data is not null, if null there is no user with these Id
            if (gitHubApi == null) {
                return null;
            }

            return gitHubApi;

        } catch (Exception e) {
            // print the error
            e.printStackTrace();

        }

        return null;
    }

    public RealmResults<GitHubApi> getAll() {
        Realm realm = Realm.getDefaultInstance();
        try {
            RealmResults<GitHubApi> results = realm.where(GitHubApi.class)
                    .findAll();

            if (results == null || results.size() == 0) {
                return null;
            }

            return results;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public void salvaGitHubApi(GitHubApi gitHubApi) {
        saveOrUpdate(gitHubApi);
    }

    protected void saveOrUpdate(GitHubApi gitHubApi) {
        Realm realm = Realm.getDefaultInstance();
        try {
            //save ususario on realm
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(gitHubApi);
            realm.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delAll() {
        Realm realm = Realm.getDefaultInstance();

        try {
            realm.beginTransaction(); // open a transation
            realm.delete(GitHubApi.class); // delete the data
            realm.commitTransaction(); // close the transation

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

}