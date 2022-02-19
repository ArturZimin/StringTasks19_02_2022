package by.zimin;

import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        toUpperCaseStartOfSentence("US national security adviser Jake Sullivan warned Friday that a Russian " +
                "assault on Ukraine could begin soon, including with bombs and missiles. sullivan advised all" +
                " Americans to depart the. country as quickly as possible for their own safety," +
                " echoing the call of a growing number of embassies that are doing the same.");


        letterAppearTwice("Asmericanas");
        letterRepeatedMoreTme("Asmericanas");
        reversRegistr("asSauLt on UkrAine could Begin soon, including with bombs and missiles.");
        showWordsFromText("assault on Ukraine could begin soon including with bombs and missiles");
        findAndShowSubstring("on Ukraine could begin soon including with bombs and missiles", "cou");
        System.out.println(countWords("on Ukraine could begin soon including with bombs and missiles"));
        countUpperCaseAndLower("on UkrAine Could Begin soon");
        findTheMostLongerWord("Ukraine could begin soon including with bombs and missiles");
        System.out.println(removeDuplicateChars("Ukraine could begin soon including with bombs and missiles"));
        takeOutNumbersFromStringAndPutToArray("Ukraine 12co4uld be33gin so555on inclu7ding with bombs and missiles");
        randomTwoWordsFromString("12co4uld be33gin so555on incl");
        System.out.println(isPalindrome("Заказ"));
        System.out.println(isPalindrome1("Заказ"));
        System.out.println(removingASpecifiedCharFromString("Ukraine 12co4uld be33gin so555on inclu7ding with", " "));
        System.out.println(removingASpecifiedCharFromString1("Ukraine 12co4uld be33gin so555on inclu7ding", " "));
    }


    /**
     * 1.	На вход подается текст, все предложения, которого начинаются с маленькой буквы.
     * Вывести исправленный текст на консоль.
     */
    public static String toUpperCaseStartOfSentence(String str) {
        char[] strArray = str.toCharArray();
        int size = strArray.length - 1;
        for (int i = 0; i < strArray.length; i++) {
            char firstElement = strArray[i];
            if (firstElement == '.' && (i + 2) < size) {
                String firstEl = Character.toString(strArray[i + 2]).toUpperCase();
                strArray[i + 2] = firstEl.charAt(0);
            }
        }
        String str1 = new String(strArray);
        System.out.println(str1);
        return str1;
    }

    /**
     * 2.	На вход подается 1 строка. Необходимо вывести букву, которая встречается в строке дважды.
     */

    public static void letterAppearTwice(String str) {
        char[] stringChars = str.toCharArray();
        String letterAppearTwice = "";
        int count = 0;
        for (int i = 0; i < stringChars.length; i++) {
            char a = stringChars[i];
            for (int y = 1; y < stringChars.length; y++) {
                char b = stringChars[y];
                if (a == b) {
                    count++;
                }
            }
            if (count == 2) {

                letterAppearTwice += stringChars[i] + " , ";
            }
            count = 0;
        }
        System.out.println(letterAppearTwice);

    }

    /**
     * 3.	На вход подается 1 строка. Необходимо вывести букву, которая встречается в строке больше всего.
     */
    public static void letterRepeatedMoreTme(String str) {
        str = str.toLowerCase();
        char[] stringChars = str.toCharArray();
        int count1 = 0;
        int maxCount = 0;
        char maxCountRepeat = ' ';
        for (int i = 0; i < stringChars.length; i++) {
            char a = stringChars[i];
            for (int y = 1; y < stringChars.length; y++) {
                char b = stringChars[y];
                if (a == b) {
                    count1++;
                }
            }
            if (maxCount < count1) {
                maxCount = count1;
                maxCountRepeat = stringChars[i];
            }
            count1 = 0;
        }
        System.out.println(Character.toString(maxCountRepeat) + " - the letter that occurs the most times.");
    }

    /**
     * 4.	На вход подается 1 строка. Необходимо вывести эту же строку символы которой будут менять свой регистр.
     */

    public static String reversRegistr(String s) {
        char[] str = s.toCharArray();
        String temp = "";
        for (int i = 0; i < str.length; i++) {
            temp = Character.toString(str[i]);
            if (isLowerCase(temp)) {
                temp = temp.toUpperCase();
                str[i] = temp.charAt(0);
            } else {
                temp = temp.toLowerCase();
                str[i] = temp.charAt(0);
            }
        }
        String newStr = new String(str);
        System.out.println(newStr);
        return newStr;
    }

    public static boolean isLowerCase(String s) {
        return s == s.toLowerCase() && s != s.toUpperCase();
    }

    /**
     * 5.	При вводе пользователь выделяет строки используя пробел. Необходимо вывести каждую из этих строк.
     */

    public static void showWordsFromText(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }

    /**
     * 6.	На вход подается строка. Известно, что она содержит ровно три одинаковые подстроки длинною в три символа.
     * Найдите их, верните подстроку.
     */
    public static String findAndShowSubstring(String s, String findSubstr) {
        String substring = "";
        int count = 0;
        for (int i = 0; i < 3; i++) {
            int indexSubstr = s.indexOf(findSubstr);
            if (indexSubstr == -1) {
                System.out.println("The substring is not find!");
                break;
            } else {
                count++;
                s.replace(findSubstr, " ");
            }
        }
        if (count == 3) {
            substring = findSubstr;
            System.out.println("The substring is find! '" + findSubstr + "'");
        }

        return substring;
    }

    /**
     * 7.	Количество слов в строке
     * Вводится строка, состоящая из слов, разделенных пробелами. Требуется посчитать количество слов в ней.
     */

    public static int countWords(String str) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == ' ' || str.charAt(i) == '\n' || str.charAt(i) == '\t') {
                flag = false;

            } else if (flag == false) {
                flag = true;
                count++;
            }
        }

        return count;
    }

    /**
     * 8.	Количество строчных и прописных букв в строке
     * Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке.
     * Учитывать только английские буквы.
     */

    public static void countUpperCaseAndLower(String str) {
        int countUpper = 0;
        int countLower = 0;
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {

            if (Character.isLetter(str.charAt(i))) {
                if (str.charAt(i) > 40 && str.charAt(i) < 91) {
                    countUpper++;
                } else {
                    countLower++;
                }
            }
        }
        System.out.println("Uppercase letters = " + countUpper + ",lowercase letters = " + countLower);
    }

    /**
     * 9  Find the most longer words and show
     */
    public static String findTheMostLongerWord(String txt) {
        StringBuilder sb = new StringBuilder();
        int countChar = 0;
        int maxLonger = 0;
        String mostLongerWord = "";
        for (int i = 0; i < txt.length(); i++) {
            if (Character.isLetter(txt.charAt(i))) {
                countChar++;
                sb.append(txt.charAt(i));

                if (maxLonger < countChar) {
                    maxLonger = countChar;
                    mostLongerWord = sb.toString();

                }
            } else {
                countChar = 0;
                sb.delete(0, sb.length());
            }

        }
        System.out.println(mostLongerWord + " " + maxLonger);
        return mostLongerWord;
    }

    /**
     * 10. Удаление из строки повторяющихся символов
     * Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было
     * введено "abc cde def", то должно быть выведено "abcdef".
     */

    public static String removeDuplicateChars(String txt) {
        StringBuilder str = new StringBuilder();
        txt = txt.replaceAll(" ", "");
        for (Character ch : txt.toCharArray()) {
            if (str.toString().contains(ch.toString())) {
                continue;
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }


    /**
     * 11. Отфильтровать из строки числа
     * Вводится строка, содержащая буквы, целые неотрицательные числа и иные символы. Требуется все числа,
     * которые встречаются в строке, поместить в отдельный целочисленный массив. Например, если дана строка
     * "data 48 call 9 read13 blank0a", то в массиве должны оказаться числа 48, 9, 13 и 0.
     */

    public static int[] takeOutNumbersFromStringAndPutToArray(String txt) {
        int[] arr = new int[10];
        int index = 0;
        String number = "";
        for (int i = 0; i < txt.length(); i++) {
            char ch = txt.charAt(i);
            if (ch > 47 && ch < 58) {
                number += String.valueOf(ch);
                if (txt.charAt(i + 1) > 47 && txt.charAt(i + 1) < 58) {
                    if (txt.charAt(i + 2) > 47 && txt.charAt(i + 2) < 58) {
                    }
                } else {
                    arr[index] = Integer.parseInt(number);
                    index++;
                    number = "";
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    /**
     * 12. Составить из букв введенной строки слова
     * Вводится строка, состоящая из букв и пробелов. Составить из входящих в нее букв несколько любых их
     * сочетаний (слов) любой длины. Каждую букву строки можно использовать неограниченное количество раз.
     */

    public static String randomTwoWordsFromString(String str) {
        StringBuilder words = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Random random = new Random();
            words.append(str.charAt(random.nextInt(str.length() - 1)));
            if (words.length() == 8) {
                words.append(" , ");
            } else if (words.length() > 18) {
                words.append(".");
                break;
            }
        }
        System.out.println(words.toString());
        return words.toString();
    }

    /**
     * 13. Напишите программу проверки, читается ли стока одинаково в обоих направлениях одинаково.
     * Вводится строка. Удалить из нее все пробел, привести к единому регистру. После этого
     * определить, является ли она палиндромом (перевертышем), т.е. одинаково пишется как с
     * начала, так и с конца.
     */


    public static boolean isPalindrome1(String txt) {
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        txt = txt.replaceAll(" ", "").toLowerCase();
        sb.append(txt).reverse();
        if (sb.toString().equals(txt)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 14. Решить предыдущую задачу не используя классы StringBuffer и StringBuilder.
     */
    public static boolean isPalindrome(String txt) {
        boolean flag = false;
        int count = 0;
        txt = txt.replaceAll(" ", "").toLowerCase();
        for (int i = 0, j = txt.length() - 1; i < txt.length(); i++) {
            if (txt.charAt(i) == txt.charAt(j)) {
                count++;
                if (j >= 0) {
                    j--;
                }
            }
        }
        if (count == txt.length()) {
            flag = true;
        }
        return flag;
    }

    /**
     * 15. Напишите программу удаления указанного символа из строки.
     * (исп. метод replaceAll для замены всех вхождений в строку другой строкой.
     */
    public static String removingASpecifiedCharFromString(String txt, String removeChar) {
        txt = txt.replaceAll(removeChar, "");
        return txt;
    }

    /**
     * 16. Решить предыдущую задачу, не используя replace/ replaceAll.
     */

    public static String removingASpecifiedCharFromString1(String txt, String removeChar) {
        StringBuilder sb = new StringBuilder();
        sb.append(txt);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == removeChar.charAt(0)) {
                sb.deleteCharAt(i);

            }
        }
        return sb.toString();
    }

}
