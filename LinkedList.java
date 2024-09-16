public class LinkedList {
    int size;
        public class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this .next=null;
        
        }
    }
    private Node  head;
    LinkedList(){
    this.head=null; 
    }
public void InsertAtStart(int data){
Node newNode= new Node(data);
newNode.next = head;
head = newNode;
}

  
 public void InsertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
   public void addAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
           InsertAtStart(data);
        } else if (position == size) {
            InsertAtEnd(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }
 public void deleteFromStart() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            head = head.next;
            size--;
        }
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head.next == null) {
            head = null;
            size--;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
            size--;
        }
    }

    public void deleteByValue(int data) {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head.data == data) {
            head = head.next;
            size--;
        } else {
            Node current = head;
            while (current.next != null) {
                if (current.next.data == data) {
                    current.next = current.next.next;
                    size--;
                    return;
                }
                current = current.next;
            }
            System.out.println("Value not found");
        }
    }
 public void search(int value) {
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.data == value) {
                System.out.println("Value found at position " + position);
                return;
            }
            current = current.next;
            position++;
        }
        System.out.println("Value not found");
    }
     public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

 
    public int length() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
  public void display(){
    Node current =head;
    
       while(current !=null){
        System.out.print(current.data+"  :");
       current= current.next;
    }
        System.out.println("Null");
    
    } 
    public int countNodes() {
        return size;
    }

  

public static void main(String args[]){
LinkedList list = new LinkedList();
 // Insert nodes at start and end
        list.InsertAtStart(10);
        list.InsertAtEnd(20);
        list.InsertAtStart(5);
        list.InsertAtEnd(30);

        System.out.println("Initial List:");
        list.display();

        // Insert nodes at specific positions
        list.addAtPosition(15, 2);
        list.addAtPosition(25, 4);

        System.out.println("After insertion:");
        list.display();

        // Delete nodes from start and end
        list.deleteFromStart();
        list.deleteFromEnd();

        System.out.println("After deletion:");
        list.display();

        // Search for values
        list.search(15);
        list.search(35);

        // Reverse the list
        list.reverse();

        System.out.println("Reversed List:");
        list.display();
        
           // Count nodes
        System.out.println("Number of nodes: " + list.countNodes());



}
    
}
