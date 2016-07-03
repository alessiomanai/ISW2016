package isw.bandicootbrothers.condivideo;

import java.util.Scanner;

public class LogIn
{
    public LogIn() {}

    public Utente buildUtente()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = in.next();
        System.out.println("\nPassword: ");
        String password = in.next();

        for(Utente u : UtenteSingleton.getInstance().getUtenteList())
        {
            if(u.nome.equals(nome) && u.password.equals(password))
            {
                return u;
            }
        }

        return new UtenteNonRegistrato();

    }

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
