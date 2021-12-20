package Model;

import java.net.SocketOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListaFilmow {

    public static class FilmComparator implements Comparator<Film> {
        @Override
        public int compare(Film first, Film second) {
            return Integer.compare(first.getNumerFilmu(), second.getNumerFilmu());
        }
    }

    private List<Film> listaFilmow;
    private int liczbaWypozyczonychFilmow;
    private int liczbaZarezerwowanychFilmow;
    private int maxID;
    public FilmComparator filmComparator;

    public List<Film> getListaFilmow() {
        return listaFilmow;
    }

    public ListaFilmow() {
        this.listaFilmow = new ArrayList<>();
        this.filmComparator = new FilmComparator();
        this.liczbaWypozyczonychFilmow = 0;
        this.liczbaZarezerwowanychFilmow = 0;
        this.maxID = 0;
    }

    public ListaFilmow( List<Film> listaFilmow) {
        this.listaFilmow = listaFilmow;
        this.filmComparator = new FilmComparator();
        this.liczbaWypozyczonychFilmow = 0;
        this.liczbaZarezerwowanychFilmow = 0;
        this.maxID = listaFilmow.size();
    }

    public void wyswietlListeFilmow(){
        for(Film film : listaFilmow){
            System.out.println(film.getNumerFilmu() + " " + film.getNazwaFilmu() + "/ Data wydania: " + film.getDataWydania() + "/ Czas trwania: " +
                    film.getCzasTrwania() + " min/ Cena: " + film.getCena() + " zl/ Jezyk: " + film.getJezyk() + "/ Stan: " + film. getStan() + '\n');
        }
    }

    public void dodajFilm(String nazwaFilmu, int rokWydania, int czasTrwania, double cena, String stan, String jezyk){
        maxID++;
        listaFilmow.add(new Film(maxID, nazwaFilmu,rokWydania,czasTrwania,cena,stan,jezyk));
    }

    public void usunFilm(int numerFilmu){
        listaFilmow.removeIf(film->film.getNumerFilmu() == numerFilmu);
    }

    public void zaktualizujFilm(int id, String nazwa, int rok, int czas, double cena, String stan, String jezyk){
        for(Film film : listaFilmow){
            if(film.getNumerFilmu() == id){
                film.setNazwaFilmu(nazwa);
                film.setDataWydania(rok);
                film.setCzasTrwania(czas);
                film.setCena(cena);
                film.setStan(stan);
                film.setJezyk(jezyk);
            }
        }
    }

    public Film przekazFilmDoWyp(int id){
        int index = 0;
        for(Film film : listaFilmow){
            if (film.getNumerFilmu() == id) {
                liczbaWypozyczonychFilmow++;
                break;
            }
            index++;
        }
        try{
            return listaFilmow.remove(index);
        }catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public void wrocFilmZWyp(Film film){
        listaFilmow.add(film);
        listaFilmow.sort(filmComparator);
        liczbaWypozyczonychFilmow--;
    }

    public Film przekazFilmDoRez(int id){
        int index = 0;
        for(Film film : listaFilmow){
            if (film.getNumerFilmu() == id) {
                liczbaZarezerwowanychFilmow++;
                break;
            }
            index++;
        }
        try{
            return listaFilmow.remove(index);
        }catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public void wrocFilmZRez(Film film){
        listaFilmow.add(film);
        listaFilmow.sort(filmComparator);
        liczbaZarezerwowanychFilmow--;
    }
}
