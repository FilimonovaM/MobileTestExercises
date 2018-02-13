package enums.natives;

public enum ContactManagerEnum {
    CONTACT_NAME("Contact Name", "Nick"),
    CONTACT_PHONE("Contact Phone", "+65 776 89876"),
    CONTACT_EMAIL("Contact Email", "NickPalyanskiy@gmail.com");

    public String user;
    public String text;

    ContactManagerEnum(String text, String user) {
        this.user = user;
        this.text = text;
    }
}
