/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileFunctions;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.swing.tree.DefaultMutableTreeNode;
import AuxClass.List;
import GUI.SimulatorFrame;
import MainClasses.App;
import MainPackage.Block;
import MainPackage.File;
import MainPackage.Directory;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeModel;
/**
 *
 * @author Gustavo
 */
public class FileSystemData {
    private final App app = App.getInstance();

    public FileSystemData() {

    }

    public void loadJSON(javax.swing.JTree FilesTree, SimulatorFrame SF){
        Gson gson = new Gson();
        try (Reader reader = new FileReader("file_system.json")) {
            JsonObject root = gson.fromJson(reader, JsonObject.class);

            // Reconstruir el árbol de archivos
            JsonObject treeJson = root.getAsJsonObject("filesTree");
            DefaultMutableTreeNode rootNode = deserializeTree(treeJson);
            FilesTree.setModel(new DefaultTreeModel(rootNode));

            // Reconstruir la lista de archivos
            JsonArray filesArray = root.getAsJsonArray("fileList");
            List<File> fileList = deserializeFileList(filesArray);
            //app.getFileSystemApp().getAssignTableSystem().setListFiles(fileList);

            // Actualizar la tabla de asignación
            if (!fileList.isEmpty() || fileList!=null){
                SF.updateAssignTable(fileList);
            
            }

            JOptionPane.showMessageDialog(SF, "Datos cargados exitosamente desde file_system.json");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(SF, "Error al cargar los datos: " + e.getMessage());
            e.printStackTrace();
        }
    }


    // Método para reconstruir el árbol desde JSON
    private DefaultMutableTreeNode deserializeTree(JsonObject nodeJson) {
        String name = nodeJson.get("name").getAsString();
        String type = nodeJson.has("type") ? nodeJson.get("type").getAsString() : "unknown";

        DefaultMutableTreeNode node;
        if (type.equals("directory")) {
            Directory directory = new Directory(name, null, null);
            node = new DefaultMutableTreeNode(directory, true);
        } else if (type.equals("file")) {
            int blockSize = nodeJson.has("blockSize") ? nodeJson.get("blockSize").getAsInt() : 0;

            // Reconstruir el primer bloque
            Block firstBlock = null;
            if (nodeJson.has("firstBlock") && !nodeJson.get("firstBlock").isJsonNull()) {
                JsonObject firstBlockJson = nodeJson.getAsJsonObject("firstBlock");
                int id = firstBlockJson.get("id").getAsInt() -1;
                boolean state = firstBlockJson.get("state").getAsBoolean();
                firstBlock = new Block(id, null);
                firstBlock.setState(state);
            }

            File file = new File(name, blockSize, firstBlock, null, null); // BlocksList será cargado desde filesArray
            file.setFirstBlock(firstBlock);
            node = new DefaultMutableTreeNode(file, false);
            
            System.out.println("SEEEE creo el acrchivo" + file);
            System.out.println("bloque archivo" + file.getFirstBlock().getId());
        } else {
            node = new DefaultMutableTreeNode(name);
        }

        JsonArray childrenArray = nodeJson.getAsJsonArray("children");
        for (JsonElement childElement : childrenArray) {
            JsonObject childJson = childElement.getAsJsonObject();
            DefaultMutableTreeNode childNode = deserializeTree(childJson);
            node.add(childNode);
        }

        return node;
    }


    // Método para reconstruir la lista de archivos desde JSON
    private List<File> deserializeFileList(JsonArray filesArray) {
        List<File> fileList = new List<>("Lista de Archivos");

        for (JsonElement fileElement : filesArray) {
            JsonObject fileJson = fileElement.getAsJsonObject();

            String fileName = fileJson.get("fileName").getAsString();
            int blockSize = fileJson.get("blockSize").getAsInt();

            // Reconstruir el primer bloque
            Block firstBlock = null;
            if (fileJson.has("firstBlock") && !fileJson.get("firstBlock").isJsonNull()) {
                JsonObject firstBlockJson = fileJson.getAsJsonObject("firstBlock");
                int id = firstBlockJson.get("id").getAsInt();
                boolean state = firstBlockJson.get("state").getAsBoolean();
                firstBlock = new Block(id, null); // El archivo se asignará más adelante
                firstBlock.setState(state);
            }

            // Reconstruir la lista de bloques asignados
            List<Block> blocksList = new List<>("Blocks List");
            JsonArray blocksArray = fileJson.has("blocksList") ? fileJson.getAsJsonArray("blocksList") : null;
            if (blocksArray != null) {
                for (JsonElement blockElement : blocksArray) {
                    JsonObject blockJson = blockElement.getAsJsonObject();
                    int id = blockJson.get("id").getAsInt();
                    boolean state = blockJson.get("state").getAsBoolean();

                    Block block = new Block(id, null); // El archivo se asignará más adelante
                    block.setState(state);
                    blocksList.append(block);
                }
            }

            // Crear el archivo y asignar sus propiedades
            File file = new File(fileName, blockSize, null, null, null); // ParentDirectory será null por ahora
            

            fileList.append(file);
        }

        return fileList;
    }

}
