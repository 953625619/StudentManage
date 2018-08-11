package entity;

public class Teacher {
    private String tno;
    private String tname;

    @Override
    public String toString() {
        return "Teacher{" +
                "tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }

    public Teacher()
    {

    }

    public Teacher(String tno, String tname) {
        this.tno = tno;
        this.tname = tname;
    }

    public String getTno() {

        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
