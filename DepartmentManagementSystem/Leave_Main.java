package DepartmentManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Leave_Main {
    ArrayList<Dean> Dean_details = new ArrayList<>();
    ArrayList<Faculty> Faculty_details = new ArrayList<>();

    public static void main(String[] args) {
        Leave_Main leave = new Leave_Main();
        leave.Display();
    }

    void Display() {
        Scanner sc = new Scanner(System.in);
        String name, password;
        int a = 0, total = 0;
        System.out.println("******* DEPARTMENT MANAGEMENT SYSTEM*******");
        System.out.println("Select any one for login procedure\n" + "1.Admin \n" + "2.Dean \n" + "3.Faculty");
        try {
            a = sc.nextInt();
            System.out.println("Enter Username");
            name = sc.next();
            System.out.println("Enter Password");
            password = sc.next();
            switch (a) {
                case 1:
                    checkadmin(name, password);
                    while (true) {
                        System.out.println("Enter 1 to ADD Dean or Faculty" + "\nEnter 2 to View Report of Registered Dean" + "\n"
                                + "Enter 3 to View Report of Registered Faculty" + "\n" + "Enter 4 to LOGOUT");
                        a = sc.nextInt();
                        switch (a) {
                            case 1:
                                System.out.println("Enter 1 to add Dean OR Enter 2 to add Faculty");
                                a = sc.nextInt();
                                if (a == 1) { // Creates Dean
                                    System.out.println("How many Dean you want to Add?");
                                    total = sc.nextInt();
                                    Admin.AddDean(Dean_details, total);
                                    continue;
                                } else if (a == 2) { // Creates Faculty
                                    System.out.println("How many Faculty you want to Add?");
                                    total = sc.nextInt();
                                    Admin.AddFaculty(Faculty_details, Dean_details, total);
                                    continue;
                                } else {

                                    System.out.println("Enter valid choice!");
                                    continue;
                                }
                            case 2: // View report of Dean
                                Admin.viewdean(Dean_details);
                                continue;
                            case 3: // View report of Faculty
                                Admin.viewfaculty(Faculty_details);
                                continue;
                            case 4: // Display is called for logout
                                Display();
                            default:
                                continue;
                        }
                    }
                case 2:
                    // Login validation for Dean
                    Dean rlogin = Matchdean(name, password, Dean_details);
                    if (rlogin != null) {
                        System.out.println("Welcome " + name + "!");
                    } else {
                        Display();
                    }
                    while (true) {
                        int c = 0;
                        System.out.println("1.View Report\n2.View Requests\n3.Grant\n4.Logout");
                        c = sc.nextInt();
                        if (c == 1) {
                            rlogin.view(Faculty_details);
                        } else if (c == 2) { // View request of  allocated Faculty
                            rlogin.requests(Faculty_details);
                        } else if (c == 3) { // Calling Grant function for Accepting or Rejecting or Pending request
                            rlogin.grant(Faculty_details);
                        } else if (c == 4)
                            Display();
                    }
                case 3:
                    Faculty e = Matchfaculty(name, password, Faculty_details); // Login validation for Faculty
                    if (e != null) {
                        System.out.println("Welcome " + name);
                        while (true) {
                            int b = 0, req = 0, n = 0;
                            System.out.println("1. View  Leaves" + "\n" + "2. Apply for leave application" + "\n" + "3. Logout");
                            b = sc.nextInt();
                            switch (b) {
                                case 1: // Viewing available leave
                                    e.viewleave();
                                    break;
                                case 2: //Requesting leave
                                    System.out.println("Your total CL are:" + e.Getfacleavecl());
                                    System.out.println("Your total Sl are:" + e.Getfacleavesl());
                                    System.out.println("Your total EL are:" + e.Getfacleaveel());
                                    System.out.println("Which leave you want to opt for:" + "\n1.CL\n2.SL\n3.EL");
                                    n = sc.nextInt();
                                    switch (n) {
                                        case 1:
                                            System.out.println("\nHow many CL do you want?");
                                            String z = "CL";
                                            req = sc.nextInt();
                                            e.reqleave(req, z);
                                            break;
                                        case 2:
                                            System.out.println("\nHow many SL do you want?");
                                            String d = "SL";
                                            req = sc.nextInt();
                                            e.reqleave(req, d);
                                            break;
                                        case 3:
                                            System.out.println("\nHow many EL do you want?");
                                            String f = "EL";
                                            req = sc.nextInt();
                                            e.reqleave(req, f);
                                            break;
                                    }
                                case 3:
                                    Display();
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                default:
                    System.out.println("Invalid Credentials!");
                    Display();
            }
        } catch (Exception e) {
            System.out.println("Exception Occured!");
            Display();
        }
        sc.close();
    }

    public void checkadmin(String name, String password) {
        if (name.equals("Admin") && password.equals("123")) {
            System.out.println("Welcome  " + name + "!");
        } else {
            System.out.println("Invalid Credentials");
            Display();
        }
    }

    public Dean Matchdean(String name, String password, ArrayList<Dean> Dean_details) {
        for (Dean getd : Dean_details) {
            if (name.equalsIgnoreCase(getd.GetNameDean()) && password.equals(getd.GetPassDean())) {
                return getd;
            }
        }
        return null;
    }

    public Faculty Matchfaculty(String name, String password, ArrayList<Faculty> Faculty_details) {
        for (Faculty getd : Faculty_details) {
            if (name.equalsIgnoreCase(getd.GetnameFac()) && password.equals(getd.GetpassFac())) {
                return getd;
            }
        }
        return null;
    }

    static boolean validatedean(String scanname, ArrayList<Dean> Dean_details) {
        for (Dean getd : Dean_details) {
            if (scanname.equalsIgnoreCase(getd.GetNameDean())) {
                System.out.println("Dean already exists please Enter again\n");
                return true;
            }
        }
        return false;
    }

    public static void AddFaculty(ArrayList<Faculty> Faculty_details, ArrayList<Dean> Dean_details, int total) {
        String scanname, scanpassword;
        for (int i = 0; i < total; i++) {
            System.out.println("\t\t\tFaculty");
            System.out.println("Enter name:");
            Scanner sc = new Scanner(System.in);
            scanname = sc.next();
            System.out.println("Enter Password:");
            scanpassword = sc.next();
            boolean v = validatefaculty(scanname, scanpassword, Faculty_details);
            if (v == true) {
                break;
            } else {
                int leavecl = 10;
                int leavesl = 8;
                int leaveel = 30;
                int usedcl = 0;
                int usedsl = 0;
                int usedel = 0;
                int requestedcl = 0;
                int requestedsl = 0;
                int requestedel = 0;
                System.out.println("\t\t\tDEAN LIST \n");
                for (Dean getd : Dean_details) {
                    if (getd.GetNameDean() != null) {
                        System.out.println("Dean Name:" + getd.GetNameDean());
                    }
                }
                System.out.println("Assign Dean to the faculty:");
                String Dean;
                Scanner scc = new Scanner(System.in);
                String De_an = scc.next();
                for (Dean getd : Dean_details) {
                    if (De_an.equalsIgnoreCase(getd.GetNameDean())) {
                        Dean = getd.GetNameDean();
                        Faculty_details.add(new Faculty(scanname, scanpassword, leavecl, leavesl, leaveel, usedcl, usedsl, usedel, requestedcl, requestedsl, requestedel, Dean));
                        System.out.println("Faculty Added\n");
                    }
                }
            }
        }
    }
static boolean validatefaculty(String scanname, String scanpassword, ArrayList<Faculty> Faculty_details) {
    for (Faculty getd: Faculty_details) {
        if (scanname.equalsIgnoreCase(getd.GetnameFac()) && scanpassword.equalsIgnoreCase(getd.GetpassFac())) {
            System.out.println("Faculty already exists please Enter again with different id or password\n");
            return true;
        }
    }
    return false;
}
    public static void viewdean(ArrayList<Dean> Dean_details) {
        System.out.println("\t\t\tDEAN LIST WITH PASSWORD\n");
        for (Dean getd : Dean_details) {
            System.out.println("Dean Name: " + getd.GetNameDean() + "\t\tPassword: " + getd.GetPassDean());
        }
    }
    public static void viewfaculty(ArrayList<Faculty> Faculty_details) {
        System.out.println("\t\t\tFACULTY LIST WITH PASSWORD\n");
        for (Faculty getd : Faculty_details) {
            System.out.println("Faculty Name: " + getd.GetnameFac() + "\t\tPassword: " + getd.GetpassFac() + "\t\tDean: " + getd.GETDean());
        }
    }
}