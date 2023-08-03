package dev.glory.httpinterface.config;

import dev.glory.httpinterface.service.GithubUserClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientConfig {

    @Bean
    GithubUserClient githubUserClient() {
        WebClient client = WebClient.builder()
                .baseUrl("https://api.github.com")
                .build();

        return HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client))
                .build()
                .createClient(GithubUserClient.class);
    }

}
