/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laba4;

import gui.MainFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author vladshuvaev
 */
public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            DatabaseManager dbManager = new DatabaseManager();
            dbManager.initializeDatabase();
            try {
                dbManager.initializeDatabase();
            } catch (Exception e) {
                System.err.println("Ошибка при инициализации поставок: " + e.getMessage());
            }
            new MainFrame(dbManager).setVisible(true);
        });
    }
}
