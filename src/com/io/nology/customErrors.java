package com.io.nology;

public class customErrors {

}

class InvalidEnergyLevel extends Exception
{
    public InvalidEnergyLevel(String message)
    {
        super(message);
    }
}


