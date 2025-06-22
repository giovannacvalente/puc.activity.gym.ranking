package puc.activity.gym.ranking.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.client.OAuth2ClientHttpRequestInterceptor;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientOauthConfig {

    @Bean
    public RestClient keycloakRestClientOauth(RestClient.Builder builder,
                                              OAuth2AuthorizedClientManager authManager) {
        var interceptor = new OAuth2ClientHttpRequestInterceptor(authManager);
        interceptor.setClientRegistrationIdResolver(r -> "keycloak");
        return builder.requestInterceptor(interceptor).build();
    }

    @Bean
    public RestClient checkinRestClient(RestClient.Builder builder,
                                        OAuth2AuthorizedClientManager authManager,
                                        @Value("${checkin.api.base-url}") String baseUrl) {
        var interceptor = new OAuth2ClientHttpRequestInterceptor(authManager);
        interceptor.setClientRegistrationIdResolver(r -> "identity-admin-cc");
        return builder.baseUrl(baseUrl)
                .requestInterceptor(interceptor)
                .build();
    }
}

