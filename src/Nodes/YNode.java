package Nodes;

import LinkedList.Month;

/**
 * Represents a node in the linked list for years. Each node contains
 * information about a specific year, including a reference to the next node in
 * the list, the year value, and a list of months associated with that year.
 */
public class YNode {

    private YNode next;
    private int year;
    private Month monthList;

    public YNode(int year) {
        this.year = year;
        this.next = null;
        monthList = new Month();
    }

    public YNode getNext() {
        return next;
    }

    public void setNext(YNode next) {
        this.next = next;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Month getMonthList() {
        return monthList;
    }

    public void setMonthList(Month monthList) {
        this.monthList = monthList;
    }

    @Override
    public String toString() {
        return "" + monthList.displayMonthDayss();
    }

}
