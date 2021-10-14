package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class App {


    public static void main(String[] args){
        String path = "./app/src/main/resources/recentquotes.json";
        String API = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";

        onlineQuotes(API);
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
        Type quoteType = new TypeToken<List<Quotes>>(){}.getType();

        List<Quotes> fileQuotes = gson.fromJson(fileReader, quoteType);

        int randomValue = (int)(Math.random() * fileQuotes.size());

        System.out.println(fileQuotes.get(randomValue).toString());

        return fileQuotes;
    }



    public static String onlineQuotes(String API){

        StringBuilder builder =new StringBuilder();

        try {

            URL url = new URL(API);

            HttpURLConnection connect =(HttpURLConnection) url.openConnection();

            connect.setRequestMethod("GET");

            int status = connect.getResponseCode();

            if (status == 200){

                InputStream input =connect.getInputStream();

                InputStreamReader reader = new InputStreamReader(input);

                BufferedReader bufferedReader =new BufferedReader(reader);

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

                FileWriter fileWriter = new FileWriter("app/src/main/resources/recentquotes.json");

                fileWriter.write(builder.toString());

                fileWriter.close();
            }else {
                System.out.println("error" + status);
                String path = "app/src/main/resources/recentquotes.json";
                gettingInfo(path);
            }
            connect.disconnect();


        } catch (IOException e){
            System.out.println(e.getMessage());

            e.printStackTrace();
        }
        return builder.toString();
    }


}


