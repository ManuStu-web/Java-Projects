//This is the code for calculator using java

package Projects;

import java.util.*;

public class Calculator {
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║          CALCULATOR          ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1. Addition                  ║");
            System.out.println("║ 2. Subtraction               ║");
            System.out.println("║ 3. Multiplication            ║");
            System.out.println("║ 4. Division                  ║");
            System.out.println("║ 5. Power                     ║");
            System.out.println("║ 6. Square Root               ║");
            System.out.println("║ 7. Factorial                 ║");
            System.out.println("║ 8. Exit                      ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.println("Enter the choice");
            int choice = in.nextInt();

            switch (choice) 
            {
                case 1:
                    basic_op(in,"+" );
                    break;

                case 2:
                    basic_op(in,"-");
                    break;

                case 3:
                    basic_op(in,"*");
                    break;

                case 4:
                    basic_op(in,"/");
                    break;

                case 5:
                    basic_op(in, "^");
                    break;

                case 6:
                    adv_op(in,"√");
                    break;

                case 7:
                    adv_op(in,"!");
                    break;

                case 8:
                    {
                      System.out.println("╔══════════════════════════════╗");
                      System.out.println("║      !!  GOOD BYE  !!        ║");
                      System.out.println("╚══════════════════════════════╝");  
                      break;
                    }

                default: 
                {
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║        INVALID CHOICE        ║");
                    System.out.println("╚══════════════════════════════╝");
                    break;
                }

            }
        }

    public static void basic_op(Scanner in,String symb) 
    {
        System.out.print("1st Number = ");
        double num1 = in.nextDouble();
        System.out.print("2nd Number = ");
        double num2 = in.nextDouble();
        double ans;
       switch (symb) {
        case "+":
            {
             ans = num1+num2;
             printanswer("Addition" , String.valueOf(ans));
             break;
            }
        case "-":
            {
             ans = num1-num2;
             printanswer("Subtraction" , String.valueOf(ans));
             break;
            }
        case "*":
            {
             ans = num1*num2;
             printanswer("Multiplication" , String.valueOf(ans));
             break;
            }
        case "/":
            {
             ans = num1/num2;
             printanswer("Division" , String.valueOf(ans));
             break;
            }
        case "^":
            {
             ans = Math.pow(num1, num2);
             printanswer("Power" , String.valueOf(ans));
             break;
            }
        default:
            break;
       }

    }

    public static void adv_op(Scanner in,String symb) 
    {
        System.out.print("1st Number = ");
        double num = in.nextDouble();
        double ans=1;
       switch (symb) {
        case "!":
            {
             for(int i=2;i<=num;i++)
             {
               ans=ans*i;
             }
             printanswer("Factorial" , String.valueOf(ans));
             break;
            }
        case "√":
            {
             ans = Math.sqrt(num);
             printanswer("Square root" , String.valueOf(ans));
             break;
            }
        default:
            break;
       }
    }

    public static void printanswer(String label , String ans)
    {
        int boxwidth = 30;
        String content = label + " : " + ans;
        int padding=(boxwidth - content.length()-2);
        int left = padding/2;
        int right = padding - left+2;

        System.out.println("╔" + "═".repeat(boxwidth) + "╗");
        System.out.println("║" + " ".repeat(left) + content + " ".repeat(right) + "║");
        System.out.println("╚" + "═".repeat(boxwidth) + "╝");


    }
}
