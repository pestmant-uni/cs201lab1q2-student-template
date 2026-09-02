

public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString(){
        if (head == null) {
            return "";
        } else {
            StringBuilder str = new StringBuilder();
            Node<E> curr = head;

            while(curr != tail) {
                str.append(curr.getElement());
                curr = curr.getNext();
            }
            str.append(curr.getElement());
            return str.toString();
        }
    }

    public E removeLast(){
        if (head == null) {
            return null;

        } else if (head == tail) {
            E removed = head.getElement();
            head = null;
            tail = null;
            size--;
            return removed;

        } else {
            Node<E> curr = head;
            
            while (curr.getNext() != tail) { 
                curr = curr.getNext();
            }

            E removed = curr.getElement();
            tail = curr;
            size--;

            if (isEmpty()) {
                return null;
            }
            return removed;
        }
    }

    public void reverse(){       
        if (head != null) {
            Node<E> prev = null;
            Node<E> curr = head;
            Node<E> next = head.getNext();
            
            head = tail;
            tail = curr;

            while (curr != null) {
                next = curr.getNext();
                curr.setNext(prev);
                prev = curr;
                curr = next;
            }
        }
    }
}
    