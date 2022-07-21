import java.util.*;
/*
 * Permutations and Combinations
 * ONLY for DISTINCT CHARACTERS
 */

public class PermutationsCombinations {
    public static ArrayList<Character> availableCharacters(HashSet<Character> hashSet, String str) {
        ArrayList<Character> availableCharacters = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (!hashSet.contains(str.charAt(i))) availableCharacters.add(str.charAt(i));
        }

        return availableCharacters;
    }

    public static void permutations(String str) {
        HashSet<ArrayList<Character>> answer = new HashSet<>();

        ArrayDeque<ArrayList<Character>> arrayDeque = new ArrayDeque<>();
        // Empty set
        arrayDeque.add(new ArrayList<>());
        while (!arrayDeque.isEmpty()) {
            ArrayList<Character> arrayList = arrayDeque.poll();
            answer.add(arrayList);
            ArrayList<Character> chArr = availableCharacters(new HashSet<>(arrayList), str);
            for (char ch: chArr) {
                ArrayList<Character> temp = new ArrayList<>(arrayList);
                temp.add(ch);
                answer.add(temp);
                arrayDeque.add(temp);
            }
        }

        System.out.println("Count is " + answer.size());
        System.out.println(answer);
    }

    public static void combinations(String str) {
        HashSet<HashSet<Character>> answer = new HashSet<>();

        ArrayDeque<HashSet<Character>> arrayDeque = new ArrayDeque<>();
        // Empty set
        arrayDeque.add(new HashSet<>());
        while (!arrayDeque.isEmpty()) {
            HashSet<Character> hashSet = arrayDeque.poll();
            answer.add(hashSet);
            ArrayList<Character> chArr = availableCharacters(hashSet, str);
            for (char ch: chArr) {
                HashSet<Character> temp = new HashSet<>(hashSet);
                temp.add(ch);
                answer.add(temp);
                arrayDeque.add(temp);
            }
        }

        System.out.println("Count is " + answer.size());
        System.out.println(answer);
    }

    public static void main(String[] args) {
        System.out.println();
        String str = "abc";
        permutations(str);
        combinations(str);
        
        System.out.println();
        str = "abcd";
        permutations(str);
        combinations(str);
    }
}