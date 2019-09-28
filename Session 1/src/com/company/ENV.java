package com.company;

public class ENV {
    public static void main(String[] args) {
        for(String s : System.getenv().values())
        {
            System.out.println(s);
        }
    }
}
