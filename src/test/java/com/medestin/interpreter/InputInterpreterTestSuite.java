package com.medestin.interpreter;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputInterpreterTestSuite {

    @Test
    public void interpretInput(){
        String input = "16 cm in";
        InputInterpreter interpreter = new InputInterpreter();
        ConverterDTO data = interpreter.interpret(input);

        assertEquals(16.0, data.getValue());
        assertEquals("cm", data.getFrom());
        assertEquals("in", data.getTo());
    }
}