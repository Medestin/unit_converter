package com.medestin.converter;

import com.medestin.interpreter.InputInterpreter;

public class Converter implements Conversion{
    private final InputInterpreter interpreter;

    public Converter() {
        this.interpreter = new InputInterpreter();
    }

    public double convert(String input){
        ConverterDTO convertedInput = interpreter.interpret(input);
        return convertedInput.getValue()/2.205;
    }

    private double convertToBase(double value, String from){
        return 0.0;
    }

    private double convertFromBase(double value, String to){
        return 0.0;
    }
}
