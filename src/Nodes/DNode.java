package Nodes;

import LinkedList.Data;


/**
 * Represents a node in the linked list for days. Each node contains information
 * about a specific day, including a reference to the next node in the list and
 * details about the day's data.
 */
public class DNode {
    
    private DNode next;
    private int day;
    private Data data;
    public DNode(String date, double israeli_Line, double gaza_Power_Line, double egyption_Line, double total_daily_supply, double overall_demand, double power_cuts, double temp){
        this.next = null;
        this.data = new Data(date, israeli_Line, gaza_Power_Line, egyption_Line, total_daily_supply, overall_demand, power_cuts, temp);
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public int getDay() {
        return day;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    
    public void setDay(int day) {
        this.day = day;
    }
    
    
}
