import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String finalResult = "Некорректные данные";
        String InputExpression;

        Scanner scanner = new Scanner(System.in);

       System.out.println("Введите пример");
       InputExpression = scanner.nextLine();
       String arg1String;
       String arg2String;
       String operator;

       String[] arrayArg1 = new String[3];

       // Получение корректных аргументов
       arrayArg1 = (Arguments.dissolution(InputExpression));

       arg1String = arrayArg1[0];
       arg2String = arrayArg1[1];
       operator = arrayArg1[2];

       switch (operator) {
            case "+":
                finalResult = Adder.add1(arg1String, arg2String);
            break;

            case "*":
                finalResult = Multiplier.mult1(arg1String, arg2String);
            break;

            case "-":
                finalResult = Substructor.sub1(arg1String, arg2String);
            break;

            case "/":
                finalResult = Divider.div1(arg1String, arg2String);
            break;
            default:
                try {
                    throw new MyExeption("Некорректные данные");
                } catch (MyExeption e) {
                    System.err.println(e.getMessage());
                    System.exit(0);
                }
        }

        // Вывод результата
        System.out.println(finalResult);
    }
}
