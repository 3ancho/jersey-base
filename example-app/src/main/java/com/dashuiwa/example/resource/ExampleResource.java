package com.dashuiwa.example.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by ruoranwang on 3/18/15.
 */
@Path("/")
public class ExampleResource {

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    @GET
    public Response testEndpoint() {
        return Response.ok("Server running!").build();
    }

    @Path("json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person testJsonEndpoint() {
        return new Person("Sancho", 76);
    }

}
