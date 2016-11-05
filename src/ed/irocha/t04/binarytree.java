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
public class binarytree {
    nodetree root;
    int height;
    int elements;
    public binarytree () {
        this.root = null;
        this.height = -1;
        this.elements = 0;
    }
    public binarytree (int data) {
        this.root = new nodetree(data);
    }
    public binarytree (nodetree root){
        this.root = root;
    }
    public nodetree getroot() {
        return root;
    }
    public int getheight() {
        return height;
    }
    public int getelements() {
        return elements;
    }
    public void setroot(nodetree root) {
        this.root = root;
    }
    public void setheight(int height) {
        this.height = height;
    }
    public void setelements(int elements) {
        this.elements = elements;
    }
    public boolean isempty(){
        return root == null;
    }
    public boolean isempty(nodetree root){
        return root.left == null && root.right == null;
    }
    nodetree node = new nodetree();
    public void insert(int data){
        
        node = new nodetree(data);
        if(isempty()) {
            root = node;
        } else {
            this.insert(node, this.root);
        }
    }
    public void insert(nodetree node, nodetree root){
        if(node.data == root.data) {
            System.out.println("el numero ya existe");
        } else if(node.data < root.data) {
            if(root.left == null) {
                root.left = node;
            } else {
                insert(node, root.left);
            }
        } else {
            if(root.right == null){
                root.right = node;
            } else {
                insert(node, root.right);
            }
        }
        this.elements++;
    }
    
    public  void preorden() {
        apreorden(root);
    }
    private void apreorden(nodetree node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + " ");     
        apreorden(node.left);   
        apreorden(node.right);    
    }
    
    public synchronized void inorden() {
        ainorden(root);
    }
    private void ainorden(nodetree node) {
        if(node == null) {
            return;
        }
        ainorden(node.left);
        System.out.print(node.data + " ");
        ainorden(node.right);
    }
    
    public synchronized void posorden(){
        aposorden(root);        
    }
    private void aposorden(nodetree node) {
        if(node == null) {
            return;
        }
        aposorden(node.left);
        aposorden(node.right);
        System.out.print(node.data + " ");
    }
    boolean hijoIzq = true;
    nodetree dad;
    
    public nodetree search(int data){
        if(!isempty()){
            nodetree t;
            t = dad = root;
            while(t.data != data){
               
                dad = t;
                if(t.data > data){
                    
                    t = t.left;
                    hijoIzq = true;
                } else {
                    t = t.right;
                    
                    hijoIzq = false;
                }
                if(t == null){
                    return null;
                }
            }
            return t;
        }System.out.println("no se encuentra");
        return null;
    }
    public boolean delete(int data){
        if(!this.isempty()){
            nodetree t = search(data);
          
            if(isempty(t)){
                if(root == t){
                    root = null;
                } else if (hijoIzq){
                    dad.left = null;
                } else {
                    dad.right = null;
                }
            } else if(t.left == null){ 
                    if(t == root){
                        root = t.right;
                    } else if(hijoIzq){
                        dad.left = t.right;
                    } else {
                        dad.right = t.left;
                    }
            } else {
                if(t == root){
                    root = t.left;
                } else if(hijoIzq){
                    dad.right = t.right;
                } else {
                    dad.left = t.right;
                }
            }
           
        }
        return true;
    }
    public boolean delete2(int data) {
        nodetree a = search(data);
        nodetree dad = root;
        if(a == null){
            System.out.println("no se encontró el nodo."); 
            return false;
        } else {
            boolean nD;
            if(a.right == null){
                nD = false;
            } else{
                nD = true;
            }
            boolean nI;
            if(a.left == null){
                nI = false;
            } else {
                nI = true;
            }
            if(isempty(a)){
                return removeCaso1(a);
            }
            
            if (nD && !nI) {
               
            }
            if (!nD && nI) {
               ;
            }
            if (nD && nI) {
                
            }
            return false;
        }
    }
    private boolean removeCaso1(nodetree node) {
        nodetree hI = node.left;
        nodetree hD = node.right;
        if (hI == node) {
            node.left = null;
            return true;
        }
        if (hD == node) {
            node.right = null;
            return true;
        } return false;
    }
}
