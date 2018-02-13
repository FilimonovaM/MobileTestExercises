package enums.driverSetup;

public enum TestsSettingsEnum {
    NATIVES_PROPERTY("/properties_native/native_test.properties"),
    WEB_PROPERTY("/properties_web/web_test.properties");

    public String text;

    TestsSettingsEnum(String text) {
        this.text = text;
    }
}
