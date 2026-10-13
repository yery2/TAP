package ex1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by pedro on 9/21/15.
 */
public class Tokens {

    public static void main(String[] args) throws IOException {

        FileReader fis = new FileReader("accounts.txt");
        BufferedReader dis = new BufferedReader(fis);
        String line;

        List<Account> list = new LinkedList<>();

        while ((line = dis.readLine()) != null) {
           StringTokenizer tokens = new StringTokenizer(line, ",");
            while (tokens.hasMoreTokens()) {
                Account c = new Account(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), Double.parseDouble(tokens.nextToken()));
                list.add(c);
            }
        }

        dis.close();

        // select name from Account where balance > 3000
        Predicate<Account> query1 = (Account a) -> a.getBalance() > 3000;
        System.out.println("select name from Account where balance > 3000");
        select(list, Account::getName, query1)
                .forEach(System.out::println);
        System.out.println();

        // select balance from Account where balance > 3000
        System.out.println("select balance from Account where balance > 3000");
        select2(list, Account::getBalance, query1)
                .forEach(System.out::println);
        System.out.println();

        // select * from Account
        System.out.println("select * from Account");
        select2(list, a->a, _->true)
                .forEach(System.out::println);
        System.out.println();

        // select type from Account
        System.out.println("select type from Account");
        select2(list, Account::getType, _->true)
                .forEach(System.out::println);
        System.out.println();

        // select id, name, balance from Account where type=IF
        System.out.println("select id, name, balance from Account where type=IF");
        select2(list, a -> Arrays.asList(a.getId(), a.getName(), a.getBalance()), p->p.getType()==AccType.IF)
                .forEach(System.out::println);
        System.out.println();

        // select name from Account order by name
        System.out.println("select name from Account order by name");
        select3(list, Account::getName, _->true, String::compareTo)
                .forEach(System.out::println);
        System.out.println();

        // select * from Account order by balance
        System.out.println("select * from Account order by balance");
        select3(list, Function.identity(), _->true, (a1, a2) -> (int) Math.floor(a1.getBalance() - a2.getBalance()))
                .forEach(System.out::println);


    }

    public static List<String> select(List<Account> table, Function<Account, String> function, Predicate<Account> where) {
        return table.stream().filter(where).map(function).toList();
    }

    public static <T> List<T> select2(List<Account> table, Function<Account, T> function, Predicate<Account> where) {
        return table.stream().filter(where).map(function).toList();
    }

    public static <T> List<T> select3(List<Account> table, Function<Account, T> function, Predicate<Account> where, Comparator<T> cmp) {
        return table.stream().filter(where).map(function).sorted(cmp).toList();
    }
}
