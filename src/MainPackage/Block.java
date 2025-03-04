/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

/**
 *
 * @author Angelo
 */
public class Block {

    private int id;
    private boolean State;
    private File FileInBlock;

    public Block(int id, File FileInBlock) {
        this.id = id;
        this.State = false;
        this.FileInBlock = FileInBlock;

    }

    public String ShowID() {
        return "ID: " + this.getId(); // O el detalle que quieras mostrar
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isState() {
        return State;
    }

    public void setState(boolean State) {
        this.State = State;
    }

    public File getFileInBlock() {
        return FileInBlock;
    }

    public void setFileInBlock(File FileInBlock) {
        this.FileInBlock = FileInBlock;
    }

}
