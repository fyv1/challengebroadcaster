package pl.fyv.mc.challengebroadcaster;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.bukkit.command.CommandSender;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import static org.bukkit.Bukkit.getLogger;

public class JSONRetriever {

    private static final String URL_STRING = "http://localhost:80/challenges.json";

    public JSONRetriever(CommandSender commandSender) throws Exception {
        Gson gson = new Gson();
        String json = readUrl();
        Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String, Object>>() {}.getType());
        map.forEach((x, y) ->  commandSender.sendMessage("key : " + x + " , value : " + y));

    }

    private String readUrl() throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(URL_STRING);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }


}
