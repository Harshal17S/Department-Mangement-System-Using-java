package DepartmentManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

class Dean {
    String name, deanid;
    Scanner sc = new Scanner(System.in);
    public Dean(String name, String password) {
        this.name = name;
        this.deanid = password;
    }
    // returns name of Dean
    public String GetNameDean() {
        return this.name;
    }
    // returns password of Dean
    public String GetPassDean() {
        return this.deanid;
    }
    public void view(ArrayList<Faculty> Faculty_details) {    //print all Faculty name, available leaves and used leaves
        for (Faculty getd : Faculty_details) {
            if (GetNameDean().equalsIgnoreCase(getd.GETDean())) {
                System.out.println("Faculty Name:" + getd.GetnameFac() + "\t\tAvailable CL:" + getd.Getfacleavecl() + "\t\tUsed CL:" + getd.Getusedleavecl() + "\n");
                System.out.println("Faculty Name:" + getd.GetnameFac() + "\t\tAvailable SL:" + getd.Getfacleavesl() + "\t\tUsed SL:" + getd.Getusedleavesl() + "\n");
                System.out.println("Faculty Name:" + getd.GetnameFac() + "\t\tAvailable EL:" + getd.Getfacleaveel() + "\t\tUsed EL:" + getd.Getusedleaveel() + "\n");
            }
        }
    }
    public void requests(ArrayList<Faculty> Faculty_details) {    // print all the requests of Faculty who are under the logged in Dean
        for (Faculty getd : Faculty_details) {
            if (GetNameDean().equalsIgnoreCase(getd.GETDean())) {
                if(getd.GETrequestedleavecl()>0)
                {
                    System.out.println("Faculty Name:" + getd.GetnameFac() + "\t\tRequesting CL for " + getd.GETrequestedleavecl() + " Days \n");
                }
                if(getd.GETrequestedleavesl()>0)
                {
                    System.out.println("Faculty Name:" + getd.GetnameFac() + "\t\tRequesting SL for " + getd.GETrequestedleavesl() + " Days \n");
                }
                if(getd.GETrequestedleaveel()>0)
                {
                    System.out.println("Faculty Name:" + getd.GetnameFac() + "\t\tRequesting EL for " + getd.GETrequestedleaveel() + " Days \n");
                }
            }
        }
    }
    // Confirmation for leave to be given or not
    public void grant(ArrayList<Faculty> Faculty_details) {
        for (Faculty getd : Faculty_details) {
            if (getd.GETDean().equalsIgnoreCase(GetNameDean())) {
                if(getd.GETrequestedleavecl()>0)
                {
                    System.out.println("Faculty Name:" + getd.GetnameFac() + "\t\tRequesting CL for " + getd.GETrequestedleavecl() + " Days \n");
                }
                if(getd.GETrequestedleavesl()>0)
                {
                    System.out.println("Faculty Name:" + getd.GetnameFac() + "\t\tRequesting SL for " + getd.GETrequestedleavesl() + " Days \n");
                }
                if(getd.GETrequestedleaveel()>0)
                {
                    System.out.println("Faculty Name:" + getd.GetnameFac() + "\t\tRequesting EL for " + getd.GETrequestedleaveel() + " Days \n");
                }
                int a;
                System.out.println("1.Confirm " + "\n" + "2.Reject" + "\n" + "3.Don't change");
                a = sc.nextInt();
                switch (a) {
                    // if Dean confirms the request
                    case 1:
                        int cl = getd.Getfacleavecl();
                        int sl = getd.Getfacleavesl();
                        int el = getd.Getfacleaveel();
                        int cl1 = getd.GETrequestedleavecl();
                        int sl1 = getd.GETrequestedleavesl();
                        int el1= getd.GETrequestedleaveel();
                        if(sl1>0)
                        {
                            int deduct = getd.GETrequestedleavesl();
                            sl -= deduct;
                            getd.updateleavesl(sl);
                            int used = getd.Getusedleavesl() + getd.GETrequestedleavesl();
                            getd.setusedleavesl(used);
                            getd.setreq1(0);
                            getd.setreq2(0);
                            getd.setreq3(0);
                            System.out.println("Leaves granted\n");
                        }
                        else if(cl1>0)
                        {
                            int deduct = getd.GETrequestedleavecl();
                            cl -= deduct;
                            getd.updateleavecl(cl);
                            int used = getd.Getusedleavecl() + getd.GETrequestedleavecl();
                            getd.setusedleavecl(used);
                            getd.setreq1(0);
                            getd.setreq2(0);
                            getd.setreq3(0);
                            System.out.println("Leaves granted\n");
                        }
                        else if(el1>0)
                        {
                            int deduct = getd.GETrequestedleaveel();
                            el -= deduct;
                            getd.updateleaveel(el);
                            int used = getd.Getusedleaveel() + getd.GETrequestedleaveel();
                            getd.setusedleaveel(used);
                            getd.setreq1(0);
                            getd.setreq2(0);
                            getd.setreq3(0);
                            System.out.println("Leaves granted\n");
                        }
                        break;
                    // if dean rejects the request
                    case 2:
                        System.out.println("Leaves Rejected\n");
                        getd.setreq1(0);
                        getd.setreq2(0);
                        getd.setreq3(0);
                        break;
                    // if dean selects pending option
                    case 3:
                        System.out.println("Leaves are as it is\n");
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
