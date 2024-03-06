package Config;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class InMemoryConfig {

    Map<String, String> config;

    private static InMemoryConfig instance;

    public static InMemoryConfig getInstance() throws IOException {
        if (instance == null) {
            instance = new InMemoryConfig();
        }

        return instance;
    }

    public InMemoryConfig() {
       this.config = new HashMap<>();
    }

    public String get(String key){
        return this.config.get(key);
    }

    public String set(String key, String value){
        return this.config.put(key, value);
    }

    public int size() {
        return this.config.size();
    }
}
