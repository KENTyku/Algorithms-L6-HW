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
        System.out.println("Задание1 ="+generateHashcode("привет, как дела"));
        System.out.println("Задание2:");
        treeSearch();
    }
    /**
     * Задание 1. Реализовать простейшую хеш-функцию.
     * 
     * Метод нахождения хешкода от введенной строки
     * @param str
     * @return 
     */
    static int generateHashcode(String str){
        int hashcode=0;
        for (int i = 0; i < str.length(); i++) {
//            System.out.println(str.codePointAt(i));
            hashcode=hashcode+str.codePointAt(i);
        }
        return hashcode;
    }
    
    /**
     * Задание 2 Реализовать двоичное дерево поиска
     */
    static void treeSearch(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(3, 1);
        tree.insert(2, 2);
        tree.insert(4, 5);
        tree.insert(10, 6);
        tree.insert(8, 3);
        tree.insert(6, 8);
        tree.print();
        tree.remove(2);
        tree.remove(3);
        tree.print();
        tree.remove(4);
        
    }
    static class BinarySearchTree {
        Node root;
        
        class Node {
            int key;
            int value;
            Node l;
            Node r;
            Node p;
            public Node(int key, int value, Node p) {
                this.key = key;
                this.value = value;
                this.p = p;
            }
        }
        
        
        Node search(Node t, int key) {
            if (t == null || t.key == key)
                return t;
            if (key < t.key)
                return search(t.l, key);
            else
                return search(t.r, key);
        }
        public Node search(int key) {
            return search(root, key);
        }
        
        Node insert(Node t, Node p, int key, int value) {
            if (t == null) {
                t = new Node(key, value, p);
            } else {
                if (key < t.key)
                    t.l = insert(t.l, t, key, value);
                else
                    t.r = insert(t.r, t, key, value);
            }
            return t;
        }
        
        public void insert(int key, int value) {
            root = insert(root, null, key, value);
        }
        void replace(Node a, Node b) {
            if (a.p == null)
                root = b;
            else if (a == a.p.l)
                a.p.l = b;
            else
                a.p.r = b;
            if (b != null)
                b.p = a.p;
        }
        
        void remove(Node t, int key) {
            if (t == null)
                return;
            if (key < t.key)
                remove(t.l, key);
            else if (key > t.key)
                remove(t.r, key);
            else if (t.l != null && t.r != null) {
                Node m = t.r;
                while (m.l != null)
                    m = m.l;
                t.key = m.key;
                t.value = m.value;
                replace(m, m.r);
            } else if (t.l != null) {
                replace(t, t.l);
            } else if (t.r != null) {
                replace(t, t.r);
            } else {
                replace(t, null);
            }
        }
        
        public void remove(int key) {
            remove(root, key);
        }
        
        void print(Node t) {
            if (t != null) {
                print(t.l);
                System.out.print(t.key + ":" + t.value + " ");
                print(t.r);
            }
        }
        
        public void print() {
            print(root);
            System.out.println();
        }

    }
    
}
