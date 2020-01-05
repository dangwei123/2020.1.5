给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else{
                if(stack.empty()){
                    return false;
                }
                char tmp=stack.pop();
                if((tmp=='('&&c==')')||(tmp=='['&&c==']')||(tmp=='{'&&c=='}')){

                }else{
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
}


使用栈实现队列的下列操作：

push(x) -- 将一个元素放入队列的尾部。
pop() -- 从队列首部移除元素。
peek() -- 返回队列首部的元素。
empty() -- 返回队列是否为空。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int size;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1=new Stack();
        s2=new Stack();
        this.size=0;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
        size++;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.empty()){
            while(!s1.empty()){
               s2.push(s1.pop());
            } 
        }
        size--;
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(s2.empty()){
            while(!s1.empty()){
               s2.push(s1.pop());
            } 
        }
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty()&&s2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
 
 
 
 使用队列实现栈的下列操作：

push(x) -- 元素 x 入栈
pop() -- 移除栈顶元素
top() -- 获取栈顶元素
empty() -- 返回栈是否为空
注意:

你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-stack-using-queues
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int size;
    /** Initialize your data structure here. */
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
        this.size=0;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
        size++;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int i=size-1;
        while(i!=0){
            q2.offer(q1.poll());
            i--;
        }
        int top=q1.poll();
        size--;
        Queue<Integer> tmp=q1;
        q1=q2;
        q2=tmp;
        return top;
    }
    
    /** Get the top element. */
    public int top() {
        int i=size-1;
        while(i!=0){
            q2.offer(q1.poll());
            i--;
        }
        int top=q1.peek();
        q2.offer(q1.poll());
        Queue<Integer> tmp=q1;
        q1=q2;
        q2=tmp;
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
 
 
 