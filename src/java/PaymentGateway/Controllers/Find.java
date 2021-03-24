/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentGateway.Controllers;
/**
 *
 * @author JungleApps
 */
public class Find {
    
    
    private String studentNumber;
    private String studName;
    private String studSurname;
    private String studProg;
    private String citizenship;

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }
    
        public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudSurname() {
        return studSurname;
    }

    public void setStudSurname(String studSurname) {
        this.studSurname = studSurname;
    }

    public String getStudProg() {
        return studProg;
    }

    public void setStudProg(String studProg) {
        this.studProg = studProg;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.studentNumber != null ? this.studentNumber.hashCode() : 0);
        hash = 43 * hash + (this.studName != null ? this.studName.hashCode() : 0);
        hash = 43 * hash + (this.studSurname != null ? this.studSurname.hashCode() : 0);
        hash = 43 * hash + (this.studProg != null ? this.studProg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Find other = (Find) obj;
        if ((this.studentNumber == null) ? (other.studentNumber != null) : !this.studentNumber.equals(other.studentNumber)) {
            return false;
        }
        if ((this.studName == null) ? (other.studName != null) : !this.studName.equals(other.studName)) {
            return false;
        }
        if ((this.studSurname == null) ? (other.studSurname != null) : !this.studSurname.equals(other.studSurname)) {
            return false;
        }
        if ((this.studProg == null) ? (other.studProg != null) : !this.studProg.equals(other.studProg)) {
            return false;
        }
        return true;
    }
    
    
    
}
