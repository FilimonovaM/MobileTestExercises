package enums.driverSetup;

public enum BrowsersEnum {
    BROWSER_MASK("browserName"),
    CHROME("Chrome"),
    SAFARI("Safari");

    public final String text;

    BrowsersEnum(String text) {
        this.text = text;
    }
}
