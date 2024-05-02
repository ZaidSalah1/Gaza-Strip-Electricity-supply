package LinkedList;

import Nodes.YNode;
import LinkedList.Days.OperationType;
import java.util.ArrayList;
import java.util.List;

/*
 * The Years class represents a linked list of years, where each year has a list of months,
 * and each month contains information about days. It provides methods to manipulate and retrieve data
 * related to years, months, and days.
 */
public class Years {

    private YNode head;
    static StringBuilder reversed;

    // Method to insert a new year with all months (June to December)
    public void insertYear(int newYear) {//This method to insert a new year with all monthes Jun---to-->Dec
        YNode newNode = new YNode(newYear);

        if (head == null || newYear <= head.getYear()) {
            newNode.setNext(head);
            newNode.getMonthList().insertMonths();//Insert all monthes in year
            head = newNode;
        } else {
            YNode curr = head;
            while (curr.getNext() != null && newYear > curr.getNext().getYear()) {
                curr = curr.getNext();
            }
            newNode.getMonthList().insertMonths();//insert all monthes name in the new Node

            newNode.setNext(curr.getNext());
            curr.setNext(newNode);
        }
    }

    // Method to insert data for a specific day in a specific year and month
    public void insertDayData(double year, String month, String date, double israeli_Line, double gaza_Power_Line,
            double egyption_Line, double total_daily_supply, double overall_demand, double power_cuts, double temp) {
        //This method to insert the data in a specfic day date
        YNode curr = head;
        while (curr != null) {
            if (curr.getYear() == year) {
                curr.getMonthList().insertMonthDays(month, date, israeli_Line, gaza_Power_Line, egyption_Line, total_daily_supply, overall_demand, power_cuts, temp);
            }
            curr = curr.getNext();
        }
    }

    // Method to insert a new month for a specific year
    public void insertYearMonth(int year, String month) {
        YNode curr = head;
        while (curr != null) {
            if (curr.getYear() == year) {
                curr.getMonthList().insertMonth(month);
            }
            curr = curr.getNext();
        }
    }

    //--------------------------------------------------------------------
    // Method to delete an entire year node with all its data
    public boolean deleteYear(int year) {
        YNode curr = head;

        if (head == null) {
            return false; // List is empty, nothing to delete
        }

        if (curr != null && curr.getYear() == year) {
            head = curr.getNext();//Move the head to the next node
            return true;
        }
        while (curr.getNext() != null && curr.getNext().getYear() != year) {
            curr = curr.getNext();
        }
        if (curr.getNext() == null) {
            return false;//year not found
        }
        curr.setNext(curr.getNext().getNext());
        return true;
    }

    // Method to delete data for a specific month in a specific year
    public boolean deleteMonthData(int year, String month) {
        YNode curr = head;
        boolean isDeleted = false;
        while (curr != null) {
            if (curr.getYear() == year) {
                isDeleted = curr.getMonthList().deleteAllDaysData(month);
                return isDeleted;
            }
            curr = curr.getNext();
        }
        return isDeleted;
    }

    // Method to delete data for a specific month in a specific year
    public boolean deleteMonthDay(String date) {
        String tmp[] = date.split("-");
        int year = Integer.parseInt(tmp[0]);

        boolean isDeleted = false;
        YNode curr = head;
        while (curr != null) {
            if (curr.getYear() == year) {
                isDeleted = curr.getMonthList().deleteMonthDay(date);
                return isDeleted;
            }
            curr = curr.getNext();
        }
        return false;
    }

    public void deleteAllData() {
        head = null;
    }

    //--------------------------------------------------------------------
    // Methods to update various attributes for a specific day in a specific year and month
    public void updateIsraeliLine(String date, int newData) {
        YNode curr = head;
        String tmp[] = date.split("-");
        System.out.println("date: " + date);
        int year = Integer.parseInt(tmp[0]);
        System.out.println("year: " + year);
        while (curr != null) {
            if (curr.getYear() == year) {
                curr.getMonthList().updateIsraeliLine(date, newData);
                break;
            }
            curr = curr.getNext();
        }
    }

    public void updateGazaPower(String date, int newData) {
        YNode curr = head;
        String tmp[] = date.split("-");
        System.out.println("date: " + date);
        int year = Integer.parseInt(tmp[0]);
        System.out.println("year: " + year);
        while (curr != null) {
            if (curr.getYear() == year) {
                curr.getMonthList().updateGazaPower(date, newData);
                break;
            }
            curr = curr.getNext();
        }
    }

