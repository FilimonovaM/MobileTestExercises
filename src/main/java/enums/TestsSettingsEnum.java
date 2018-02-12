package enums;

public enum TestsSettingsEnum {
    NATIVES_PROPERTY("/properties_native/native_test.properties"),
    WEB_PROPERTY("/properties_web/web_test.properties"),
    APPIUM_LOCALHOST("http://0.0.0.0:4723/wd/hub");

    public String text;

    TestsSettingsEnum(String text) {
        this.text = text;
    }
}
