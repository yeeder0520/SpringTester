package com.example.demo.controller;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/20 下午 05:08
 **/
@Controller
@Slf4j
public class HelloGoogleAuth {
    private String secret; // 儲存的密鑰

    /**
     * 取得帶有Google Authenticator驗證器密鑰的qrcode
     *
     * @return 帶有Google Authenticator驗證氣密鑰的qrcode url
     */
    @GetMapping("/auth/qrcode")
    public RedirectView getSecretQrCode() {

        secret = genSecretKey(); // 產生並儲存密鑰
        log.info("secret = " + secret);


        String qrCodeData = createGoogleAuthenticatorKeyUri(secret);
        log.info(qrCodeData); // otpauth://totp/ABC:john@@abc.com?secret=CIIHTWBCP7AA6TXT&issuer=ABC

        String googleChartsQrCodeFormat = "https://www.google.com/chart?chs=200x200&cht=qr&chl=%s";
        String qrCodeUrl = String.format(googleChartsQrCodeFormat, qrCodeData);
        log.info(qrCodeUrl); // https://www.google.com/chart?chs=200x200&cht=qr&chl=otpauth://totp/ABC:john@@abc.com?secret=CIIHTWBCP7AA6TXT&issuer=ABC

        return new RedirectView(qrCodeUrl); // 重新導向到指定的url
    }

    /**
     * 產生密鑰字串
     *
     * @return 密鑰字串
     */
    private String genSecretKey() {
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        final GoogleAuthenticatorKey key = gAuth.createCredentials();
        return key.getKey();
    }

    /**
     * 建立Google Authenticator密鑰uri
     *
     * @param secret 密鑰字串
     * @return Google Authenticator密鑰uri
     */
    private String createGoogleAuthenticatorKeyUri(String secret) {
        String otpType = "totp";
        String account = "ABC:john@abc.com";
        String issuer = "ABC";
        String googleAuthenticatorKeyUriFormat = "otpauth://%s/%s?secret=%s&issuer=%s";
        return String.format(googleAuthenticatorKeyUriFormat, otpType, account, secret, issuer);
    }

    /**
     * Google Authenticator TOTP驗證
     *
     * @param code 一次性驗證碼
     * @return 驗證結果
     */
    @GetMapping("/auth/{code}")
    @ResponseBody
    public String googleAuthenticatorAuth(@PathVariable("code") int code) {
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        boolean isCodeValid = gAuth.authorize(secret, code); // 驗證
        return isCodeValid ? "pass" : "fail";
    }
}
