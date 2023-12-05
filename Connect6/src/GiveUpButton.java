
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;


public class GiveUpButton extends JButton implements ActionListener {

    private ScoreBoard score_board;
    private Board board;

    public GiveUpButton(ScoreBoard sb, Board b) {
        super("기권");
        score_board = sb;
        board = b;
        addActionListener(this);       
    }

    public void actionPerformed(ActionEvent e) {
        getScore();
        reset();
    }

    // 기권을 한 사람의 반대편에 점수 할당 
    private void getScore() {
        if (board.turn().equals(board.white())){
            try {
                score_board.update(board.white());
                JOptionPane.showMessageDialog(null, score_board.player_black() + " Win!");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {
            try {
                score_board.update(board.black());
                JOptionPane.showMessageDialog(null, score_board.player_white() + " Win!");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    // 3선 2승 해서 2승 할 경우 이긴사람 출력 및 다시 게임 할지 묻기
    private void reset(){
        if (score_board.matchOver()){
            int result = JOptionPane.showConfirmDialog(null, "새로운 게임을 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
        
            if (result == JOptionPane.YES_OPTION){
                board.reStart();
                score_board.begin();
            } else {
                System.exit(1);
            }
        } else {
            board.reStart();
        }
    }

}