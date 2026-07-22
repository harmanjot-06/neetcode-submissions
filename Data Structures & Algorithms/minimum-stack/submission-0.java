class MinStack {

    Stack<Integer> mainst;
    Stack<Integer> otherst;
    Integer min = Integer.MIN_VALUE;

    public MinStack() {
        mainst = new Stack<>();
        otherst = new Stack<>();
    }
    
    public void push(int val) {
        mainst.push(val);
        otherst.push(otherst.isEmpty() ? val : Math.min(val, otherst.peek()));
    }
    
    public void pop() {
        mainst.pop();
        otherst.pop();
    }
    
    public int top() {
        return mainst.peek();
    }
    
    public int getMin() {
        return otherst.peek();
    }
}
