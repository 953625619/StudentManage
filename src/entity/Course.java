package entity;

public class Course {
    private String cno;
    private String cname;
    private String tno;

    @Override
    public String toString() {
        return "Course{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", tno='" + tno + '\'' +
                '}';
    }

    public Course()
    {

    }

    public Course(String cno, String cname, String tno) {
        this.cno = cno;
        this.cname = cname;
        this.tno = tno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }
}
