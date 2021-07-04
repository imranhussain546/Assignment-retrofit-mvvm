package com.imran.assignmentquokkalab.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entry {
    @SerializedName("API")
    @Expose
    private String api;
    @SerializedName("Description")
    @Expose
    private String description;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

