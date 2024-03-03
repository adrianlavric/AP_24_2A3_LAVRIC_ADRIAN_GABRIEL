package lab1;

/**
 *
 * @author Lavric Adrian-Gabriel
 */


public class Lab1 {

    public static void main(String[] args) {
        Lab1 lab1 = new Lab1();
        lab1.compulsory();

    }

    public void compulsory() {
        System.out.println("Hello World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);

        int result = n * 3;
        result += Integer.parseInt("10101", 2);
        result += Integer.parseInt("FF", 16);
        result *= 6;

        int sumCif = 0;
        while(result > 0 || sumCif > 9) {

            if(result == 0) {

                result = sumCif;
                sumCif = 0;

            }

            sumCif += result % 10;
            result /= 10;

        }

        result = sumCif;

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
    void homework() {



    }
    void bonus() {

    }

}
