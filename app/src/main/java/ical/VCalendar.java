package ical;


public class VCalendar {

    final String BGNVCALENDAR="BEGIN:VCALENDAR";
    final String VERSION="VERSION:2.0";   
    final String PROD="PRODID:-//POO//PROJETO1//PT";
    final String BGNVEVENT="BEGIN:VEVENT";
    final String ENDVEVENT="END:VEVENT";
    final String ENDVCALENDAR="END:VCALENDAR";   
    private FormatData data = new FormatData(); // Inancia OBJ da classe FormatData, criada para analise e formulação dos
                                        //correta dos parametros da norma que regem o .ICAL
    private String nomeEmpresa;
    private String nomeApp;
    private String idioma;
    private int anoInicial;
    private int mesInicial;
    private int diaInicial;
    private int hrInicial;
    private int mmInicial;
    private int ssInicial;
    private int anoFinal;
    private int mesFinal;
    private int diaFinal;
    private int hrFinal;
    private int mmFinal;
    private int ssFinal;
    private int anoFRep;
    private int mesFRep;
    private int diaFRep;
    private int heFRep;
    private int mmFRep;
    private int ssFRep;
    private int anoEx;
    private int mesEx;
    private int diaEx;
    private int interval;
    private String freq;
    private String byday;   
    private String summary; //O assunto do evento
    private String location; //Um texto livre para indicar o local do evento
    String dtstamp; //indica a data e hora que a instância do iCalendar foi criada
    String dtstart; // Indica a data e hora que o evento começa
    String dtend; //Indica a data e hora que o evento termina 
    String uuid;  //identificador único universal (UUID) algo como: 48021fb2-78ca-4bf6-aa67-f96aa6f39413   
    String until; //fim do evento recorrente
    String exdate;//evento excluída de eventos recorrentes
    String rrule;
    String prodid;
    //construtor sem RRULE
    public VCalendar(String empresa, String app,String lingua,int anoInicial, int mesInicial, int diaInicial, int hrInicial, int mmInicial,int ssInicial,int anoFinal, int mesFinal, 
    int diaFinal, int hrFinal, int mmFinal,int ssFinal, String summary, String location) {
            this.nomeEmpresa=empresa;
            this.nomeApp=app;
            this.idioma=lingua;
            this.anoInicial = anoInicial;
            this.mesInicial = mesInicial;
            this.diaInicial = diaInicial;
            this.hrInicial = hrInicial;
            this.mmInicial = mmInicial;
            this.ssInicial=ssInicial;
            this.anoFinal = anoFinal;
            this.mesFinal = mesFinal;
            this.diaFinal = diaFinal;
            this.hrFinal = hrFinal;
            this.mmFinal = mmFinal; 
            this.ssFinal=ssFinal;          
            this.summary = summary;
            this.location = location; 

            prodid();
            dtstamp();
            dtstart();               
            dtend();             
            uuid();
    }

    //construtor com RRULE sem EXDATE
    public VCalendar(String empresa, String app,String lingua,int anoInicial, int mesInicial, int diaInicial, int hrInicial, int mmInicial,int ssInicial,int anoFinal, int mesFinal, 
    int diaFinal, int hrFinal, int mmFinal,int ssFinal, String summary, String location,String frequencia,int intervalo,
    int anoFRep, int mesFRep,int diaFRep,int heFRep, int mmFRep,int ssFRep,String dia){
            this.nomeEmpresa=empresa;
            this.nomeApp=app;
            this.idioma=lingua;
            this.anoInicial = anoInicial;
            this.mesInicial = mesInicial;
            this.diaInicial = diaInicial;
            this.hrInicial = hrInicial;
            this.mmInicial = mmInicial;
            this.anoFinal = anoFinal;
            this.mesFinal = mesFinal;
            this.diaFinal = diaFinal;
            this.hrFinal = hrFinal;
            this.mmFinal = mmFinal;
            this.ssInicial=ssInicial;
            this.anoFRep = anoFRep;
            this.mesFRep = mesFRep;
            this.diaFRep = diaFRep;
            this.heFRep = heFRep;
            this.mmFRep = mmFRep;
            this.ssFRep = ssFRep;
            this.ssFinal=ssFinal;
            this.summary = summary;
            this.location = location;
            this.freq=frequencia;
            this.interval=intervalo; 
            this.byday=dia;            

            prodid();
            dtstamp();
            dtstart();               
            dtend();  
            until();           
            uuid();  
            freq();
            until();
            byday(); 
            rrule();      
    }

