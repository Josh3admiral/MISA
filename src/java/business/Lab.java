
package business;

public class Lab {
    private String studentRegNo;
    private String name;
    private String labResults;
   

    public Lab(String studentRegNo, String name, String labResults) {
        this.studentRegNo = studentRegNo;
        this.name = name;
        this.labResults = labResults;   
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

    public String getLabResults() {
        return labResults;
    }

    public void setLabResults(String labResults) {
        this.labResults = labResults;
    }
    

}
    
