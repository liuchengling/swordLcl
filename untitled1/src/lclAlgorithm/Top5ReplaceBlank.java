package lclAlgorithm;

public class Top5ReplaceBlank {

    public static void main(String[] args) {
        String url = "we are happy";
        System.out.println(Replace(url));
    }

    public static String Replace(String url) {
        if (url.length() <= 0) {
            return "";
        }
        StringBuilder newUrl = new StringBuilder(url);
        int blankLength = 0;
        int originalLength = newUrl.length();
        for (int i = 0; i < originalLength; i++) {
            if (' ' == newUrl.charAt(i)) {
                blankLength++;
            }
        }
        int newLength = blankLength * 2 + originalLength;
        int indexOfOriginal = originalLength - 1;
        int indexOfNew = newLength - 1;

        newUrl.setLength(newLength);
        System.out.println("urlLength:" + newUrl.length());

        while (indexOfOriginal >= 0 && indexOfNew >indexOfOriginal) {
            if (' ' == newUrl.charAt(indexOfOriginal)) {
                newUrl.setCharAt(indexOfNew--, '0');
                newUrl.setCharAt(indexOfNew--, '2');
                newUrl.setCharAt(indexOfNew--, '%');
            } else {
                System.out.println("p2"+indexOfNew);
                newUrl.setCharAt(indexOfNew--, newUrl.charAt(indexOfOriginal));
            }
            System.out.println("p1"+indexOfOriginal);
            indexOfOriginal--;
        }
        return newUrl.toString();
    }

}
