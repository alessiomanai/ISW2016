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

    //Serve ad aggiungere un commento ad un Video
    public boolean scriviCommento(Utente u)
    {
        //Se si è un Utente registrato o un admin, il commento si può aggiungere, altrimenti no
        if(u instanceof UtenteRegistrato || u instanceof Admin)
        {
            this.commenti.add(new Commento(u.nome + "ha inserito un commento", u));

            return true;
        }

        return false;
    }

    //Questa funzione serve a chiedere all'utente se vuole o no commentare/condividere il video
    public boolean vuoi()
    {
        Scanner in1 = new Scanner(System.in);
        String scelta1 = in1.next();

        if (scelta1.equals("S") || scelta1.equals("s"))
        {
            return true;
        }

        return false;
    }
}
