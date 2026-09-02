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
            return null;
        } else {
            StringBuilder str = new StringBuilder();
            Node<E> currentNode = head;

            while(currentNode.getNext() != null) {
                str.append(currentNode.getElement());
                currentNode = currentNode.getNext();
            }
            str.append(currentNode.getElement());
            return str.toString();
        }
    }

    public E removeLast(){
        if (head == null) {
            return null;

        } else if (head.getNext() == null) {
            E removed = head.getElement();
            head = null;
            size--;
            return removed;

        } else {
            Node<E> prevNode = head;
            Node<E> currentNode = head.getNext();
            
            while (currentNode.getNext() != null) { 
                prevNode = currentNode;
                currentNode = currentNode.getNext();
            }

            prevNode.setNext(null);
            tail = prevNode;
            size--;
            return currentNode.getElement();
        }
    }

    public void reverse(){       
        if (head != null || size == 0) {
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
    