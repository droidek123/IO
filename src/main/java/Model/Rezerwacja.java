package Model;

import java.time.LocalDateTime;

public class Rezerwacja {
    private Film zarezerwowanyFilm;
    private LocalDateTime dataRezerwacji;
    private LocalDateTime dataUplynieciaRezerwacji;

    public Rezerwacja(Film zarezerwowanyFilm) {
        this.zarezerwowanyFilm = zarezerwowanyFilm;
    }

    public Film getZarezerwowanyFilm() {
        return zarezerwowanyFilm;
    }

    @Override
    public String toString() {
        return "Rezerwacja{" +
                "zarezerwowanyFilm=" + zarezerwowanyFilm +
                ", dataRezerwacji=" + dataRezerwacji +
                ", dataUplynieciaRezerwacji=" + dataUplynieciaRezerwacji +
                '}';
    }
}
