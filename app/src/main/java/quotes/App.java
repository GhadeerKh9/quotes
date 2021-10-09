/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;

import java.io.*;

import com.google.common.reflect.TypeToken;
import java.net.URL;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args){
        String path = "./app/src/main/resources/recentquotes.json";
        String API = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";

    }
    public static List gettingInfo(String extension) {

        Gson gson = new Gson();
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(extension);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error");
        }



        Type quotesList = new TypeToken<ArrayList<Quotes>>() {}.getType();

        List<Quotes> fileQuotes = gson.fromJson(fileReader, quotesList);


        int randomValue = (int)(Math.random() * fileQuotes.size());

        System.out.println("Quote Index is : " + randomValue);
        System.out.println(fileQuotes.get(randomValue).toString());

        return fileQuotes;

    }


    public static String onlineQuotes(String API){
        StringBuilder builder =new StringBuilder();
        try {
            URL url = new URL(API);
            HttpURLConnection connect =(HttpURLConnection) url.openConnection();
            connect.setRequestMethod("GET");

            if (connect.getResponseCode() == 200){
                InputStream input =connect.getInputStream();
                InputStreamReader fileReader = new InputStreamReader(input);
                BufferedReader bufferedReader =new BufferedReader(fileReader);
                String line = bufferedReader.readLine();
                builder = new StringBuilder(line);
                while (line !=null){
                    System.out.println(line);
                    line = bufferedReader.readLine();
                    if(line != null){
                        builder.append(line);
                    }
                }
                bufferedReader.close();
                FileWriter fileWriter = new FileWriter("addQuote.json");
                fileWriter.write(builder.toString());
                fileWriter.close();
            }else {
                System.out.println("error" + connect.getResponseCode());
                gettingInfo("./app/src/main/resources/recentquotes.json");
            }
            connect.disconnect();


        } catch (IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }


}

