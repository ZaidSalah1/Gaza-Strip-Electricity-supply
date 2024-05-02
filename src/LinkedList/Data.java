package LinkedList;


/*
 * The Data class represents a data object with information about power supply
 * and demand. It includes attributes such as date, Israeli line, Gaza Power line,
 * Egyptian line, total daily supply, overall demand, power cuts, and temperature.
 * It provides methods to access and modify these attributes.
 */
public class Data {

    private String date;
    private double israeli_Line;
    private double gaza_Power_Line;
    private double egyption_Line;
    private double total_daily_supply;
    private double overall_demand;
    private double power_cuts;
    private double temp;

    public Data(String date, double israeli_Line, double gaza_Power_Line, double egyption_Line, double total_daily_supply, double overall_demand, double power_cuts, double temp) {
        this.date = date;
        this.israeli_Line = israeli_Line;
        this.gaza_Power_Line = gaza_Power_Line;
        this.egyption_Line = egyption_Line;
        this.total_daily_supply = total_daily_supply;
        this.overall_demand = overall_demand;
        this.power_cuts = power_cuts;
        this.temp = temp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getIsraeli_Line() {
        return israeli_Line;
    }

    public void setIsraeli_Line(double israeli_Line) {
        this.israeli_Line = israeli_Line;
    }

    public double getGaza_Power_Line() {
        return gaza_Power_Line;
    }

    public void setGaza_Power_Line(double gaza_Power_Line) {
        this.gaza_Power_Line = gaza_Power_Line;
    }

    public double getEgyption_Line() {
        return egyption_Line;
    }

    public void setEgyption_Line(double egyption_Line) {
        this.egyption_Line = egyption_Line;
    }

    public double getTotal_daily_supply() {
        return total_daily_supply;
    }

    public void setTotal_daily_supply(double total_daily_supply) {
        this.total_daily_supply = total_daily_supply;
    }

    public double getOverall_demand() {
        return overall_demand;
    }

    public void setOverall_demand(double overall_demand) {
        this.overall_demand = overall_demand;
    }

    public double getPower_cuts() {
        return power_cuts;
    }

    public void setPower_cuts(double power_cuts) {
        this.power_cuts = power_cuts;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
    
    @Override
    public String toString() {
        return date + "," + israeli_Line + "," + gaza_Power_Line + "," + egyption_Line + "," + total_daily_supply +"," + overall_demand +"," + power_cuts + ","+ temp;
    }

}
