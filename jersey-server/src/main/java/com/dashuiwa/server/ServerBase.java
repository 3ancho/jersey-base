package com.dashuiwa.server;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created by ruoranwang on 3/18/15.
 */
public class ServerBase {

    /**
     * @return a httpServer instance that can run right away
     */
    public static void runServer(ResourceConfig appResourceConfig) {
        URI uri = UriBuilder.fromUri("http://" + "127.0.0.1").port(8081).build();
        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, appResourceConfig, false);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Stopping server");
                server.shutdownNow();
            }
        }, "shutdownHook"));

        // run
        try {
            server.start();
            System.out.println("Press CTRL^C to exit..");
            Thread.currentThread().join();
        } catch (Exception e) {
            System.out.println("There was an error while starting Grizzly HTTP server.");
        }
    }
}
