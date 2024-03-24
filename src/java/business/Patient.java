
package business;

public class Patient{
    private String studentRegNo;
    private String name;
    private String symptoms;
    private String prescription;
    private String labTest;
   

    public Patient(String studentRegNo, String name, String symptoms, String prescription, String labTest) {
        this.studentRegNo = studentRegNo;
        this.name = name;
        this.symptoms = symptoms;
        this.prescription = prescription;
        this.labTest = labTest;
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

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getLabTest() {
        return labTest;
    }

    public void setLabTest(String labTest) {
        this.labTest = labTest; 
    }
 
    
    
    
    
    
    
    
    
    
    
    
    
    
}
   
