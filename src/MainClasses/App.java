/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import AuxClass.List;
import AuxClass.Node;
import MainPackage.AssignTable;
import MainPackage.Block;
import MainPackage.File;
import MainPackage.FileSystem;
import MainPackage.SD;

/**
 *
 * @author Angelo
 */
public class App {

    private static App instance;

    private SD SDApp;
    private FileSystem FileSystemApp;

    private App() {
        this.SDApp = SDInit();
        this.FileSystemApp = FileSystemInit();
    }

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    private SD SDInit() {

        int Limit = 30;
        List<Block> BlocksList = new List("BlocksList");
        
        for (int i = 0; i < Limit; i++) {
            Block NewBlock = new Block(i, null);
            BlocksList.append(NewBlock);
        }

        SD SDInit = new SD(Limit, BlocksList);

        return SDInit;

    }

    private FileSystem FileSystemInit() {

        List<File> ListFiles = new List("ListFiles");
        AssignTable AssignTableSystem = new AssignTable(ListFiles);

        FileSystem FileSystemInit = new FileSystem(AssignTableSystem, this.SDApp);

        return FileSystemInit;
    }

    public void testSearchAndSet() {
        File testFile = new File("Nombre1", 10, null, null, null);
        this.FileSystemApp.getAssignTableSystem().getListFiles().append(testFile);

        this.FileSystemApp.searchAndSet(testFile.getBlockSize(), testFile);

//        Node<Block> current = testFile.getBlocksList().first();
//        while (current != null) {
//            Block block = current.gettInfo();
//            // Se imprime el identificador o estado del bloque según lo que se implemente en toString()
//            System.out.println(block.isState());
//            current = current.getpNext();
//        }
        
        Node<Block> CurrentNode = this.SDApp.getBlocksList().first();
        while (CurrentNode != null) {            
            Block block = CurrentNode.gettInfo();
            System.out.println(block.isState());
            CurrentNode = CurrentNode.getpNext();
        }
        
        
    }

    public void start() {
        System.out.println("Runneando");
        testSearchAndSet();
    }

    public SD getSDApp() {
        return SDApp;
    }

    public void setSDApp(SD SDApp) {
        this.SDApp = SDApp;
    }

    public FileSystem getFileSystemApp() {
        return FileSystemApp;
    }

    public void setFileSystemApp(FileSystem FileSystemApp) {
        this.FileSystemApp = FileSystemApp;
    }

}
