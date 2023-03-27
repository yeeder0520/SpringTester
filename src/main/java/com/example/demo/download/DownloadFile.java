package com.example.demo.download;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

@RestController
public class DownloadFile {

    @PostMapping("/ping")
    public String ping(@RequestBody String json) throws JSONException {
        System.out.println("json : " + json);
        JSONObject jsonObject = new JSONObject(json);
        System.out.println(jsonObject.get("fileName"));
        return "pong";
    }

    @PostMapping(value = "/download", consumes = "application/json", produces = "application/json")
    public String download(@RequestBody String data, HttpServletResponse response, HttpServletRequest request)
            throws IOException, JSONException {

        JSONObject jsonObject = new JSONObject(data);
        String fileName = jsonObject.get("fileName").toString();
        System.out.println("fileName => " + fileName);

        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        OutputStream os = null;
        fileName = new String(fileName.getBytes(StandardCharsets.US_ASCII), StandardCharsets.UTF_8); // 解決中文亂碼

        //檔案所在位置
        File file = new File("C:\\Users\\6620\\Desktop\\123\\PCS測試\\" + fileName);
        if (file.exists()) {
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
                os = response.getOutputStream();// 將要下載的檔案內容通過輸出流寫回到瀏覽器
                int i = bis.read(buff);
                while (i != -1) {
                    os.write(buff, 0, buff.length);
                    os.flush();
                    i = bis.read(buff);
                }
            }
        }
        return "SSS";
    }
}
