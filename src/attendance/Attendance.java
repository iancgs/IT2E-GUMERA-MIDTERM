package attendance;
    
import java.util.Scanner;


public class Attendance {
    Config conf = new Config();
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Attendance attendance = new Attendance();

        int action;
        do {
            System.out.println("1. Add Attendance Record");
            System.out.println("2. Display Attendance Records");
            System.out.println("3. Update Attendance Record");
            System.out.println("4. Delete Attendance Record");
            System.out.println("5. Exit");

            System.out.println("Enter action");
            action = sc.nextInt();
    
    
        switch (action) {
                case 1:
                    attendance.addAttendance();
                    break;

                case 2:
                   
                    break;

                case 3:
                   
                    break;

                case 4:
                   
                    break;

                case 5:
                    System.out.println("Exiting.....");
                    break;

                default:
                    System.out.println("Invalid action. Please try again");
            }
        } while (action != 5);
    }

   public void addAttendance(){
         Scanner sc = new Scanner(System.in);

          System.out.print("attendance id: ");
          String id = sc.next();
          System.out.print("attendance date: ");
          String date = sc.next();
          System.out.print("attendance status: ");
          String status = sc.next();
          System.out.print("attendance remarks: ");
          String remarks = sc.next();
          
          String sql = "INSERT INTO tbl_attendance (Attendance_id, attendance_date,attendance_status, attendance_remarks) VALUES ( ?, ?, ?, ?)";
            conf.addRecord(sql , id, date, status, remarks);

    }
   public void viewAttendance() {
            String qry = "SELECT * FROM tbl_attendance";
            String[] hrds = {"id","date", "status", "remarks"};
            String[] clmns = {"Attendance_id", "attendance_date", "attendance_status", "attendance_remarks"};

            conf.viewRecords(qry, hrds, clmns);
    }  
   
    private void updateAttendance() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Attendance ID to update: ");
        int id = sc.nextInt();

        System.out.println("New Date (YYYY-MM-DD): ");
        String date = sc.next();

        System.out.println("New Status (Present/Absent): ");         
        String status = sc.next();

        System.out.println("New Remarks: ");
        String remarks = sc.next();

        // Corrected SQL query
        String qry = "UPDATE tbl_attendance SET date = ?, status = ?, remarks = ? WHERE attendance_id = " + id;

        // Correct variable name
        conf.updateRecord(qry, date, status, remarks);      
    }

       
     private void deleteAttendance(){
            
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the ID to Delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM tbl_attendance WHERE r_id = ?";

        conf.deleteRecord(qry, id);
    }
}