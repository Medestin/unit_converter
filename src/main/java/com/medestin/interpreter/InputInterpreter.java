package com.medestin.interpreter;

import com.medestin.converter.ConverterDTO;
import com.medestin.exception.InvalidInputConventionException;

public class InputInterpreter {

    public ConverterDTO interpret(String input){
        return validate(input);
    }

    private ConverterDTO validate(String input){
        String[] splitInput = input.split("[ ]");
        if(splitInput.length != 3){
            throw new InvalidInputConventionException("Wrong input format, should be 'value unitFrom unitTo'");
        }
        double value = Double.parseDouble(splitInput[0]);
        String from = splitInput[1];
        String to = splitInput[2];

        return new ConverterDTO(value, from, to);
    }
}
