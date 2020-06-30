// leetcode problem link https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
public class CQueue {

    private final Stack appendStack;
    private final Stack deleteStack;

    public CQueue() {
        this.appendStack = new Stack();
        this.deleteStack = new Stack();
    }
    
    public void appendTail(int value) {
        appendStack.push(new Node(value));
    }
    
    public int deleteHead() {
        if(deleteStack.isEmpty()) {
            if(appendStack.isEmpty()) {
                return -1;
            } else {
                while(!appendStack.isEmpty()) {
                    deleteStack.push(appendStack.pop());
                }
            }
        } 
        return deleteStack.pop().value;
    }

    protected class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    protected class Stack {
        Node top;
        public void push(Node node) {
            node.next = top;
            top = node;
        }
        public Node pop() {
            if (top == null) {
                return null;
            }
            Node result = top;
            top = top.next;
            return result;
        }
        public boolean isEmpty() {
            return top == null;
        }
    }
}