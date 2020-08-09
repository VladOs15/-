import java.util.ArrayList;
import java.util.List;

public class CountingNumber {
    List<Integer> numList = new ArrayList<>();
    boolean isSum = false, isDelete = false, isMultiple = false, isMinus = false;

    public CountingNumber(){}

    public CountingNumber(String stringNum) {
        String[] str = stringNum.split(" ");
        for (int i = 0; i < str.length; i++) {
            if (isNumeric(str[i])) numList.add(Integer.parseInt(str[i]));
            else if (isArithmeticSigns(str[i])) {
                switch (str[i]) {
                    case "+":
                        isSum = true;
                        break;
                    case "-":
                        isMinus = true;
                        break;
                    case "/":
                        isDelete = true;
                        break;
                    case "*":
                        isMultiple = true;
                        break;
                }
            }
        }

        if (isSum) System.out.println(numList.get(0) + numList.get(1));
        else if (isDelete) System.out.println(numList.get(0) / numList.get(1));
        else if (isMinus) System.out.println(numList.get(0) - numList.get(1));
        else if (isMultiple) System.out.println(numList.get(0) * numList.get(1));
    }


    public static boolean isNumeric(String strNum){
        try{
            int num = Integer.parseInt(strNum);
            if (0 < num && num <= 10)
                return true;
            else
                return false;
        } catch (NumberFormatException | NullPointerException e){
            return false;
        }
    }

    public static boolean isArithmeticSigns(String strNum){
        String[] mas = {"+", "-", "/", "*"};
        boolean isFlag = false;
        for (int i = 0; i < mas.length; i++) {
            if (strNum.equals(mas[i])) {
                isFlag = true;
            }
        }
        return isFlag;
    }
}
