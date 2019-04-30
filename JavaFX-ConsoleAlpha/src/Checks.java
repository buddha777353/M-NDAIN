public class Checks {

    private String description;
    private double amount;
    private int transfernum;
    private int date;

    public Checks() {
        this.description = "";
        this.amount = 0;
        this.transfernum = 0;
        this.date = 0;
    }

    public Checks(String description, double amount, int transfernum) {
        this.description = description;
        this.amount = amount;
        this.transfernum = transfernum;
        this.date = date;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public double getamount() {
        return amount;
    }

    public void setamount(double amount) {
        this.amount = amount;
    }

    public int gettransfernum() {
        return transfernum;
    }

    public void settransfernum(int transfernum) {
        this.transfernum = transfernum;
    }
    
    public int getdate() {
        return date;
    }

    public void setdate(int date) {
        this.date = date;
    }

}