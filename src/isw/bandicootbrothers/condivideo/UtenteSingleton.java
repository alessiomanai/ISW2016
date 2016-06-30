package isw.bandicootbrothers.condivideo;

import java.util.ArrayList;

public class UtenteSingleton
{
    private static UtenteSingleton singleton;

    private ArrayList<Utente> utentiList = new ArrayList<Utente>();

    public static UtenteSingleton getInstance()
    {
        if (singleton == null) {
            singleton = new UtenteSingleton();
        }
        return singleton;
    }

    private UtenteSingleton()
    {

    }

    public ArrayList<Utente> getUtenteList()
    {
        return utentiList;
    }

}

