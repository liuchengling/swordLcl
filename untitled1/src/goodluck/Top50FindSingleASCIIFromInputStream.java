package goodluck;

import java.util.ArrayList;

public class Top50FindSingleASCIIFromInputStream {
    int[] occurrence;
    int index;

    private Top50FindSingleASCIIFromInputStream() {
        index = 0;
        occurrence = new int[256];
        for(int i=0;i<256;i++)
            occurrence[i] = -1;
    }

    private void insert(char c) {
        if(occurrence[c]==-1)
            occurrence[c] = index;
        else if(occurrence[c]>=0)
            occurrence[c] = -2;
        index++;
    }

    private char findFirst() {
        int minIndex = Integer.MAX_VALUE;
        char ch = '#';
        for(int i=0;i<256;i++) {
            if(occurrence[i]>=0 && occurrence[i]<minIndex) {
                ch = (char)i;
                minIndex = occurrence[i];
            }
        }
        return ch;
    }

    public static void main(String[] args) {
        Top50FindSingleASCIIFromInputStream demo = new Top50FindSingleASCIIFromInputStream();
        demo.insert('g');
        System.out.println(demo.findFirst());
        demo.insert('o');
        System.out.println(demo.findFirst());
        demo.insert('o');
        System.out.println(demo.findFirst());
        demo.insert('g');
        System.out.println(demo.findFirst());
        demo.insert('l');
        System.out.println(demo.findFirst());
        demo.insert('e');
        System.out.println(demo.findFirst());
    }
}
