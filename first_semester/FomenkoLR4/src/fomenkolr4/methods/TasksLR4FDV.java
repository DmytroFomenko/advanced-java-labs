package fomenkolr4.methods;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static fomenkolr4.methods.HelpMet.*;

public class TasksLR4FDV {

    // TO UPPER
    public static char[] upperCase(char[] setLetter) {
        for (int i = 0; i < setLetter.length; i++) {
            if (setLetter[i] > 96 & setLetter[i] < 123) {   // bitwise operator 1 & 1 = 1
                setLetter[i] -= 32;
            }
            if ((setLetter[i] > 1071 & setLetter[i] < 1102)) {
                setLetter[i] -= 32;
            }
        }
        return setLetter;
    }


    // TO LOWER
    public static char[] lowCase(char[] setLetter) {
        for (int i = 0; i < setLetter.length; i++) {
            if (setLetter[i] > 64 && setLetter[i] < 91) {
                setLetter[i] += 32;
            }
            if ((setLetter[i] > 1039 && setLetter[i] < 1070)) {
                setLetter[i] += 32;
            }
        }
        return setLetter;
    }


    public static String sname(String s) {
        String errorStr = "ERROR: Latin letters or numbers are present";

        char[] snameChars = s.toCharArray();
        char[] resultChars = new char[snameChars.length]; // Resulting chars with tail

        int resultLength = 0;
        int i = 0;
        int j = 0;
        int spaceCnt = 0;
        while (i < snameChars.length) {

            if ((snameChars[i] > 96 && snameChars[i] < 123) || snameChars[i] > 47 && snameChars[i] < 58) {
                return errorStr;
            }

            if (snameChars[i] != 32) {
                if (spaceCnt == 0) {
                    resultChars[j++] = upperCaseOneSymb(snameChars[i]);
                    resultLength++;
                }
            } else {
                if (++spaceCnt == 1) {
                    resultChars[j++] = 32;
                    resultLength++;
                }

                resultChars[j++] = upperCaseOneSymb(snameChars[++i]);
                resultChars[j++] = '.';
                resultLength += 2;
            }

            i++;
        }

        char[] resultChars2 = new char[resultLength]; // Resulting chars without tail
        for (i = 0; i < resultLength; i++) {
            resultChars2[i] = resultChars[i];
        }

        return new String(resultChars2);
    }


    public static String checkPassword(String password) {   // aA5#
        StringBuilder sb = new StringBuilder();
        sb.append("Password " + password + " is ");

        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!_$%#@*]).+";

        if (password.matches(pattern)) {
            sb.append("TRUE");
        } else {
            sb.append("WRONG");
        }

        return sb.toString();
    }

    public static String checkLogin(String login) {
        StringBuilder sb = new StringBuilder();
        sb.append("Login " + login + " is ");

        String pattern = "[A-Z]{1,2}\\d{8}[A-Z]{1,3}";

        if (login.matches(pattern)) {
            sb.append("TRUE");
        } else {
            sb.append("WRONG");
        }

        return sb.toString();
    }

    public static String checkSum(String sum) {
        StringBuilder sb = new StringBuilder();
        sb.append(sum + " => ");

        String pattern = "(\\d{1,})\\.(\\d{2}) (грн)";

        if (sum.matches(pattern)) {
            sb.append("true");
        } else {
            sb.append("false");
        }

        return sb.toString();
    }

    public static String checkDate(String date) {
        StringBuilder sb = new StringBuilder();
        sb.append("Format of date " + date + " is ");

        String pattern = "(\\d{2})\\.(\\d{2})\\.(\\d{4})";

        if (date.matches(pattern)) {
            sb.append("TRUE");
        } else {
            sb.append("WRONG");
        }

        return sb.toString();
    }

    public static String checkPhoneNum(String num) {
        StringBuilder sb = new StringBuilder();
        sb.append("Phone number " + num + " is ");

        String pattern = "(067|068|096|097|098)(\\d{7})";

        String sameDigits = "\\d{1,}(\\d)?\\1{4,}(\\d{1,})?";

        if (num.matches(pattern) && !num.matches(sameDigits)) {
            sb.append("TRUE");
        } else {
            sb.append("WRONG");
        }

        return sb.toString();
    }

    public static String checkPostNum(String post) {
        StringBuilder sb = new StringBuilder();
        sb.append("Post number " + post + " is ");

        String patternFirstNotNum = "[a-zA-Z][0-9a-zA-Z!_.]*";
        String patternNumOfSymbAndPointBeforeDom = "[0-9a-zA-Z!_.]{1,20}\\.[a-z]{1,}";
        String patternUaRuCheck = "[0-9a-zA-Z!_.]*\\.(ua|ru)";
        String patternSymbInSequence = "([0-9a-zA-Z!_.]*)((!|_|[.]){2,})([0-9a-zA-Z!_.]*)";

        if (post.matches(patternFirstNotNum) && post.matches(patternNumOfSymbAndPointBeforeDom)
                && !post.matches(patternUaRuCheck) && !post.matches(patternSymbInSequence)) {
            sb.append("TRUE");
        } else {
            sb.append("WRONG");
        }

        return sb.toString();
    }


    public static String strCalc(String str) {
        // Test text: GggGGgg  жЖжж     жЖжDdd

        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder(str);

        int LowCaseC = 0;
        int UpperCaseC = 0;
        int LowCaseE = 0;
        int UpperCaseE = 0;

        int end = 0;
        int spaceIndex = -1;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) > 1071 && sb.charAt(i) < 1102) {
                LowCaseC++;
            }
            if (sb.charAt(i) > 1039 && sb.charAt(i) < 1070) {
                UpperCaseC++;
            }
            if (sb.charAt(i) > 96 && sb.charAt(i) < 123) {
                LowCaseE++;
            }
            if (sb.charAt(i) > 64 && sb.charAt(i) < 91) {
                UpperCaseE++;
            }

            if (!Character.isWhitespace(sb.charAt(i))) { // if not ' '
                sb.setCharAt(end++, sb.charAt(i));
                spaceIndex = -1;
            } else if (spaceIndex < 0) {
                sb.setCharAt(end++, sb.charAt(i));
                spaceIndex = i;
            }
        }
        sb.setLength(end);

        result.append("The text without the odd spaces:\n")
                .append(sb).append("\n\n")
                .append("This text consists of:\n")
                .append("LowCase cyrillic – ")
                .append(LowCaseC).append("\n")
                .append("UpperCase cyrillic – ")
                .append(UpperCaseC).append("\n")
                .append("LowCase english – ")
                .append(LowCaseE).append("\n")
                .append("UpperCase english – ")
                .append(UpperCaseE);

        return result.toString();
    }


    public static String groupByDomainUsers(String[] str) {
        ArrayList<String> nicks;
        HashMap<String, ArrayList<String>> mailGroups = new HashMap<>();

        Pattern pattern = Pattern.compile("(.+?)(?=;).*(?<=@)(.+)"); // (nick)..(domain)
        Matcher match;

        for (String s : str) {
            match = pattern.matcher(s);

            if (match.find()) {
                String dom = match.group(2);
                String nick = match.group(1);

                nicks = mailGroups.get(dom);

                if (nicks == null) {
                    nicks = new ArrayList<>();
                    mailGroups.put(dom, nicks);
                }
                nicks.add(nick);
            }
        }
        return toStringHashMap(mailGroups);
    }

}
