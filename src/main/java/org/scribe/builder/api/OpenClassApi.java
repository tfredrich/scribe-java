package org.scribe.builder.api;

import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.JsonTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.model.OAuthConstants;
import org.scribe.model.Verb;

public class OpenClassApi
    extends DefaultApi20
{
    private static final String AUTHORIZATION_URL =
        "http://localhost:9003/oauth2/auth?client_id=%s&redirect_uri=%s&scope=%s&response_type=code";

    @Override
    public String getAuthorizationUrl( OAuthConfig config )
    {
        return String.format( AUTHORIZATION_URL, config.getApiKey(), config.getCallback(), config.getScope() );
    }

    @Override
    public String getAccessTokenEndpoint()
    {
        return "http://localhost:9003/oauth2/token";
    }

    @Override
    public Verb getAccessTokenVerb()
    {
        return Verb.POST;
    }

    @Override
    public AccessTokenExtractor getAccessTokenExtractor()
    {
        return new JsonTokenExtractor();
    }

    @Override
    public String getTokenParameterName()
    {
        return OAuthConstants.TOKEN;
    }
}
