package com.example.demo;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;
import org.junit.jupiter.api.Test;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/21 上午 10:07
 **/
public class TestGoogle {

    @Test
    void testGoogle(){
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        GoogleAuthenticatorKey john = gAuth.createCredentials();
        String otpAuthTotpURL = GoogleAuthenticatorQRGenerator.getOtpAuthURL("justin", "justin_account", john);
        System.out.println("otpAuthTotpURL = " + otpAuthTotpURL);
    }
}
