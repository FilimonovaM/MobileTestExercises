package enums.driverSetup;

public enum CommonInfoEnum {
    URL_MASK("sut"),
    URL_PREFIX("http://"),
    APP_MASK("app"),
    HOST_MASK("host");

    public final String text;

    CommonInfoEnum(String text) {
        this.text = text;
    }
}
