package com.medestin.converter;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterTestSuite {

    @Test
    public void testBasicConversion(){
        Converter converter = new Converter();
        String input = "4 lb kg";
        double result = converter.convert(input);
        assertEquals(1.814, result, 0.001);
    }

    @Test
    public void testLengthConversion(){
        Converter converter = new Converter();
        String input = "5 cm in";
        double result = converter.convert(input);
        assertEquals(1.968, result, 0.001);
    }
}