package java_labs;


public class Password {

    public static boolean isValidPassword(String password) {
       
        if (password.length() < 5 || password.length() > 12) {
            return false;
        }

        
        if (!password.matches("[a-z0-9]+")) {
            return false;
        }

        
        if (!password.matches(".*[a-z].*") || !password.matches(".*\\d.*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("abc11se"));    // True 
        System.out.println(isValidPassword("123sd123"));   // True 
        System.out.println(isValidPassword("adfasdsdf"));  // False 
        System.out.println(isValidPassword("Aasdfasd12")); // False 	 
    }
}
