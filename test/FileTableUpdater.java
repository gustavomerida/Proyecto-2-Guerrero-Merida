/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pilli
 */
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FileTableUpdater {
    private JTextArea textArea;
    private Map<String, String> fileRecords; // Para almacenar los registros de archivos por nombre

    public FileTableUpdater() {
        // Inicializamos la interfaz
        JFrame frame = new JFrame("Gestor de Archivos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Crear el JTextArea con encabezados
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // Inicializar almacenamiento de registros
        fileRecords = new HashMap<>();

        // Agregar un JScrollPane para que el texto sea desplazable
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Mostrar la ventana
        frame.setVisible(true);

        // Agregar encabezados
        updateTextArea();
    }

    /**
     * Método para agregar o actualizar un archivo en el JTextArea.
     * Si el archivo ya existe, se actualizarán sus valores.
     */
    public void addOrUpdateFile(String fileName, int blocks, String firstBlockAddress, String color) {
        // Crear el nuevo registro
        String newRecord = String.format("%-20s %-15d %-20s %-10s", fileName, blocks, firstBlockAddress, color);
        
        // Guardar en la estructura
        fileRecords.put(fileName, newRecord);

        // Actualizar el JTextArea con los valores nuevos
        updateTextArea();
    }

    /**
     * Método para actualizar el contenido del JTextArea
     */
    private void updateTextArea() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s %-15s %-20s %-50s\n", "Nombre Archivo", "Bloques Asignados", "Dirección Primer Bloque", "Color"));
        sb.append("----------------------------------------------------------------------------\n");

        for (String record : fileRecords.values()) {
            sb.append(record).append("\n");
        }

        textArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        FileTableUpdater manager = new FileTableUpdater();

        
        // Agregamos archivos de prueba
        manager.addOrUpdateFile("archivo1.txt", 10, "0x1A3B", "Rojo");
        manager.addOrUpdateFile("documento.pdf", 20, "0x2F4C", "Azul");

        // Simulación de actualización de un archivo existente
        manager.addOrUpdateFile("archivo1.txt", 15, "0x1A3B", "Verde");
    }
}
