import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Array arr = new Array(20);
        for(int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        arr.addFirst(-1);

        arr.set(5, 97);
        System.out.println(arr);

        // remove index 5
        arr.remove(5);

        System.out.println(arr);

        // find index
        System.out.println(arr.find(8));

        // remove element with array
        arr.removeElement(8);
        System.out.println(arr);

        System.out.println("everything is ok!");
    }
}
