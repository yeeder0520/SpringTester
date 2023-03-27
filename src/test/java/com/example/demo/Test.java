package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

import javax.net.ssl.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)  //使用DEFINED_PORT才會帶我自己設定的port
@Slf4j
class Test {

    @org.junit.jupiter.api.Test
    void test123() {

        String url = "http://localhost:9997/?key=MIIB%2FjCCAWcCAQAwgZ8xGDAWBgNVBAMMDzEyNzYzOTI1LTAyLTAwMDEMMAoGA1UE%0ACwwDVFNUMRwwGgYDVQQLDBM5NzE2MjY0MC1SQS1JTkZPMTY4MTQwMgYDVQQLDCtD%0AaHVuZ2h3YSBUZWxlY29tIEluZm9ybWF0aW9uIFRlc3QgUHVibGljIENBMRQwEgYD%0AVQQKDAtJbmZvcm1hdGlvbjELMAkGA1UEBhMCVFcwgZ8wDQYJKoZIhvcNAQEBBQAD%0AgY0AMIGJAoGBAKytz%2FXdQVaK%2FOVdNNhD4NKGcaPt4f34WlqAmWNv5W9kc2XFK417%0AnlTjNZOPQ1Nx8Nyu8ycG%2F5hjgfZct3kMpqhdIg0rR%2BX4WLf3pwV6khfSBak2%2FtZa%0ASEMT4vheeEvrt9RD1MzeokLMtARi%2FLO5MA2Bv89nq7j65KbuBGTlYOipAgMBAAGg%0AHjAcBgkqhkiG9w0BCQ4xDzANMAsGA1UdDwQEAwIHgDANBgkqhkiG9w0BAQUFAAOB%0AgQBAPgGLJj2B%2FoIowhTkafCHKsDccg2Q5FOqynxPMU%2Fc53LNDMjrHrY4ASelRLRy%0AS%2FMsLoRcLxFb8adqiotfbFE8cEXlIKwsm%2F3g7qwT4z3jqvu%2FWVxMK%2Bm4Qhf7RJZD%0ApBj%2BFodK8Rct9vpFpmeSph95FHC4ljJLABMPWzImRWmYEg%3D%3D%0A&dn_cn=12763925-02-000&dn_ou2=97162640-RA-INFO168&dn_ou3=TST&email=%40%40&ra_code=97162640-RA-INFO168&apply_id=20210000065803&browser=EXPLORER&req_type=newrequest&cert_type=101&cert_period=101&post_it=Chunghwa+Telecom+Information+Test+Public+CA&signdata=MIIKfgYJKoZIhvcNAQcCoIIKbzCCCmsCAQExCzAJBgUrDgMCGgUAMIIDZwYJKoZI%0AhvcNAQcBoIIDWASCA1R8TUlJQi9qQ0NBV2NDQVFBd2daOHhHREFXQmdOVkJBTU1E%0AekV5TnpZek9USTFMVEF5TFRBd01ERU1NQW9HQTFVRQpDd3dEVkZOVU1Sd3dHZ1lE%0AVlFRTERCTTVOekUyTWpZME1DMVNRUzFKVGtaUE1UWTRNVFF3TWdZRFZRUUxEQ3RE%0ACmFIVnVaMmgzWVNCVVpXeGxZMjl0SUVsdVptOXliV0YwYVc5dUlGUmxjM1FnVUhW%0AaWJHbGpJRU5CTVJRd0VnWUQKVlFRS0RBdEpibVp2Y20xaGRHbHZiakVMTUFrR0Ex%0AVUVCaE1DVkZjd2daOHdEUVlKS29aSWh2Y05BUUVCQlFBRApnWTBBTUlHSkFvR0JB%0AS3l0ei9YZFFWYUsvT1ZkTk5oRDROS0djYVB0NGYzNFdscUFtV052NVc5a2MyWEZL%0ANDE3Cm5sVGpOWk9QUTFOeDhOeXU4eWNHLzVoamdmWmN0M2tNcHFoZElnMHJSK1g0%0AV0xmM3B3VjZraGZTQmFrMi90WmEKU0VNVDR2aGVlRXZydDlSRDFNemVva0xNdEFS%0AaS9MTzVNQTJCdjg5bnE3ajY1S2J1QkdUbFlPaXBBZ01CQUFHZwpIakFjQmdrcWhr%0AaUc5dzBCQ1E0eER6QU5NQXNHQTFVZER3UUVBd0lIZ0RBTkJna3Foa2lHOXcwQkFR%0AVUZBQU9CCmdRQkFQZ0dMSmoyQi9vSW93aFRrYWZDSEtzRGNjZzJRNUZPcXlueFBN%0AVS9jNTNMTkRNanJIclk0QVNlbFJMUnkKUy9Nc0xvUmNMeEZiOGFkcWlvdGZiRkU4%0AY0VYbElLd3NtLzNnN3F3VDR6M2pxdnUvV1Z4TUsrbTRRaGY3UkpaRApwQmorRm9k%0ASzhSY3Q5dnBGcG1lU3BoOTVGSEM0bGpKTEFCTVBXekltUldtWUVnPT0KfDEyNzYz%0AOTI1LTAyLTAwMHw5NzE2MjY0MC1SQS1JTkZPMTY4fFRTVHxAQHw5NzE2MjY0MC1S%0AQS1JTkZPMTY4fDIwMjEwMDAwMDY1ODAzfEVYUExPUkVSfG5ld3JlcXVlc3R8MTAx%0AfDEwMXxDaHVuZ2h3YSBUZWxlY29tIEluZm9ybWF0aW9uIFRlc3QgUHVibGljIENB%0AfHygggU9MIIFOTCCBCGgAwIBAgIQGgzAeIcALXehYKb5FjZJsjANBgkqhkiG9w0B%0AAQsFADBvMQswCQYDVQQGEwJUVzEjMCEGA1UECgwaQ2h1bmdod2EgVGVsZWNvbSBD%0Aby4sIEx0ZC4xOzA5BgNVBAsMMihGb3IgVGVzdCBPbmx5KVB1YmxpYyBDZXJ0aWZp%0AY2F0aW9uIEF1dGhvcml0eSAtIEcyMB4XDTIxMTEwODA4MjI0NFoXDTI2MTEwODA4%0AMjI0NFowajELMAkGA1UEBhMCVFcxKDAmBgNVBAoMH0NodW5naHdhIFRlbGVjb20g%0AVGVzdCBQdWJsaWMgQ0ExEzARBgNVBAsMClNlcnZlckNlcnQxHDAaBgNVBAMMEzk3%0AMTYyNjQwLVJBLUlORk8xNjgwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIB%0AAQDVNog0IkTjQBIFHmRyxCKAxGDiVicqS%2Br1C%2FmqvZvtSgAnJCamdwIvJzAevVkE%0AQURatnVoVDTYbusv94eM3JCkwuPTRkU82Ep9IPLpGP%2F2UEKXCz%2B%2BMBUNSdf8Hgai%0ALfpGTFE2ugryoNBh72X%2BSFKl0YGOjhby69BnxnUC0VjflGP3F5z9szKLqLRvoO77%0Ah7JKZHn1Y26JdcNfmTtVOTc8pEyBHSHAzRtV5glfiPyxAf4fQ1kdp10OmXXj5Bnd%0Az%2FD%2FTz%2BlaCg7Io4lIlXiLO7T8T8ZnvfKvnh5GPxhTLL1RVTm7S5tMI9QcLBpPRs8%0ACE3qfDnYDkGMFsutGOl7owbrAgMBAAGjggHUMIIB0DAfBgNVHSMEGDAWgBTIdkBn%0A9r5J%2BGoOOS%2BIuFsTGHTM%2FDAdBgNVHQ4EFgQUu9wCn6WGSPToTC7cM8Yn%2Ftsx5uIw%0AgaQGA1UdHwSBnDCBmTBOoEygSoZIaHR0cDovL3JlcG9zaXRvcnkudGVzdHB1Ymxp%0AY2NhLmhpbmV0Lm5ldC9jcmwvUHViQ0FHMi8xOTAxLTEvY29tcGxldGUuY3JsMEeg%0ARaBDhkFodHRwOi8vcmVwb3NpdG9yeS50ZXN0cHVibGljY2EuaGluZXQubmV0L2Ny%0AbC9QdWJDQUcyL2NvbXBsZXRlLmNybDCBmwYIKwYBBQUHAQEEgY4wgYswTQYIKwYB%0ABQUHMAKGQWh0dHA6Ly9yZXBvc2l0b3J5LnRlc3RwdWJsaWNjYS5oaW5ldC5uZXQv%0AY2VydHMvSXNzdWVkVG9UaGlzQ0EucDdiMDoGCCsGAQUFBzABhi5odHRwOi8vb2Nz%0AcC50ZXN0cHVibGljY2EuaGluZXQubmV0L09DU1Avb2NzcEcyMBgGA1UdIAQRMA8w%0ADQYLKwYBBAGBtyNkAAMwDgYDVR0PAQH%2FBAQDAgeAMB8GA1UdJQQYMBYGCCsGAQUF%0ABwMCBgorBgEEAYI3CgMMMA0GCSqGSIb3DQEBCwUAA4IBAQAvuEQAY2l3O7cnr37Y%0A%2B3eyrnL3XNkZY0OLrYwpDEz4JIU1Mp8NvMk1tKfccBZsqCAl1Z0aTCdP%2FzySqPp3%0AP%2FnhRtwXYDqO3cDDnXXvrm937sOY1J2Ato%2BB2I1AlKG91AFy7PKP7RdsSKDWI6Dy%0AW3Ogn57plQkmNDX2hOxAdHBmZDrYkfdAaSsi6R1zRS9SCvJ4UqhPUelBFMMMspU2%0APrfmfWm08cIkmC8f83zedMDGyS%2FX54iMXvCdrkGaB1L3CxYnXbBlRTbYQi6EjwD2%0A3Jo39n96mQvQVcelKaCJ8%2FM3oL6d9t25980o%2FDKr2QC%2BNpc%2FjcrDcKR6bN1BaZsO%0A%2B6WvMYIBqzCCAacCAQEwgYMwbzELMAkGA1UEBhMCVFcxIzAhBgNVBAoMGkNodW5n%0AaHdhIFRlbGVjb20gQ28uLCBMdGQuMTswOQYDVQQLDDIoRm9yIFRlc3QgT25seSlQ%0AdWJsaWMgQ2VydGlmaWNhdGlvbiBBdXRob3JpdHkgLSBHMgIQGgzAeIcALXehYKb5%0AFjZJsjAJBgUrDgMCGgUAMA0GCSqGSIb3DQEBAQUABIIBAKIkCzgW9BYUwJG08WuJ%0Ae0aESmQyh6uuZ91MblrD2AkuF8I6x6w30EkceVI%2Bb8QKaPV1o%2BYvvjfOqX88QiFf%0A40CJOrwdFXO8%2FFTSg1xA585%2BFth%2B5cl5lt8%2B5ILqDA6%2FV86tSlWheIN%2BblQp9hdU%0A%2Bz5%2BqphqTg3e4fuGa6mRwmL2dRBIUwFZBhj5IkgWrmEHU9UrNJ7wty3X0eh2jF%2B5%0Avrwr1qoRW%2BcnMAp8l3NnubN1x4tJPveUrEU%2BSu%2FH3zpwbdKHycwsajP3beHYVRTL%0A7Av1qpR3%2BccmvGgVGQmKH7q%2FjX2xMkl%2FNvqM4aVJWwnBcxuptvWr2AaRmSQjpcby%0AXsY%3D%0A";

        // 不驗證SSL憑證
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {

            }
        }};

        InputStream in = null;
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(getHostnameVerifier());
            HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("POST"); //建議為POST
            //connection.setRequestMethod("GET"); //建議為POST

            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Length", "0");
            DataOutputStream os = new DataOutputStream(connection.getOutputStream());
            os.write("".getBytes("UTF-8"), 0, 0);
            os.flush();
            os.close();

            int responceCode = connection.getResponseCode();

            in = connection.getInputStream();
            if (responceCode == HttpsURLConnection.HTTP_OK) {
                BufferedReader read = new BufferedReader(new InputStreamReader(in, "MS950"));
                String response = read.readLine();
                log.info("response ====" + response);
            } else {
                String response = "";
            }

        } catch (GeneralSecurityException e) {
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        } catch (Exception e) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    private static HostnameVerifier getHostnameVerifier() {
        return new HostnameVerifier() {

            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
    }
}
