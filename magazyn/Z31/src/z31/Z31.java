
package z31;


import java.util.*;

public class Z31 {
    
    public static Scanner scanner = new Scanner(System.in);


    
    public static void main(String[] args) {
        
        
            Magazyn magazyn = new Magazyn();
        List<ProduktWMagazynie> Koszyk = new ArrayList<>();
        int wybor;
  
               do{
            
        
            System.out.println("\nMenu: ");
            System.out.println("1. - przyjecie towaru");
            System.out.println("2. - Sprawdz stan magazynu");
            System.out.println("3. - Zakup towaru");
            System.out.println("4. - Wyjscie");
            wybor=scanner.nextInt();
            String slowo;
            
            switch(wybor){
                case 1: 
                    System.out.print("Czy chcesz dodac nowy produkt, czy zwiekszyc ilosc juz przebywajacych w magazynie? (1/0)\n");
                    int opcja = scanner.nextInt();
                    if(opcja == 1){
                        
                   
                    ProduktWMagazynie nowy_produkt = new ProduktWMagazynie();
                    
                    System.out.print("Podaj nazwe towaru: ");

                        slowo = scanner.next();
                        nowy_produkt.nazwa = slowo;
                        
                    System.out.print("Podaj cene towaru: ");
                        double cena;
                        cena = scanner.nextDouble();
                        nowy_produkt.cena = cena;
                        
                    System.out.print("Podaj ilosc towaru: ");
                        int ilosc;
                        ilosc = scanner.nextInt();
                        nowy_produkt.ilosc = ilosc;
                        
                    
                    magazyn.DodajProdukt(nowy_produkt);
                    }
                    else {
                        magazyn.WyswietlZawartosc();
                        System.out.print("Ktorego z towarow chcesz dolozyc? Podaj indeks");
                        int indeks = scanner.nextInt();
                        System.out.print("Wybrales pozycje: " + indeks + "\nTowar:" + magazyn.WyswietlJeden(indeks));
                        System.out.print("Ile sztuk chcesz dolozyc?");
                        int ilosc = scanner.nextInt();
                        magazyn.ZmienIlosc(indeks, ilosc);
                        System.out.print("Po dolozeniu: \nTowar: " + magazyn.WyswietlJeden(indeks));
                    }

                    break;
                    
                case 2:
                        magazyn.WyswietlZawartosc();
                    break;
                
                case 3:
                    System.out.println("Jaki towar chcesz zakupic");
                    magazyn.WyswietlZawartosc();
                    System.out.println("Podaj jego indeks: ");
                    int indeks = scanner.nextInt();
                    System.out.println("Ile sztuk?");
                    int ilosc = scanner.nextInt();
                    magazyn.ZmniejszIlosc(indeks, ilosc);
                    ProduktWMagazynie produkt_do_koszyka = new ProduktWMagazynie(magazyn.ListaProduktow.get(indeks-1).nazwa, magazyn.ListaProduktow.get(indeks-1).cena, ilosc);
                    Koszyk.add(produkt_do_koszyka);
                    System.out.println("Zawartosc koszyka: ");
                    double suma = 0;
                    for(int i = 0; i<Koszyk.size(); i++){        
                    double cena_tego_produktu = Koszyk.get(i).ilosc * Koszyk.get(i).cena;
                        System.out.println(( i+1) +". : \nNazwa:" + Koszyk.get(i).nazwa + "\nIlosc: " + Koszyk.get(i).ilosc + "\nCena za sztuke: "+ Koszyk.get(i).cena + "Cena laczna: " + cena_tego_produktu + "\n");
                        suma += cena_tego_produktu;
                    }
                    System.out.println("\nCena zamowienia: " + suma);
                    break;

                case 4:
                    System.out.print("Koniec\n");
                    break;
                default:
                    System.out.print("Nie ma takiej opcji\n");
                    break;
                
            }

        }while (wybor != 4);
        
        
    }
    
}
        


class ProduktWMagazynie extends Produkt{

    public int ilosc;
    
    public ProduktWMagazynie(){};
    
    ProduktWMagazynie(String nazwa, double cena, int ilosc){
        super(nazwa,cena);
        this.ilosc = ilosc;
    }
    
        public void ZmienIloscWMagazynie(int ilosc){
        this.ilosc += ilosc;
        
    }
        
         public void ZmniejszIloscWMagazynie(int ilosc){
        this.ilosc -= ilosc;
        
    }

        
    public String toStringMagazyn(){
        String s = super.toString();
        s += "Ilosc w magazynie: " + ilosc;
        return s;
    }
    
   

    
}


class Magazyn{
    

    

    public List<ProduktWMagazynie> ListaProduktow = new ArrayList<>();
    
    
    Magazyn(){
       ProduktWMagazynie produkt1 = new ProduktWMagazynie("rower gorski", 1499.99, 50);
       ProduktWMagazynie produkt2 = new ProduktWMagazynie("hulajnoga", 249.99, 20);
       ProduktWMagazynie produkt3 = new ProduktWMagazynie("kask", 49.99, 40);
       ProduktWMagazynie produkt4 = new ProduktWMagazynie("ochraniacze", 69.99, 10);
       
       ListaProduktow.add(produkt1);
       ListaProduktow.add(produkt2);
       ListaProduktow.add(produkt3);
       ListaProduktow.add(produkt4);

    }
    
    
    
    public void DodajProdukt(ProduktWMagazynie produkt){
        ListaProduktow.add(produkt);
    }
    
    public void WyswietlZawartosc(){
        if (ListaProduktow.size()>0){
            for(int i =0; i <ListaProduktow.size(); i++){
                System.out.println((i+1)+". " + ListaProduktow.get(i).toStringMagazyn());
            }
        }
    }
    
        public String WyswietlJeden(int indeks){
            String s = "";
        if(indeks<= ListaProduktow.size()){
            s = ListaProduktow.get(indeks-1).toStringMagazyn() + "\n";
        }
        return s;
    }
        public void ZmienIlosc(int indeks, int ilosc){
            ListaProduktow.get(indeks-1).ZmienIloscWMagazynie(ilosc);
        }
        
        public void ZmniejszIlosc(int indeks, int ilosc){
            ListaProduktow.get(indeks-1).ZmniejszIloscWMagazynie(ilosc);
        }

        
         public ProduktWMagazynie GetObiekt(int index){
        ProduktWMagazynie produkt_do_koszyka = ListaProduktow.get(index-1);
        
        return produkt_do_koszyka;
    }
        
        
        
}


class Produkt{
    public String nazwa;
    public double cena;
    
    Produkt(){};
    
    Produkt(String nazwa, double cena){
        this.nazwa = nazwa;
        this.cena = cena;
    }
    
 
    
    public String toString(){
        String s = "Nazwa: " + nazwa + "\n";
        s += "Cena: " + cena + "\n";

        return s;
        
    }
    
    
}