package LinkedList;

import Nodes.DNode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The Days class represents a singly linked list of daily data, where each node
 * contains information about a specific day, including power line data, demand,
 * and temperature. It provides methods for inserting, deleting, and updating
 * daily data, as well as calculating various operations on the data.
 *
 * The class uses DNode to represent individual days, and it includes methods
 * for deleting all days data, deleting a specific day, updating different types
 * of data (Israeli line, Gaza power line, Egyptian line, overall demand, power
 * cuts, and temperature), reversing the order of data, and calculating total
 * values for each type of data.
 */
public class Days {

    private DNode head;

    public void insertDayData(String date, double israeli_Line, double gaza_Power_Line, double egyption_Line, double total_daily_supply, double overall_demand, double power_cuts, double temp) {

        // Check if the month abbreviation
        if (isMonthAbbreviation(date) == true) {
            // Convert the date format from "yyyy-MMM-dd" to "yyyy-MM-dd"
            String tmp[] = date.split("-");
            String month = convertMonthNameToNumber(tmp[1]);
            date = tmp[0] + "-" + month + "-" + tmp[2];
        }
        // Create a new node with the provided data
        DNode newNode = new DNode(date, israeli_Line, gaza_Power_Line, egyption_Line, total_daily_supply, overall_demand, power_cuts, temp);
        // Check if the linked list is empty or if the new date is earlier than the head date
        if (head == null || date.compareTo(head.getData().getDate()) < 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            // Traverse the linked list to find the correct position to insert the new node
            DNode curr = head;
            while (curr.getNext() != null && date.compareTo(head.getData().getDate()) > 0) {
                curr = curr.getNext();
            }
            newNode.setNext(curr.getNext());
            curr.setNext(newNode);
        }
    }

    public static boolean isMonthAbbreviation(String dateString) {
        try {
            // Try to parse the date using a formatter that expects a month abbreviation
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
            LocalDate.parse(dateString, formatter);
            return true;  // Parsing successful, month abbreviation is present
        } catch (Exception e) {
            return false; // Parsing failed, month abbreviation is not present
        }
    }

    public String convertMonthNameToNumber(String month) {

        if (month.equalsIgnoreCase("Jan")) {
            return "01";
        } else if (month.equalsIgnoreCase("Feb")) {
            return "02";
        } else if (month.equalsIgnoreCase("Mar")) {
            return "03";
        } else if (month.equalsIgnoreCase("Apr")) {
            return "04";
        } else if (month.equalsIgnoreCase("May")) {
            return "05";
        } else if (month.equalsIgnoreCase("Jun")) {
            return "06";
        } else if (month.equalsIgnoreCase("Jul")) {
            return "07";
        } else if (month.equalsIgnoreCase("Aug")) {
            return "08";
        } else if (month.equalsIgnoreCase("Sep")) {
            return "09";
        } else if (month.equalsIgnoreCase("Oct")) {
            return "10";
        } else if (month.equalsIgnoreCase("Nov")) {
            return "11";
        } else {
            return "12";
        }
    }
    //---------------------------------------------------------------------

    public boolean deleteAllDaysData() {
        if (head != null) {
            head = null; // Set the head of the days list to null, effectively removing all days' data.
            return true;
        }
        return false;// Already empty
    }

    public boolean deleteSpecificDay2(String day) {
        // Initialize the current node to the head of the linked list
        DNode curr = head;
        // Check if the linked list is empty
        if (head == null) {
            return false;
        }
        // Extract the day from the date of the current node
        String currDate[] = curr.getData().getDate().split("-");
        String currDay = currDate[2];
        // Check if the first node's day matches the specified day
        if (currDay.equals(day)) {
            head = curr.getNext();
            return true;// Deletion successful
        }
        // Traverse the linked list to find the node with the specified day
        while (curr.getNext() != null && !currDay.equals(day)) {
            curr = curr.getNext();
            // Check if there is a next node and update the current day
            if (curr.getNext() != null) {
                currDate = curr.getNext().getData().getDate().split("-");
                currDay = currDate[2];
            }
        }
        // Check if the end of the list is reached without finding the specified day
        if (curr.getNext() == null) {
            return false;// Specified day not found in the list
        }
        // Update the next reference of the preceding node to skip the node with the specified day
        curr.setNext(curr.getNext().getNext());
        return true;// Deletion successful
    }

