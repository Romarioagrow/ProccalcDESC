package app;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        boolean same = false, different = false;

        double stavka = 0.833331; //%
        double sum = 0; // Итоговый результат
        double procent, profit, budjet = 0;

        int vnesti = 0; // Внести в месяц

        int period;

        System.out.println("Сумма одинаковая или разнная?\n1 - одинаковая; 2 - разная");
        char choice = inp.next().charAt(0);

        switch (choice) {
            case '1':
                same = true;
                System.out.println("Вносим одинаковую сумму...");
                break;
            case '2':
                different = true;
                System.out.println("Вносим разную сумму...");
                break;
            default:System.out.println("0");
        }

        System.out.println("На сколько месяцев?");
        period = inp.nextInt();

        if (same) {
            System.out.println("Введите сумму на весь срок:");
            vnesti = inp.nextInt();
        }

        for (int i = 1; i <= period; i++) {
            if (different) {
                System.out.println("Введите сумму за месяц " + i + ":");
                vnesti = inp.nextInt();
            }

            budjet += vnesti;
            sum += vnesti;
            procent = (sum/100)*stavka;
            sum += procent;

            System.out.println("На месяц " + i + " сумма составляет: " + (double) Math.round(sum * 100) /100);

            profit = sum - budjet;
            System.out.println("Профит на месяц " + i + ": " + (double) Math.round(profit * 100) /100);

            System.out.println("Внесено средств: " + (double) Math.round(budjet * 100) /100 + "\n");
        }

        profit = sum - budjet;

        double procentprof = ((budjet / sum) * 100) - 100;

        System.out.println("\nИТОГО за " + period + " месяцев");
        System.out.println("Затраченная сумма: " + budjet);
        System.out.println("Итоговая сумма: " + (double) Math.round(sum * 100) /100);
        System.out.println("Профит за полный срок: " + (double) Math.round(profit * 100) /100);
        System.out.println("Эффективная процентная ставка: " + (double) Math.round(Math.abs(procentprof) * 100) /100 + "%");
    }
}

// Эффективаная процентная ставка, сколько % прибыли от внесенной за год. полученный профит от внесенной ссумы