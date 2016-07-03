package isw.bandicootbrothers.condivideo;

import java.util.ArrayList;

/*
| SINGLETON che rappresenta il DB Utenti
| Consiste in un ArrayList di Utenti
*/
public class UtenteSingleton
{
    //Rendo la classe una singleton
    private static UtenteSingleton singleton;

    //Arraylist che conterrà gli utenti.
    private ArrayList<Utente> utentiList = new ArrayList<Utente>();

    //Istanzio il metodo getInstance della singleton
    public static UtenteSingleton getInstance()
    {
        if (singleton == null) {
            singleton = new UtenteSingleton();
        }
        return singleton;
    }

    private UtenteSingleton() { }

    public ArrayList<Utente> getUtenteList()
    {
        return utentiList;
    }

}

