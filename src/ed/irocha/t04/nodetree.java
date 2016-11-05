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
public class nodetree {
    int data;
    nodetree left;
    nodetree right;        
    //Methods
    //Contructor
    public nodetree() {
        this.data = data;
        this.left= left;
        this.right = right;
    }
    public nodetree(int data) {
        this.data = data;
        this.left= left;
        this.right = right;
    }
    public int getData() {
        return data;
    }
    /*public NodeTree getDad() {
        return dad;
    }*/
    public nodetree getLeft() {
        return left;
    }
    public nodetree getRight() {
        return right;
    }
    public void setdata(int data) {
        this.data = data;
    }
    /*public void setDad(NodeTree dad) {
        this.dad = dad;
    }*/
    public void setLeft(nodetree left) {
        this.left = left;
    }
    public void setRight(nodetree right) {
        this.right = right;
    }
}
