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

    @Override
    public String toString(){
        return DirectoryName + " [D]";
    }
    
    
    /**
     * @return the DirectoryName
     */
    public String getDirectoryName() {
        return DirectoryName;
    }

    /**
     * @param DirectoryName the DirectoryName to set
     */
    public void setDirectoryName(String DirectoryName) {
        this.DirectoryName = DirectoryName;
    }

    /**
     * @return the FilesIntoDirectory
     */
    public List<File> getFilesIntoDirectory() {
        return FilesIntoDirectory;
    }

    /**
     * @param FilesIntoDirectory the FilesIntoDirectory to set
     */
    public void setFilesIntoDirectory(List<File> FilesIntoDirectory) {
        this.FilesIntoDirectory = FilesIntoDirectory;
    }

    /**
     * @return the SubDirectoriesList
     */
    public List<Directory> getSubDirectoriesList() {
        return SubDirectoriesList;
    }

    /**
     * @param SubDirectoriesList the SubDirectoriesList to set
     */
    public void setSubDirectoriesList(List<Directory> SubDirectoriesList) {
        this.SubDirectoriesList = SubDirectoriesList;
    }
    
}
