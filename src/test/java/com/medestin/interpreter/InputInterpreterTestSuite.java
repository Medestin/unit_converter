package com.medestin.interpreter;

import com.medestin.converter.ConverterDTO;
import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class InputInterpreterTestSuite {

    @Test
    public void interpretInput(){
        String input = "16 cm in";
        InputInterpreter interpreter = new InputInterpreter();
        ConverterDTO data = interpreter.interpret(input);

        assertEquals(16.0, data.getValue(), 0.00000001);
        assertEquals("cm", data.getFrom());
        assertEquals("in", data.getTo());
    }

    @Test(expected = InputMismatchException.class)
    public void testInterpreterThrowingException(){
        InputInterpreter interpreter = new InputInterpreter();
        interpreter.interpret("23 cm kg l");
    }
}