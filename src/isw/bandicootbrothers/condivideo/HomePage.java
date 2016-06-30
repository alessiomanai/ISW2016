package isw.bandicootbrothers.condivideo;

import java.util.Scanner;

public class HomePage
{
    public static void main(String [] args)
    {
        UtenteSingleton.getInstance().getUtenteList().add(new UtenteRegistrato("Luca", "luca", 96));
        UtenteSingleton.getInstance().getUtenteList().add(new UtenteRegistrato("Emanuel", "emanuel", 17));
        UtenteSingleton.getInstance().getUtenteList().add(new UtenteRegistrato("Alessio", "alessio", 55));
        UtenteSingleton.getInstance().getUtenteList().add(new UtenteRegistrato("Corrado", "corrado", 34));
        UtenteSingleton.getInstance().getUtenteList().add(new UtenteRegistrato("Matteo", "matteo", 13));
        UtenteSingleton.getInstance().getUtenteList().add(new Admin("Davide", "davide", 85));
        UtenteSingleton.getInstance().getUtenteList().add(new Admin("Andrea", "andrea", 29));

        VideoSingleton.getInstance().getVideoList().add(new Video("Acqua corrente",   "Alessio",  87));
        VideoSingleton.getInstance().getVideoList().add(new Video("Ma anche no",      "Emanuel",  121));
        VideoSingleton.getInstance().getVideoList().add(new Video("Mobbasta",         "Corrado",  56));
        VideoSingleton.getInstance().getVideoList().add(new Video("Babbi l'orsetto",  "Andrea",   211));
        VideoSingleton.getInstance().getVideoList().add(new Video("La villa di Lato", "Luca",     54));
        VideoSingleton.getInstance().getVideoList().add(new Video("Il buio",          "Alessio",  9));
        VideoSingleton.getInstance().getVideoList().add(new Video("Rocchio 47",       "Emanuel",  45));
        VideoSingleton.getInstance().getVideoList().add(new Video("Italiano Medio",   "Corrado",  21));
        VideoSingleton.getInstance().getVideoList().add(new Video("Ahia",             "Andrea",   197));
        VideoSingleton.getInstance().getVideoList().add(new Video("Urgenze",          "Luca",     55));
        VideoSingleton.getInstance().getVideoList().add(new Video("Djanni",           "Alessio",  79));
        VideoSingleton.getInstance().getVideoList().add(new Video("Leghifascisti",    "Emanuel",  33));
        VideoSingleton.getInstance().getVideoList().add(new Video("Salveenee",        "Corrado",  34));
        VideoSingleton.getInstance().getVideoList().add(new Video("Renzie",           "Andrea",   16));
        VideoSingleton.getInstance().getVideoList().add(new Video("Brava Giovanna",   "Andrea",   122));

        System.out.println("\n|| ********** CONDIVIDEO ********** ||");
        System.out.println("|| ************ Log In ************ ||\n");

        //Log in
        LogIn lg = new LogIn();
        Utente user = lg.buildUtente();

        while(true)
        {
            System.out.println("\n|| ************ CONDIVIDEO ************ ||");
            System.out.println("|| *************** Home *************** ||\n");

            System.out.println("************* Ricerca Video **************\n");
            // Ricerca Video
            VideoSearcher vs = new VideoSearcher();
            user.videoInteressato = vs.ricercaVideo();

            System.out.println("\n************ Riproduci Video *************");

            // Riproduzione Video
            VideoPlayer vp = new VideoPlayer();
            vp.play(user.videoInteressato);

            System.out.println("\n************* Commenta Video *************");

            // Commenta Video
            System.out.println("\nVuoi commentare il video? S/N");

            Scanner in1 = new Scanner(System.in);
            String scelta1 = in1.next();

            if(scelta1.equals("S") || scelta1.equals("s"))
            {
                user.videoInteressato.scriviCommento(user);
            }

            System.out.println("************ Condividi Video *************");

            //Condividi Video
            System.out.println("\nVuoi condividere il video? S/N");

            Scanner in2 = new Scanner(System.in);
            String scelta2 = in2.next();

            if(scelta2.equals("S") || scelta2.equals("s"))
            {
                user.videoInteressato.condividiVideo();
            }
        }
    }
}
