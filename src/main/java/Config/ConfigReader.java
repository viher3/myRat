package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @doc https://niruhan.medium.com/how-to-add-a-config-file-to-a-java-project-99fd9b6cebca
 */
public class ConfigReader {

    final String file = "config.properties";

    Properties config = new Properties();

    private static ConfigReader instance;

    private ConfigReader() {
        try (FileInputStream configInput = new FileInputStream(file)) {
            config.load(configInput);
        }catch (Exception e){
            throw new RuntimeException("Error loading ".concat(file).concat(" config file."));
        }
    }

    public static ConfigReader getInstance() throws IOException {
        if (instance == null) {
            instance = new ConfigReader();
        }

        return instance;
    }

    public String get(String key) {
        return config.getProperty(key);
    }
}
