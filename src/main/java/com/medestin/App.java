package com.medestin;

import com.medestin.converter.Converter;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me conversion info: 'value from to'");
        String input = scanner.nextLine();

        Converter converter = new Converter();
        System.out.println("Value converted: " + converter.convert(input));
    }
}
