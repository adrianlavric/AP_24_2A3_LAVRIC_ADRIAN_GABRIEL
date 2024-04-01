package org.example;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    private int gridWidth;
    private int gridHeight;
    private boolean drawGrid = false;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(drawGrid) {
            drawGrid(g);
        }
    }

    private void drawGrid(Graphics g) {
        int cellWidth = getWidth() / gridWidth;
        int cellHeight = getHeight() / gridHeight;

        for (int i = 0; i <= gridWidth; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, getHeight());
        }

        for (int i = 0; i <= gridHeight; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, getWidth(), y);
        }
    }

    public void setGridSize(int width, int height) {
        this.gridWidth = width;
        this.gridHeight = height;
        drawGrid = true;
        repaint();
    }
}
