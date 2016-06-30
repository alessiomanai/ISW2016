import java.util.ArrayList;

public class Admin extends UtenteRegistrato
{
    public Admin()
    {
        super();
    }

    public Admin(String nome, String password, int age)
    {
        super(nome, password, age);
    }

    public boolean bannaUtente(Utente user)
    {
        ArrayList<Video> daBloccare = new ArrayList<Video>();

        //recupero la lista dei video aventi come utente, quello da bloccare
        for(Video v : VideoSingleton.getInstance().getVideoList())
        {
            if(v.autore.equals(user))
            {
                daBloccare.add(v);
            }
        }

        //Rimuovo dalla singleton dei video tutti i video dell'array appena popolato
        for(Video v : daBloccare)
        {
            VideoSingleton.getInstance().getVideoList().remove(v);
        }

        for(Utente u : UtenteSingleton.getInstance().getUtenteList())
        {
            if(user.nome.equals(u.nome))
            {
                UtenteSingleton.getInstance().getUtenteList().remove(u);
                return true;
            }
        }

        return false;
    }
}