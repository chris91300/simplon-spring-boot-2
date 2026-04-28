package fr.springBoot.jpalibrary.model;

public enum CategoryType {
    ROMAN_POLICIER("roman policier"),
    ROMAN_HORREUR("horreur"),
    ROMAN_HISTORIQUE("historique"),
    ROMAN_SENTIMENTAL("sentimental"),
    NOUVELLE("nouvelle"),
    BIOGRAPHIE("biographie");

    private final String type;

    CategoryType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
