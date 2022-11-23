
// Importing util package
import java.util.*;

// Creating a Rgistrationdetail class Which has to store a new registration Data
class Registrationdetail {
    String name;
    int pass;
    int number;
    int age;
}


// Main Class
class Loginform {

    // temp --> Total Registration has done
    static int temp = 0;

    // Object of registration Detail
    static Registrationdetail[] registrationfull = new Registrationdetail[20];
    Registrationdetail rd = new Registrationdetail();

    // Declaring a Scanner Class
    static Scanner sc;


    // Initialisation Has been done for all Registration (Only once)
    public static void initRegistration() {
        for (int i = 0; i < 20; i++) {
            registrationfull[i] = new Registrationdetail();
        }
        return;
    }

    // new registration has been done in registration function
    public static void registration() {
        System.out.println(registrationfull);
        if (temp >= 20) {
            System.out.println("Sorry, No More Registration");
            return;
        }

        sc = new Scanner(System.in);
        System.out.println("Enter Your Name");
        registrationfull[temp].name = sc.nextLine();
        System.out.println("Enter Your PASS");
        registrationfull[temp].pass = sc.nextInt();
        System.out.println("Enter Your NUMBER");
        registrationfull[temp].number = sc.nextInt();
        System.out.println("Enter Your AGE");
        registrationfull[temp].age = sc.nextInt();
        temp++;
        System.out.println("Thanks You for Registration");
        return;
    }


    // In Login check name and passaword is right or not
    public static int check(String nam, int pas) {

        for (int i = 0; i < temp; i++) {
            boolean ans=true;
            for (int j=0; j<registrationfull[i].name.length(); j++){
                if(registrationfull[i].name.indexOf(i) != nam.indexOf(i)){
                    ans=false;
                }
            }
            if (ans && registrationfull[i].pass == pas) {
                return i;
            }
        }
        return -1;
    }

    // It print all Detail Registration
    public static void printfulldetail() {
        System.out.println("<----- FULL DETAIL ----->");
        for (int i = 0; i < temp; i++) {
            System.out.println(i + " Name: " + registrationfull[i].name + "  Numbrer " + registrationfull[i].number
                    + "  Age " + registrationfull[i].age);
        }
        return;
    }

    // It print its own Detail
    public static void printdetail(int i) {
        System.out.println("<-------------DETAIL OF LOGGER ------------->");
        System.out.println("Your Name: " + registrationfull[i].name);
        System.out.println("Your Passaword: " + registrationfull[i].pass);
        System.out.println("Your Number: " + registrationfull[i].number);
        System.out.println("Your Age: " + registrationfull[i].age);
    }


    // It print it own detail after login
    public static void changepass(int i){
        int oldpas,newpas;
        sc=new Scanner(System.in);
        System.out.print("Enter old pass");
        oldpas=sc.nextInt();
        System.out.println();
        System.out.print("Enter new pass");
        newpas=sc.nextInt();
        boolean checkold=checking(oldpas,i);

        if(checkold){
            registrationfull[i].pass=newpas;
        }else{
            System.out.println("Sorry, Your Old pass is Wrong");
        }
    }


    // making changing passaword will check old passaword
    public static boolean checking(int old, int i){
        if(registrationfull[i].pass==old){
            return true;
        }else {
            return false;
        }
    }

    // It login function
    public static void login() {
        sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Passaword: ");
        int pass = sc.nextInt();
        int checklogin = check(name, pass);
        if (checklogin == -1) {
            System.out.println("Incorrect password or Name");
            return;
        } else {
            System.out.println("You Are a Successfully Login.");
            int presslogin = 0;
            while (true) {
                System.out.println("Press 1 to get your Detail");
                System.out.println("Press 2 to get Full Detail");
                System.out.println("Press 3 to change Passaword");
                System.out.println("Press -1 to Quit");
                presslogin = sc.nextInt();
                if (presslogin == 1) {
                    printdetail(checklogin);
                    System.out.println();
                } else if (presslogin == 2) {
                    printfulldetail();
                    System.out.println();
                }else if(presslogin == 3){
                    changepass(checklogin);
                }else {
                    System.out.println("You are Quitted a Login");
                    break;
                }
            }
        }
    }

   // It print company Information
    public static void companyinfo() {
        System.out.println("<------ COMPANY INFORMATIION ------->");
        System.out.println("Name: ABC");
        System.out.println("Number: +91XXXXXXXXXX");
        System.out.println("Address: SGSITS INDORE");
        System.out.println("No of Employees: " + temp);
        System.out.println("<--------------- EXIT --------->");
    }

    /**
     * @param args
     */

    // Main function
    public static void main(String[] args) {
        initRegistration();

        System.out.println("Welcome to Login-Registration");
        sc = new Scanner(System.in);
        int press;
        while (true) {
            System.out.println("Press 1 for Registration");
            System.out.println("Press 2 for Login");
            System.out.println("Press 3 for Company Information");
            System.out.println("Press -1 to Quit");
            press = sc.nextInt();
            if (press == 1) {
                System.out.println("Enter Detail for Registration");
                registration();
            } else if (press == 2) {
                System.out.println("Enter a Login Detail");
                login();
            } else if (press == 3) {
                companyinfo();
            } else if (press == -1) {
                break;
            } else {
                break;
            }
        }
    }
}