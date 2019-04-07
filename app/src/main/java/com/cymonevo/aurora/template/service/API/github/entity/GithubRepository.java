package com.cymonevo.aurora.template.service.API.github.entity;

import com.google.gson.annotations.SerializedName;

public class GithubRepository {
    @SerializedName("name")
    public String name;
    @SerializedName("private")
    public boolean isPrivate;
    @SerializedName("description")
    public String description;
    @SerializedName("html_url")
    public String url;
}
