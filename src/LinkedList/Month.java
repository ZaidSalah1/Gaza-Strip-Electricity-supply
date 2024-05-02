package LinkedList;

import Nodes.MNode;
import LinkedList.Days.OperationType;

/**
 * The Month class represents a singly linked list of months, where each month
 * contains information about its days, including power line data, demand, and
 * temperature. It provides methods for insertion, deletion, updating, and
 * calculation of various operations on the data.
 *
 * The class uses MNode to represent individual months and Days to store daily
 * data. It also includes methods for reversing data and calculating operations
 * on specific types of data (Israeli line, Gaza power line, Egyptian line,
 * Overall demand, Power cuts, and Temperature).
 */
public class Month {

    private MNode head;

    /////*************************Insertion Methods********************************\\\\\
    /*
     Inserts a new month node into the linked list of months. The new month node
     is created with the provided date and inserted in the correct order based on
     the comparison of month names.
     */
    public void insertMonth(String newDate) {
        MNode newNode = new MNode(newDate);

        if (head == null || newDate.compareTo(head.getMonth()) < 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            MNode curr = head;
            while (curr.getNext() != null && newDate.compareTo(curr.getMonth()) > 0) {
                curr = curr.getNext();
            }
            newNode.setNext(curr.getNext());
            curr.setNext(newNode);
        }
    }

    public void insertMonthDays(String month, String date, double israeli_Line, double gaza_Power_Line, double egyption_Line, double total_daily_supply, double overall_demand, double power_cuts, double temp) {
        MNode curr = head;
        while (curr != null) {
            if (curr.getMonth().equalsIgnoreCase(month)) {
                curr.getDaysList().insertDayData(date, israeli_Line, gaza_Power_Line, egyption_Line, total_daily_supply, overall_demand, power_cuts, temp);
            }
            curr = curr.getNext();
        }
    }

