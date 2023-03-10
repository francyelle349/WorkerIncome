package Enumeracao.Trabalhador;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/*Fazendo um Código baseado em um diagrama de classe, o objetivo deste código é a de ler as informações de um funcionário e no final calcular quanto este funcionário ganhou baseado pelo mês/ano. */
import java.util.ArrayList;
import java.util.List;

public class Worker{
   
    private String nameOfTheEmployee;
    private WorkerLevel workerlevel;
    private Double BaseSalary;

    private Department department;
    

    private List <HourContract> contracts = new ArrayList<>();

   

    public Worker(){
        
    }
    
    public Worker(String nameOfTheEmployee, WorkerLevel workerlevel, Double baseSalary, Department department) {
        this.nameOfTheEmployee = nameOfTheEmployee;
        this.workerlevel = workerlevel;
        BaseSalary = baseSalary;
        this.department = department;
    }
    
    public String getNameOfTheEmployee() {
        return nameOfTheEmployee;
    }
    public void setNameOfTheEmployee(String nameOfTheEmployee) {
        this.nameOfTheEmployee = nameOfTheEmployee;
    }
    public WorkerLevel getWorkerlevel() {
        return workerlevel;
    }
    public void setWorkerlevel(WorkerLevel workerlevel) {
        this.workerlevel = workerlevel;
    }

    public Double getBaseSalary() {
        return BaseSalary;
    }
    public void setBaseSalary(Double baseSalary) {
        BaseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department departament) {
        this.department = departament;
    }
    
     public List<HourContract> getContract() {
        return contracts;
    }

    //Não posso ter um set de contracts, pois não posso trocar esta lista por outra lista, isso porque já tenho os metodos add e remove contract
    
    public void addContract(HourContract contract){
        contracts.add(contract);

    }
    public void removeContract(HourContract contract){
        contracts.remove(contract);

    }

    public Double income(int year, int month){

        double sum = BaseSalary;

        DateTimeFormatter converter = DateTimeFormatter.ofPattern("MM/yyyy");

        LocalDate date = LocalDate.of(year,month, 1);
        

        for(HourContract x: contracts ){

            if(date.format(converter).equals( x.getDate().format(converter))){
                sum += (x.getValuePerHour()*x.getHours());  
            }
        }
        return sum;
    }
}