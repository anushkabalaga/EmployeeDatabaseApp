package com.employee.www;
import java.sql.*;
import java.util.Scanner;

public class EmployeeDatabaseApp {

    public static void main(String[] args) throws ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        final String URL = "jdbc:mysql://localhost:3306/company_db";
        final String USER = "root";
        final String PASSWORD = "root"; // change to your MySQL password

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connected to Database!");

            while (true) {
                System.out.println("\n--- Employee Database Menu ---");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                if (choice == 1) {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();

                    String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setString(1, name);
                        pstmt.setString(2, dept);
                        pstmt.setDouble(3, salary);
                        int rows = pstmt.executeUpdate();
                        System.out.println(rows > 0 ? "Employee added!" : "Failed to add employee.");
                    }

                } else if (choice == 2) {
                    String sql = "SELECT * FROM employees";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql);
                         ResultSet rs = pstmt.executeQuery()) {
                        System.out.println("\nID\tName\tDepartment\tSalary");
                        System.out.println("--------------------------------------");
                        while (rs.next()) {
                            System.out.printf("%d\t%s\t%s\t%.2f\n",
                                    rs.getInt("id"),
                                    rs.getString("name"),
                                    rs.getString("department"),
                                    rs.getDouble("salary"));
                        }
                    }

                } else if (choice == 3) {
                    System.out.print("Enter Employee ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter new department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter new salary: ");
                    double salary = sc.nextDouble();

                    String sql = "UPDATE employees SET name=?, department=?, salary=? WHERE id=?";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setString(1, name);
                        pstmt.setString(2, dept);
                        pstmt.setDouble(3, salary);
                        pstmt.setInt(4, id);
                        int rows = pstmt.executeUpdate();
                        System.out.println(rows > 0 ? "Employee updated!" : "No employee found.");
                    }

                } else if (choice == 4) {
                    System.out.print("Enter Employee ID to delete: ");
                    int id = sc.nextInt();

                    String sql = "DELETE FROM employees WHERE id=?";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setInt(1, id);
                        int rows = pstmt.executeUpdate();
                        System.out.println(rows > 0 ? "Employee deleted!" : " No employee found.");
                    }

                } else if (choice == 5) {
                    System.out.println("Exiting...");
                    break;

                } else {
                    System.out.println("Invalid choice! Try again.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