    //---------------------------------------------------------------------
    public void updateIsraeliLine(String date, int newData) {
        DNode curr = head;
        String tmp[] = date.split("-");
        String day = tmp[2];

        double total;
        // Traverse the linked list to find the node with the specified date
        while (curr != null) {
            String tmp2[] = curr.getData().getDate().split("-");
            String currDay = tmp2[2];
            // Check if the current node's date matches the specified date
            if (currDay.equals(day)) {
                // Update Israeli power line data
                curr.getData().setIsraeli_Line(newData);
                // Recalculate the total daily supply
                total = curr.getData().getIsraeli_Line() + curr.getData().getEgyption_Line() + curr.getData().getGaza_Power_Line();
                curr.getData().setTotal_daily_supply(total);
                break; // Exit the loop once the update is done
            }
            curr = curr.getNext();
        }
    }

    // Repeat the same pattern for the other update methods...
    public void updateGazaPower(String date, int newData) {
        DNode curr = head;
        String tmp[] = date.split("-");
        String day = tmp[2];
        double total;

        while (curr != null) {
            String tmp2[] = curr.getData().getDate().split("-");
            String currDay = tmp2[2];
            if (currDay.equals(day)) {
                curr.getData().setGaza_Power_Line(newData);
                total = curr.getData().getIsraeli_Line() + curr.getData().getEgyption_Line() + curr.getData().getGaza_Power_Line();
                curr.getData().setTotal_daily_supply(total);
                break;
            }
            curr = curr.getNext();
        }
    }

    public void updateEgyptianLine(String date, int newData) {
        DNode curr = head;
        String tmp[] = date.split("-");
        String day = tmp[2];
        double total;
        while (curr != null) {
            String tmp2[] = curr.getData().getDate().split("-");
            String currDay = tmp2[2];
            if (currDay.equals(day)) {
                curr.getData().setEgyption_Line(newData);
                total = curr.getData().getIsraeli_Line() + curr.getData().getEgyption_Line() + curr.getData().getGaza_Power_Line();
                curr.getData().setTotal_daily_supply(total);
                break;
            }
            curr = curr.getNext();
        }
    }

    public void updateOverallDemand(String date, int newData) {
        DNode curr = head;
        String tmp[] = date.split("-");
        String day = tmp[2];

        while (curr != null) {
            String tmp2[] = curr.getData().getDate().split("-");
            String currDay = tmp2[2];
            if (currDay.equals(day)) {
                curr.getData().setOverall_demand(newData);
                break;
            }
            curr = curr.getNext();
        }
    }

    public void updatePowerCuts(String date, int newData) {
        DNode curr = head;
        String tmp[] = date.split("-");
        String day = tmp[2];

        while (curr != null) {
            String tmp2[] = curr.getData().getDate().split("-");
            String currDay = tmp2[2];
            if (currDay.equals(day)) {
                curr.getData().setPower_cuts(newData);
                break;
            }
            curr = curr.getNext();
        }
    }

    public void updateTemp(String date, int newData) {
        DNode curr = head;
        String tmp[] = date.split("-");
        String day = tmp[2];

        while (curr != null) {
            String tmp2[] = curr.getData().getDate().split("-");
            String currDay = tmp2[2];
            if (currDay.equals(day)) {
                curr.getData().setTemp(newData);
                break;
            }
            curr = curr.getNext();
        }
    }

    public void updateYear(int year, int newData) {
        DNode curr = head;
        while (curr != null) {
            String tmp[] = curr.getData().getDate().split("-");
            String month = tmp[1];
            String day = tmp[2];
            String newDate = newData + "-" + month + "-" + day;
            curr.getData().setDate(newDate);
            curr = curr.getNext();
        }
    }
    //---------------------------------------------------------------------

    private int getCountOfDays() {
        int count = 0;
        DNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.getNext();
        }

