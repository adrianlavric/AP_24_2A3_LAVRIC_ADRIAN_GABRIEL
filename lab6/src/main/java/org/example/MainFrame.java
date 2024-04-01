package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ConfigurationPanel configurationPanel;
    private DrawingPanel drawingPanel;
    private ControlPanel controlPanel;
    public MainFrame() {
        setTitle("My Game");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        configurationPanel = new ConfigurationPanel(this);
        drawingPanel = new DrawingPanel();
        controlPanel = new ControlPanel();

        add(configurationPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }
    public DrawingPanel getDrawingPanel() {
        return drawingPanel;
    }
}
