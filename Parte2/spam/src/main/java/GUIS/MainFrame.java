package GUIS;

import Model.GameController;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame{
    private GameController controller;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public MainFrame() {
        super("SCC");
        initFrame();
        initGame();
    }

    private void initFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        this.setContentPane(mainPanel);
    }

    private void initGame() {
        controller = new GameController();
        InitPage pInicio = new InitPage(this, controller);
        Combat pCombat = new Combat(this, controller);
        
        mainPanel.add(pInicio, "Inicio");
        mainPanel.add(pCombat, "Combat");
        
        mostrarPantalla("Inicio");
    }
    
    public void mostrarPantalla(String nombre){
        cardLayout.show(mainPanel, nombre);
    }
    
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
