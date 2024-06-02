import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class SnakeGame extends JFrame {

    private GameBoard gameBoard;
    private JPanel welcomePanel;

    public SnakeGame() {
        initUI();
    }

    private void initUI() {
        setTitle("Snake Game");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

       

        welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Welcome to Snake Game", JLabel.CENTER);
        titleLabel.setFont(new Font("Algerian", Font.BOLD, 24));
        welcomePanel.add(titleLabel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Algerian", Font.BOLD, 18));
        welcomePanel.add(startButton, BorderLayout.SOUTH);
        welcomePanel.setBackground(Color.BLUE); 
        titleLabel.setForeground(Color.WHITE); 
        startButton.setBackground(Color.GREEN);
        startButton.setForeground(Color.WHITE);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        add(welcomePanel);
    }

    private void startGame() {
        if (gameBoard != null) {
            remove(gameBoard);
        }
        gameBoard = new GameBoard();
        add(gameBoard);
        revalidate();
        repaint();
        gameBoard.requestFocusInWindow(); // Ensure focus is set
    }

    public void showWelcomePanel() {
        remove(gameBoard);
        add(welcomePanel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ex = new SnakeGame();
            ex.setVisible(true);
        });
    }
}
