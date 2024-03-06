package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @doc https://niruhan.medium.com/how-to-add-a-config-file-to-a-java-project-99fd9b6cebca
 */
public class PropertiesFileConfig {

    final String file = "config.properties";

    Properties config = new Properties();

    private static PropertiesFileConfig instance;

    private PropertiesFileConfig() {
        try (FileInputStream configInput = new FileInputStream(file)) {
            config.load(configInput);
        }catch (Exception e){
            throw new RuntimeException("Error loading ".concat(file).concat(" config file."));
        }
    }

    public static PropertiesFileConfig getInstance() throws IOException {
        if (instance == null) {
            instance = new PropertiesFileConfig();
        }

        return instance;
    }

    public String get(String key) {
        return config.getProperty(key);
    }
}
