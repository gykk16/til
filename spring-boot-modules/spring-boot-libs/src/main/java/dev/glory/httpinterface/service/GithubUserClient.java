package dev.glory.httpinterface.service;

import dev.glory.httpinterface.model.GithubUser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;
import java.util.Optional;

public interface GithubUserClient {

    @GetExchange("/users")
    List<GithubUser> findAll();

    @GetExchange("/users/{loginId}")
    Optional<GithubUser> findByLoginId(@PathVariable String loginId);


}
