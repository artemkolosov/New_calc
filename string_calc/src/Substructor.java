public class Substructor {

    // По условиям задания нужно удалить подстроку из строки
    // Однако, упущен тот факт, что подстрока может входить в строку не один раз а несколько
    // Пример "1World2World" - "World"
    // или подстрока входит в строку не с конца строки, а из середины
    // Пример "Hello World!" - "World", должно выдать "Hello World!", а не "Hello !"

    // Допущение, которое следует из примера решения, рассматриваем только подстроки,
    // которые точно входят с конца строки один раз

    public static String sub1(String arg1String, String arg2String)

    {
        String resultSub = "";

        int  k = arg1String.indexOf(arg2String);

        if (!arg1String.endsWith(arg2String)) // Если строка не заканчивается подстрокой
        {
            resultSub = arg1String; // результат равен строке
        }
            else {
            // если заканчивается
                resultSub = arg1String.substring(0, arg1String.length() - arg2String.length());
            // результат равен строка минус подстрока с конца выражения
        }

        resultSub = "\"" + resultSub + "\"";

        return (resultSub);

    }
}
