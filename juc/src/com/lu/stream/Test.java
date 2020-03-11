package com.lu.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author 小卢
 */
public class Test {
    public static void main(String[] args) {
//        User u1 = new User(1, "a", 21);
//        User u2 = new User(2, "b", 22);
//        User u3 = new User(3, "c", 23);
//        User u4 = new User(4, "d", 24);
//        User u5 = new User(6, "e", 25);
//
//        List<User> users = Arrays.asList(u1, u2, u3, u4, u5);
//        List<User> collect = users.stream().filter((user) -> user.getId() % 2 == 0).filter((user) -> user.getAge() > 23).map((user -> {
//            user.setName(user.getName().toUpperCase());
//            return user;
//        })).sorted((user1, user2) -> user2.getName().compareTo(user1.getName())).limit(1).collect(Collectors.toList());
////        System.out.println(collect);
//
//        Supplier<Integer> supplier = () -> 1024;
//        System.out.println(supplier.get());
//        Consumer<List<User>> tConsumer = users111 -> System.out.println(users111);
//        tConsumer.accept(collect);


        for (int i = 0; i < 10000; i++) {
            int tmp = i;
            new Thread(() -> System.out.println(tmp)).start();
        }
    }

}
