import java.sql.SQLOutput;

public class Divider {

    public static String div1(String arg1String, String arg2String)

    {
        String resultDiv = "";
        int lengthArg1 = arg1String.length();
        int arg2Integer = Integer.parseInt(arg2String);

        resultDiv = arg1String.substring(0, lengthArg1/arg2Integer );

        //Результатом деления строки на число может быть строка нулевой длинны

        //if (resultDiv.equals("")) {
        // System.out.println("строка нулевой длины");
        // }

        resultDiv = "\"" + resultDiv + "\"";

        return (resultDiv);

    }

}
