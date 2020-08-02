public class Main {
    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 5; i ++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        // Add element by index
        linkedList.add(2, 888);
        System.out.println(linkedList);

        // Update element
        linkedList.set(2, 666);
        System.out.println(linkedList);

        // check contains
        System.out.println(linkedList.contains(666));

        System.out.println("Program running is ok !");
    }
}
