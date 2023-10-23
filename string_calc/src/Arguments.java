public class Arguments {
    // Проверка входящей строки на корректность
    // Возврат корректных аргументов или выброс исключения


    // Допущение - символ """ ("двойная кавычка") внутри строковых аргументах является недопустимым
    // Таким образом переданная строка "Hel"lo " + "Wor"ld!" должна вызывать ошибку, а не результат "Hel"lo Wor"ld!"
    // Условия задачи не дают однозначного ответа о возможности использования символа двойных кавычек в строковых аргументах


    // Попробуем решить только строковыми методами, без переброса строки в массив символов

    public static String[] dissolution(String inputExpression) {
        String[] ArrayArg = new String[3];

        boolean expressionCorrect = true; // флаг корректного выражения
        int expressionLenght = inputExpression.length();

        // Длина выражения должна быть больше или равна 7 и меньше или равно 27.
        // Это следует из условия что максимальная
        // длина строкового аргумента на входе 10 символов.
        // Две строки максимальной длинны (10) с кавычками с двух сторон = 2*12=24
        // и оператор окруженный пробелами 3. Итого 27.
        // Минимальная длинна строки у выражения вида "a" * b.
        // строка минимальной длинны (1) с кавычками = 3, оператор окруженный пробелами = 3,
        // целочисленный аргумент (1..9) = 1. Итого 7

        if (expressionLenght >= 28 | expressionLenght <= 6) {
            expressionCorrect = false;
            //System.out.println("Общая длина выражения");
        }
        // Пробелы в начале или в конце выражения
        if (inputExpression.endsWith(" ") | inputExpression.startsWith(" ")) {
            expressionCorrect = false;
            //System.out.println("пробелы");
        }
        // Первый символ - не кавычка, т.е. первый аргумент не является корректной строкой.

        if (!inputExpression.startsWith("\"")) {
            expressionCorrect = false;
            //System.out.println("кавычка первая");
        }

        if (!expressionCorrect) {
            try {
                throw new MyExeption("Некорректные данные");
            } catch (MyExeption e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }
        }

        // Более чем двойной пробел до или после оператора, корректный оператор (+,-,*,/)

        int firstQuotationMarkIndex = inputExpression.indexOf('\"');
        int secondQuotationMarkIndex = inputExpression.indexOf('\"', 1);
        if (secondQuotationMarkIndex == 1) {
            expressionCorrect = false;
            //System.out.println("Пустой первый аргумент");
        }

        // Получение первого строкового аргумента

        //ArrayArg[0] = inputExpression.substring(0, secondQuotationMarkIndex+1);

        // System.out.println("Арг1 " + ArrayArg[0]);

        ArrayArg[0] = inputExpression.substring(1, secondQuotationMarkIndex);

        if (ArrayArg[0].length() > 10) {
            expressionCorrect = false;
            //System.out.println("Первый аргумент > 10");

        }

        // Получение кандидата на звание оператора
        String listValidOperators = "+-*/";
        String probablyOperator = inputExpression.substring(secondQuotationMarkIndex + 2, secondQuotationMarkIndex + 3);
        int k = listValidOperators.indexOf(probablyOperator);

        // Валидация и получение оператора
        switch (k) {
            case -1:
                expressionCorrect = false;
                System.out.println("Некорректный оператор");
                break;
            case 0:
                ArrayArg[2] = "+";
                break;
            case 1:
                ArrayArg[2] = "-";
                break;
            case 2:
                ArrayArg[2] = "*";
                break;
            case 3:
                ArrayArg[2] = "/";
                break;
            default:
                expressionCorrect = false;
        }


        //Оператор не обернут в пробелы
        if (!((inputExpression.substring(secondQuotationMarkIndex + 1, secondQuotationMarkIndex + 2).equals(" ")) &
                (inputExpression.substring(secondQuotationMarkIndex + 3, secondQuotationMarkIndex + 4).equals(" ")))) {
            //System.out.println("нет пробела");
            expressionCorrect = false;
        }

        if (!expressionCorrect) {
            try {
                throw new MyExeption("Некорректные данные");
            } catch (MyExeption e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }
        }

        // Лишние пробелы возле оператора
        if ((inputExpression.substring(secondQuotationMarkIndex, secondQuotationMarkIndex + 1).equals(" ")) |
                (inputExpression.substring(secondQuotationMarkIndex + 4, secondQuotationMarkIndex + 5).equals(" "))) {
            expressionCorrect = false;
            // System.out.println("лишний пробел");
        }

        System.out.println("Оператор " + ArrayArg[2]);

        // Получение второго аргумента

        ArrayArg[1] = inputExpression.substring(ArrayArg[0].length() + 5);
        System.out.println(ArrayArg[1] + " тест 1");


        if (!expressionCorrect) {
            try {
                throw new MyExeption("Некорректные данные");
            } catch (MyExeption e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }
        }

        boolean secondArgumentIsCorrectInt = false;
        boolean secondArgumentHasQuot = false;

        // Первый и последний символ аргумента2 - НЕ кавычки.
        if (!(ArrayArg[1].charAt(0) == '\"') & !(ArrayArg[1].charAt(ArrayArg[1].length() - 1) == '\"')) {
            secondArgumentHasQuot = false;
        }

        // Первый и последний символ аргумента2 - КАВЫЧКИ
        // Обрезаем кавычки
        if ((ArrayArg[1].charAt(0) == '\"') & (ArrayArg[1].charAt(ArrayArg[1].length() - 1) == '\"')) {
            secondArgumentHasQuot = true;
            ArrayArg[1] = ArrayArg[1].substring(1, ArrayArg[1].length() - 1);
        }

        // Проверка второй аргумент ненулевой
        if (ArrayArg[1].length() == 0) {

            expressionCorrect = false;
            // System.out.println("Пустой второй аргумент");
        }

        // Проверяем экзотику вида "Hello, " + " + ""World""
        if (ArrayArg[1].indexOf('\"') > 0) {
            expressionCorrect = false;
        }

        String l = "123456789";
        int p = l.indexOf(ArrayArg[1]);
        // System.out.println("вхождение аргумента " + p);

        if ((p >= 0 & (ArrayArg[1].length() == 1)) | ArrayArg[1].equals("10")) {

            secondArgumentIsCorrectInt = true;
        }
        // System.out.println("второй аргумент корректное число " + secondArgumentIsCorrectInt);

        // Проверка второго аргумента и соотнесение его с оператором

        if ((!secondArgumentHasQuot) & (!secondArgumentIsCorrectInt)) {
            expressionCorrect = false;
            //System.out.println("Второй аргумент без кавычек и не корректное число");
        }

        if (((ArrayArg[2] == "+") | (ArrayArg[2] == "-")) & secondArgumentIsCorrectInt & !secondArgumentHasQuot) {
            expressionCorrect = false;
            //System.out.println("несовпадение аргументов и оператора");
        }


        if (((ArrayArg[2] == "*") | (ArrayArg[2] == "/")) & !secondArgumentIsCorrectInt) {
            expressionCorrect = false;
            //System.out.println("несовпадение аргументов и оператора Агумент 2 число ");
            }

            // Окончательная проверка флага, выброс исключения, остановка программы
            if (!expressionCorrect) {
                try {
                    throw new MyExeption("Некорректные данные");
                } catch (MyExeption e) {
                    System.err.println(e.getMessage());
                    System.exit(0);
                }
            }

            return (ArrayArg);
        }

}

