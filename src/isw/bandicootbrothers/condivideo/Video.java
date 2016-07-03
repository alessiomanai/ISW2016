package isw.bandicootbrothers.condivideo;


import java.util.ArrayList;
import java.util.Scanner;

public class Video
{
    public String nome; //nome del video
    public String autore;
    public int durata; //in secondi
    public ArrayList<Commento> commenti = new ArrayList<Commento>();

    public boolean vietato = false;

    public Video(String nome, String autore, int durata)
    {
        this.nome = nome;
        this.autore = autore;
        this.durata = durata;
        this.vietato = false;
    }

    public Video() {}

    public void condividiVideo() { }

    public boolean scriviCommento(Utente u)
    {
        if(u instanceof UtenteRegistrato || u instanceof Admin)
        {
            this.commenti.add(new Commento(u.nome + "ha inserito un commento", u));

            return true;
        }

        return false;
    }
}
