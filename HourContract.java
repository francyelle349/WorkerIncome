package Enumeracao.Trabalhador;

import java.time.LocalDate;


public class HourContract {
    private LocalDate date;
    
    private Double valuePerHour;
    private Integer HoursOfTheDay;

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }
    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }
    public Integer getHours() {
        return HoursOfTheDay;
    }
    public void setHours(Integer hours) {
        this.HoursOfTheDay = hours;
    }
    public HourContract(LocalDate date, Double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        HoursOfTheDay = hours;
    }

    
    

    
}
