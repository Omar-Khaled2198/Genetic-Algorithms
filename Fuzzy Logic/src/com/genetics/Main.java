package com.genetics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Variable variable=new Variable("position",-45);
        variable.addShape("RBelow", "trapetrianglezoidal",new int[]{-90,-45,9});
        variable.addShape("RUpper", "triangle",new int[]{-9,23,54});
    }
}