    public void updateEgyptianLine(String date, int newData) {
        YNode curr = head;
        String tmp[] = date.split("-");
        System.out.println("date: " + date);
        int year = Integer.parseInt(tmp[0]);
        System.out.println("year: " + year);
        while (curr != null) {
            if (curr.getYear() == year) {
                curr.getMonthList().updateEgyptianLine(date, newData);
                break;
            }
            curr = curr.getNext();
        }
    }

    public void updateOverallDemand(String date, int newData) {
        YNode curr = head;
        String tmp[] = date.split("-");
        System.out.println("date: " + date);
        int year = Integer.parseInt(tmp[0]);
        System.out.println("year: " + year);
        while (curr != null) {
            if (curr.getYear() == year) {
                curr.getMonthList().updateOverallDemand(date, newData);
                break;
            }
            curr = curr.getNext();
        }
    }

    public void updatePowerCuts(String date, int newData) {
        YNode curr = head;
        String tmp[] = date.split("-");
        System.out.println("date: " + date);
        int year = Integer.parseInt(tmp[0]);
        System.out.println("year: " + year);
        while (curr != null) {
            if (curr.getYear() == year) {
                curr.getMonthList().updatePowerCuts(date, newData);
                break;
            }
            curr = curr.getNext();
        }
    }

    public void updateTemp(String date, int newData) {
        YNode curr = head;
        String tmp[] = date.split("-");
        System.out.println("date: " + date);
        int year = Integer.parseInt(tmp[0]);
        System.out.println("year: " + year);
        while (curr != null) {
            if (curr.getYear() == year) {
                curr.getMonthList().updateTemp(date, newData);
                break;
            }
            curr = curr.getNext();
        }
    }

    public void updateYear(int oldYear, int newYear) {
        YNode curr = head;
        while (curr != null) {
            if (curr.getYear() == oldYear) {
                curr.setYear(newYear);
                curr.getMonthList().updateYear(newYear, newYear);
            }
            curr = curr.getNext();
        }
    }

    //--------------------------------------------------------------------
    // Method to retrieve data for a specific day across all years
    public StringBuilder dayAcross(String day) {
        StringBuilder sb = new StringBuilder();
        YNode curr = head;

        while (curr != null) {
            sb.append(curr.getMonthList().getMonthDayData(day));
            curr = curr.getNext();
        }

        return sb;
    }

    // Method to retrieve data for a specific month across all years
    public StringBuilder getMonthData(String month) {
        StringBuilder sb = new StringBuilder();
        YNode curr = head;
        while (curr != null) {
            sb.append(curr.getMonthList().getMonthData(month));
            curr = curr.getNext();
        }
        return sb;
    }

