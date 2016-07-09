/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jorge
 */
public class Activity {
    private String description;
    private Date dataStart; 
    private Date dataEnd;
    private Float activityHours;
    
   /*
    public Activity(String description, String startDate, String endDate){
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        
        
    }
    */
    
    public Activity(String description, String startDate, String endDate,String activityHours) throws ParseException{
        this.description = description;
        
        //conversão da string startDate para o tipo date
        SimpleDateFormat formatoS = new SimpleDateFormat("dd/MM/yyyy");
        dataStart = formatoS.parse(startDate);
        
        //conversão da String endDate para o tipo date
        SimpleDateFormat formatoEnd = new SimpleDateFormat("dd/MM/yyyy");
        dataEnd = formatoEnd.parse(endDate);
        
        //conversão da String activityHours para Float
        Float horasAtividades = Float.valueOf(activityHours);
        
        if(horasAtividades == 1){
        //Calcula e atribui o numero de horas da atividade
        this.activityHours = calcActivityHours(dataStart,dataEnd);
        
        }else{
                
        this.activityHours = horasAtividades;
        }
        
        
    }

    public Activity() {
        
    }
     
    /**
     * Retora uma string dos atributos
     * @return Retorna uma string contendo os atributos de uma atividade
     */
    public String toString() {  
	return "descricao atividade: " + description + " CHA: " + activityHours.toString() + " data de inicio: " + dataStart + " data de termino: " + dataEnd;  
} 
    
    /**
     * Dado duas datas, calcula a quantidade de dias passado entre as duas
     * e multiplica por 8 para obter a quantidade de horas gastas na atividade
     * @param startDate Data de inicio da atividade
     * @param endDate Data do termino da atividade
     * @return A quantidade de horas que a atividade vale
     */
    private float calcActivityHours(Date startDate, Date endDate){
        long difference;
        int miliSecDay = 1000 * 60 * 60 * 24; //Quantidade de milisegundos em um dia
        float hoursSpent;
        int maxDayWork = 8;// Numero maxido de horas permitidas
        Calendar initDate = Calendar.getInstance();
                
        Calendar finalDate = Calendar.getInstance();
        
        initDate.set(Calendar.YEAR, startDate.getYear());
        initDate.set(Calendar.MONTH, startDate.getMonth());
        initDate.set(Calendar.DAY_OF_MONTH, startDate.getMonth());

        finalDate.set(Calendar.YEAR, endDate.getYear());
        finalDate.set(Calendar.MONTH, endDate.getMonth());
        finalDate.set(Calendar.DAY_OF_MONTH, endDate.getMonth());
        
        //Calcula a quandidade de milisegundos entre as duas datas e divide pela quantidade de milisegundos contidos em um dia, 
        //para descobrir quantos dias se passaram
        difference = (finalDate.getTimeInMillis() - initDate.getTimeInMillis()) / miliSecDay;
        
        //Calculo para descobrir o numero de horas trabalhadas
        hoursSpent = difference * maxDayWork;
        
        
        return hoursSpent;
    }

    public String getDescription() {
        return description;
    }


    public Float getActivityHours() {
        return activityHours;
    }


    public Date getStartDate() {
        return dataStart;
    }


    public Date getEndDate() {
        return dataEnd;
    }
}
