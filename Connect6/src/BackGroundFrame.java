import javax.swing.*;

public class BackGroundFrame extends JFrame {

    private int number;

    public int getNumber() { return number; }

    public BackGroundFrame() {

        BackGroundButton nomal = new BackGroundButton("Nomal", this);
        BackGroundButton wind = new BackGroundButton("Wind", this);
        BackGroundButton space = new BackGroundButton("Space", this);

        // 배경 표시
        JLabel background_nomal = new JLabel(new ImageIcon("images//empty0.png"));
        JLabel background_wind = new JLabel(new ImageIcon("images//empty1.png"));
        JLabel background_space = new JLabel(new ImageIcon("images//empty2.png"));

        background_nomal.setBounds(40, 60, 80, 80);
        background_wind.setBounds(160, 60, 80, 80);
        background_space.setBounds(280, 60, 80,80);
        add(background_nomal);
        add(background_wind);
        add(background_space);

        // 버튼
        setLayout(null);
        nomal.setBounds(40, 20, 80, 30);
        wind.setBounds(160, 20, 80, 30 );
        space.setBounds(280, 20, 80,30);
        add(space);
        add(nomal);
        add(wind);

        // 프레임 설정
        setTitle("Select BackGround");
		setSize(400,200);
        setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void choice(String s){
        if (s.equals("Nomal"))
            number = 0;
        else if (s.equals("Wind"))
            number = 1;
        else 
            number = 2;
    }

}
