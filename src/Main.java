import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws throwsException {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String result = calc (input);
        System.out.println(result);
    }
    public static String calc(String input) throws throwsException {
        String[] actions = {"+", "-", "*", "/"};
        String[] altAction = {"\\+", "-", "\\*", "/"};
        int actionIndex = -1;
        for (int i = 0; i < altAction.length; i++) {
            if (input.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        if (actionIndex == -1) {
            throw new throwsException("throws Exception \n//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String[] nums = input.split(altAction[actionIndex]);
        if (nums.length > 2) {
            throw new throwsException("throws Exception \n//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        int num1, num2;
        String strRes = null;
        try {
            num1 = Integer.parseInt(nums[0].trim());
            num2 = Integer.parseInt(nums[1].trim());
            if (num1 >= 1 && num1 <= 10 && num2 >= 1 && num2 <= 10){
                int res;
                switch (actions[actionIndex]) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    default:
                        res = num1 / num2;
                        break;
                }
                strRes = "" + res;
            } else {
                throw new throwsException("throws Exception \n//т.к. числа должны быть от 1 до 10 включительно");
            }
        } catch (NumberFormatException e) {
            throw new throwsException("throws Exception \n//т.к. строка не является математической операцией");
        }
        return strRes;
    }
}