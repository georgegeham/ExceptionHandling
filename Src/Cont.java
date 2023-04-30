package Src;

public class Cont implements Comparable<Cont> {
    private String id;
    private String sname;
    private String lname;

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return " <CONTAINER " + this.getID() + ">\n" + " <SHORT-NAME>" + this.getSname() + "</SHORT-NAME>\n"
                + " <LONG-NAME>" + this.getLname() + "</LONG-NAME>\n"
                + " </CONTAINER>\n";
    }

    @Override
    public int compareTo(Cont c) {
        int flag = 0;
        for (int i = 0; i < this.sname.length(); i++) {
            if (this.getSname().charAt(i) > c.getSname().charAt(i)) {
                flag = 1;
                break;
            } else if (this.getSname().charAt(i) < c.getSname().charAt(i)) {
                flag = -1;
                break;
            } else {
                flag = 0;
                continue;
            }
        }
        if (flag == 1)
            return 1;
        else if (flag == -1)
            return -1;
        else
            return 0;

    }

}