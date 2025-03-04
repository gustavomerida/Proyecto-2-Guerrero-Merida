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
public class AssignTable {

    private List<File> ListFiles;

    public AssignTable(List<File> ListFiles) {
        this.ListFiles = ListFiles;
    }

    public StringBuilder updateTextArea() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-20s %-15s %-20s %-50s\n", "Nombre Archivo", "Bloques Asignados", "Direccion Primer Bloque", "Color"));
        sb.append("----------------------------------------------------------------------------\n");

        for (int i = 0; i < this.ListFiles.size(); i++) {

            String FileName = this.ListFiles.get(i).getFileName();
            String BlockList = this.ListFiles.get(i).getBlocksList().travel2();
            int FirstBlock = this.ListFiles.get(i).getFirstBlock().getId();
            String Color = null;
            sb.append(String.format("%-20s %-15s %-20s %-50s\n", FileName, BlockList, FirstBlock, Color));
        }
        
        return sb;
        
    }

    public List<File> getListFiles() {
        return ListFiles;
    }

    public void setListFiles(List<File> ListFiles) {
        this.ListFiles = ListFiles;
    }

}
