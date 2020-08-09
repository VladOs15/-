public class CountingNumberRoman extends CountingNumber {
    private static final String[] masRomanNumber = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public CountingNumberRoman(String stringNum) {
        String[] str = stringNum.split(" ");

        for (int i = 0; i < str.length; i++) {
            if (isNumericRoman(str[i])) numList.add(transfer(str[i]));
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

        if (isSum) System.out.println(transferNum(numList.get(0) + numList.get(1)));
        else if (isDelete) System.out.println(transferNum(numList.get(0) / numList.get(1)));
        else if (isMinus) System.out.println(transferNum(numList.get(0) - numList.get(1)));
        else if (isMultiple) System.out.println(transferNum(numList.get(0) * numList.get(1)));
    }

    public int transfer(String str){
        int number = 0;
        for(int i = 0; i < masRomanNumber.length; i++){
            if (masRomanNumber[i].equals(str.toUpperCase())) number += i + 1;
        }
        return number ;
    }

    public String transferNum(int romanNum){
        String outputStrRoman = "";
        if (0 < romanNum && romanNum <= 10){
            outputStrRoman += masRomanNumber[romanNum - 1];
        }
        else if (10 < romanNum && romanNum <= 100)
        {
            int y = romanNum / 10;
            if (1 <= y && y < 4){
                for (int i = 0; i < y; i++) outputStrRoman += "X";
                if (romanNum - y * 10 != 0) outputStrRoman += masRomanNumber[romanNum % 10 - 1];
            }
            else if (y == 4){
                outputStrRoman += "XL";
                if (romanNum - y * 10 != 0) outputStrRoman += masRomanNumber[romanNum % 10 - 1];
            }
            else if (y == 5) {
                outputStrRoman += "L";
                if (romanNum - y * 10 != 0) outputStrRoman += masRomanNumber[romanNum % 10 - 1];
            }
            else if (5 < y && y < 9) {
                outputStrRoman += "L";
                for (int i = 5; i < y; i++) outputStrRoman += "X";
                if (romanNum - y * 10 != 0) outputStrRoman += masRomanNumber[romanNum % 10 - 1];
            } else if (y == 9){
                outputStrRoman += "XC";
                if (romanNum - y * 10 != 0) outputStrRoman += masRomanNumber[romanNum % 10 - 1];
            } else if (y == 10){
                outputStrRoman += "C";
            }
        } else System.out.println("I don't know! :( ");
        return outputStrRoman;
    }

    public static boolean isNumericRoman(String strNum){
        boolean isFlag = false;
        for (int i = 0; i < masRomanNumber.length; i++) {
            if (strNum.toUpperCase().equals(masRomanNumber[i])) {
                isFlag = true;
            }
        }
        return isFlag;
    }
}
