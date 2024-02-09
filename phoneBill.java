//Credits: https://www.w3schools.com/java/ref_string_equalsignorecase.asp (Ignore case method)


//import scanner and formatting
import java.util.Scanner;
import java.text.DecimalFormat;

class phoneBill {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Phone Bill Activity!");

        //default values for packages
        boolean isCorrectPack = false;
        String subPackage = null;

        //error check the input while asking the user for the input
        while (!isCorrectPack){
            //ask user for type of package
            System.out.println("What subscription package do you use? Please enter green, blue, or purple.");
            subPackage = input.nextLine().strip();
            //error checks
            if (subPackage.equalsIgnoreCase("green") || subPackage.equalsIgnoreCase("blue") || subPackage.equalsIgnoreCase("purple")){
                isCorrectPack = true;
            } else {
                System.out.println("Invalid input. Please enter one of the three subscription packages: green, blue, purple");
            }
        }

        //ask user their data usage
        System.out.println("How much data do you use?");
        double dataUsage = input.nextDouble();

        //default values for costs
        double extraFees;
        double monthlyBill = 0;

        //blue package
        if (subPackage.equalsIgnoreCase("blue")){
            //additional fees over 4GB usage
            if (dataUsage > 4){
                dataUsage -= 4;
                extraFees = dataUsage * 10;
                monthlyBill = extraFees + 70;
            } else {
                monthlyBill = 70;
            }

        //purple package
        } else if (subPackage.equalsIgnoreCase("purple")) {
            monthlyBill = 99.95;

        //green package
        } else if (subPackage.equalsIgnoreCase("green")){
            //additional fees over 2GB usage
            if (dataUsage > 2){
                dataUsage -= 2;
                extraFees = dataUsage * 15;
                monthlyBill = extraFees + 49.99;
                //if the bill is $75 or more, a coupon can be used if the user has one
                if (monthlyBill >= 75) {
                    //default values for checking coupon
                    boolean hasCoupon = false;
                    String coupon = "";
                    input.nextLine();

                    //error checking and asking user if they have coupon
                    while (!hasCoupon){
                        //checks for coupon
                        System.out.println("Do you have a coupon? Please say yes or no.");
                        coupon = input.nextLine().strip();
                        //error checks
                        if (coupon.equalsIgnoreCase("yes") || coupon.equalsIgnoreCase("no")){
                            hasCoupon = true;
                        } else {
                            System.out.println("Invalid input. Do you have a coupon? Please say yes or no.");
                        }
                    }

                    //takes $20 off bill with coupon for green package
                    if (coupon.equalsIgnoreCase("yes")){
                        monthlyBill -= 20;
                    }
                }
            } else {
                monthlyBill = 49.99;
            }


        }

        //format the bill to 2 decimal places
        DecimalFormat df = new DecimalFormat("###,##0.00");


        //tell user their monthly bill and thank them for using the program
        System.out.println("Your monthly bill is $" + df.format(monthlyBill) + ". Thank you for using this program.");

        
    }
}