        return count;
    }

    //  Calculate the specified operation on the Israeli power line data.
    public double calculateOperationOnIsraeliLine(OperationType operationType) {
        DNode curr = head;
        double result = 0;
        // Check if the linked list is not empty
        if (curr != null) {
            // Initialize the result with the Israeli power line data of the first node
            result = curr.getData().getIsraeli_Line();
            curr = curr.getNext();
        }
        // Traverse the linked list to perform the specified operation on Israeli power line data
        while (curr != null) {
            double israeliLine = curr.getData().getIsraeli_Line();
            // Switch based on the operation type
            switch (operationType) {
                case TOTAL:
                    result += israeliLine;
                    break;
                case AVERAGE:// Average calculation will be handled separately after the loop
                    break;
                case MAXIMUM:
                    result = Math.max(result, israeliLine);
                    break;
                case MINIMUM:
                    result = Math.min(result, israeliLine);
                    break;
            }
            // Move to the next node
            curr = curr.getNext();
        }
        // Calculate the average if the operation type is AVERAGE
        if (operationType == OperationType.AVERAGE) {
            double sum = calculateTotalIsraeliLine();
            int count = getCountOfDays();
            if (count > 0) {
                return sum / count;
            } else {
                return 0; // Avoid division by zero
            }
        }

        return Math.round(result);
    }

    // Implementation similar to calculateOperationOnIsraeliLine, with modifications for Gaza power line
    public double calculateOperationOnGazaPowerLine(OperationType operationType) {
        DNode curr = head;
        double result = 0;

        if (curr != null) {
            result = curr.getData().getGaza_Power_Line();
            curr = curr.getNext();
        }

        while (curr != null) {
            double gazaLine = curr.getData().getGaza_Power_Line();

            switch (operationType) {
                case TOTAL:
                    result += gazaLine;
                    break;
                case AVERAGE:
                    break;
                case MAXIMUM:
                    result = Math.max(result, gazaLine);
                    break;
                case MINIMUM:
                    result = Math.min(result, gazaLine);
                    break;
            }

            curr = curr.getNext();
        }

        if (operationType == OperationType.AVERAGE) {
            double sum = calculateTotalGazaPowerLine();
            int count = getCountOfDays();
            if (count > 0) {
                return sum / count;
            } else {
                return 0; // Avoid division by zero
            }
        }

        return Math.round(result);
    }
    // Implementation similar to calculateOperationOnIsraeliLine, with modifications for Egyptian power line

    public double calculateOperationOnEgyptianLine(OperationType operationType) {
        DNode curr = head;
        double result = 0;

        if (curr != null) {
            result = curr.getData().getEgyption_Line();
            curr = curr.getNext();
        }

        while (curr != null) {
            double egyptionLine = curr.getData().getEgyption_Line();

            switch (operationType) {
                case TOTAL:
                    result += egyptionLine;
                    break;
                case AVERAGE:
                    break;
                case MAXIMUM:
                    result = Math.max(result, egyptionLine);
                    break;
                case MINIMUM:
                    result = Math.min(result, egyptionLine);
                    break;
            }

            curr = curr.getNext();
        }

        if (operationType == OperationType.AVERAGE) {
            double sum = calculateTotalEgyptianLine();
            int count = getCountOfDays();
            if (count > 0) {
                return sum / count;
            } else {
                return 0; // Avoid division by zero
            }
        }

        return Math.round(result);
    }

    // Implementation similar to calculateOperationOnIsraeliLine, with modifications for overall demand
    public double calculateOperationOnOverallDemand(OperationType operationType) {
        DNode curr = head;
        double result = 0;

        if (curr != null) {
            result = curr.getData().getOverall_demand();
            curr = curr.getNext();
        }

        while (curr != null) {
            double getOverallDemand = curr.getData().getOverall_demand();

            switch (operationType) {
                case TOTAL:
                    result += getOverallDemand;
                    break;
                case AVERAGE:
                    break;
                case MAXIMUM:
                    result = Math.max(result, getOverallDemand);
                    break;
                case MINIMUM:
                    result = Math.min(result, getOverallDemand);
                    break;
            }

            curr = curr.getNext();
        }

        if (operationType == OperationType.AVERAGE) {
            double sum = calculateTotalOverallDemand();
            int count = getCountOfDays();
            if (count > 0) {
                return sum / count;
            } else {
                return 0; // Avoid division by zero
            }
        }

        return Math.round(result);
    }

    // Implementation similar to calculateOperationOnIsraeliLine, with modifications for power cuts
    public double calculateOperationOnPowerCuts(OperationType operationType) {
        DNode curr = head;
        double result = 0;

        if (curr != null) {
            result = curr.getData().getPower_cuts();
            curr = curr.getNext();
        }

        while (curr != null) {
            double getPower_cuts = curr.getData().getPower_cuts();

            switch (operationType) {
                case TOTAL:
                    result += getPower_cuts;
                    break;
                case AVERAGE:
                    break;
                case MAXIMUM:
                    result = Math.max(result, getPower_cuts);
                    break;
                case MINIMUM:
                    result = Math.min(result, getPower_cuts);
                    break;
            }

            curr = curr.getNext();
        }

        if (operationType == OperationType.AVERAGE) {
            double sum = calculateTotalPowerCuts();
            int count = getCountOfDays();
            if (count > 0) {
                return sum / count;
            } else {
                return 0; // Avoid division by zero
            }
        }

        return Math.round(result);
    }

    // Implementation similar to calculateOperationOnIsraeliLine, with modifications for temperature
    public double calculateOperationOnTemp(OperationType operationType) {
        DNode curr = head;
        double result = 0;

        if (curr != null) {
            result = curr.getData().getTemp();
            curr = curr.getNext();
        }

        while (curr != null) {
            double getPower_cuts = curr.getData().getTemp();

            switch (operationType) {
                case TOTAL:
                    result += getPower_cuts;
                    break;
                case AVERAGE:
                    break;
                case MAXIMUM:
                    result = Math.max(result, getPower_cuts);
                    break;
                case MINIMUM:
                    result = Math.min(result, getPower_cuts);
                    break;
            }

            curr = curr.getNext();
        }

        if (operationType == OperationType.AVERAGE) {
            double sum = calculateTotalPowerCuts();
            int count = getCountOfDays();
            if (count > 0) {
                return sum / count;
            } else {
                return 0; // Avoid division by zero
            }
        }

        return Math.round(result);
    }

    public enum OperationType {
        TOTAL, AVERAGE, MAXIMUM, MINIMUM
    }

    //---------------------------------------------------------------------    
    public StringBuilder getDays() {
        StringBuilder sb = new StringBuilder();
        DNode curr = head;
        while (curr != null) {
            sb.append(curr.getData().toString()).append("\n");
            curr = curr.getNext();
        }
        return sb;
    }

    public StringBuilder getDayData(String day) {
        StringBuilder sb = new StringBuilder();
        DNode curr = head;
        while (curr != null) {
            String tmp[] = curr.getData().getDate().split("-");
            String currDay = tmp[2];
            if (currDay.equals(day)) {
                sb.append(curr.getData().toString()).append("\n");
            }
            curr = curr.getNext();
        }
        return sb;
    }

    public boolean isDateEmpty(String date) {

        if (isMonthAbbreviation(date) == true) {
            String tmp[] = date.split("-");
            String month = convertMonthNameToNumber(tmp[1]);
            date = tmp[0] + "-" + month + "-" + tmp[2];
        }
        if (head == null) {
            return false;
        }

        DNode curr = head;
        while (curr != null) {
            if (curr.getData().getDate().equals(date)) {
                return true;
            }
            curr = curr.getNext();
        }

        return false;
    }

    public void reversData() {
        DNode prev = null;
        DNode curr = head;
        DNode next = null;
        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DNode curr = head;
        while (curr != null) {
            sb.append(curr.getData().toString()).append("\n");
            curr = curr.getNext();
        }
        return sb.toString();
    }

    //--------------------------------------------------------------------- 
    public double calculateTotalIsraeliLine() {
        double total = 0;
        DNode curr = head;
        while (curr != null) {
            total += curr.getData().getIsraeli_Line();
            curr = curr.getNext();
        }
        return total;
    }

    public double calculateTotalGazaPowerLine() {
        double total = 0;
        DNode curr = head;
        while (curr != null) {
            total += curr.getData().getGaza_Power_Line();
            curr = curr.getNext();
        }
        return total;
    }

    public double calculateTotalEgyptianLine() {
        double total = 0;
        DNode curr = head;
        while (curr != null) {
            total += curr.getData().getEgyption_Line();
            curr = curr.getNext();
        }
        return total;
    }

    public double calculateTotalOverallDemand() {
        double total = 0;
        DNode curr = head;
        while (curr != null) {
            total += curr.getData().getOverall_demand();
            curr = curr.getNext();
        }
        return total;
    }

    public double calculateTotalPowerCuts() {
        double total = 0;
        DNode curr = head;
        while (curr != null) {
            total += curr.getData().getPower_cuts();
            curr = curr.getNext();
        }
        return total;
    }

    public double calculateTotalTemp() {
        double total = 0;
        DNode curr = head;
        while (curr != null) {
            total += curr.getData().getTemp();
            curr = curr.getNext();
        }
        return total;
    }

}
