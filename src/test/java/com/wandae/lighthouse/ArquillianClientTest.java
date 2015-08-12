package com.wandae.lighthouse;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public abstract class ArquillianClientTest {

    
    @Deployment(testable = false)
    public static WebArchive deploy() {
        return ShrinkWrap.create(WebArchive.class, "test.war").addAsResource("META-INF/beans.xml")
                         .addPackages(true, "com.wandae.lighthouse");
    }

    @ArquillianResource
    protected URL base;
}
