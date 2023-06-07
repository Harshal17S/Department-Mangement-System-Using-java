package DepartmentManagementSystem;
import java.util.*;
class Admin
{
    // it adds Dean
    public static void AddDean(ArrayList<Dean> Dean_details, int total) {
        String scanname, scanpassword;
        for (int i = 0; i < total; i++) {
            System.out.println("\t\t\tDEAN");
            System.out.println("Enter name:");
            Scanner sc = new Scanner(System.in);
            scanname = sc.next();
            boolean v = validatedean(scanname, Dean_details);
            if (v != true) {
                System.out.println("Enter Password:");
                scanpassword = sc.next();
                Dean_details.add(new Dean(scanname, scanpassword));
                System.out.println("Dean Created\n");
            } else {
                System.out.println("Username Already Exists ");
                break;
            }
        }
    }
    static boolean validatedean(String scanname, ArrayList<Dean> Dean_details) {
        for (Dean getd : Dean_details) {
            if (scanname.equalsIgnoreCase(getd.GetNameDean()))
            {
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
            }
            else {
                int leavecl = 10;
                int leavesl=8;
                int leaveel=30;
                int usedcl = 0;
                int usedsl=0;
                int usedel=0;
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
                Scanner scc=new Scanner(System.in);
                String De_an = scc.next();
                for (Dean getd : Dean_details) {
                    if (De_an.equalsIgnoreCase(getd.GetNameDean())) {
                        Dean= getd.GetNameDean();
                        Faculty_details.add(new Faculty(scanname, scanpassword,leavecl,leavesl,leaveel ,usedcl,usedsl,usedel,requestedcl,requestedsl,requestedel, Dean));
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

