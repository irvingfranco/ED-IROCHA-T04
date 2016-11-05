/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.irocha.t04;

/**
 *
 * @author casa
 */
public class EDIRochaT04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        binarytree b = new binarytree();
        b.insert(7);
        b.insert(62);
        b.insert(15);
        b.insert(21);
        b.insert(13);
        b.insert(16);
        b.insert(32);
        b.insert(35);
        b.insert(23);
        b.insert(44);
        b.delete(21);
        System.out.println("preorden");
        b.preorden();
        System.out.println("inorden");
        b.inorden();
        System.out.println("postorden");
        b.posorden();
        // TODO code application logic here
    }
    
}
