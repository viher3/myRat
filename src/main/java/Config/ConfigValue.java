package Config;

public enum ConfigValue {
    APP_VERSION("APP_VERSION"),
    APP_MODE("APP_MODE"),
    APP_MODE_CLIENT("CLIENT"),
    APP_MODE_SERVER("SERVER"),
    PUBLIC_IP("PUBLIC_IP"),
    PRIVATE_IP("PRIVATE_IP"),
    SERVER_ADDRESS("SERVER_ADDRESS"),
    SERVER_PORT("SERVER_PORT"),
    ;

    private final String value;

    ConfigValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}