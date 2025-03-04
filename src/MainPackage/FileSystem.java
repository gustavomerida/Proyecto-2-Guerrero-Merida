/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

import AuxClass.List;
import AuxClass.Node;
import MainClasses.App;

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

    public void searchAndSet(int BlockSizeFile, File newFile) {
        
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
            return;
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
    }

    public AssignTable getAssignTableSystem() {
        return AssignTableSystem;
    }

    public void setAssignTableSystem(AssignTable AssignTableSystem) {
        this.AssignTableSystem = AssignTableSystem;
    }

}
