package dev.glory.httpinterface.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GithubUser(String login, Long id, String url, String name, String email) {
}
