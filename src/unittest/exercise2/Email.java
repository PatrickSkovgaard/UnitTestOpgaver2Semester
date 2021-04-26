package unittest.exercise2;

public class Email {

    public boolean validEmail(String email){

        if (email.substring(email.length()-10, email.length()).equals("@gmail.com")){
            return true;
        }

        if (email.substring(email.length()-8, email.length()).equals("@live.dk")){
            return true;
        }

        if (email.substring(email.length()-12, email.length()).equals("@hotmail.com")){
            return true;
        }
        return false;
    }
}
