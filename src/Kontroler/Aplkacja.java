package Kontroler;

import Model.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplkacja {

    private static ListaFilmow listaFilmow = new ListaFilmow(new ArrayList<>(
            List.of(
                    new Film(1,"Kill Bill", 2003, 111,  50.00, "dobry", "Polski"),
                    new Film(2,"Kill Bill 2", 2004, 137,  50.00, "dobry", "Angielski"),
                    new Film(3, "Szklana pułapka", 1988, 132, 55, "dobry", "Polski"),
                    new Film(4, "Szklana pułapka 2", 1990, 124, 65, "dobry", "Angielski"),
                    new Film(5, "Szklana pułapka 3", 1995, 128, 50, "dobry", "Polski")
            )
    ));

    private static ArrayList<Klient> listaKlientow = new ArrayList<>(
            List.of(
                    new Klient(1, "Andrzej", "Olszewski", 21, "Wittiga 8", 123456789),
                    new Klient(2, "Jan", "Kowalski", 50, "Długa 12", 987654321)
                    )
    );

    public static void wyswietlKlientow(){
        for(Klient klient : listaKlientow){
            System.out.println(klient.toString());
        }
    }

    public static void dodajKlienta(int id, String imie, String nazwisko, int wiek, String adres, int telefon){
        listaKlientow.add(new Klient(id, imie, nazwisko, wiek, adres, telefon));
    }

    public static void usunKlienta(int id){
        listaKlientow.removeIf(klient -> klient.getId() == id);
    }

    public static void zaktualizujKlienta(int id, String imie, String nazwisko, int wiek, String adres, int telefon){
        for(Klient klient : listaKlientow){
            if(klient.getId() == id){
                klient.setImie(imie);
                klient.setNazwisko(nazwisko);
                klient.setWiek(wiek);
                klient.setAdres(adres);
                klient.setTelefon(telefon);
            }
        }
    }

    public static void wyswietlGlowneMenu(){
        System.out.println("================== MENU ==================\n");
        System.out.println("1. Lista klientów");
        System.out.println("2. Lista filmów");
        System.out.println("0. Wyjście");
    }

    public static void filmMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int idFilmu, rokWydania, czasTrwania;
        String nazwaFilmu, stan, jezyk;
        double cena;

        do{
            System.out.println("================== MENU Filmów ==================\n");
            System.out.println("1. Wyświetl listę filmow");
            System.out.println("2. Dodaj nowy film do listy");
            System.out.println("3. Usuń film z listy");
            System.out.println("4. Zaktualizuj dane filmu");
            System.out.println("0. Wyjście");
            int wyborOperacji = Integer.parseInt(scanner.nextLine());

            switch (wyborOperacji){
                case 0:{
                    quit = true;
                    break;
                }
                case 1:{
                    listaFilmow.wyswietlListeFilmow();
                    break;
                }
                case 2:{

                    System.out.println("Podaj nazwę filmu: ");
                    nazwaFilmu = scanner.nextLine();
                    System.out.println("Podaj stan: ");
                    stan = scanner.nextLine();
                    System.out.println("Podaj jezyk: ");
                    jezyk = scanner.nextLine();
                    try {
                        System.out.println("Podaj rok wydania: ");
                        rokWydania = Integer.parseInt(scanner.nextLine());
                        System.out.println("Podaj czas trwania [min]: ");
                        czasTrwania = Integer.parseInt(scanner.nextLine());
                        System.out.println("Podaj cenę [zl]: ");
                        cena = Integer.parseInt(scanner.nextLine());
                        listaFilmow.dodajFilm(nazwaFilmu,rokWydania,czasTrwania,cena,stan,jezyk);
                    }catch(NumberFormatException e){
                        System.out.println("Podano zly format danych");
                    }
                    break;
                }
                case 3:{
                    listaFilmow.wyswietlListeFilmow();
                    System.out.println("Podaj id filmu do usunięcia");
                    idFilmu = Integer.parseInt(scanner.nextLine());
                    listaFilmow.usunFilm(idFilmu);
                    break;
                }
                case 4:{
                    listaFilmow.wyswietlListeFilmow();
                    System.out.println("Podaj id: ");
                    idFilmu = Integer.parseInt(scanner.nextLine());
                    for(Film film : listaFilmow.getListaFilmow()){
                        if(film.getNumerFilmu()==idFilmu){
                            System.out.println("Podaj nazwę filmu: ");
                            nazwaFilmu = scanner.nextLine();
                            System.out.println("Podaj stan: ");
                            stan = scanner.nextLine();
                            System.out.println("Podaj jezyk: ");
                            jezyk = scanner.nextLine();
                            try {
                                System.out.println("Podaj rok wydania: ");
                                rokWydania = Integer.parseInt(scanner.nextLine());
                                System.out.println("Podaj czas trwania: ");
                                czasTrwania = Integer.parseInt(scanner.nextLine());
                                System.out.println("Podaj cenę: ");
                                cena = Integer.parseInt(scanner.nextLine());

                                listaFilmow.zaktualizujFilm(idFilmu, nazwaFilmu, rokWydania, czasTrwania, cena, stan, jezyk);
                            }catch(NumberFormatException e){
                                System.out.println("Podano zly format danych");
                            }
                            break;
                        }
                        else{
                            System.out.println("Nie ma filmu o takim indeksie");
                        }
                    }
                    break;
                }
                default: {
                    System.out.println("Źle podana opcja");
                }
            }

        }while (!quit);
    }

    public static void klientMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int id, wiek, telefon;
        int maxID = listaKlientow.size();
        String imie, nazwisko, adres;

        do {
            System.out.println("================== MENU KLIENTA ==================\n");
            System.out.println("1. Wyświetl listę klientów");
            System.out.println("2. Dodaj nowego klienta");
            System.out.println("3. Usuń klienta");
            System.out.println("4. Zaktualizuj dane klienta");
            System.out.println("5. Wypożycz film klientowi");
            System.out.println("6. Zarezerwuj film klientowi");
            System.out.println("7. Zwróć film z wypożyczenia");
            System.out.println("8. Zwolnij film z rezerwacji");
            System.out.println("0. Wyjście");
            int wyborOperacji = Integer.parseInt(scanner.nextLine());

            switch (wyborOperacji) {
                case 0: {
                    quit = true;
                    break;
                }
                case 1: {
                    wyswietlKlientow();
                    break;
                }
                case 2: {
                    System.out.println("Podaj imie: ");
                    imie = scanner.nextLine();
                    System.out.println("Podaj nazwisko: ");
                    nazwisko = scanner.nextLine();
                    System.out.println("Podaj adres: ");
                    adres = scanner.nextLine();
                    try {
                        System.out.println("Podaj wiek: ");
                        wiek = Integer.parseInt(scanner.nextLine());
                        System.out.println("Podaj telefon: ");
                        telefon = Integer.parseInt(scanner.nextLine());
                        maxID++;
                        dodajKlienta(maxID, imie, nazwisko, wiek, adres, telefon);
                    }catch(NumberFormatException e){
                        System.out.println("Podano zly format danych");
                    }
                    break;
                }
                case 3: {
                    wyswietlKlientow();
                    System.out.println("Podaj id klienta do usunięcia");
                    id = Integer.parseInt(scanner.nextLine());
                    usunKlienta(id);
                    break;
                }
                case 4:{
                    wyswietlKlientow();
                    System.out.println("Podaj id: ");
                    id = Integer.parseInt(scanner.nextLine());
                    for(Klient klient : listaKlientow) {
                        if (klient.getId() == id) {
                            System.out.println("Podaj imie: ");
                            imie = scanner.nextLine();
                            System.out.println("Podaj nazwisko: ");
                            nazwisko = scanner.nextLine();
                            System.out.println("Podaj adres: ");
                            adres = scanner.nextLine();
                            try {
                                System.out.println("Podaj wiek: ");
                                wiek = Integer.parseInt(scanner.nextLine());
                                System.out.println("Podaj telefon: ");
                                telefon = Integer.parseInt(scanner.nextLine());
                                zaktualizujKlienta(id, imie, nazwisko, wiek, adres, telefon);
                            } catch (NumberFormatException e) {
                                System.out.println("Podano zly format danych");
                            }
                            break;
                        }
                        else{
                            System.out.println("Nie ma klienta o takim indeksie");
                            break;
                        }
                    }
                    break;
                }
                case 5:{
                    boolean czyKlientIstnieje = false;
                    listaFilmow.wyswietlListeFilmow();
                    System.out.println("Podaj numer filmu do wypożyczenia");
                    id = Integer.parseInt(scanner.nextLine());
                    Film film = listaFilmow.przekazFilmDoWyp(id);
                    if(film == null){
                        System.out.println("Źle podany numer filmu");
                        break;
                    }
                    System.out.println("Podaj id klienta który wypożycza film");
                    id = Integer.parseInt(scanner.nextLine());
                    for(Klient klient : listaKlientow){
                        if(klient.getId()==id){
                            List<Wypozyczenie> temp = klient.getListaWypozyczen();
                            temp.add(new Wypozyczenie(film));
                            klient.setListaWypozyczen(temp);
                            czyKlientIstnieje = true;
                            break;
                        }
                    }
                    if(!czyKlientIstnieje){
                        System.out.println("Źle podany indeks klienta");
                        listaFilmow.wrocFilmZWyp(film);
                    }
                    break;
                }
                case 6:{
                    boolean czyKlientIstnieje = false;
                    listaFilmow.wyswietlListeFilmow();
                    System.out.println("Podaj numer filmu do rezrwacji");
                    id = Integer.parseInt(scanner.nextLine());
                    Film film = listaFilmow.przekazFilmDoRez(id);
                    if(film == null){
                        System.out.println("Źle podany numer filmu");
                        break;
                    }
                    System.out.println("Podaj id klienta który rezrewuje film");
                    id = Integer.parseInt(scanner.nextLine());
                    for(Klient klient : listaKlientow){
                        if(klient.getId()==id){
                            List<Rezerwacja> temp = klient.getListaRezerwacje();
                            temp.add(new Rezerwacja(film));
                            klient.setListaRezerwacje(temp);
                            czyKlientIstnieje = true;
                            break;
                        }
                    }
                    if(!czyKlientIstnieje){
                        System.out.println("Źle podany indeks klienta");
                        listaFilmow.wrocFilmZRez(film);
                    }
                    break;
                }
                case 7:{
                    wyswietlKlientow();
                    boolean czyKlientIstnieje = false;
                    System.out.println("Podaj id klienta który oddaje film");
                    id = Integer.parseInt(scanner.nextLine());
                    for(Klient klient : listaKlientow){
                        if(klient.getId() == id){
                            czyKlientIstnieje = true;
                            System.out.println("Podaj numer filmu do zwrotu");
                            id = Integer.parseInt(scanner.nextLine());
                            List<Wypozyczenie>temp =  klient.getListaWypozyczen();
                            int counter = 0;
                            for(Wypozyczenie t : temp){
                                if(t.getWypozyczonyFilm().getNumerFilmu() == id){
                                    break;
                                }
                                counter++;
                            }
                            try {
                                Wypozyczenie wypozyczenie = temp.remove(counter);
                                listaFilmow.wrocFilmZWyp(wypozyczenie.getWypozyczonyFilm());
                            }catch (IndexOutOfBoundsException e){
                                System.out.println("Źle podany indeks filmu");
                                break;
                            }
                            break;
                        }
                    }
                    if(!czyKlientIstnieje){
                        System.out.println("Źle podany indeks klienta");
                        break;
                    }
                    break;
                }
                case 8:{
                    wyswietlKlientow();
                    boolean czyKlientIstnieje = false;
                    System.out.println("Podaj id klienta który kończy rezerwację");
                    id = Integer.parseInt(scanner.nextLine());
                    for(Klient klient : listaKlientow){
                        if(klient.getId() == id){
                            czyKlientIstnieje = true;
                            System.out.println("Podaj numer filmu kończący rezerwację");
                            id = Integer.parseInt(scanner.nextLine());
                            List<Rezerwacja>temp =  klient.getListaRezerwacje();
                            int counter = 0;
                            for(Rezerwacja t : temp){
                                if(t.getZarezerwowanyFilm().getNumerFilmu() == id){
                                    break;
                                }
                                counter++;
                            }
                            try {
                                Rezerwacja rezerwacja = temp.remove(counter);
                                listaFilmow.wrocFilmZWyp(rezerwacja.getZarezerwowanyFilm());
                            }catch (IndexOutOfBoundsException e){
                                System.out.println("Źle podany indeks filmu");
                                break;
                            }
                            break;
                        }
                    }
                    if(!czyKlientIstnieje){
                        System.out.println("Źle podany indeks klienta");
                        break;
                    }
                    break;
                }

                default: {
                    System.out.println("Źle podana opcja");
                }
            }
        }while (!quit);
    }

    public static void main(String[] args) {

        boolean quit = false;
        Scanner scan = new Scanner(System.in);
        do {
            wyswietlGlowneMenu();
            int wybor = Integer.parseInt(scan.nextLine());

            switch (wybor){
                case 0: {
                    quit = true;
                    break;
                }
                case 1:{
                    klientMenu();
                    break;
                }
                case 2:{
                    filmMenu();
                    break;
                }
                default:{
                    System.out.println("Źle podana opcja");
                }
            }
        }while(!quit);
    }
}
