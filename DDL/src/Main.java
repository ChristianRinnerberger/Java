public class Main {
    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();

        dll.addFirst(1);
        dll.addFirst(10);
        dll.addLast(25);
        dll.printList();

        dll.addLast(50);
        dll.removeFirst();
        dll.printList();

        dll.removeFirst();
        dll.removeFirst();


        dll.removeFirst();
        dll.addFirst(1);
        dll.getSize();
        dll.printList();

    }
}
