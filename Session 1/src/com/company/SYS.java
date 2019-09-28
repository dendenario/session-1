package com.company;

import java.util.Properties;

public class SYS
{
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.list(System.out);
    }
}
