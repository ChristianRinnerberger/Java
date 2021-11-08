import org.w3c.dom.Node;

public class DDCList <ContentType>{

    Node<ContentType> head;
    Node<ContentType> tail;
    Node<ContentType> current;


    public DDCList(){
        head= new Node<ContentType>(null);
        tail= new Node<ContentType>(null);
        current = null;
    }
    public boolean isEmpty(){
        return head.getNext() == tail;
    }
    public boolean hasAccess(){
        return current != head && current != tail && current != null;
    }
    public void toFirst(){
        current = head.getNext();
    }
    public void toLast(){
        current = tail.getPrevious();
    }
    public void next(){
        current = current.getNext();
    }
    public void prev(){
        current = current.getPrevious();
    }
    public void setObject(ContentType content){
        if(hasAccess() && content != null){
            current.setObject(content);
        }
    }
    public ContentType getObject(){
        if (hasAccess()) {
            return current.getObject();
        }
        return null;
    }
    public void append(ContentType content){
    //1
        if(content != null){
            Node<ContentType> newNode = new Node<ContentType>(content);
            newNode.setNext(tail);
            newNode.setPrevious(tail.getPrevious());
            tail.getPrevious().setNext(newNode);
            tail.setPrevious(newNode);
        }
    }
    public void remove(){
    if(hasAccess()){
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        current = current.getNext;
    }
    }
    public void insertBefore(ContentType content){
        if(content != null){
            Node<ContentType> newNode = new Node<ContentType>(content);
            newNode.setNext(current);
            newNode.setPrevious(current.getPrevious());
            current.getPrevious().setNext(newNode);
            current.setPrevious(newNode);
        }
    }
    public void insertAfter(ContentType content){
        if(content != null){
            Node<ContentType> newNode = new Node<ContentType>(content);
            newNode.setNext(current.getNext);
            newNode.setPrevious(current);
            current.setNext(newNode);
            current.getPrevious().setPrevious(newNode);
        }
    }








}
