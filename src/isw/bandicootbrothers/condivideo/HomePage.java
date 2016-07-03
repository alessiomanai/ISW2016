package isw.bandicootbrothers.condivideo;

import java.util.ArrayList;
import java.util.Scanner;

public class HomePage
{
    public static void main(String [] args)
    {
        //DB Utenti tramite la singleton UtenteSingleton
        UtenteSingleton.getInstance().getUtenteList().add(new UtenteRegistrato("Luca", "luca", 96));
        UtenteSingleton.getInstance().getUtenteList().add(new UtenteRegistrato("Emanuel", "emanuel", 17));
        UtenteSingleton.getInstance().getUtenteList().add(new UtenteRegistrato("Alessio", "alessio", 55));
        UtenteSingleton.getInstance().getUtenteList().add(new UtenteRegistrato("Corrado", "corrado", 34));
        UtenteSingleton.getInstance().getUtenteList().add(new UtenteRegistrato("Matteo", "matteo", 13));
        UtenteSingleton.getInstance().getUtenteList().add(new Admin("Davide", "davide", 85));
        UtenteSingleton.getInstance().getUtenteList().add(new Admin("Andrea", "andrea", 29));

        //DB Video tramite la singleton VideoSingleton
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

        //Messaggio di benvenuto per l'utente
        if(user instanceof UtenteRegistrato)
        {
            System.out.println("Benvenuto " + user.nome + "! Sei un Utente Registrato");
        }
        else
        {
            if(user instanceof Admin)
            {
                System.out.println("Benvenuto " + user.nome + "! Sei un Admin");
            }
            else
            {
                System.out.println("Benvenuto ospite! Sei un tutente non registrato!");
            }
        }

        //Qui iniziano le azioni dell'utente
        while(true)
        {
            System.out.println("\n|| ************ CONDIVIDEO ************ ||");
            System.out.println("|| *************** Home *************** ||\n");

            System.out.println("************* Ricerca Video **************\n");

            // Ricerca Video
            VideoSearcher vs = new VideoSearcher();
            ArrayList<Video> listaVideo = vs.ricercaVideo();

            // Se durante la ricerca sono stati trovati dei video, continuo, altrimenti si passa ad una nuova ricerca
            if(listaVideo.size() > 0)
            {
                //Stampo una lita dei video che ho trovato
                System.out.println("\nTrovati " + listaVideo.size() + " video:");

                int a = 0;

                for(Video v : listaVideo)
                {
                    System.out.println("Video numero " + a + " - Nome:\t" + v.nome);
                    a++;
                }

                //Chiedo all'utente se interessa qualcuno dei video che ha trovato
                System.out.println("\nTi interessa qualcuno di questi video? \n"+
                        "Inserisci il numero del video interessato o scrivi '-1' per tornare alla home");

                user.videoInteressato = vs.sceltaVideo(listaVideo);

                //Se l'utente ha selezionato un video, continuo, altrimenti passo ad una nuova ricerca
                if(user.videoInteressato != null)
                {
                    //Riproduzione video
                    System.out.println("\n************ Riproduci Video *************");

                    System.out.println("\n>>>>>>>> Inizio Riproduzione Video <<<<<<<\n");

                    System.out.println("Stai guardando " + user.videoInteressato.nome +
                            " pubblicato da " + user.videoInteressato.autore +
                            "\nQuesto video ha una durata di " + user.videoInteressato.durata + " secondi");

                    // Riproduzione Video
                    VideoPlayer vp = new VideoPlayer();
                    boolean safe = vp.play(user.videoInteressato);

                    if (safe) {

                        System.out.println("Questo video ha dei contenuti espliciti:" +
                                "\nNon è riproducibile da utenti minorenni e utenti non registrati");
                    } else {

                        System.out.println("Questo video NON ha dei contenuti espliciti:" +
                                "\nE' riproducibile da qualsiasi utente");
                    }

                    System.out.println("\n>>>>>>>>> Fine Riproduzione Video <<<<<<<<");

                    // Commenta Video
                    System.out.println("\n************* Commenta Video *************");

                    //Chiedo all'utente se vuole commentare
                    System.out.println("\nVuoi commentare il video? S/N");
                    boolean vuoiCommentare = user.videoInteressato.vuoi();

                    //Se vuole commentare, controllo se può
                    if (vuoiCommentare)
                    {
                        if (user.videoInteressato.scriviCommento(user))
                        {
                            System.out.println("Video commentato\n");
                        }
                        else
                        {
                            System.out.println("Non sei un utente Registrato, non puoi commentare i video!\n");
                        }
                    }

                    //Condividi video
                    System.out.println("************ Condividi Video *************");

                    //Chiedo all'utente se vuole commentare
                    System.out.println("\nVuoi condividere il video? S/N");
                    boolean vuoiCondividere = user.videoInteressato.vuoi();

                    //Se vuole commentare, lo faccio commentare
                    if (vuoiCondividere)
                    {
                        user.videoInteressato.condividiVideo();
                        System.out.println("Video codiviso");
                    }

                    user.videoInteressato = null;
                }
            }
        }
    }
}
