package it.unibo.soseng.jerseysa;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 * 
 * Example adapted from the jersey-quickstart-grizzly2 Maven archetype
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:7070/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in it.unibo.soseng.rssa.sarecipe package
        final ResourceConfig rc = new ResourceConfig().packages("it.unibo.soseng.jerseysa");
        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final HttpServer server = startServer();
        System.out.println("Jersey app started with endpoints available at "+BASE_URI);
        Runtime.getRuntime().addShutdownHook(new Thread() {
        	public void run() {
        		server.shutdownNow();
        	}
        });
        Thread.currentThread().join();
    }
}
