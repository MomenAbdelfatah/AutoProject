package engine;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class JsonReader {
    public static JSONObject readJson(String relativePath) throws Exception {
        InputStream is = JsonReader.class.getClassLoader().getResourceAsStream(relativePath);
        if (is == null) {
            throw new FileNotFoundException("File not found: " + relativePath);
        }
        String content = new String(is.readAllBytes());
        return new JSONObject(content);
    }

}
