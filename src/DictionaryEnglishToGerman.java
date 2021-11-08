import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryEnglishToGerman {

    /**
     * Java
     * Datenstrukturen
     * Aufgabe - Wörterbuch: Deutsch - Englisch
     * Erstelle ein Programm welches ein Wörterbuch zum Übersetzen von Wörtern zwischen Englisch und Deutsch implementiert
     * (bi-direktional). Es soll folgende Funktionalitäten umfassen:
     * - Hinzufügen eines neuen Wort-Paars (Englisch und Deutsch)
     * Entfernen eines Wort-Paars aus dem Wörterbuch
     * Übersetzen eines Wortes (Deutsch oder Englisch) in die jeweilig andere Sprache
     **/

    public static void main(String[] args)
    {
        String a, b;

        Map<String, String> gerEngDictionary = new HashMap<>();
        gerEngDictionary.put("Montag", "Monday");
        gerEngDictionary.put("Dienstag", "Tuesday");
        gerEngDictionary.put("Mittwoch", "Wednesday");
        gerEngDictionary.put("Donnerstag", "Thursday");
        gerEngDictionary.put("Freitag", "Friday");

        Map<String, String> engGerDictionary = new HashMap<>();
        engGerDictionary.put("Monday", "Montag");
        engGerDictionary.put("Tuesday", "Dienstag");
        engGerDictionary.put("Wednesday", "Mittwoch");
        engGerDictionary.put("Thursday", "Donnerstag");
        engGerDictionary.put("Friday", "Freitag");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Was möchten Sie tun? \n Geben Sie '1' für insert, '2' für delete oder '3' für englische Übersetzung oder '4' für deutsche Übersetzung ein ");
        int input = scanner.nextInt();


        if (input == 1)
        {
            System.out.println("Wie viele Wortpaare möchten Sie hinzufügen");
            int n = scanner.nextInt();
            System.out.println("Geben Sie das deutsche Wort ein, betätigen Sie die Space taste und geben sie das englische Wort ein. Bestätigen Sie mit Enter");
            for (int i = 0; i < n; i++)
            {
                a = scanner.next();
                b = scanner.next();
                gerEngDictionary.put(a, b);
                engGerDictionary.put(b, a);
                System.out.println(gerEngDictionary);
                System.out.println(engGerDictionary);
            }
            scanner.close();


        }
        else if (input == 2)
        {
            System.out.println("Wie viele Wortpaare möchten Sie entfernen?");
            int n = scanner.nextInt();
            System.out.println("Geben Sie das Wortpaar ein, welches Sie löschen möchten.");
            for (int i = 0; i < n; i++)
            {
                a = scanner.next();
                b = scanner.next();
                gerEngDictionary.remove(a, b);
                engGerDictionary.remove(b, a);
                System.out.println(gerEngDictionary);
                System.out.println(engGerDictionary);
            }
            scanner.close();

        }
        else if (input == 3)
        {
            System.out.println("Geben Sie das zu übersetzende deutsche Wort ein");
            Scanner scanner_1 = new Scanner(System.in);
            String eingabe = scanner_1.nextLine();
            scanner_1.close();
            String ausgabe = gerEngDictionary.get(eingabe);
            System.out.println(ausgabe);
        }
        else if (input == 4)
        {
            System.out.println("Geben sie das zu übersetzende englische Wort ein");
            Scanner scanner_2 = new Scanner(System.in);
            String eingabe_1 = scanner_2.nextLine();
            scanner_2.close();
            String ausgabe_1 = engGerDictionary.get(eingabe_1);
            System.out.println(ausgabe_1);
            scanner_2.close();
        }
        else
        {
            System.out.println("Falsche Eingabe");
        }

    }
}
