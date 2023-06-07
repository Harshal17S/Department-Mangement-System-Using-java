package DepartmentManagementSystem;

class Faculty {
    String facname, facpass, Dean;
    int facleavecl,facleavesl,facleaveel, usedleavecl,usedleavesl,usedleaveel, requestcl, requestsl, requestel;
    public Faculty(String scanname, String scanpassword, int leavecl,int leavesl,int leaveel ,int usedcl,int usedsl,int usedel,
                   int requestedcl,int requestedsl,int requestedel, String Dean)
    {
        this.facname = scanname;
        this.facpass = scanpassword;
        this.facleavecl = leavecl;
        this.facleavesl= leavesl;
        this.facleaveel=leaveel;
        this.usedleavecl = usedcl;
        this.usedleavesl=usedsl;
        this.usedleaveel=usedel;
        this.requestcl = requestedcl;
        this.requestsl = requestedsl;
        this.requestel = requestedel;
        this.Dean = Dean;

    }
    // Displays available leaves
    public void viewleave() {
        System.out.println("Your Casual Leaves(CL) are:" + Getfacleavecl());
        System.out.println("Your Sick Leaves(SL) are:" + Getfacleavesl());
        System.out.println("Your Earn Leaves(EL) are:" + Getfacleaveel());
    }
    // function for requesting leave
    public void reqleave(int request, String s) { // it checks if requested no. of leaves are available or not
        if (request > Getfacleavecl() && s=="CL") {
            System.out.println("You don't have sufficient Casual leaves\n");
        }
        else if(request>Getfacleavesl() && s=="SL") {
            System.out.println("You don't have sufficient Sick leaves\n");
        }
        else if(request>Getfacleaveel() && s=="EL") {
            System.out.println("You don't have sufficient Earn leaves\n");
        }
        else {
            System.out.println("Requested for leave of " + request + " days");
        }
        if(s=="CL"){
            setreq1(request);
        } else if (s=="SL") {
            setreq2(request);
        }
        else if(s=="EL"){
            setreq3(request);
        }
    }
    // set the value of total leaves of Faculty
    public void setreq1(int request) {
        this.requestcl = request;
    }
    public void setreq2(int request) {
        this.requestsl = request;
    }
    public void setreq3(int request) {
        this.requestel = request;
    }
    // returns name of Faculty
    public String GetnameFac() {
        return this.facname;
    }
    // returns password of Faculty
    public String GetpassFac() {
        return this.facpass;
    }
    // returns remaining leaves of Faculty
    public int Getfacleavecl() {
        return this.facleavecl;
    }
    public int Getfacleavesl() {
        return this.facleavesl;
    }
    public int Getfacleaveel() {
        return this.facleaveel;
    }
    // returns used leaves of Faculty
    public int Getusedleavecl() {
        return this.usedleavecl;
    }
    public int Getusedleavesl() {
        return this.usedleavesl;
    }
    public int Getusedleaveel() {
        return this.usedleaveel;
    }
    // setting the value of used leaves of Faculty
    public void setusedleavecl(int used) {
        this.usedleavecl = used;
    }
    public void setusedleavesl(int used) {
        this.usedleavesl = used;
    }
    public void setusedleaveel(int used) {
        this.usedleaveel = used;
    }
    // returns no. of requesting leave
    public int GETrequestedleavecl() {
        return this.requestcl;
    }
    public int GETrequestedleavesl() {
        return this.requestsl;
    }
    public int GETrequestedleaveel() {
        return this.requestel;
    }
    // updating the value of total leaves of regular Faculty
    public void updateleavecl(int update) {
        this.facleavecl = update;
    }
    public void updateleavesl(int update) {
        this.facleavesl = update;
    }
    public void updateleaveel(int update) {
        this.facleaveel = update;
    }
    // returns the Dean name of Faculty
    public String GETDean() {
        return this.Dean;
    }
}
