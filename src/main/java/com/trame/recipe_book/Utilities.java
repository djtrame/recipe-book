package com.trame.recipe_book;

//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;

public final class Utilities
{
    private Utilities() {

    }

    //note that in order to use the Spring Security we need artifact spring-boot-starter-security in the POM file
    //however, adding this causes security to be enabled for the app and all requests start to get a 401 unauthorized
    //and if you go to http://localhost:8080 it asks you to Login
//    public static String getCurrentUsername(@AuthenticationPrincipal UserDetails userDetails) {
//        return null;
//    }
}
