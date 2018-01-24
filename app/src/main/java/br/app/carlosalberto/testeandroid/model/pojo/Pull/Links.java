
package br.app.carlosalberto.testeandroid.model.pojo.Pull;

import java.util.HashMap;
import java.util.Map;

public class Links {

    private Self self;
    private Html html;
    private Issue issue;
    private Comments comments;
    private ReviewComments reviewComments;
    private ReviewComment reviewComment;
    private Commits commits;
    private Statuses statuses;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public Html getHtml() {
        return html;
    }

    public void setHtml(Html html) {
        this.html = html;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public ReviewComments getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(ReviewComments reviewComments) {
        this.reviewComments = reviewComments;
    }

    public ReviewComment getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(ReviewComment reviewComment) {
        this.reviewComment = reviewComment;
    }

    public Commits getCommits() {
        return commits;
    }

    public void setCommits(Commits commits) {
        this.commits = commits;
    }

    public Statuses getStatuses() {
        return statuses;
    }

    public void setStatuses(Statuses statuses) {
        this.statuses = statuses;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
