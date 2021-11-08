public class DoublyLinkedList {

    private DLLNode header;
    private  DLLNode trailer;
    private int size;

    public DoublyLinkedList(){
        header = new DLLNode(null,null,null);
        trailer = new DLLNode(null,header,null);
        header.setNext(trailer);
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Integer first(){
        if(isEmpty()){
            return null;
        }
        return header.getNext().getValue();
    }

    public Integer last(){
        if(isEmpty()){
            return null;
        }
        return trailer.getPrev().getValue();
    }

    public void addFirst(Integer value){
        addBetween(value,header,header.getNext());
    }

    public void addLast(Integer value){
        addBetween(value,trailer.getPrev(),trailer);
    }

            private void addBetween(Integer value, DLLNode predecessor, DLLNode successor){
                DLLNode newest = new DLLNode(value,predecessor,successor);
                predecessor.setNext(newest);
                successor.setPrev(newest);
                size++;
            }

    public Integer removeFirst(){
        if (isEmpty()){
            return null;
        }
        return remove(header.getNext());
    }

    public Integer removeLast(){
        if (isEmpty()){
            return null;
        }
        return remove(trailer.getPrev());
    }

            private Integer remove(DLLNode node) {
                DLLNode predecessor = node.getPrev();
                DLLNode successor = node.getNext();

                predecessor.setNext(successor);
                successor.setPrev(predecessor);
                size--;
                return node.getValue();
            }

    public void printList(){
        if (isEmpty()){
            System.out.println("List is Empty!");
        }else{
            System.out.println("New list: ");

            DLLNode start = header.getNext();

            while(start != trailer){
                System.out.println(start.getValue() + " ");

                start = start.getNext();
            }
            System.out.println("\nThe size of the list: " + size);
        }
    }

}
