
package z33;

import java.util.*;
import java.io.*;

public class Z33 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)throws IOException, FileNotFoundException {
        
    Macierz macierz = new Macierz();
    System.out.print("Podaj liczbe N: ");
    int n = scanner.nextInt();
    
    macierz.setN(n);
    
    macierz.Set0();
    
    System.out.print("Podaj liczbe, ktora chcesz wstawic: ");
    n = scanner.nextInt();
    System.out.print("Podaj do ktorej kolomny: ");
    int kol = scanner.nextInt();
    System.out.print("Podaj liczbe do ktorego wiersza: ");
    int wiersz = scanner.nextInt();
    

        

    
    
    macierz.WstawElement(n, kol, wiersz);
    
    macierz.WypiszMacierz();
    macierz.LiczSumy();
    
    macierz.ZapiszDoPliku();
    
    }
    
    
    
}

class Macierz {

    public int n;
    public int macierz[][] = new int[100][100];

    public int suma_wiersz1;
    public int suma_kol1;
    public int suma_przekatna;
    


    
        
    public void setN(int n){
    this.n = n;
    }
    
    
    public void Set0(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                macierz[i][j]=0;
            }
        }
        
    }

    public void WypiszMacierz(){
        
        System.out.print("\n");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(" " + macierz[i][j] + " ");
            }
            System.out.print("\n");
        }
 
    }

    
    public void WstawElement(int element, int wiersz, int kol){
        macierz[wiersz-1][kol-1]=element;
        
    }

    public void LiczSumy(){

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == 0)
                     this.suma_wiersz1 += macierz[i][j];            
                if(j == 0)
                    this.suma_kol1 += macierz[i][j];
                if( i==j)
                    this.suma_przekatna += macierz[i][j];
            }
            
        }
        
        System.out.print("\nSuma Wiersz 1 = " + this.suma_wiersz1);
        System.out.print("\nSuma Kolumna 1 = " + this.suma_kol1);
        System.out.print("\nSuma przekatna  = " + this.suma_przekatna + "\n");
        
        
    }

    
    public void ZapiszDoPliku() throws IOException, FileNotFoundException{
        System.out.print("Podaj nazwe katalogu: ");
        Scanner scanner = new Scanner(System.in);
        String nazwa_katalog = scanner.next();
        File katalog = new File( "C:/"+nazwa_katalog );
        if(katalog.isDirectory() == false){
            katalog.mkdirs();
        }
        try{
            System.out.print("Podaj nazwa pliku: ");
            String nazwa_pliku = scanner.next();
            FileWriter plik = new FileWriter("C:/"+nazwa_katalog+"/"+nazwa_pliku+".txt");
            BufferedWriter bufor = new BufferedWriter(plik);        
            
            bufor.write("Suma w kolumnie 1 = " + this.suma_kol1);
            bufor.newLine();
            bufor.write("Suma w wierszu 1 = " + this.suma_wiersz1);
            bufor.newLine();
            bufor.write("Suma po przekatnej = " + this.suma_przekatna);
            bufor.newLine();
            bufor.newLine();
            
            bufor.close();
            
        }catch(IOException e){
            System.out.print("Blad otwarcia pliku");
        }
        
        
        
    }

}