     import java.util.*;
     import java.util.HashSet;
     public class DataStructures {
         /**
          * Java
          * Datenstrukturen
          * Aufgabe - Mengenlehre
          * Gegeben sind drei Zahlenmengen A, B, C - realisiert als Arrays vom Typ Integer:
          * A = { 49, 30, 14, 47, 13, 2, 12, 29, 19, 11, 15, 39, 43, 45, 34 }
          * B = { 39, 33, 38, 14, 4, 32, 40, 25, 17, 46, 35, 6, 2, 12, 49 }
          * C = { 41, 12, 5, 35, 42, 28, 47, 20, 26, 24, 50, 40, 14, 17, 10 }
          * Berechne möglichst effizient die Vereinigungsmenge von A ∪ B ∪ C sowie alle möglichen Schnittmengen und Differenzmengen der drei Zahlenmengen.
          **/


         public static void main(String[] args) {
                                              //creating the arrays
             HashSet<Integer> A = new HashSet<>(Arrays.asList(49, 30, 14, 47, 13, 2, 12, 29, 19, 11, 15, 39, 43, 45, 34));
             HashSet<Integer> B = new HashSet<>(Arrays.asList(39, 33, 38, 14, 4, 32, 40, 25, 17, 46, 35, 6, 2, 12, 49));
             HashSet<Integer> C = new HashSet<>(Arrays.asList(41, 12, 5, 35, 42, 28, 47, 20, 26, 24, 50, 40, 14, 17, 10));
                                                  //retrieve all Methods
             System.out.println(intersection(A, B, C));
             System.out.println(union(A, B, C));
             System.out.println(difference(A, B, C));
         }

     /** METHOD INTERSECTION
          *
          * @param A are defined in the "main method" as an HashSet from the type <Integer>
          * @param B are defined in the "main method" as an HashSet from the type <Integer>
          * @param C are defined in the "main method" as an HashSet from the type <Integer>
          * @param <T> is called as a "Generic Type" which can be any class in which it will be defined. In this case T is an HashSet type.
          * @return setIntersect returns the new created array within this method
          */
             public static <T>Set<T> intersection(Set<T> A, Set<T> B, Set<T> C) {
             HashSet<T> setIntersect = new HashSet<T>();

             for (T t : A) {                            //t as A
                 if (B.contains(t) && C.contains(t)) {  //checks if B or C have an intersection
                     setIntersect.add(t);              // if yes puts the value in the new array
                 }
             }
             return setIntersect;                       //return the new array
         }

     /** METHOD DIFFERENCE AMOUNT
          *
          * @param <T> is called as a "Generic Type" which can be any class in which it will be defined. In this case T is an ArraHashSetyList type.
          * @param A are defined in the "main method" as an HashSet from the type <Integer>
          * @param B are defined in the "main method" as an HashSet from the type <Integer>
          * @param C are defined in the "main method" as an HashSet from the type <Integer>
          * @return setDiff returns the new created array within this method
          */
         public static <T>Set<T> difference(Set<T> A, Set<T> B, Set<T> C) {
             HashSet<T> setDiff = new HashSet<>();

             for (T t : A) {                                //t as A
                 if (!B.contains(t) && !C.contains(t)) {    //checks if B or C have a diff in it
                     setDiff.add(t);                       //if yes puts the value in the new array
                 }
             }
             return setDiff;                               // returns the new array
         }

         /** METHOD UNION
          *
          * @param A are defined in the "main method" as an HashSet from the type <Integer>
          * @param B are defined in the "main method" as an HashSet from the type <Integer>
          * @param C are defined in the "main method" as an HashSet from the type <Integer>
          * @param <T> is called as a "Generic Type" which can be any class in which it will be defined. In this case T is an HashSet type.
          * @return
          */
         public static  <T>Set<T> union(Set<T> A, Set<T> B, Set<T> C) {
             HashSet<T> set = new HashSet<T>();

             set.addAll(A);             //union all array
             set.addAll(B);
             set.addAll(C);

             return set;       //returns it






         }
     }
