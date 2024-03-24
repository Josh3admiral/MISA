
package business;


public class Reception {
    private String studentRegNo;
    private String name;
    private String consultationRoom1;
    private String consultationRoom2;
   

    public Reception(String studentRegNo, String name, String consultationRoom1, String consultationRoom2) {
        this.studentRegNo = studentRegNo;
        this.name = name;
        this.consultationRoom1= consultationRoom1;  
        this.consultationRoom2= consultationRoom2;
}

    public String getStudentRegNo() {
        return studentRegNo;
    }

    public void setStudentRegNo(String studentRegNo) {
        this.studentRegNo = studentRegNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConsultationRoom1() {
        return consultationRoom1;
    }

    public void setConsultationRoom1(String consultationRoom1) {
        this.consultationRoom1 = consultationRoom1;
    }

    public String getConsultationRoom2() {
        return consultationRoom2;
    }

    public void setConsultationRoom2(String consultationRoom2) {
        this.consultationRoom2 = consultationRoom2;
    }
    
}
    
