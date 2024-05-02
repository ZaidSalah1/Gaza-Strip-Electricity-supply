package Nodes;

import LinkedList.Days;

/**
 * Represents a node in the linked list for months. Each node contains information
 * about a specific month, including a reference to the next node in the list, the
 * month name, and a list of days associated with that month.
 */
public class MNode {
    
    private MNode next;
    private String month;
    private Days daysList;
    
    public MNode(String month){
        this.next = null;
        this.month = month;
        this.daysList = new Days();
    }

    public MNode getNext() {
        return next;
    }

    public void setNext(MNode next) {
        this.next = next;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Days getDaysList() {
        return daysList;
    }

    public void setDaysList(Days daysList) {
        this.daysList = daysList;
    }

    @Override
    public String toString() {
        return daysList.toString();
    }
    
    
}
