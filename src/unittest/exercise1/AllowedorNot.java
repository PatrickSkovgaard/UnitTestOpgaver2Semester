package unittest.exercise1;

public class AllowedorNot {

    public boolean isAllowed(String name, int age){
        if (name.length() > 10 && age % 2 == 0){
            return true;
        }
        if (name.length() == age){
            return true;
        }
        if (name.startsWith("n") && name.endsWith("n")){
            return true;
        }
        return false;
    }
}
