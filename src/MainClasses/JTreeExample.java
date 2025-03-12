package MainClasses;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeExample {
    public static void main(String[] args) {
        // Create custom objects
        
        
        class MyCustomObject {
            String name;
            int numeroBloque;

            MyCustomObject(String name, int numeroBloque) {
                this.name = name;
                this.numeroBloque = numeroBloque;
            }
            
            public boolean hh(){
                
                return true;
                       
            }

            @Override
            public String toString() {
                return name; // This is what will be displayed in the JTree
            }
        }

        // Create nodes and attach custom objects
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new MyCustomObject("Root", 1));
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode(new MyCustomObject("Child 1", 2));
        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode(new MyCustomObject("Child 2", 3));
        
        
        MyCustomObject objeto = (MyCustomObject) child2.getUserObject();
        
        objeto.hh();
        
        if (child1.getUserObject() instanceof MyCustomObject) {
            System.out.println("La vaina funciona");
            
            System.out.println(child1.getUserObject().getClass());
        }
        System.out.println();
        
        root.add(child1);
        root.add(child2);

        // Create JTree and display it
        JTree tree = new JTree(root);
        JFrame frame = new JFrame("JTree Example");
        frame.add(new JScrollPane(tree));
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}