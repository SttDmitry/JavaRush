package com.example.http;

import com.example.http.entities.Cat;
import com.example.http.entities.Dog;
import com.example.http.entities.Fish;
import com.example.http.entities.Women;

import javax.swing.text.DateFormatter;
import java.awt.*;
import java.text.DateFormat;
import java.text.Format;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String name1= "1";
        String name2= "2";
        String name3= "3";

        String whoIWannaBe = "Когда я вырасту, то хочу быть паровым экскаватором!";
        for (int i=0;i<10;i++) {
            System.out.println(whoIWannaBe);
        }

        int[] values = new int[]{800, 1500, 2200, 2700, 3200};

        for (int value : values) {
            System.out.printf("Я согласен на зарплату $%d/месяц в первый год.\n", value);
        }

        String robotSpeech = "Слава Роботам! Убить всех человеков!";
        for (int i=0;i<16;i++) {
            System.out.println(robotSpeech);
        }

        Cat cat1 = new Cat("Meow");
        Cat cat2 = new Cat("Kitty");

        Dog dog1 = new Dog("Max");
        Dog dog2 = new Dog("Bella");
        Dog dog3 = new Dog("Jack");

        System.out.println("-------------------------------------\n 2 урок JavaRush");

        Cat cat3 = new Cat("");
        Cat cat4 = new Cat("");
        Cat cat5 = new Cat("");
        Cat cat6 = new Cat("");
        Cat cat7 = new Cat("");
        Cat cat8 = new Cat("");
        Cat cat9;
        Cat cat10;



        Women owner = new Women("Alice", "Eve");

        Fish fish1 = new Fish("Shark");

        cat1.setOwner(owner);
        dog1.setOwner(owner);
        fish1.setOwner(owner);

        System.out.println(getMinFour(1,2,3,4));

        System.out.println("-------------------------------------\n 3 урок JavaRush");

        Calendar calendar = new GregorianCalendar();

        calendar.set(1998, Calendar.AUGUST, 1);

        Date date = new Date(calendar.getTimeInMillis());

        System.out.println(DateFormat.getDateInstance(DateFormat.LONG, Locale.US).format(date)+"\n");

        int multi = 1;
        for (int i=2; i<=10; i++) {
            multi*=i;
        }
        System.out.println(multi);

        int sum = 0;
        for (int i=1; i<=10; i++) {
            sum+=i;
            System.out.println(sum);
        }



        String[] names = new String[]{"Мама", "Мыла", "Раму"};
        for (int i=0;i<names.length;i++) {
            String name = names[i];
            StringBuilder sb = new StringBuilder("");
            for (int j=0;j<names.length;j++) {
                if (i!=j) {
                    sb.append(names[j]);
                }
            }
            System.out.println(name+sb);
            sb.setLength(0);
            for (int j=names.length-1;j>-1;j--) {
                if (i!=j) {
                    sb.append(names[j]);
                }
            }
            System.out.println(name+sb);
        }

        int max = 10;

        for (int i=1; i<=max; i++ ) {
            for (int j=1; j<=max; j++) {
                System.out.printf("%3d ", i*j);
            }
            System.out.println("\n");
        }

        Color color1 = Color.RED;
        Color color2 = Color.ORANGE;
        Color color3 = Color.YELLOW;
        Color color4 = Color.GREEN;
        Color color5 = Color.BLUE;
        Color color6 = Color.PINK.brighter();
        Color color7 = Color.PINK.darker();

        System.out.println(color1 + ", " + color2 + ", " +  color3 + ", " +  color4 + ", " +  color5 + ", " +  color6 + ", " +  color7);

        System.out.println("It's Windows path: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\"");
        System.out.println("It's Java string: \\\"C:\\\\Program Files\\\\Java\\\\jdk1.7.0\\\\bin\\\"");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = scanner.nextInt();


        System.out.printf("%s захватит мир через %d лет. Му-ха-ха!\n", name, age);

        int salary = Integer.parseInt(scanner.nextLine());

        System.out.printf("%s получает %d через %d лет.\n", name, age, salary);

        System.out.printf("%s зарабатывает $5,000. Ха-ха-ха!", name);

        String nameAnother = scanner.nextLine();

        System.out.printf("%s проспонсировал %s, и она стала известной певицей.", name, nameAnother);

        String jap = "日本語";
        System.out.println(jap);
    }

    public static int getMin(int a,int b) {
        return a > b ? b : a;
    }

    public static int getMax(int a,int b) {
        return a > b ? a : b;
    }

    public static int getMinThree(int a, int b, int c) {
        return a > b ? (b > c ? c : b) : (a > c ? c : a);
    }

    public static int getMinFour(int a, int b, int c, int d) {
        int minAB = getMin(a,b);
        int minCD = getMin(c,d);
        return minAB > minCD ? minCD : minAB ;
    }

}
