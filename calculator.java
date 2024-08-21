import java.util.Scanner;

public class calculator{
    public static void main(String args[]){
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter the number one");
    int number_1=sc.nextInt();
    System.out.println("Enter the number");
    int number_2=sc.nextInt();
    System.out.print("Enter the operator==> ");
    char operator=sc.next().charAt(0);
    switch(operator){
        case '+': System.out.println(number_1+number_2);
        break;
        case '-': System.out.println(number_1-number_2);
        break;

        case '*': System.out.println(number_1*number_2);
        break;

        case '/': System.out.println(number_1/number_2);
        break;

        case '%': System.out.println(number_1%number_2);
        break;

        default: System.out.println("operartor not found ");

    }

        }
    }
