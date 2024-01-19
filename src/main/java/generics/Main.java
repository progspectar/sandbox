package generics;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

        Deque<Integer> ints = new MyStack<>();
        ints.push(1);
        ints.push(2);
        ints.push(3);

    }
}
