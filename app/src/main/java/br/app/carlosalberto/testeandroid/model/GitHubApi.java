package br.app.carlosalberto.testeandroid.model;

import android.support.annotation.NonNull;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class GitHubApi extends RealmObject {

    @PrimaryKey
    @NonNull
    private int id;
    private String name;
    private String fullname;
    private String description;
    private String forks;
    private String stargazerscount;
    private String avatarurl;
    private String pullurl;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getForks() {
        return forks;
    }

    public void setForks(String forks) {
        this.forks = forks;
    }

    public String getStargazerscount() {
        return stargazerscount;
    }

    public void setStargazerscount(String stargazerscount) {
        this.stargazerscount = stargazerscount;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getPullurl() {
        return pullurl;
    }

    public void setPullurl(String pullurl) {
        this.pullurl = pullurl;
    }


}
