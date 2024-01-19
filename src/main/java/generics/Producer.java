package generics;

import java.util.Collection;

public class Producer {
    public void update(Collection<? extends String> ids) {
        ids.forEach(System.out::println);
    }
}
