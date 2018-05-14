/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package algorithms.l6.hw;

/**
 *
 * @author Yuri Tveritin
 */
public class AlgorithmsL6HW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("="+generateHashcode("привет"));
    }
    /**
     * Метод нахождения хешкода от введенной строки
     * @param str
     * @return 
     */
    static int generateHashcode(String str){
        int hashcode=0;
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.codePointAt(i));
            hashcode=hashcode+str.codePointAt(i);
        }
        return hashcode;
    }
    
}
