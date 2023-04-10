package tn.enig.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AccessLevel {
    @JsonProperty("Guest")
    GUEST,
    @JsonProperty("Reporter")
    REPORTER,
    @JsonProperty("Developer")
    DEVELOPER,
    @JsonProperty("Maintainer")
    MAINTAINER,
    @JsonProperty("Owner")
    OWNER
}
