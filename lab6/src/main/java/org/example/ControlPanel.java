package org.example;

import javax.swing.*;

public class ControlPanel extends JPanel {
    public ControlPanel() {
        JButton loadButton = new JButton("Load");
        JButton saveButton = new JButton("Save");
        JButton exitButton = new JButton("Exit");

        this.add(loadButton);
        this.add(saveButton);
        this.add(exitButton);

        exitButton.addActionListener(e -> System.exit(0));
    }
}
