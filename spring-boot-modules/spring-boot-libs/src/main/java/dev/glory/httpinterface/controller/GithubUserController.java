package dev.glory.httpinterface.controller;

import dev.glory.httpinterface.model.GithubUser;
import dev.glory.httpinterface.service.GithubUserClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/github-users")
@RequiredArgsConstructor
@Slf4j
public class GithubUserController {

    private final GithubUserClient githubUserClient;

    @GetMapping
    public List<GithubUser> findAll() {
        log.debug("==> githubUserClient = {}", githubUserClient);
        return githubUserClient.findAll();
    }

    @GetMapping("/{loginId}")
    public GithubUser findByLoginId(@PathVariable String loginId) {
        return githubUserClient.findByLoginId(loginId).orElseThrow();
    }

}
