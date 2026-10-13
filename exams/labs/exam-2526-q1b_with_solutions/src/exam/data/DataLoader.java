package exam.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class DataLoader {
    public static List<GitHubEvent> loadFromDataset(String path) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<GitHubEvent>>() {}.getType();
        try (FileReader reader = new FileReader(path)) {
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            throw new RuntimeException("Error loading dataset: " + e.getMessage());
        }
    }
}

