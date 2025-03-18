/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

import AuxClass.List;
import AuxClass.Node;
import MainClasses.App;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Angelo
 */
public class FileSystem {

    private AssignTable AssignTableSystem;
    private SD SDSystem;

    public FileSystem(AssignTable AssignTableSystem, SD SDSystem) {
        this.AssignTableSystem = AssignTableSystem;
        this.SDSystem = SDSystem;
    }

    public boolean searchAndSet(int BlockSizeFile, File newFile) {

        List<Block> BlocksListFile = new List("Blocks File");
        newFile.setBlocksList(BlocksListFile);

        Node<Block> CurrentBlock = this.SDSystem.getBlocksList().first();
        int BlocksAvailable = 0;
        int Limit = this.SDSystem.getLimitBlocks();

        for (int i = 0; i < Limit && CurrentBlock != null; i++) {
            if (!CurrentBlock.gettInfo().isState()) {
                BlocksAvailable++;
            }
            CurrentBlock = CurrentBlock.getpNext();
        }

        if (BlockSizeFile > BlocksAvailable) {
            System.out.println("No hay suficientes bloques disponibles.");
            return false;
        }

        CurrentBlock = this.SDSystem.getBlocksList().first();

        for (int i = 0; i < Limit && CurrentBlock != null && BlockSizeFile > 0; i++) {
            if (!CurrentBlock.gettInfo().isState()) {

                newFile.getBlocksList().append(CurrentBlock.gettInfo());
                CurrentBlock.gettInfo().setFileInBlock(newFile);
                CurrentBlock.gettInfo().setState(true);
                BlockSizeFile--;
            }
            CurrentBlock = CurrentBlock.getpNext();
        }
        newFile.setFirstBlock((Block) BlocksListFile.first().gettInfo());

        return true;
    }

    public String ShowDate(DefaultMutableTreeNode NodeCreated, String Element, String Action) {

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter Formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String NewDate = (dateTime.format(Formatter));

        if (NodeCreated.getUserObject() instanceof File) {
            System.out.println(NodeCreated);
            File CurrentFile = (File) NodeCreated.getUserObject();            
            
            String result  = String.format(NewDate +" Se ha %s un %s, nombre: %s [A]\n", Action, Element, CurrentFile.getFileName()) ;
            
            return result;
        }
        else{
            String result  = String.format(NewDate +" Se ha %s un %s, nombre: %s \n", Action, Element, NodeCreated.toString()) ;   
            return result;
        }
    }

    public void DeleteFile() {
        //
    }

    public AssignTable getAssignTableSystem() {
        return AssignTableSystem;
    }

    public void setAssignTableSystem(AssignTable AssignTableSystem) {
        this.AssignTableSystem = AssignTableSystem;
    }

    // Método para obtener todos los archivos a partir de un nodo dado
    public static List<DefaultMutableTreeNode> getAllFilesFromNode(DefaultMutableTreeNode node) {
        List<DefaultMutableTreeNode> fileList = new List<>("Lista de Archivos");

        // Llamar al método recursivo para llenar la lista
        collectFiles(node, fileList);

        return fileList;
    }

    // Método recursivo para recolectar archivos
    private static void collectFiles(DefaultMutableTreeNode node, List<DefaultMutableTreeNode> fileList) {
        // Verificar si el nodo tiene hijos
        Enumeration<TreeNode> children = node.children();

        while (children.hasMoreElements()) {
            TreeNode childNode = children.nextElement();

            // Hacer un casting a DefaultMutableTreeNode
            if (childNode instanceof DefaultMutableTreeNode) {
                DefaultMutableTreeNode defaultChildNode = (DefaultMutableTreeNode) childNode;

                // Obtener el objeto del usuario del nodo
                Object userObject = defaultChildNode.getUserObject();

                // Verificar si es una instancia de File
                if (userObject instanceof File) {
                    // Agregar a la lista
                    fileList.append(defaultChildNode);
                }

                // Llamar recursivamente para los hijos del nodo actual
                collectFiles(defaultChildNode, fileList);
            }
        }
    }

}
