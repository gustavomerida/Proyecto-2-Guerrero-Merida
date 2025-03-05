/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

import AuxClass.List;

/**
 *
 * @author Angelo
 */
public class File {
    private String FileName;
    private int BlockSize; 
    // private String FileType;
    private Block FirstBlock;
    private List<Block> BlocksList;
    private Directory ParentDirectory;

    public File(String FileName, int BlockSize, Block FirstBlock, List<Block> BlocksList, Directory ParentDirectory) {
        this.FileName = FileName;
        this.BlockSize = BlockSize;
        // this.FileType = FileType; // .txt o .pdf...
        this.FirstBlock = null; // Apuntador al primer bloque
        this.BlocksList = null; // Lista de los bloques a colorear
        this.ParentDirectory = ParentDirectory; // Directorio Padre
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

    public int getBlockSize() {
        return BlockSize;
    }

    public void setBlockSize(int BlockSize) {
        this.BlockSize = BlockSize;
    }
/*
    public String getFileType() {
        return FileType;
    }

    public void setFileType(String FileType) {
        this.FileType = FileType;
    }
*/
    public Block getFirstBlock() {
        return FirstBlock;
    }

    public void setFirstBlock(Block FirstBlock) {
        this.FirstBlock = FirstBlock;
    }

    public List<Block> getBlocksList() {
        return BlocksList;
    }

    public void setBlocksList(List<Block> BlocksList) {
        this.BlocksList = BlocksList;
    }

    public Directory getParentDirectory() {
        return ParentDirectory;
    }

    public void setParentDirectory(Directory ParentDirectory) {
        this.ParentDirectory = ParentDirectory;
    }
}
