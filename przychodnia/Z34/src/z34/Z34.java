
package z34;

import java.util.*;
import java.io.*;


public class Z34 {

    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException, FileNotFoundException {
        
        
        Przychodnia przychodnia = new Przychodnia();

        int wybor;
  
               do{
            
        
            System.out.println("\nMenu: ");
            System.out.println("1. - Dodaj pacjenta"); // ok
            System.out.println("2. - Dodaj lekarza"); // ok
            System.out.println("3. - Dodaj wizyte"); // ok
            System.out.println("4. - Usun pacjenta"); // ok
            System.out.println("5. - Usun lekarza"); // ok
            System.out.println("6. - Usun wizyte"); // ok
            System.out.println("7. - Wyswietl i zapisz wizyty");
            System.out.println("8. - Wyswietl i zapisz pacjentow");
            System.out.println("9. - Wyswietl i zapisz lekarzy");
            System.out.println("10 - Wyjdz\n");
            
            wybor=scanner.nextInt();
            String slowo;
            
            switch(wybor){
                case 1: 
                    System.out.print("\nPodaj imie pacjenta: \t");
                    String imie = scanner.next();
                    System.out.print("\nPodaj nazwisko pacjenta: \t");
                    String nazwisko = scanner.next();
                    System.out.print("\nPodaj miasto pacjenta: \t");
                    String miasto = scanner.next();
                    System.out.print("\nPodaj ulice pacjenta: \t");
                    String ulica = scanner.next();
                    System.out.print("\nPodaj nr_domu pacjenta: \t");
                    String nr_domu = scanner.next();
                    System.out.print("\nPodaj date urodzenia pacjenta: \t");
                    String data_ur = scanner.next();
                    
                    Pacjent pacjent = new Pacjent(imie, nazwisko, miasto, ulica, nr_domu, data_ur);
                    przychodnia.DodajPacjenta(pacjent);
                    break;
                    
                case 2:
                    System.out.print("\nPodaj imie lekarza: \t");
                     imie = scanner.next();
                    System.out.print("\nPodaj nazwisko lekarza: \t");
                     nazwisko = scanner.next();
                    System.out.print("\nPodaj miasto lekarza: \t");
                     miasto = scanner.next();
                    System.out.print("\nPodaj ulice lekarza: \t");
                     ulica = scanner.next();
                    System.out.print("\nPodaj nr_domu lekarza: \t");
                     nr_domu = scanner.next();
                    System.out.print("\nPodaj date urodzenia lekarza: \t");
                     data_ur = scanner.next();
                     
                     System.out.print("\nPodaj specjalizacje lekarza: \t");
                     String specjalizacja = scanner.next();
                    
                    Lekarz lekarz = new Lekarz(imie, nazwisko, miasto, ulica, nr_domu, data_ur, specjalizacja);
                    przychodnia.DodajLekarza(lekarz);
                    break;
                    
                    
                case 3:
                    System.out.print("\nPodaj nr pacjenta: \t");
                    int nrPac = scanner.nextInt();
                    System.out.print("\nPodaj nr lekarza: \t");
                    int nrLek = scanner.nextInt();
                    System.out.print("\nPodaj date :\t");
                    String data = scanner.next();
                    Wizyta wizyta = new Wizyta(przychodnia.ListaPacjentow.get(nrPac-1), przychodnia.ListaLekarzy.get(nrLek-1), data);
                    przychodnia.DodajWizyte(wizyta);
                    break;
                case 4:
                    System.out.print("\nPodaj nr pacjenta do usuniecia: \t");
                    int numer = scanner.nextInt();
                    if(przychodnia.ListaPacjentow.size()>=numer){
                        przychodnia.UsunPacjenta(przychodnia.ListaPacjentow.get(numer-1));
                    }
                    else  System.out.print("\nNie ma takiego pacjenta\n");
                    break;
                case 5:
                    System.out.print("\nPodaj nr pacjenta do usuniecia: \t");
                    numer = scanner.nextInt();
                    if(przychodnia.ListaLekarzy.size()>=numer){
                        przychodnia.UsunLekarza(przychodnia.ListaLekarzy.get(numer-1));
                    }
                    else  System.out.print("\nNie ma takiego lekarza\n");
                    break;
                case 6:
                    
                    System.out.print("\nPodaj nr wizyty do usuniecia: \t");
                    numer = scanner.nextInt();
                    if(przychodnia.ListaWizyt.size()>=numer){
                        przychodnia.UsunWizyte(przychodnia.ListaWizyt.get(numer-1));
                    }
                    else  System.out.print("\nNie ma takiej wizyty\n");
                    
                    break;
                case 7:
                    przychodnia.WypiszListeWizyt();
                    przychodnia.ZapiszListeWizyt();
                    break;
                case 8:
                    przychodnia.WypiszListePacjentow();
                    przychodnia.ZapiszListePacjentow();
                    break;
                case 9:
                    przychodnia.WypiszListeLekarzy();
                    przychodnia.ZapiszListeLekarzy();
                    break;
            }
 
    }while(wybor != 10);
    
    
    }
}


