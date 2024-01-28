package Config;

public enum ConfigValue{
    APP_VERSION("APP_VERSION");

    private final String value;

    ConfigValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}