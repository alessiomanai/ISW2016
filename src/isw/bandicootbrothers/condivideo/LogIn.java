package isw.bandicootbrothers.condivideo;

import java.util.Scanner;

public class LogIn
{
    public LogIn() {}

    public Utente buildUtente()
    {
        //Inserisco nome utente e password
        Scanner in = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = in.next();
        System.out.println("\nPassword: ");
        String password = in.next();

        //cerco che tale utente esista nel DB
        for(Utente u : UtenteSingleton.getInstance().getUtenteList())
        {
            if(u.nome.equals(nome) && u.password.equals(password))
            {
                //se esiste, lo restituisco al chiamante
                return u;
            }
        }

        //Altrimenti restituisco un utente non registrato
        return new UtenteNonRegistrato();

    }

    /*
    | TEST
    | consiste nella funzione precedente, ma con parametri già dati. (Senza Scanner)
    */
    public Utente buildUtenteT(String nome, String psw)
    {
        String name = nome;
        String password = psw;

        for(Utente u : UtenteSingleton.getInstance().getUtenteList())
        {
            if(u.nome.equals(name) && u.password.equals(password))
            {
                return u;
            }
        }

        return new UtenteNonRegistrato();
    }

}