abstract class Czlowiek{
    
    String imie;
    String nazwisko;
    String miasto;
    String ulica;
    String nr_domu;
    String data_ur;
    
    
    Czlowiek(){}
    
    Czlowiek (String imie, String nazwisko, String miasto, String ulica, String nr_domu, String data_ur){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nr_domu = nr_domu;
        this.data_ur = data_ur;
        
    }
}

class Przychodnia{
    
    List<Lekarz> ListaLekarzy = new ArrayList<>();
    List<Pacjent> ListaPacjentow = new ArrayList<>();
    List<Wizyta> ListaWizyt = new ArrayList<>();
    
    public void DodajLekarza(Lekarz lekarz){
        ListaLekarzy.add(lekarz);
    }
    
    public void DodajPacjenta(Pacjent pacjent){
        ListaPacjentow.add(pacjent);
    }
    
    public void DodajWizyte(Wizyta wizyta){
        ListaWizyt.add(wizyta);
    }
    
    
    public void UsunLekarza(Lekarz lekarz){
        ListaLekarzy.remove(lekarz);
    }
    
    public void UsunPacjenta(Pacjent pacjent){
        ListaPacjentow.remove(pacjent);
    }
    
    
    public void UsunWizyte(Wizyta wizyta){
        ListaWizyt.remove(wizyta);
    }
    
    public void WypiszListePacjentow(){
        if(ListaPacjentow.size()<=0)
            System.out.print("\nZaden pacjent nie został dodany.\n");
        else {
            for( int i = 0; i<ListaPacjentow.size(); i++){
                System.out.print("\n" + (i+1) + "\nImie = " + ListaPacjentow.get(i).imie);
                System.out.print("\nNazwisko = " + ListaPacjentow.get(i).nazwisko);
                System.out.print("\nMiasto = " + ListaPacjentow.get(i).miasto);
                System.out.print("\nUlica = " + ListaPacjentow.get(i).ulica);
                System.out.print("\nNr domu = " + ListaPacjentow.get(i).nr_domu);
                System.out.print("\nData ur = " + ListaPacjentow.get(i).data_ur);
                System.out.print("\nChoroba = " + ListaPacjentow.get(i).choroba + "\n");
            }
        }
        
    }
    
    
    public void WypiszListeLekarzy(){
        if(ListaLekarzy.size()<=0)
            System.out.print("Zaden lekarz nie został dodany. \n");
        else {
            for( int i = 0; i<ListaPacjentow.size(); i++){
                System.out.print("\n" + (i+1) + "\nImie = " + ListaLekarzy.get(i).imie);
                System.out.print("\nNazwisko = " + ListaLekarzy.get(i).nazwisko);
                System.out.print("\nMiasto = " + ListaLekarzy.get(i).miasto);
                System.out.print("\nUlica = " + ListaLekarzy.get(i).ulica);
                System.out.print("\nNr domu = " + ListaLekarzy.get(i).nr_domu);
                System.out.print("\nData ur = " + ListaLekarzy.get(i).data_ur);
                System.out.print("\nSpecjalizacja = " + ListaLekarzy.get(i).specjalizacja + "\n");
            }
        }
        
    }
    
    
    public void WypiszListeWizyt(){
        if(ListaWizyt.size()<=0)
            System.out.print("Zadena wizyta nie została dodana. \n");
        else {
            for( int i = 0; i<ListaWizyt.size(); i++){
                System.out.print("\n" + (i+1) + "\nImie = " + ListaWizyt.get(i).pacjent.imie);
                System.out.print("\nNazwisko = " + ListaWizyt.get(i).pacjent.nazwisko);
                System.out.print("\nLekarz: ");
                System.out.print("\nImie = " + ListaWizyt.get(i).lekarz.imie);
                System.out.print("\nNazwisko = " + ListaWizyt.get(i).lekarz.nazwisko);
                System.out.print("\nData = " + ListaWizyt.get(i).data + "\n");
            }
        }
        
    }
    
    
    public void ZapiszListeLekarzy()throws IOException, FileNotFoundException{
         File katalog = new File( "C:/przychodnia" );
        if(katalog.isDirectory() == false){
            katalog.mkdirs();
        }
        
        try{
            FileWriter plik = new FileWriter("C:/przychodnia/ListaLekarzy.txt");
            BufferedWriter bufor = new BufferedWriter(plik);        
            
            for(int i = 0; i<ListaLekarzy.size();i++){
                bufor.write("Imie = " + ListaLekarzy.get(i).imie);
                bufor.newLine();
                bufor.write("Nazwisko = " + ListaLekarzy.get(i).nazwisko);
                bufor.newLine();
                bufor.write("Miasto = " + ListaLekarzy.get(i).miasto);
                bufor.newLine();
                bufor.write("Ulica = " + ListaLekarzy.get(i).ulica);
                bufor.newLine();
                bufor.write("Nr domu = " + ListaLekarzy.get(i).nr_domu);
                bufor.newLine();
                bufor.write("Ulica = " + ListaLekarzy.get(i).data_ur);
                bufor.newLine();
                bufor.write("Specjalizacja = " + ListaLekarzy.get(i).specjalizacja);
                bufor.newLine();
                bufor.newLine();
            }
            bufor.close();
            
            
        }catch(IOException e){
            System.out.print("Blad otwarcia pliku. \n");
        }
    }
    
