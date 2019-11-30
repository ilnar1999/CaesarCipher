package com.epam.izh;

import static com.epam.izh.Decoder.*;
import static com.epam.izh.Printer.*;

public class Main {
    private static String newText = "";

    public static void main(String[] args) {
        for (int key = 1; key < 33; key++) { // перебор всех возможных сдвигов
            for (int i = 0; i < getTextLength(); i++) { // перебор всех символов в тексте
                Character nowCharacter = getCharacterFromText(i);
                int positionNewLetters = 0;
                boolean isUpperCase = false;
                if (Character.isLetter(nowCharacter)) {
                    isUpperCase = Character.isUpperCase(nowCharacter);
                    Character letterInLowerCase = Character.toLowerCase(nowCharacter);
                    for (int j = 0; j < getLettersLength(); j++) {
                        if (letterInLowerCase.equals(getLetterFromLetters(j))) {
                            positionNewLetters = (j + key) % 33;
                        }
                    }
                }
                if (Character.isLetter(nowCharacter)) {
                    if (isUpperCase) {
                        newText += getLetterFromLetters(positionNewLetters).toString().toUpperCase();
                    } else {
                        newText += getLetterFromLetters(positionNewLetters);
                    }
                } else {
                    newText += nowCharacter;
                }
            }
            printKey(key);
            printNewText(newText);
            newText = "";
        }
    }
}
