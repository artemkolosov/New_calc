public class Multiplier {

    public static String mult1(String arg1String, String arg2String)

    {
        int arg2Integer = Integer.parseInt(arg2String);

        String resultMult = "";

        for (int i = 1; i<=arg2Integer; i++){
            resultMult = resultMult + arg1String;
        }
        // Проверка условия 40 символов, обрезание результата если длиннее.
        int lengthResult = resultMult.length();

        if  (lengthResult > 40) {
            resultMult = resultMult.substring(0, 40);
            resultMult = resultMult + "...";
        }

        resultMult = "\"" + resultMult + "\"";

        return (resultMult);
    }
}
