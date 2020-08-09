public class CalculatorException {
    public static boolean isException(String[] inputStr){
        InputText inputText = new InputText();
        try {
            inputText.setText(inputStr);
            return true;
        } catch (StringException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
