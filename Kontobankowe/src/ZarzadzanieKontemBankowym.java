class Klient {
    private String nazwaKlienta;
    private int numerIdKlienta;
    private String adres;

    public Klient(String nazwaKlienta, int numerIdKlienta, String adres) {
        this.nazwaKlienta = nazwaKlienta;
        this.numerIdKlienta = numerIdKlienta;
        this.adres = adres;
    }

    public String getNazwaKlienta() {
        return nazwaKlienta;
    }

    public int getNumerIdKlienta() {
        return numerIdKlienta;
    }

    public String getAdres() {
        return adres;
    }

    public void wyswietlInformacjeOKliencie() {
        System.out.println("Klient: " + nazwaKlienta);
        System.out.println("Numer ID klienta: " + numerIdKlienta);
        System.out.println("Adres: " + adres);
    }
}

class KontoBankowe {
    private String numerKonta;
    private double saldo;
    private Klient wlascicielKonta;

    public KontoBankowe(String numerKonta, double saldo, Klient wlascicielKonta) {
        this.numerKonta = numerKonta;
        this.saldo = saldo;
        this.wlascicielKonta = wlascicielKonta;
    }

    public String getNumerKonta() {
        return numerKonta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Klient getWlascicielKonta() {
        return wlascicielKonta;
    }

    public void wplacSrodki(double kwota) {
        if (kwota > 0) {
            saldo += kwota;
            System.out.println("Wpłata " + kwota + " PLN na konto " + numerKonta);
        } else {
            System.out.println("Nieprawidłowa kwota wpłaty.");
        }
    }

    public void wyplacSrodki(double kwota) {
        if (kwota > 0 && kwota <= saldo) {
            saldo -= kwota;
            System.out.println("Wypłata " + kwota + " PLN z konta " + numerKonta);
        } else {
            System.out.println("Nieprawidłowa kwota wypłaty lub brak wystarczających środków na koncie.");
        }
    }

    public void wyswietlInformacjeOKoncie() {
        System.out.println("Konto bankowe: " + numerKonta);
        System.out.println("Saldo: " + saldo + " PLN");
        wlascicielKonta.wyswietlInformacjeOKliencie();
    }
}

public class ZarzadzanieKontemBankowym {
    public static void main(String[] args) {
        Klient klient1 = new Klient("Gniewosz Zręba", 1, "ul. Letnia 13");
        Klient klient2 = new Klient("Krystyna Jabłońska", 2, "ul. Lakowa 9");

        KontoBankowe konto1 = new KontoBankowe("12345", 1000.0, klient1);
        KontoBankowe konto2 = new KontoBankowe("67890", 500.0, klient2);

        konto1.wplacSrodki(500.0);
        konto1.wyplacSrodki(300.0);

        konto2.wplacSrodki(200.0);
        konto2.wyplacSrodki(700.0);

        konto1.wyswietlInformacjeOKoncie();
        konto2.wyswietlInformacjeOKoncie();
    }
}
