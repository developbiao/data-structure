import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Test count novel words
//         countNovelWordsWithBST();
        // countNovelWordsWithLinkedList();

        benchMarkSet();

        System.out.println("Programing Running is ok!");
    }

    private static void countNovelWordsWithBST() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for(String word: words1) {
                set1.add(word);
            }
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            BSTSet<String> set2 = new BSTSet<>();
            for(String word: words2) {
                set2.add(word);
            }
            System.out.println("Total different words: " + set2.getSize());
        }

        System.out.println();

    }

    private static void countNovelWordsWithLinkedList() {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            LinkedListSet<String> set1 = new LinkedListSet<>();

            for(String word: words1) {
                set1.add(word);
            }
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            LinkedListSet<String> set2 = new LinkedListSet<>();
            for(String word: words2) {
                set2.add(word);
            }
            System.out.println("Total different words: " + set2.getSize());
        }

        System.out.println();

    }

    private static void benchMarkSet(){

        String filename = "pride-and-prejudice.txt";
        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1  + " s");

        System.out.println();

        LinkedListSet<String> linkedSet = new LinkedListSet<>();
        double time2 = testSet(linkedSet, filename);
        System.out.println("LinkedList Set: " + time2  + " s");

    }

    private static double testSet(Set<String> set, String filename) {
        long startTime = System.nanoTime();
        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for(String word: words) {
                set.add(word);
            }
            System.out.println("Total different words: " + set.getSize());
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