    //construtor com RRULE com EXDATE
    public VCalendar(String empresa, String app,String lingua,int anoInicial, int mesInicial, int diaInicial, int hrInicial, int mmInicial,int ssInicial,int anoFinal, int mesFinal, 
    int diaFinal, int hrFinal, int mmFinal,int ssFinal, String summary, String location,String frequencia,int intervalo,
    int anoFRep, int mesFRep,int diaFRep,int heFRep, int mmFRep,int ssFRep,String dia, int anoEx,int mesEx,int diaEx){
            this.nomeEmpresa=empresa;
            this.nomeApp=app;
            this.idioma=lingua;
            this.anoInicial = anoInicial;
            this.mesInicial = mesInicial;
            this.diaInicial = diaInicial;
            this.hrInicial = hrInicial;
            this.mmInicial = mmInicial;
            this.anoFinal = anoFinal;
            this.mesFinal = mesFinal;
            this.diaFinal = diaFinal;
            this.hrFinal = hrFinal;
            this.mmFinal = mmFinal;
            this.ssInicial=ssInicial;
            this.anoFRep = anoFRep;
            this.mesFRep = mesFRep;
            this.diaFRep = diaFRep;
            this.heFRep = heFRep;
            this.mmFRep = mmFRep;
            this.ssFRep = ssFRep;
            this.ssFinal=ssFinal;
            this.summary = summary;
            this.location = location;
            this.freq=frequencia;
            this.interval=intervalo; 
            this.byday=dia;
            this.anoEx=anoEx;
            this.mesEx=mesEx;
            this.diaEx=diaEx;            

            prodid();
            dtstamp();
            dtstart();               
            dtend();  
            until();           
            uuid();  
            freq();
            until();
            byday(); 
            rrule();  
            exdate();    
    }

    //chama metodo DTSTAMP(HORARIO ATUAL DA INSTANCIA)
    public boolean dtstamp(){      
        this.dtstamp=data.dtstamp();
        return true;

    }

    //chama metodo DTEND(HORARIO FINAL DO EVENTO)
    public String dtend(){        
            data.dtend(this.anoFinal, this.mesFinal, this.diaFinal, this.hrFinal, this.mmFinal, this.ssFinal); 
            if(data.getDataFinal().equals(null)){
                return null;
            }
            return this.dtend=data.getDataFinal();       
    }  

    //chama metodo DTSTART(HORARIO INICIAL DO EVENTO)
    public String dtstart(){            
        data.dtstart(this.anoInicial, this.mesInicial, this.diaInicial, this.hrInicial, this.mmInicial, this.ssInicial);  
        if(data.getDataInicial().equals(null)){
            return this.dtstart=null;
        }
         return this.dtstart=data.getDataInicial();   
    }
    
    ////chama metodo UNTIL(HORARIO FINAL DA REPETIÇÃO)    
    public String until(){            
            data.until(this.anoFRep, this.mesFRep, this.diaFRep, this.heFRep, this.mmFRep, this.ssFRep);  
            if(data.getUntil().equals(null)){
                return null;
        }
                return this.until=data.getUntil();     
    } 

    //chama metodo EXDATE(DIA EXCLUIDO DO EVENTO NA REPETIÇÃO)
    public String exdate(){            
        data.exdate(this.anoEx, this.mesEx, this.diaEx, this.hrInicial, this.mmInicial, this.ssInicial);  
        if(data.getDataExdate().equals(null)){
            return null;
    }
            return this.exdate=data.getDataExdate();          

    }   

