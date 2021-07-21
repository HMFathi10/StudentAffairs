package students.affairs;
public class ComData {
String Name;
String SSN;

    public ComData(String Name, String SSN) {
        this.Name = Name;
        this.SSN = SSN;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

}
