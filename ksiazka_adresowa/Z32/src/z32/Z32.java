package z32;

import java.util.*;
import java.io.*;


public class Z32 {

    public static Scanner scanner = new Scanner(System.in);
  
    public static void main(String[] args) throws IOException, FileNotFoundException{
        int wybor = 0;
        KsiazkaAdresowa ksiazkaAdresowa = new KsiazkaAdresowa();
       
        
        do{
            
        
            System.out.println("\nMenu: ");
            System.out.println("1. - Odczyt Wszystkich zapisow");
            System.out.println("2. - Dodaj pozycje");
            System.out.println("3. - Pokaz dane z wybranej pozycji");
            System.out.println("4. - Pokaz wszystkie pozycje");
            System.out.println("5. - Zapis wszystkich pozycji");
            System.out.println("6. - Wyjscie");
            wybor=scanner.nextInt();
            
            switch(wybor){
                case 1: 
                    ksiazkaAdresowa.PokazListeAdresow();
                    break;
                case 2:
                    Adres adres = new Adres();
                    String dane;
                    System.out.print("Podaj miasto: ");
                    dane=scanner.next();
                    adres.SetMiasto(dane);
                    
                    System.out.print("Podaj ulice: ");
                    dane=scanner.next();
                    adres.SetUlica(dane);
                    
                    System.out.print("Podaj nr domu: ");
                    dane=scanner.next();
                    adres.SetNr_Domu(dane);
                    
                    System.out.print("Podaj kod pocztowy: ");
                    dane=scanner.next();
                    adres.SetKodPocztowy(dane);
                    
                    ksiazkaAdresowa.DodajAdres(adres);
                    break;
                
                case 3:
                    System.out.println("Podaj nr pozycji adresu do wyswietlenia\n");
                    int pozycja;
                    pozycja=scanner.nextInt();
                    ksiazkaAdresowa.PokazKonretnyAdres(pozycja);
                    break;
                case 4:
                    ksiazkaAdresowa.PokazListeAdresow();
                    break;
                case 5:
                    ksiazkaAdresowa.ZapiszDoPliku();

                    
                    break;
                case 6:
                    System.out.print("Koniec\n");
                    break;
                default:
                    System.out.print("Nie ma takiej opcji\n");
                    break;
                
            }

        }while (wybor != 6);
        
        
    }
    
}




class KsiazkaAdresowa{

    private List<Adres> listaAdresow = new ArrayList<>();
    
    public void DodajAdres(Adres adres){
        listaAdresow.add(adres);
    }
    
    public void UsunAdres(Adres adres){
        listaAdresow.remove(adres);
    }
    
    public void PokazListeAdresow(){
        if(listaAdresow.size()>0){
        for (int i =0; i<listaAdresow.size(); i++){
            
            System.out.println("1. " + listaAdresow.get(i).toString() + "\n\n");
            }
        }
        else System.out.print("Nie dodano jeszcze zadnych pozycji\n");
    }
    
    int GetSize(){
        return listaAdresow.size();
    }
    
    public void PokazKonretnyAdres(int i){
        if(listaAdresow.size()>=i-1)
        System.out.print(listaAdresow.get(i-1).toString());
        else System.out.print("nie ma takiej pozycji\n");
    }
        
        public String PokazListeAdresowString(){
            String s = "";
        if(listaAdresow.size()>0){
        for (int i =0; i<listaAdresow.size(); i++){
            
            s += "1. " + listaAdresow.get(i).toString() + "\n\n";
            }
        
        }
        else System.out.print("Nie dodano jeszcze zadnych pozycji\n");
        return s;
    }
        
        
    public void ZapiszDoPliku()  throws IOException, FileNotFoundException{
        
                    String nowy_katalog = "test";
                    File katalog = new File("C:/"+nowy_katalog);
                    boolean spr;
                    spr = katalog.isDirectory();
                    if(spr == false){
                        katalog.mkdirs();
                    }
                    
                    
                    try
                    {
                    FileWriter plik = new FileWriter("C:/"+nowy_katalog+"/zad32.txt", true);
                    BufferedWriter bufor = new BufferedWriter(plik);
                    for(int i = 0 ; i< listaAdresow.size(); i++){
                        bufor.write("Miasto: " + listaAdresow.get(i).GetMiasto());   
                        bufor.newLine();
                    
                        bufor.write("Ulica: " + listaAdresow.get(i).GetUlica());   
                        bufor.newLine();
                    
                        bufor.write("Nr domu: " + listaAdresow.get(i).GetNr_domu());   
                        bufor.newLine();
                    
                        bufor.write("Kod pocztowy: " + listaAdresow.get(i).GetKodPocztowy());   
                        bufor.newLine();
                        bufor.newLine();
                    

                    }
                    bufor.close();
      
                    }catch(IOException e)
                    {System.out.print("Brak pliku");}
                        
                    
    }    
    

}


class Adres{

    String ulica;
    String nr_domu;
    String miasto;
    String kod_pocztowy;
    
    Adres(){};
    
    void SetUlica(String ulica){
        this.ulica = ulica;
    }
    
    void SetMiasto(String miasto){
        this.miasto = miasto;
    }
    
    void SetKodPocztowy(String kod_pocztowy){
        this.kod_pocztowy = kod_pocztowy;
    }
    
    void SetNr_Domu(String nr_domu){
        this.nr_domu = nr_domu;
    }
    
    public String GetUlica(){
        return ulica;
    }
    
    public String GetMiasto(){
        return miasto;
    }
    
    public String GetKodPocztowy(){
        return kod_pocztowy;
    }
    
    public String GetNr_domu(){
        return nr_domu;
    }
    
   public String toString(){
        String s = "Miasto: " + this.miasto + "\n";
        s += "Ulica: " + this.ulica + "\n";
        s += "Nr domu: " + this.nr_domu + "\n";
        s += "Kod pocztowy: " + this.kod_pocztowy + "\n";
        return s;
    }
    
}
