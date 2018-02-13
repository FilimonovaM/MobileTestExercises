package enums.web;

public enum SitePageEnum {

    HOME("https://www.iana.org/"),
    DOMAIN("https://www.iana.org/domains"),
    NUMBER_RESOURCES("https://www.iana.org/numbers"),
    PROTOCOL("https://www.iana.org/protocols"),

    HOME_PAGE_TITLE("Internet Assigned Numbers Authority"),
    DOMAIN_TITLE("Domain Names"),
    NUMBER_RESOURCES_TITLE("Number Resources"),
    PROTOCOL_ASSIGNMENTS_TITLE("Protocol Assignments"),

    DOMAIN_BLOCK_TEXT("Domain Names\n" +
            "Management of the DNS Root Zone (assignments of ccTLDs and gTLDs) along with other functions such as the " +
            ".int and .arpa zones.\n" +
            "Root Zone Management\n" +
            "Database of Top Level Domains\n" +
            ".int Registry\n" +
            ".arpa Registry\n" +
            "IDN Practices Repository"),
    NUMBER_RESOURCES_BLOCK_TEXT("Number Resources\n" +
            "Coordination of the global IP and AS number spaces, such as allocations made to Regional Internet " +
            "Registries.\nIP Addresses & AS Numbers\n" +
            "Network abuse information"),
    PROTOCOL_BLOCK_TEXT("Protocol Assignments\n" +
            "The central repository for protocol name and number registries used in many Internet protocols.\n" +
            "Protocol Registries\n" +
            "Apply for an assignment\n" +
            "Time Zone Database");

    public String text;

    SitePageEnum(String text) {
        this.text = text;
    }
}
