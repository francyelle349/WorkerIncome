package Enumeracao.Trabalhador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Executar {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter department Name:");
        String departmentName = sc.nextLine
        ();
        System.out.println("Enter worker data:");
        
        System.out.print("name:");
        String workerName = sc.nextLine();
        System.out.print("Level:");
        String workerLevel = sc.nextLine();
        System.out.print("Salary:");
        Double workerBaseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary,new Department(departmentName));

        System.out.print("How many contracts to this worker:");

        int numberOfContracts = sc.nextInt();
        sc.nextLine();
        int count = 0;
        for(int i = 0; i < numberOfContracts;i++){
            count++;
            System.out.printf("Enter contract %s data:%n",count);
            System.out.println("FORMAT: DD/MM/YYYY:");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dateString = sc.nextLine();
            LocalDate date = LocalDate.parse(dateString,formatter);
            System.out.print("Value per Hour:");
            Double valuePerHour = sc.nextDouble();
            System.out.print("Hours (Contract):");
            sc.nextLine();
            int hours = sc.nextInt();
            sc.nextLine();
            HourContract contract = new HourContract(date,valuePerHour,hours);
            worker.addContract(contract);

        }
        System.out.print("Enter month and year to calculate Income MM/YYYY:");
        String StringYearAndMonth = sc.nextLine();
        String stringyear = StringYearAndMonth.substring(0,2);
        String stringMonth = StringYearAndMonth.substring(3,7);
        int year = Integer.parseInt(stringyear);
        int month = Integer.parseInt(stringMonth);
        System.out.println("Name: "+worker.getNameOfTheEmployee());
        System.out.println("Department:"+worker.getDepartment().getName());
        System.out.print("Income for "+StringYearAndMonth+": ");
        System.out.print(worker.income(month,year));
        


        sc.close();

    }
    
}