    //chama metodo UUID(IDENTIFICADOR UNICO DE CADA EVENTO)
    public String uuid(){
        return this.uuid=data.uuid();
    }
    //chama metodo Freq(Converte padrao PT, para padrão .ICAL)
    public String freq(){
        data.freq(freq);
        return this.freq=data.getFrequencia();
    }

    //chama metodo BYDAY(Converte padrao PT, para padrão .ICAL)
    public String byday(){
        data.dia(byday);
        return this.byday=data.getDia();
    }

    //Concatena os parametros que formam a RRULE(REPETIÇÃO)
    public String rrule(){        
        return this.rrule="RRULE:"+"FREQ="+freq.toString()+";"+"INTERVAL="+interval+";"+"UNTIL="+until.toString()+";"+"BYDAY="+byday.toString();        
    }

    //Concatena os parametros que formam a PRODID(IDENTIFICAÇÃO DO APP)
    public String prodid(){        
        return this.prodid="PRODID:-//"+nomeEmpresa+"//"+nomeApp+"//"+idioma;      
    }       

    public String getSummary() {
        return summary;
    }

    public String setSummary(String summary) {
        return this.summary = summary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }    
 
    public String getUntil() {
        return until;
    }

    public String getDtstart() {
        return dtstart;
    }
    

    public void setDtstart(int ano,int mes, int dia,int hr,int mm,int ss){
        data.dtstart(ano, mes, dia, hr, mm, ss);
        if(data.getDataInicial().equals(null)){
            this.dtstart=null;
        }
        this.dtstart=data.getDataInicial(); 
    }    

    public String getDtend() {
        return dtend;
    }

    public void setDtend(int ano,int mes, int dia,int hr,int mm,int ss) {
        data.dtend(ano, mes, dia, hr, mm, ss);
        if(data.getDataFinal().equals(null)){
            this.dtend=null;
        }
        this.dtend=data.getDataFinal(); 
    }

    public void setUntil(String until) {
        this.until = until;
    }   
   

    public String getExdate() {
        return exdate;
    }

    public void setExdate(int ano,int mes, int dia) {
        data.exdate(ano, mes, dia, this.hrInicial, this.mmInicial, this.ssInicial);
        if(data.getDataExdate().equals(null)){
            this.exdate=null;
        }
        this.exdate=data.getDataExdate(); 
    }
    

    

    
    @Override
    public String toString() {        
        //retorno toString(), caso o evento tenha RRULE e EXDATE
        if(rrule!=null){ 
            if(exdate!=null){  
                 return VERSION+"\n"+prodid+"\n"+BGNVEVENT+"\n"+"SUMMARY: "+summary+"\n"+"DTSTAMP:"+dtstamp+"\n"+"DTSTART:"
                        +dtstart+"\n"+"DTEND:"+dtend+"\n"+"UID: "+uuid+"\n"+rrule+"\n"+"EXDATE:"+exdate+"\n"+"LOCATION:"+location+"\n"+ENDVEVENT;
             
            //retorno toString(), caso o evento tenha RRULE e não tenha EXDATE
            }else{
                return VERSION+"\n"+prodid+"\n"+BGNVEVENT+"\n"+"SUMMARY: "+summary+"\n"+"DTSTAMP:"+dtstamp+"\n"+"DTSTART:"
                        +dtstart+"\n"+"DTEND:"+dtend+"\n"+"UID: "+uuid+"\n"+rrule+"\n"+"LOCATION:"+location+"\n"+ENDVEVENT;
                }
            }   
                
                 //retorno toString(), caso o evento não tenha RRULE e nem EXDATE
                return VERSION+"\n"+prodid+"\n"+BGNVEVENT+"\n"+"SUMMARY: "+summary
                        +"\n"+"UID: "+uuid+"\n"+"DTSTAMP:"+dtstamp+"\n"+"DTSTART:"+dtstart+"\n"+"DTEND:"
                        +dtend+"\n"+"LOCATION:"+location+"\n"+ENDVEVENT;
        } 
}