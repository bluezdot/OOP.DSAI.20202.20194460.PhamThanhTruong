import javax.swing.JOptionPane;

public class Ex2_2_5 {
    public static void main(String[] args) {
        String strNum1, strNum2;

        String strNotification = "You've just entered ";

        strNum1 = JOptionPane.showInputDialog(null, "Please enter the first number: ",
                "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";
        strNum2 = JOptionPane.showInputDialog(null, "Please enter the second number: ",
                "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;

        strNotification += "\nSum: " + sum;
        strNotification += "\nDifference: " + difference;
        strNotification += "\nProduct: " + product;
        strNotification += "\nQuotient: " + quotient;

        JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
