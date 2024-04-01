package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.module.Configuration;

public class ConfigurationPanel extends JPanel {
    private MainFrame mainFrame;
    private JButton newGameButton;
    private JTextField gridWidthField;
    private JTextField gridHeightField;
    public ConfigurationPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initialize();
    }

    private void initialize() {
        JLabel widthLabel = new JLabel("Grid Width:");
        gridWidthField = new JTextField(5);
        JLabel heightLabel = new JLabel("Grid Height:");
        gridHeightField = new JTextField(5);
        newGameButton = new JButton("Create");

        this.add(widthLabel);
        this.add(gridWidthField);
        this.add(heightLabel);
        this.add(gridHeightField);
        this.add(newGameButton);

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int width = Integer.parseInt(gridWidthField.getText());
                int height = Integer.parseInt(gridHeightField.getText());
                mainFrame.getDrawingPanel().setGridSize(width, height);
            }
        });
    }

}
