package com.epam.izh;

public class Decoder {
    private Character[] letters = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п',
                                   'р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
    private String text = "Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв. Ъы зёюивй жёхчгюв бюнс ж ъы вдгивъгзхбсгрв аёхкдв. \n" +
            "Зъеъёс вгъ дмъчющгд, мзд гъюэцъьгджзс тздшд аёхкх фчбфъзжф жбъщжзчюъв гъждчъёнъгжзчх мъбдчъмъжадшд югщючющиивх. \n" +
            "Ф юэимюб чхни южздёюу ю чгыж юэвъгъгюф, здмгъъ дзёхэюч еджздфггиу юэвъгмючджзс мъбдчъмъжаюк едёдадч. \n" +
            "Ю зъв гъ въгъъ, еджбъщдчхбх гъищхмх. Ф еёюнъб а чрчдщи, мзд чюгдя чжъви вдя югзъббъаз, х чдэвдьгд, вды мёъэвъёгдъ жзёъвбъгюъ ад чжъви шхёвдгюмгдви. \n" +
            "Гхязю ёънъгюъ вгъ едвдшбх еёдшёхввх югзиюзючгдшд зюех, жеълюхбсгд ждэщхггхф щбф юэимъгюф деёъщъбъггрк жздёдг мъбдчъмъжадя щиню. \n" +
            "Въгф вдьгд гхэчхзс дзлдв Вхзёюлр, х ъы, цъэ еёъичъбюмъгюф, вхзъёсу.";

    private Character getCharacterFromText(int characterPosition) {
        return text.charAt(characterPosition);
    }

    private int getTextLength() {
        return text.length();
    }

    private int getLettersLength() {
        return letters.length;
    }

    private Character getLetterFromLetters(int position) {
        return letters[position];
    }

    private Character getNewLetter(int key, int position) {
        Character currentCharacter = getCharacterFromText(position);
        int positionNewLetters = 0;
        boolean isUpperCase = false;
        if (Character.isLetter(currentCharacter)) {
            isUpperCase = Character.isUpperCase(currentCharacter);
            Character letterInLowerCase = Character.toLowerCase(currentCharacter);
            for (int j = 0; j < getLettersLength(); j++) {
                if (letterInLowerCase.equals(getLetterFromLetters(j))) {
                    positionNewLetters = (j + key) % 33;
                }
            }
        }
        return selectRegister(currentCharacter, positionNewLetters, isUpperCase);
    }

    private Character selectRegister(char currentCharacter, int positionNewLetters, boolean isUpperCase) {
        if (Character.isLetter(currentCharacter)) {
            if (isUpperCase) {
                return Character.toUpperCase(getLetterFromLetters(positionNewLetters));
            } else {
                return getLetterFromLetters(positionNewLetters);
            }
        } else {
            return currentCharacter;
        }
    }

    String getNewText(int key) {
        String text = "";
        for (int position = 0; position < getTextLength(); position++) {
            text += getNewLetter(key, position);
        }
        return text;
    }
}
