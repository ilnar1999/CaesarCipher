package com.epam.izh;

public class Main {
    public static void main(String[] args) {
        Decoder decoder = new Decoder();
        Printer printer = new Printer();
        for (int key = 1; key < 33; key++) { // перебор всех возможных сдвигов
            String newText = decoder.getNewText(key);
            printer.printKey(key);
            printer.printNewText(newText);
        }
    }
}
