/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import com.mycompany.laba4.DatabaseManager;
import javax.swing.*;
import java.awt.Font;
import java.sql.SQLException;


/**
 *
 * @author vladshuvaev
 */
public class MainFrame extends JFrame {
    private final DatabaseManager dbManager;
    
    public MainFrame(DatabaseManager dbManager) {
        this.dbManager = dbManager;
        initializeUI();
    }
    
    private void initializeUI() {
    setTitle("Магазин волшебных палочек Оливандера");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800, 600);
    setLocationRelativeTo(null);

    // Установка красивого зелёного цвета фона
    getContentPane().setBackground(new java.awt.Color(144, 238, 144)); // светло-зелёный (light green)

    JTabbedPane tabbedPane = new JTabbedPane();

    tabbedPane.addTab("Палочки", new WandsPanel(dbManager));
    tabbedPane.addTab("Покупатели", new WizardsPanel(dbManager));
    tabbedPane.addTab("Компоненты", new ComponentsPanel(dbManager));
    tabbedPane.addTab("Продажи", new SalesPanel(dbManager));
    tabbedPane.addTab("Поставки", new DeliveryPanel(dbManager));

    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("Очистка");

    JMenuItem clearDataItem = new JMenuItem("Очистить все данные");
    clearDataItem.addActionListener(e -> clearAllData());

    fileMenu.add(clearDataItem);
    menuBar.add(fileMenu);
    setJMenuBar(menuBar);

    add(tabbedPane);
    }
    

    
    private void clearAllData() {
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Вы уверены, что хотите очистить все данные?",
            "Подтверждение",
            JOptionPane.YES_NO_OPTION
        );
        
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                dbManager.clearAllData();
                JOptionPane.showMessageDialog(
                    this,
                    "Все данные успешно очищены",
                    "Успех",
                    JOptionPane.INFORMATION_MESSAGE
                );
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(
                    this,
                    "Ошибка при очистке данных: " + e.getMessage(),
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}
