/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileFunctions;
import AuxClass.List;
/**
 *
 * @author Gustavo
 */
public class TreeNodeData {
private String name; // Nombre del nodo
    private List<TreeNodeData> children; // Hijos del nodo

    public TreeNodeData(String name) {
        this.name = name;
        this.children = new List<>("Children");
    }

    public void setChildren(List<TreeNodeData> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public List<TreeNodeData> getChildren() {
        return children;
    }
}
