package enums;

public enum ContactManagerEnum {
    CONTACT_NAME("Contact Name"),
    CONTACT_PHONE("Contact Phone");

    public String text;

    ContactManagerEnum(String text) {
        this.text = text;
    }
}
