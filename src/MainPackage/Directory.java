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
public class Directory {
    private String DirectoryName;
    private List<File> FilesIntoDirectory;
    private List<Directory> SubDirectoriesList;

    public Directory(String DirectoryName, List<File> FilesIntoDirectory, List<Directory> SubDirectoriesList) {
        this.DirectoryName = DirectoryName;
        this.FilesIntoDirectory = FilesIntoDirectory;
        this.SubDirectoriesList = SubDirectoriesList;
    }
    
}
