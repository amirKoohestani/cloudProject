package com.reporter.controller;

import com.reporter.dto.GetMailDetail;
import com.reporter.dto.MailDetail;
import com.reporter.service.ReportService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<MailDetail> getMails(@RequestHeader(value = "Authorization") String authorizeHeader) {
        Long id = getIdByToken(authorizeHeader);
        return null;
    }

    @GetMapping(path = "{id}")
    public GetMailDetail getMailByUID(@RequestHeader(value = "Authorization") String authorizeHeader){
        Long id = getIdByToken(authorizeHeader);
        return null;
    }

    @GetMapping(path = "configs/{id}")
    public GetMailDetail getMailByConfigID(@RequestHeader(value = "Authorization") String authorizeHeader){
        Long id = getIdByToken(authorizeHeader);
        return null;
    }

    private Long getIdByToken(String token) {
        HttpURLConnection connection = null;
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL url = new URL("localhost:8080/mail");
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestProperty("Authorization", "Bearer " + token);

            int status = connection.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                    reader.close();

                }
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                    reader.close();
                }
            }
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }


        JSONArray albums = new JSONArray(responseContent);
        for (int i = 0 ; i < albums.length() ; i++){
            JSONObject album = albums.getJSONObject(i);
            int id = album.getInt("id");
            String title = album.getString("title");
        }



        return 0L;
    }
}
