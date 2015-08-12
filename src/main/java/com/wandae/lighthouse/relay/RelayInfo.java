package com.wandae.lighthouse.relay;

import java.net.MalformedURLException;
import java.net.URL;

import javax.inject.Singleton;

@Singleton
public class RelayInfo implements Relay {

    private URL url;

    @Override
    public URL getRelayUrl() {
        return url;
    }

    @Override
    public void setRelayUrl(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Problem on creating url from given String \"" + url + "\". Cause: ", e);
        }

    }

}
