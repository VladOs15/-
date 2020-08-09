import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String read = reader.readLine();
        String[] str = read.split(" ");

        if (CalculatorException.isException(str)) {
            if (CountingNumber.isNumeric(str[0]))
                new CountingNumber(read);
            else
                new CountingNumberRoman(read);
        }
        reader.close();
    }
}
