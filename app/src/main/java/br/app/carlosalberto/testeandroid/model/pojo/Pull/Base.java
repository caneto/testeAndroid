
package br.app.carlosalberto.testeandroid.model.pojo.Pull;

import java.util.HashMap;
import java.util.Map;

public class Base {

    private String label;
    private String ref;
    private String sha;
    private User__ user;
    private Repo_ repo;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public User__ getUser() {
        return user;
    }

    public void setUser(User__ user) {
        this.user = user;
    }

    public Repo_ getRepo() {
        return repo;
    }

    public void setRepo(Repo_ repo) {
        this.repo = repo;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
