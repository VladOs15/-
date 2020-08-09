public class InputText {
    private String[] text;

    public void setText(String[] text) throws StringException {
        if (CountingNumber.isNumeric(text[0]) && CountingNumber.isArithmeticSigns(text[1]) && CountingNumber.isNumeric(text[2])
                || CountingNumberRoman.isNumericRoman(text[0]) && CountingNumberRoman.isArithmeticSigns(text[1]) && CountingNumberRoman.isNumericRoman(text[2])) {
            this.text = text;
        } else
            throw new StringException("Введено неверное значение!");
    }
}
