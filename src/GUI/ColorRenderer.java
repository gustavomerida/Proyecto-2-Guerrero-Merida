package GUI;

import javax.swing.*;
import java.awt.*;


// SE PODRIA DESARROLLAR UNA LOGICA PARA LOS COLORES

public class ColorRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        setOpaque(true);
        if (value != null) {
            if (isSelected) {

                setBackground(Color.RED.darker());
                setForeground(Color.WHITE);

            } else {
                
                setBackground(Color.RED);
                setForeground(Color.WHITE);

            }

        } else {

            if (isSelected) {

                setBackground(Color.GREEN.darker());
                setForeground(Color.BLACK);
                
            } else {

                setBackground(Color.GREEN);
                setForeground(Color.BLACK);
            }
        }

        return this;
    }
}
