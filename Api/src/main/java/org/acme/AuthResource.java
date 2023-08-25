package org.acme;

import io.quarkus.security.User;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.resource.spi.work.SecurityContext;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;


@Path("")
public class AuthResource {
    @POST
    @PermitAll
    @Path("/register")
    public Response register(User user){
        UserManager.addUser(null);
        return Response.ok(null).build();
    }

    @POST
    @RolesAllowed("user")
    @Path("/login")
    public String login(@Context SecurityContext securityContext){
        return UserManager.generateJWT(securityContext.getUserPrincipal().getName());

    }
}
