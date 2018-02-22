package enums.driverSetup;

public enum TestsSettingsEnum {
    NATIVES_PROPERTY_ON_PC("/properties_native/native_test.properties"),
    NATIVES_PROPERTY_ON_FARM("/properties_native/native_for_happy_farmers.properties"),

    WEB_PROPERTY_ON_PC("/properties_web/web_test.properties"),
    WEB_PROPERTY_ON_FARM_IOS("/properties_web/web_for_happy_farmers_ios.properties"),
    WEB_PROPERTY_ON_FARM_ANDROID("/properties_web/web_for_happy_farmers_android.properties");

    public String text;

    TestsSettingsEnum(String text) {
        this.text = text;
    }
}
