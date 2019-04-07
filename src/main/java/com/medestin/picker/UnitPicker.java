package com.medestin.picker;

import com.medestin.exception.BaseNotSetException;
import com.medestin.exception.UnsupportedConversionException;

import java.util.HashMap;
import java.util.Map;

public final class UnitPicker {
    private static Map<String, Double> massUnits = new HashMap<>();
    private static Map<String, Double> lengthUnits = new HashMap<>();
    private static String base;

    static{
        massUnits.put("g", 1.0);
        massUnits.put("kg", 1000.0);
        massUnits.put("lb", 453.592);

        lengthUnits.put("cm", 1.0);
        lengthUnits.put("m", 100.0);
        lengthUnits.put("in", 2.54);
    }

    public static Map<String, Double> getMapSetBase(String unitOne, String unitTwo) {
        if(massUnits.containsKey(unitOne) && massUnits.containsKey(unitTwo)){
            base = "g";
            return massUnits;
        } else if (lengthUnits.containsKey(unitOne) && lengthUnits.containsKey(unitTwo)){
            base = "cm";
            return lengthUnits;
        } else {
            throw new UnsupportedConversionException("Unsupported unit(s)");
        }
    }

    public static String getBase() throws BaseNotSetException{
        if(base != null){
            return base;
        }
        throw new BaseNotSetException("base has not been set");
    }
}
