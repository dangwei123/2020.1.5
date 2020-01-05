设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-stack
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class MinStack {
class Node{
    private int data;
    private int min;
    public Node(int data,int min){
        this.data=data;
        this.min=min;
    }
}
    private Stack<Node> stack;
    private int size;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack();
        this.size=0;
    }
    
    public void push(int x) {
        if(stack.empty()){
            Node node=new Node(x,x);
            stack.push(node);
        }else{
            Node node=new Node(x,Math.min(x,stack.peek().min));
            stack.push(node);
        }
        size++;
    }
    
    public void pop() {
        stack.pop();
        size--;
    }
    
    public int top() {
        return stack.peek().data;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
 
 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。

循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。

你的实现应该支持如下操作：

MyCircularQueue(k): 构造器，设置队列长度为 k 。
Front: 从队首获取元素。如果队列为空，返回 -1 。
Rear: 获取队尾元素。如果队列为空，返回 -1 。
enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
isEmpty(): 检查循环队列是否为空。
isFull(): 检查循环队列是否已满。
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/design-circular-queue
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class MyCircularQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        arr=new int[k];
        capacity=k;
        front=0;
        rear=0;
        size=0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(size==capacity){
            return false;
        }
        arr[rear]=value;
        rear=(rear+1)%capacity;
        size++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size==0){
            return false;
        }
        front=(front+1)%capacity;
        size--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(size==0)
        return -1;
        return arr[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(size==0)
        return -1;
        return arr[(rear-1+capacity)%capacity];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
 
 