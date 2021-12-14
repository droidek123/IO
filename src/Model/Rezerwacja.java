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

    public void setZarezerwowanyFilm(Film zarezerwowanyFilm) {
        this.zarezerwowanyFilm = zarezerwowanyFilm;
    }

    public LocalDateTime getDataRezerwacji() {
        return dataRezerwacji;
    }

    public void setDataRezerwacji(LocalDateTime dataRezerwacji) {
        this.dataRezerwacji = dataRezerwacji;
    }

    public LocalDateTime getDataUplynieciaRezerwacji() {
        return dataUplynieciaRezerwacji;
    }

    public void setDataUplynieciaRezerwacji(LocalDateTime dataUplynieciaRezerwacji) {
        this.dataUplynieciaRezerwacji = dataUplynieciaRezerwacji;
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
