import java.awt.*;
import java.io.*;
import javax.swing.*;

public class ScoreBoard extends JFrame {

    private JLabel set_score_white;
    private JLabel set_score_black;
    private JLabel p_black;
    private JLabel p_white;
    private Board board;
    
    public boolean black_win = false;

    public String player_black() {return p_black.getText();}
    public String player_white() {return p_white.getText();}

    public ScoreBoard(Board b) {
        board = b;
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(3,1));
        JPanel p1 = new JPanel(new FlowLayout());
        p_black = new JLabel(JOptionPane.showInputDialog(null, "Enter your name"));
        p_white = new JLabel(JOptionPane.showInputDialog(null, "Enter your name"));
        p1.add(p_black);
        p1.add(new JLabel(":"));
        p1.add(p_white);
        cp.add(p1);
        JPanel p2 = new JPanel(new FlowLayout());
        set_score_black = new JLabel("0");
        p2.add(set_score_black);
        p2.add(new JLabel(":"));
        set_score_white = new JLabel("0");
        p2.add(set_score_white);
        cp.add(p2);
        JPanel p4 = new JPanel(new FlowLayout());
        p4.add(new GiveUpButton(this, board));
        cp.add(p4);
        begin();
        setLocation(810,0);
        setTitle("ScoreBoard");
        setSize(200,160);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void begin() {
        if (matchOver()) {
            p_black.setText(JOptionPane.showInputDialog(null, "Enter your name."));
            p_white.setText(JOptionPane.showInputDialog(null, "Enter your name."));
            set_score_white.setText("0");
            set_score_black.setText("0");
        }
    }

    public boolean matchOver() {
        int guest = Integer.parseInt(set_score_white.getText());
        int home = Integer.parseInt(set_score_black.getText());
        return guest == 2 || home == 2;
    }

    private void updateSetScore(JLabel winner) {
        int new_set_score = Integer.parseInt(winner.getText()) + 1;
        winner.setText(Integer.toString(new_set_score));
    }

    public void update() throws IOException {
        if(black_win) {
            updateSetScore(set_score_black);
            black_win = false;
        } else {
            updateSetScore(set_score_white);
        }
    }

    public void update(ImageIcon i) throws IOException {
        if(i.equals(board.black())) {
            updateSetScore(set_score_white);
        } else {
            updateSetScore(set_score_black);
        }
    }

}