package models;

public enum Country {
    INDIA("India"),
    UNITED_STATES("United States"),
    CANADA("Canada"),
    AUSTRALIA("Australia"),
    ISRAEL("Israel"),
    NEW_ZEALAND("New Zealand"),
    SINGAPORE ("Singapore");

    private final String name;

    Country(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
