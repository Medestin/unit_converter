package com.medestin.converter;

import com.medestin.interpreter.InputInterpreter;

import java.util.HashMap;
import java.util.Map;

public class Converter implements Conversion{
    private final InputInterpreter interpreter;
    private final String BASE = "g";
    private final Map<String, Double> units = new HashMap<>();

    public Converter() {
        this.interpreter = new InputInterpreter();
        units.put(BASE, 1.0);
        units.put("kg", 1000.0);
        units.put("lb", 453.592);
    }

    public double convert(String input){
        ConverterDTO convertedInput = interpreter.interpret(input);
        if(!isConversionPossible(convertedInput.getFrom(), convertedInput.getTo())){
            throw new RuntimeException("Unsupported conversion unit(s)");
        }

        if(convertedInput.getFrom().equals(convertedInput.getTo())){
            return convertedInput.getValue();
        }

        double valueBase = convertToBase(convertedInput.getValue(), convertedInput.getFrom());
        return convertFromBase(valueBase, convertedInput.getTo());
    }

    private double convertToBase(double value, String from){
        return isBase(from) ? value : value*units.get(from);
    }

    private double convertFromBase(double value, String to){
        return isBase(to) ? value : value/units.get(to);
    }

    private boolean isBase(String input){
        return input.equals(BASE);
    }

    private boolean isConversionPossible(String from, String to){
        return units.containsKey(from) && units.containsKey(to);
    }
}
