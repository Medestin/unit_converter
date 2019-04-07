package com.medestin.converter;

public class ConverterDTO {
    private final double value;
    private final String from;
    private final String to;

    public ConverterDTO(double value, String from, String to) {
        this.value = value;
        this.from = from;
        this.to = to;
    }

    public double getValue() {
        return value;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
