package com.medestin.interpreter;

import com.medestin.converter.ConverterDTO;

public class InputInterpreter {

    public ConverterDTO interpret(String input){
        return new ConverterDTO(16.0, "cm", "in");
    }
}
