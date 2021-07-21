package students.affairs;
public class Subject {
private String SubName;
private String Code;
private String Pre;
private String Arr;
private int Hours;

    public Subject(String SubName, String Code, String Pre, String Arr, int Hours) {
        this.SubName = SubName;
        this.Code = Code;
        this.Pre = Pre;
        this.Arr = Arr;
        this.Hours = Hours;
    }

    public String getSubName() {
        return SubName;
    }

    public void setSubName(String SubName) {
        this.SubName = SubName;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getPre() {
        return Pre;
    }

    public void setPre(String Pre) {
        this.Pre = Pre;
    }

    public String getArr() {
        return Arr;
    }

    public void setArr(String Arr) {
        this.Arr = Arr;
    }

    public int getHours() {
        return Hours;
    }

    public void setHours(int Hours) {
        this.Hours = Hours;
    }

}
