package com.wandae.lighthouse.relay;

import java.net.URL;

public interface Relay {
    /**
     * 
     * @return relays endpoint urls to be used by clients
     */
    URL getRelayUrl();
    
    /**
     * 
     * @param url url of relay endpoint as string
     */
    void setRelayUrl(String url);
}
