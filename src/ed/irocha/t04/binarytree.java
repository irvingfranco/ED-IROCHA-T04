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
    //Methods
    //Contructor
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
    public nodetree getRoot() {
        return root;
    }
    public int getheight() {
        return height;
    }
    public int getelements() {
        return elements;
    }
    public void setRoot(nodetree root) {
        this.root = root;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setElements(int elements) {
        this.elements = elements;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public boolean isEmpty(nodetree root){
        return root.left == null && root.right == null;
    }
    nodetree node = new nodetree();
    public void insert(int data){
        //NodeTree node = new NodeTree(data);
        node = new nodetree(data);
        if(isEmpty()) {
            root = node;
        } else {
            this.insert(node, this.root);
        }
    }
    public void insert(nodetree node, nodetree root){
        if(node.data == root.data) {
            System.out.println("El número ya fue introducido");
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
    //EMPIEZA EL RECORRIDO EN PREORDEN
    public synchronized void PreOrden() {
        aPreorden(root);
    }
    private void aPreorden(nodetree node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + " ");     //mostrar datos del nodo
        aPreorden(node.left);   //recorre subarbol izquierdo
        aPreorden(node.right);     //recorre subarbol derecho
    }
    //EMPEZAR RECORRIDO INORDEN
    public synchronized void InOrden() {
        aInorden(root);
    }
    private void aInorden(nodetree node) {
        if(node == null) {
            return;
        }
        aInorden(node.left);
        System.out.print(node.data + " ");
        aInorden(node.right);
    }
    //EMPEZAR RECORRIDO PORORDEN
    public synchronized void PosOrden(){
        aPosorden(root);        
    }
    private void aPosorden(nodetree node) {
        if(node == null) {
            return;
        }
        aPosorden(node.left);
        aPosorden(node.right);
        System.out.print(node.data + " ");
    }
    boolean hijoIzq = true;
    nodetree dad;
    public nodetree search(int data){
        if(!isEmpty()){
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
        }System.out.println("no esta");
        return null;
    }
    public boolean delete(int data){
        if(!this.isEmpty()){
            nodetree t = search(data);
          
            if(isEmpty(t)){
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
            //Caso 3 dos hijos
        }
        return true;
    }
   
    private boolean removeNodoCaso1(nodetree node) {
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
