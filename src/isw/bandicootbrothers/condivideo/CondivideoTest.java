package isw.bandicootbrothers.condivideo;


import org.junit.Assert;
import org.junit.Test;

public class CondivideoTest
{
    @Test
    public void banTest()
    {
        UtenteSingleton.getInstance().getUtenteList().add(new UtenteRegistrato("Matteo", "matteo", 13));
        UtenteSingleton.getInstance().getUtenteList().add(new Admin("Davide", "davide", 85));

        VideoSingleton.getInstance().getVideoList().add(new Video("Acqua corrente",   "Matteo",  87));
        VideoSingleton.getInstance().getVideoList().add(new Video("Ma anche no",      "Davide",  121));
        VideoSingleton.getInstance().getVideoList().add(new Video("Mobbasta",         "Matteo",  56));
        VideoSingleton.getInstance().getVideoList().add(new Video("Babbi l'orsetto",  "Davide",   211));

        Admin ad = new Admin("Gianni", "gianni", 38);

        //Ban di un utente esistente nel DB
        Assert.assertEquals(ad.bannaUtente(new Utente("Matteo", "matteo", 13)), true);

        //Ban di un utente esistente nel DB
        Assert.assertEquals(ad.bannaUtente(new Utente("Gianni", "gianni", 58)), false);

        UtenteSingleton.getInstance().getUtenteList().clear();
        VideoSingleton.getInstance().getVideoList().clear();
    }

    @Test
    public void scriviCommentoTest()
    {
        UtenteNonRegistrato user = new UtenteNonRegistrato();
        user.videoInteressato = new Video("Il gol di Grosso del 2006", "Grosso", 89);

        Assert.assertEquals(user.videoInteressato.scriviCommento(user), false);

        UtenteRegistrato user2 = new UtenteRegistrato("Andrea", "casanova", 53);
        user2.videoInteressato = new Video("Emily CTRL+V", "Salvatore Aranzulla", 120);

        Assert.assertEquals(user2.videoInteressato.scriviCommento(user2), true);

        UtenteSingleton.getInstance().getUtenteList().clear();
        VideoSingleton.getInstance().getVideoList().clear();
    }

    @Test
    public void ricercaVideoTesto()
    {
        VideoSingleton.getInstance().getVideoList().add(new Video("Acqua corrente",   "Matteo",  87));
        VideoSingleton.getInstance().getVideoList().add(new Video("Ma anche no",      "Davide",  121));
        VideoSingleton.getInstance().getVideoList().add(new Video("Mobbasta",         "Matteo",  56));
        VideoSingleton.getInstance().getVideoList().add(new Video("Casanova corre!",  "Davide",   211));

        VideoSearcher vs = new VideoSearcher();

        Assert.assertEquals(vs.ricercaVideoT("corre"), 2);

        Assert.assertEquals(vs.ricercaVideoT("Paralipomeni della batracomiomachia"), 0);

        UtenteSingleton.getInstance().getUtenteList().clear();
        VideoSingleton.getInstance().getVideoList().clear();
    }

    @Test
    public void LoginTest()
    {
        UtenteSingleton.getInstance().getUtenteList().add(new UtenteRegistrato("Matteo", "matteo", 13));
        UtenteSingleton.getInstance().getUtenteList().add(new Admin("Davide", "davide", 85));

        LogIn lg = new LogIn();

        Assert.assertEquals(lg.buildUtenteT("Mario", "mario") instanceof UtenteNonRegistrato, true);

        Assert.assertEquals(lg.buildUtenteT("Davide", "davide") instanceof Admin, true);

        Assert.assertEquals(lg.buildUtenteT("Matteo", "matteo") instanceof UtenteRegistrato, true);
    }
}
