package ex1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Database {


    public static void main(String args[]){

       List<Person> db = Person.createShortList();

        // select * from person where age >3

       // System.out.println(db.stream().filter(p->p.getAge()>3).collect(Collectors.toList()));

        Predicate<Person> query1= (Person p)->p.getAge()>30;
        System.out.println(select(db,Query.ALL,query1));

        System.out.println(select(db,Query.MAX,query1));


        System.out.println(select2(db,Query.ALL,query1,(p1, p2) -> p2.getSurName().compareTo(p1.getSurName())));

        System.out.println(select2(db,Query.MAX,query1,(p1, p2) -> Integer.compare(p2.getAge(),p1.getAge())));

    }

    public static List<Person> select(List<Person> table, Query type, Predicate<Person> where){
        Stream<Person> result1 = table.stream().filter(where);
        List<Person> result = null;
        switch (type){
            case ALL->  result = result1.collect(Collectors.toList());
            case MAX -> result = result1.max((Person p1, Person p2) -> p1.getSurName().compareTo(p2.getSurName())).stream().toList();
        }
        return result;
     }



    public  static <T> List<T> select2(List<T> table, Query type, Predicate<T> where, Comparator<T> orderBy){
        Stream<T> result1 = table.stream().filter(where);
        List<T> result = null;
        switch (type){
            case ALL->  result = result1.sorted(orderBy).collect(Collectors.toList());
            case MAX -> result = result1.max(orderBy).stream().toList();
        }
        return result;
    }





}

