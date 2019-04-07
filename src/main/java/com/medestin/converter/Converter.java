package com.medestin.converter;

import com.medestin.exception.BaseNotSetException;
import com.medestin.exception.UnsupportedConversionException;
import com.medestin.interpreter.InputInterpreter;
import com.medestin.picker.UnitPicker;

import java.util.Map;

public class Converter implements Conversion{
    private final InputInterpreter interpreter;
    private Map<String, Double> units;

    public Converter() {
        this.interpreter = new InputInterpreter();
    }

    public double convert(String input){
        ConverterDTO convertedInput = interpreter.interpret(input);
        this.units = UnitPicker.getMapSetBase(convertedInput.getFrom(), convertedInput.getTo());
        String base;

        try{
            base = UnitPicker.getBase();
        } catch (BaseNotSetException e){
            throw new UnsupportedConversionException("Base is not set");
        }

        if(convertedInput.getFrom().equals(convertedInput.getTo())){
            return convertedInput.getValue();
        }

        double valueBase = convertToBase(convertedInput.getValue(), convertedInput.getFrom(), base);
        return convertFromBase(valueBase, convertedInput.getTo(), base);
    }

    private double convertToBase(double value, String from, String base){
        return (from.equals(base)) ? value : value*units.get(from);
    }

    private double convertFromBase(double value, String to, String base) {
        return (to.equals(base)) ? value : value / units.get(to);
    }
}
