package ical;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class FormatData {
    private String dataInicial;
    private String dataFinal;
    private String dataExdate;
    private String frequencia;
    private String until;
    private String dia;
   

    public String dtstamp() {
        LocalDateTime agora = LocalDateTime.now();
        String res = agora.toString();
        String ano = res.substring(0, 4);
        String mes = res.substring(5, 7);
        String dia = res.substring(8, 10);
        String hora = res.substring(11, 13);
        String mm = res.substring(14, 16);
        String ss = res.substring(17, 19);
        String dtstamp = (ano + mes + dia + "T" + hora + mm + ss);        
        return dtstamp;

    }

    public boolean dtstart(int ano, int mes, int dia, int hr, int mm, int ss){
        try{
            LocalDateTime localDateTime = LocalDateTime.of(ano, mes, dia, hr, mm, ss);
            String dataInicialFormatada = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss"));  
            this.dataInicial=dataInicialFormatada;                     
            return true;
        }catch(Exception e){
            System.out.println("Inicio do evento inválido");
            System.out.println("Evento não cadastrado/atualizado\n");
            return false;
        }
    }

    public boolean dtend(int ano,int mes,int dia,int hr,int mm,int ss){
        try{
            LocalDateTime localDateTime = LocalDateTime.of(ano, mes, dia, hr, mm, ss);
            String dataFinalFormatada = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss"));
            this.dataFinal=dataFinalFormatada;
            return true;

        }catch(Exception e){
            System.out.println("Fim do evento inválido");
            System.out.println("Evento não cadastrado/atualizado\n");
            return false;

        }
    }

    public boolean until(int ano,int mes,int dia,int hr,int mm,int ss){
        try{
            LocalDateTime localDateTime = LocalDateTime.of(ano, mes, dia, hr, mm, ss);
            String dataUntilFormatada = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss"));
            this.until=dataUntilFormatada;
            return true;

        }catch(Exception e){
            System.out.println("data invalida");
            System.out.println("Evento não cadastrado\n");

            return false;

        }
    }

    public boolean exdate(int ano,int mes,int dia,int hr,int mm,int ss){
        try{
            LocalDateTime localDateTime = LocalDateTime.of(ano, mes, dia, hr, mm, ss);
            String dataExdateFormatada = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss"));
            this.dataExdate=dataExdateFormatada;
            return true;

        }catch(Exception e){
            System.out.println("data invalida");
            System.out.println("Evento não cadastrado/atualizado\n");
            return false;

        }
    }    

    public String freq(String frequencia){
        if(frequencia.contains("dia")){
            return this.frequencia="DAILY";
        }     
        else if(frequencia.contains("sem")){
            return this.frequencia="WEEKLY";
        } 
        else if(frequencia.contains("men")){
           return this.frequencia="MONTHLY";
        } 
        else if (frequencia.contains("anu")){
            return this.frequencia="YEARLY";
        }      
            return this.frequencia; 
    }

    public String dia(String dia){
        if(dia.contains("seg")){
            return this.dia="MO";
        }     
        else if(dia.contains("ter")){
            return this.dia="TU";
        } 
        else if(dia.contains("qua")){
           return this.dia="WE";
        } 
        else if (dia.contains("qui")){
            return this.dia="TH";
        }
        else if (dia.contains("sex")){
            return this.dia="FR";
        }
        else if (dia.contains("sab")){
            return this.dia="SA"; 
        } 
        else if (dia.contains("dom")){
            return this.dia="SU";
        }
            return this.dia; 
    }

    public String uuid(){
        String uuid=(UUID.randomUUID().toString());
        return uuid;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public boolean setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
        return true;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public boolean setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
        return true;
    }
    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getUntil() {
        return until;
    }

    public void setUntil(String until) {
        this.until = until;
    }
    

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }    


    public String getDataExdate() {
        return dataExdate;
    }

    public boolean setDataExdate(String dataExdate) {
        this.dataExdate = dataExdate;
        return true;
    }

    @Override
    public String toString() {
        return "FormatData [dataFinal=" + dataFinal + ", dataInicial=" + dataInicial + ", frequencia=" + frequencia
                + ", until=" + until + "]";
    }
   
}

