public class GoStone{

    private int x;
    private int y;
    private String state;

    public int x() {return x;}
    public int y() {return y;}
    public String state() {return state;}
    public String state(String s) {return state = s;}
    
    public GoStone(int row, int col) {
        x = row;
        y = col;
        state = "NULL";
    }

}
