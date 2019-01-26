package Chapter1.Section3;

import java.util.Stack;

// TODO: 添加测试用例测试
public class Buff {

    Stack<Character> lft = new Stack<>();
    Stack<Character> rgt = new Stack<>();


    public Buff() {
    }

    void insert(char c) {
        lft.push(c);
    }

    char delete() {
        return lft.pop();
    }

    void left(int k) {
        for (int i=0; i<k; i++) {
            rgt.push(lft.pop());
        }
    }

    void right(int k) {
        lft.push(rgt.pop());
    }

    int size() {
        return lft.size() + rgt.size();
    }

}
