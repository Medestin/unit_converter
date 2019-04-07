package com.medestin.converter;

public class Converter {

    public double convert(String input){
        String[] arrayInput = input.split("[ ]");
        double value = Double.parseDouble(arrayInput[0]);
        String unitFrom = arrayInput[1];
        String unitTo = arrayInput[2];
        return value/2.205;
    }
}
