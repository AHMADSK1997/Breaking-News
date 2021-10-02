package com.example.BreakingNews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DataFromUrl {
    private String path;
    private static HttpURLConnection conn;
    private ArrayList<Item> items = new ArrayList<>();

    public DataFromUrl(String path) {
        this.path = path;
    }
    private int Connection() {
        int status = 500;
        try {
            URL url = new URL(this.path);
            conn = (HttpURLConnection) url.openConnection();

            // Request setup
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);// 5000 milliseconds = 5 seconds
            conn.setReadTimeout(5000);

            // Test if the response from the server is successful
            status = conn.getResponseCode();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }
    public ArrayList<Item> Readitems(){
        BufferedReader reader;
        try {
            if(Connection() >= 300) {
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                Readlines(reader);
            }else {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                Readlines(reader);
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return items;
    }
    private void Readlines(BufferedReader reader) {
        String line;
        StringBuilder responseContent = new StringBuilder();
        try {
            line = reader.readLine();
            while (!line.contains("item")) {
                line = reader.readLine();
            }
            while (line  != null) {
                while(line  != null && !line.contains("</item>")) {
                    responseContent.append(line);
                    line = reader.readLine();
                }
                if(line  == null) break;
                responseContent.append(line);
                parser(responseContent.toString());
                responseContent.setLength(0);
                line = reader.readLine();

            }
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private void parser(String xml) {
        DocumentBuilder builder;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource src = new InputSource();
            src.setCharacterStream(new StringReader(xml));

            Document doc = builder.parse(src);
            String title = doc.getElementsByTagName("title").item(0).getTextContent();
            String description = doc.getElementsByTagName("description").item(0).getTextContent();
            String link = doc.getElementsByTagName("link").item(0).getTextContent();
            String pubDate = doc.getElementsByTagName("pubDate").item(0).getTextContent();
            String guid = doc.getElementsByTagName("guid").item(0).getTextContent();
            String tags = doc.getElementsByTagName("tags").item(0).getTextContent();
            Item i = new Item(title, description, link, pubDate, guid, tags);
            items.add(i);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