    // Method to check if a specific year exists in the list
    public boolean isYearExist(int year) {//Method to check if a specfic year is in the list or not
        YNode curr = head;
        while (curr != null) {
            if (curr.getYear() == year) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    // Method to retrieve a list of all years
    public List<Integer> getYears() {//Method to return all years to use it in combobox
        List<Integer> years = new ArrayList<>();
        YNode curr = head;
        while (curr != null) {
            years.add(curr.getYear());
            curr = curr.getNext();
        }
        return years;
    }

    // Method to search for data by year
    public StringBuilder searchByYear(int year) {
        StringBuilder sb = new StringBuilder();
        YNode curr = head;
        while (curr != null) {
            if (curr.getYear() == year) {
                sb.append(curr.toString());
            }
            curr = curr.getNext();
        }

        return sb;
    }

    // Method to search for data by year and month
    public StringBuilder searchYearMonth(int year, String month) {//search b month
        StringBuilder sb = new StringBuilder();
        YNode curr = head;

        while (curr != null) {
            if (curr.getYear() == year) {
                sb.append(curr.getMonthList().displayMonthDay(month));
            }
            curr = curr.getNext();
        }

        return sb;
    }

    // Method to search for data by day
    public StringBuilder searchDayData(String date) {//search by day
        StringBuilder sb = new StringBuilder();
        String tmp[] = date.split("-");
        int year = Integer.parseInt(tmp[0]);
        String month = tmp[1];
        String day = tmp[2];

        YNode curr = head;
        while (curr != null) {
            if (curr.getYear() == year) {
                sb.append(curr.getMonthList().getMonthDayData(month, day));
            }
            curr = curr.getNext();
        }
        return sb;
    }

    //Method for checking if the date have no data
    public boolean isDateEmpty(String date) {
        String tmp[] = date.split("-");
        int year = Integer.parseInt(tmp[0]);

        YNode curr = head;
        while (curr != null) {
            if (curr.getYear() == year) {
                return curr.getMonthList().isDateEmpty(date);
            }
            curr = curr.getNext();
        }
        return false;
    }

    //Method to reverse data
    public void reverseData() {
        YNode prev = null;
        YNode curr = head;
        YNode next = null;

        while (curr != null) {
            next = curr.getNext(); // Save the next node
            curr.setNext(prev);    // Reverse the link
            prev = curr;           // Move prev to the current node
            curr = next;           // Move to the next node
        }

        head = prev;  // Update the head to the last node (which is now the first node after reversal)

        YNode cuurentYear = head;
        while (cuurentYear != null) {
            cuurentYear.getMonthList().reverseData();
            cuurentYear = cuurentYear.getNext();
        }

    }

    // Method to print all data
    public StringBuilder display() {
        StringBuilder sb = new StringBuilder();
        YNode curr = head;
        while (curr != null) {
            sb.append(curr.toString());
            curr = curr.getNext();
        }
        return sb;
    }

    //--------------------------------------------------------------------
    // Methods to calculate operations on various attributes for a specific day
    public double calculateOperationOnIsraeliLine(String date, OperationType operationType) {
        String tmp[] = date.split("-");
        String month = tmp[1];
        double result = 0;
        int year = Integer.parseInt(tmp[0]);

        YNode curr = head;
        while (curr != null) {
            if (curr.getYear() == year) {
                result = curr.getMonthList().calculateOperationOnIsraeliLine(month, operationType);
                break;
            }
            curr = curr.getNext();
        }

        return Math.round(result);
    }

    public double calculateOperationOnGazaPowerLine(String date, OperationType operationType) {
        String tmp[] = date.split("-");
        String month = tmp[1];
        double result = 0;
        int year = Integer.parseInt(tmp[0]);

        YNode curr = head;
        while (curr != null) {
            if (curr.getYear() == year) {
                result = curr.getMonthList().calculateOperationOnGazaPowerLine(month, operationType);
                break;
            }
            curr = curr.getNext();
        }

        return Math.round(result);
    }

    public double calculateOperationOnEgyptianLine(String date, OperationType operationType) {
        String tmp[] = date.split("-");
        String month = tmp[1];
        double result = 0;
        int year = Integer.parseInt(tmp[0]);

        YNode curr = head;
        while (curr != null) {
            if (curr.getYear() == year) {
                result = curr.getMonthList().calculateOperationOnEgyptianLine(month, operationType);
                break;
            }
            curr = curr.getNext();
        }

        return Math.round(result);
    }

    public double calculateOperationOnOverallDemand(String date, OperationType operationType) {
        String tmp[] = date.split("-");
        String month = tmp[1];
        double result = 0;
        int year = Integer.parseInt(tmp[0]);

        YNode curr = head;
        while (curr != null) {
            if (curr.getYear() == year) {
                result = curr.getMonthList().calculateOperationOnOverallDemand(month, operationType);
                break;
            }
            curr = curr.getNext();
        }

        return Math.round(result);
    }

    public double calculateOperationOnPowerCuts(String date, OperationType operationType) {
        String tmp[] = date.split("-");
        String month = tmp[1];
        double result = 0;
        int year = Integer.parseInt(tmp[0]);

        YNode curr = head;
        while (curr != null) {
            if (curr.getYear() == year) {
                result = curr.getMonthList().calculateOperationOnPowerCuts(month, operationType);
                break;
            }
            curr = curr.getNext();
        }

        return Math.round(result);
    }

    public double calculateOperationOnTemp(String date, OperationType operationType) {
        String tmp[] = date.split("-");
        String month = tmp[1];
        double result = 0;
        int year = Integer.parseInt(tmp[0]);

        YNode curr = head;
        while (curr != null) {
            if (curr.getYear() == year) {
                result = curr.getMonthList().calculateOperationOnTemp(month, operationType);
                break;
            }
            curr = curr.getNext();
        }

        return Math.round(result);
    }

    //---------------------------------------------------------

    public void insert(int yearInput, String month, String date, double raeli_Line, double gaza_Power, double egy_line, double total, double overall_demand, int powercuts, double temp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
