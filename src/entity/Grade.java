package entity;

public class Grade {
    private String sno;
    private String cno;
    private double grade;

    @Override
    public String toString() {
        return "Grade{" +
                "sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", grade=" + grade +
                '}';
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Grade()
    {

    }
    public Grade(String sno,String cno)
    {
        this.sno = sno;
        this.cno = cno;
    }
    public Grade(String sno, String cno, double grade) {

        this.sno = sno;
        this.cno = cno;
        this.grade = grade;
    }
}
