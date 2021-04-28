package com.company;

public class Train extends Square
{
    private String name;
    protected Train (String name)
    {
        this.name = name;
    }
    protected String getName(){
        return name;
    }


}
