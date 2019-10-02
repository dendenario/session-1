package com.company;

import java.util.Map;

public class ENV {
    public static void main(String[] args) {
        for(Map.Entry<String,String> s : System.getenv().entrySet())
        {
            System.out.println(s.getKey()+ "=" + s.getValue());
        }
    }
}