    public void ZapiszListePacjentow()throws IOException, FileNotFoundException{
        
        File katalog = new File( "C:/przychodnia" );
        if(katalog.isDirectory() == false){
            katalog.mkdirs();
        }
        
        try{
            FileWriter plik = new FileWriter("C:/przychodnia/ListaPacjentow.txt");
            BufferedWriter bufor = new BufferedWriter(plik);        
            
            for(int i = 0; i<ListaPacjentow.size();i++){
                bufor.write("Imie = " + ListaPacjentow.get(i).imie);
                bufor.newLine();
                bufor.write("Nazwisko = " + ListaPacjentow.get(i).nazwisko);
                bufor.newLine();
                bufor.write("Miasto = " + ListaPacjentow.get(i).miasto);
                bufor.newLine();
                bufor.write("Ulica = " + ListaPacjentow.get(i).ulica);
                bufor.newLine();
                bufor.write("Nr domu = " + ListaPacjentow.get(i).nr_domu);
                bufor.newLine();
                bufor.write("Ulica = " + ListaPacjentow.get(i).data_ur);
                bufor.newLine();
                bufor.write("Choroba = " + ListaPacjentow.get(i).choroba);
                bufor.newLine();
                bufor.newLine();
            }
            bufor.close();
            
            
        }catch(IOException e){
            System.out.print("Blad otwarcia pliku. \n");
        }
    }
        
        
    
    
    public void ZapiszListeWizyt()throws IOException, FileNotFoundException{
          File katalog = new File( "C:/przychodnia" );
        if(katalog.isDirectory() == false){
            katalog.mkdirs();
        }
        
        try{
            FileWriter plik = new FileWriter("C:/przychodnia/ListaWizyt.txt");
            BufferedWriter bufor = new BufferedWriter(plik);        
            
            for(int i = 0; i<ListaWizyt.size();i++){
                bufor.write("Pacjent: ");
                bufor.newLine();
                bufor.write("Imie = " + ListaWizyt.get(i).pacjent.imie);
                bufor.newLine();
                bufor.write("Nazwisko = " + ListaWizyt.get(i).pacjent.nazwisko);
                bufor.newLine();
                bufor.write("Lekarz: ");
                bufor.newLine();
                bufor.write("Imie = " + ListaWizyt.get(i).lekarz.imie);
                bufor.newLine();
                bufor.write("Nazwisko = " + ListaWizyt.get(i).lekarz.nazwisko);
                bufor.newLine();
                bufor.write("Data = " + ListaWizyt.get(i).data);
                bufor.newLine();

                bufor.newLine();
            }
            bufor.close();
            
            
        }catch(IOException e){
            System.out.print("Blad otwarcia pliku. \n");
        }
        
        
        
    }
    
    
}

class Wizyta{
    Pacjent pacjent;
    Lekarz lekarz;
    String data;

    Wizyta(Pacjent pacjent, Lekarz lekarz, String data){
        this.pacjent = pacjent;
        this.lekarz = lekarz;
        this.data = data;
        
    }
   
    
}

class Lekarz extends Czlowiek{
    String specjalizacja;
    
     Lekarz(String imie, String nazwisko, String miasto, String ulica, String nr_domu, String data_ur, String specjalizacja){
        super(imie,nazwisko,miasto,ulica,nr_domu,data_ur);
        this.specjalizacja = specjalizacja;
        
    }
}

class Pacjent extends Czlowiek{
    String choroba;
    
     Pacjent(String imie, String nazwisko, String miasto, String ulica, String nr_domu, String data_ur){
        super(imie,nazwisko,miasto,ulica,nr_domu,data_ur);
        this.choroba = "nieznana";
        
    }
}