    /*
     Initializes the linked list of months by inserting nodes for all months
     of the year, starting from January (Jan).
     */
    public void insertMonths() {//Method to insert all monthes to a new year node
        MNode newNode = new MNode("Jan");//Start from jun
        head = newNode;  // Set the instance variable 'head' to the new node
        MNode curr = head;

        int monthCount = 2;//start the counter month number from Feb
        String month;
        while (monthCount <= 12) {
            switch (monthCount) {
                case 2:
                    month = "Feb";
                    break;
                case 3:
                    month = "Mar";
                    break;
                case 4:
                    month = "Apr";
                    break;
                case 5:
                    month = "May";
                    break;
                case 6:
                    month = "Jun";
                    break;
                case 7:
                    month = "Jul";
                    break;
                case 8:
                    month = "Aug";
                    break;
                case 9:
                    month = "Sep";
                    break;
                case 10:
                    month = "Oct";
                    break;
                case 11:
                    month = "Nov";
                    break;
                case 12:
                    month = "Dec";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + monthCount);
            }
            newNode = new MNode(month);
            curr.setNext(newNode);
            monthCount++;
            curr = curr.getNext();
        }
    }

    /////*************************Deletion Methods********************************\\\\\
    // Deletes all daily data for a specific month. 
    public boolean deleteAllDaysData(String month) {
        MNode curr = head;
        boolean isDeleted = false;
        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                isDeleted = curr.getDaysList().deleteAllDaysData();
                return isDeleted;
            }
            curr = curr.getNext();
        }
        return isDeleted;
    }

    /*
     Deletes daily data for a specific date in the linked list of days for the specified month.
     It locates the month node and then calls the deleteSpecificDay2 method of the linked list of
     days in that month, passing the day to be deleted.
     */
    public boolean deleteMonthDay(String date) {
        String tmp[] = date.split("-");
        String month = tmp[1];
        String day = tmp[2];
        boolean isDeleted = false;

        MNode curr = head;
        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                isDeleted = curr.getDaysList().deleteSpecificDay2(day);
                return isDeleted;
            }
            curr = curr.getNext();
        }
        return false;
    }

    /////*************************Update Methods********************************\\\\\
    /*
    Updates the Israeli power line data for a specific date in the linked
    list of days and the same thing for other update methods
     */
    public void updateIsraeliLine(String date, int newData) {
        MNode curr = head;
        String tmp[] = date.split("-");
        String month = tmp[1];
        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                curr.getDaysList().updateIsraeliLine(date, newData);
            }
            curr = curr.getNext();
        }
    }

    public void updateGazaPower(String date, int newData) {
        MNode curr = head;
        String tmp[] = date.split("-");
        String month = tmp[1];
        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                curr.getDaysList().updateGazaPower(date, newData);
            }
            curr = curr.getNext();
        }
    }

    public void updateEgyptianLine(String date, int newData) {
        MNode curr = head;
        String tmp[] = date.split("-");
        String month = tmp[1];
        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                curr.getDaysList().updateEgyptianLine(date, newData);
            }
            curr = curr.getNext();
        }
    }

    public void updatePowerCuts(String date, int newData) {
        MNode curr = head;
        String tmp[] = date.split("-");
        String month = tmp[1];
        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                curr.getDaysList().updatePowerCuts(date, newData);
            }
            curr = curr.getNext();
        }
    }

    public void updateTemp(String date, int newData) {
        MNode curr = head;
        String tmp[] = date.split("-");
        String month = tmp[1];
        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                curr.getDaysList().updateTemp(date, newData);
            }
            curr = curr.getNext();
        }
    }

    public void updateOverallDemand(String date, int newData) {
        MNode curr = head;
        String tmp[] = date.split("-");
        String month = tmp[1];
        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                curr.getDaysList().updateOverallDemand(date, newData);
            }
            curr = curr.getNext();
        }
    }

    public void updateYear(int year, int newData) {
        MNode curr = head;
        while (curr != null) {
            curr.getDaysList().updateYear(year, newData);
            curr = curr.getNext();
        }
    }
    ////===========================================================================\\\\\

    //Appends the day data for a specific month and day to a StringBuilder.
    public StringBuilder getMonthDayData(String month, String day) {
        StringBuilder sb = new StringBuilder();
        MNode curr = head;

        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                sb.append(curr.getDaysList().getDayData(day));
            }
            curr = curr.getNext();
        }
        return sb;
    }

    // Appends all day data for a specific month to a StringBuilder.
    public StringBuilder getMonthData(String month) {
        StringBuilder sb = new StringBuilder();
        MNode curr = head;

        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                sb.append(curr.getDaysList().getDays());
            }
            curr = curr.getNext();
        }
        return sb;
    }

    //Appends day data for a specific day across all months to a StringBuilder.
    public StringBuilder getMonthDayData(String day) {
        StringBuilder sb = new StringBuilder();
        MNode curr = head;

        while (curr != null) {
            sb.append(curr.getDaysList().getDayData(day));
            curr = curr.getNext();
        }
        return sb;
    }

    //Displays all months and their associated day data
    public StringBuilder displayMonthDayss() {
        MNode curr = head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append(curr.toString());
            curr = curr.getNext();
        }
        return sb;
    }

    //Displays a specific month and its associated day data
    public StringBuilder displayMonthDay(String month) {
        MNode curr = head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                sb.append(curr.toString());
            }
            curr = curr.getNext();
        }
        return sb;
    }

    public void displayMonths() {
        MNode curr = head;
        while (curr != null) {
            System.out.println(curr.getMonth());
            curr = curr.getNext();
        }
    }

    public void reverseData() {
        MNode prev = null;
        MNode curr = head;
        MNode next = null;

        while (curr != null) {
            next = curr.getNext(); // Save the next node
            curr.setNext(prev);    // Reverse the link
            prev = curr;           // Move prev to the current node
            curr = next;           // Move to the next node
        }

        head = prev;  // Update the head to the last node (which is now the first node after reversal)

        MNode currentMonth = head;
        while (currentMonth != null) {
            currentMonth.getDaysList().reversData();
            currentMonth = currentMonth.getNext();
        }

    }

    public boolean isDateEmpty(String date) {

        if (head == null) {
            return false;
        }

        String tmp[] = date.split("-");
        String month = tmp[1];
        MNode curr = head;
        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                return curr.getDaysList().isDateEmpty(date);
            }
            curr = curr.getNext();
        }
        return false;
    }

    //------------------------------------------------------------------------------
    public double calculateOperationOnIsraeliLine(String month, OperationType operationType) {
        MNode curr = head;
        double result = 0;

        if (curr != null) {
            result = curr.getDaysList().calculateOperationOnIsraeliLine(operationType);
            curr = curr.getNext();
        }
        if (month.equals("nun")) {
            while (curr != null) {
                switch (operationType) {
                    case TOTAL:
                        result += curr.getDaysList().calculateOperationOnIsraeliLine(operationType);
                        break;
                    case AVERAGE:
                        result += curr.getDaysList().calculateOperationOnIsraeliLine(operationType);
                        break;
                    case MAXIMUM:
                        result = Math.max(result, curr.getDaysList().calculateOperationOnIsraeliLine(operationType));
                        break;
                    case MINIMUM:
                        result = Math.min(result, curr.getDaysList().calculateOperationOnIsraeliLine(operationType));
                        break;
                }
                curr = curr.getNext();
            }
            if (operationType == OperationType.AVERAGE) {
                double sum = result;
                return sum / 12;
            }

        } else {
            while (curr != null) {
                if (curr.getMonth().equals(month)) {
                    result = curr.getDaysList().calculateOperationOnIsraeliLine(operationType);
                    break; // Break out of the loop once the correct month is found
                }
                curr = curr.getNext();
            }
        }
        return result;
    }

    public double calculateOperationOnGazaPowerLine(String month, OperationType operationType) {
        MNode curr = head;
        double result = 0;

        if (curr != null) {
            result = curr.getDaysList().calculateOperationOnGazaPowerLine(operationType);
            curr = curr.getNext();
        }
        if (month.equals("nun")) {
            while (curr != null) {
                switch (operationType) {
                    case TOTAL:
                        result += curr.getDaysList().calculateOperationOnGazaPowerLine(operationType);
                        break;
                    case AVERAGE:
                        result += curr.getDaysList().calculateOperationOnGazaPowerLine(operationType);
                        break;
                    case MAXIMUM:
                        result = Math.max(result, curr.getDaysList().calculateOperationOnGazaPowerLine(operationType));
                        break;
                    case MINIMUM:
                        result = Math.min(result, curr.getDaysList().calculateOperationOnGazaPowerLine(operationType));
                        break;
                }
                curr = curr.getNext();
            }
            if (operationType == OperationType.AVERAGE) {
                double sum = result;
                return sum / 12;
            }
        }

        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                result = curr.getDaysList().calculateOperationOnGazaPowerLine(operationType);
                break; // Break out of the loop once the correct month is found
            }
            curr = curr.getNext();
        }

        return result;
    }

    public double calculateOperationOnEgyptianLine(String month, OperationType operationType) {
        MNode curr = head;
        double result = 0;

        if (curr != null) {
            result = curr.getDaysList().calculateOperationOnEgyptianLine(operationType);
            curr = curr.getNext();
        }
        if (month.equals("nun")) {
            while (curr != null) {
                switch (operationType) {
                    case TOTAL:
                        result += curr.getDaysList().calculateOperationOnEgyptianLine(operationType);
                        break;
                    case AVERAGE:
                        result += curr.getDaysList().calculateOperationOnEgyptianLine(operationType);
                        break;
                    case MAXIMUM:
                        result = Math.max(result, curr.getDaysList().calculateOperationOnEgyptianLine(operationType));
                        break;
                    case MINIMUM:
                        result = Math.min(result, curr.getDaysList().calculateOperationOnEgyptianLine(operationType));
                        break;
                }
                curr = curr.getNext();
            }
            if (operationType == OperationType.AVERAGE) {
                double sum = result;
                return sum / 12;
            }
        }

        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                result = curr.getDaysList().calculateOperationOnEgyptianLine(operationType);
                break; // Break out of the loop once the correct month is found
            }
            curr = curr.getNext();
        }

        return result;
    }

    public double calculateOperationOnOverallDemand(String month, OperationType operationType) {
        MNode curr = head;
        double result = 0;

        if (curr != null) {
            result = curr.getDaysList().calculateOperationOnOverallDemand(operationType);
            curr = curr.getNext();
        }
        if (month.equals("nun")) {
            while (curr != null) {
                switch (operationType) {
                    case TOTAL:
                        result += curr.getDaysList().calculateOperationOnOverallDemand(operationType);
                        break;
                    case AVERAGE:
                        result += curr.getDaysList().calculateOperationOnOverallDemand(operationType);
                        break;
                    case MAXIMUM:
                        result = Math.max(result, curr.getDaysList().calculateOperationOnOverallDemand(operationType));
                        break;
                    case MINIMUM:
                        result = Math.min(result, curr.getDaysList().calculateOperationOnOverallDemand(operationType));
                        break;
                }
                curr = curr.getNext();
            }
            if (operationType == OperationType.AVERAGE) {
                double sum = result;
                return sum / 12;
            }
        }

        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                result = curr.getDaysList().calculateOperationOnOverallDemand(operationType);
                break; // Break out of the loop once the correct month is found
            }
            curr = curr.getNext();
        }

        return result;
    }

    public double calculateOperationOnPowerCuts(String month, OperationType operationType) {
        MNode curr = head;
        double result = 0;

        if (curr != null) {
            result = curr.getDaysList().calculateOperationOnPowerCuts(operationType);
            curr = curr.getNext();
        }
        if (month.equals("nun")) {
            while (curr != null) {
                switch (operationType) {
                    case TOTAL:
                        result += curr.getDaysList().calculateOperationOnPowerCuts(operationType);
                        break;
                    case AVERAGE:
                        result += curr.getDaysList().calculateOperationOnPowerCuts(operationType);
                        break;
                    case MAXIMUM:
                        result = Math.max(result, curr.getDaysList().calculateOperationOnPowerCuts(operationType));
                        break;
                    case MINIMUM:
                        result = Math.min(result, curr.getDaysList().calculateOperationOnPowerCuts(operationType));
                        break;
                }
                curr = curr.getNext();
            }
            if (operationType == OperationType.AVERAGE) {
                double sum = result;
                return sum / 12;
            }
        }

        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                result = curr.getDaysList().calculateOperationOnPowerCuts(operationType);
                break; // Break out of the loop once the correct month is found
            }
            curr = curr.getNext();
        }

        return result;
    }

    public double calculateOperationOnTemp(String month, OperationType operationType) {
        MNode curr = head;
        double result = 0;

        if (curr != null) {
            result = curr.getDaysList().calculateOperationOnTemp(operationType);
            curr = curr.getNext();
        }
        if (month.equals("nun")) {
            while (curr != null) {
                switch (operationType) {
                    case TOTAL:
                        result += curr.getDaysList().calculateOperationOnTemp(operationType);
                        break;
                    case AVERAGE:
                        result += curr.getDaysList().calculateOperationOnTemp(operationType);
                        break;
                    case MAXIMUM:
                        result = Math.max(result, curr.getDaysList().calculateOperationOnTemp(operationType));
                        break;
                    case MINIMUM:
                        result = Math.min(result, curr.getDaysList().calculateOperationOnTemp(operationType));
                        break;
                }
                curr = curr.getNext();
            }
            if (operationType == OperationType.AVERAGE) {
                double sum = result;
                return sum / 12;
            }
        }

        while (curr != null) {
            if (curr.getMonth().equals(month)) {
                result = curr.getDaysList().calculateOperationOnTemp(operationType);
                break; // Break out of the loop once the correct month is found
            }
            curr = curr.getNext();
        }

        return result;
    }

    //------------------------------------------------------------------------------
}
