public class DLLNode {

    private Integer value;
    private DLLNode prev;
    private DLLNode next;

    public DLLNode(Integer value, DLLNode prev, DLLNode next){
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public DLLNode getPrev() {
        return prev;
    }

    public void setPrev(DLLNode prev) {
        this.prev = prev;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }
}
