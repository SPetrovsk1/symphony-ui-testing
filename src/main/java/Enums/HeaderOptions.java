package Enums;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public enum HeaderOptions {

    WHAT_WE_DO("What We Do"),
    HOW_WE_WORK("How We Work"),
    CLIENT_STORIES("Client Stories"),
    ABOUT_US("About Us"),
    CAREERS("Careers"),
    CONTACT_US("ContactUs");

    private final String text;

    HeaderOptions(final String text) {
        this.text = text;
    }

    private static Map<String, HeaderOptions> values = populateMap();

    private static Map<String, HeaderOptions> populateMap() {
        Map<String, HeaderOptions> valuesMap = new HashMap<>();
        HeaderOptions[] values = values();
        Stream.of(values).forEach(e -> valuesMap.put(e.text, e));
        return valuesMap;
    }

    @Override
    public String toString() {
        return text;
    }

    public static HeaderOptions parse(String text) {
        if (!values.containsKey(text)) {
            throw new IllegalArgumentException("Error while parsing!");
        }
        return values.get(text);
    }
}
