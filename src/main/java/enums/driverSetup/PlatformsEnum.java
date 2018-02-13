package enums.driverSetup;

public enum PlatformsEnum {
    PLATFORM_MASK("platformName"),
    ANDROID("Android"),
    IOS("Safari"),
    UNKNOWN_PLATFORM("Unknown platform");

   public final String text;

    PlatformsEnum(String text) {
        this.text = text;
    }
}
