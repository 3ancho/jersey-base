package com.dashuiwa.example;

import com.dashuiwa.server.ServerBase;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;

import java.io.IOException;

/**
 * Created by ruoranwang on 3/18/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ServerBase.runServer(new ExampleApp("com.dashuiwa.example.resource"));

    }

    public static class ExampleApp extends ResourceConfig {
        public ExampleApp(String... packagePath) {
            super(JacksonFeature.class, // Use Jackson to encode and decode JSON
                    GZipEncoder.class, EncodingFilter.class); // GZip requests and responses if the client so desires

            packages(packagePath);
        }

    }
}
