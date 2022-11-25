package advprogproject2;
import java.util.Random; import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class tictactoe implements CheckClass,GameStatus,ActionListener{
    Scanner tscan = new Scanner(System.in);
    Random rand = new Random();
    int[] SUM_rows= {0,0,0};int[] SUM_col= {0,0,0};int SUM_dgn= 0;int SUM_dgp=0;
    Player PlayerOne = new Player(1);
    Player PlayerTwo = new Player(2);
    Board myBoard = new Board();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JLabel winner_field = new JLabel();
    JButton[] buttons = new JButton[9];
    JPanel winner_panel = new JPanel();
    public tictactoe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        textfield.setBackground(Color.WHITE);
        textfield.setForeground(Color.BLACK);
        textfield.setFont(new Font("Verdana", Font.BOLD, 33));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("TIC-TAC-TOE");
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 700, 100);
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(Color.WHITE);
        frame.add(button_panel);
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Ink Free", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            title_panel.add(textfield);
            frame.add(button_panel);
            frame.add(title_panel, BorderLayout.NORTH);

        }

    }
    @Override
    public int[] easyDifficulty(Random rand)
    {
        return new int[] {rand.nextInt(3),rand.nextInt(3)};
    }
    @Override
    public int[] midDifficulty(Board b,Random rand)
    {
        int x; int y;
        if (((b.getPieceStatus(0, 1)==1 && b.getPieceStatus(0, 2)==1) || (b.getPieceStatus(1, 0)==1 && b.getPieceStatus(2, 0)==1) || (b.getPieceStatus(1, 1)==1 && b.getPieceStatus(2, 2)==1))&& b.getPieceStatus(0, 0)==0)
        {x=0; y=0;}
        else if (((b.getPieceStatus(0, 0)==1 && b.getPieceStatus(0, 2)==1) || (b.getPieceStatus(1, 1)==1 && b.getPieceStatus(2, 1)==1)) && b.getPieceStatus(0, 1)==0)
        {x=0; y=1;}
        else if (((b.getPieceStatus(1, 2)==1 && b.getPieceStatus(2, 2)==1) || (b.getPieceStatus(0, 0)==1 && b.getPieceStatus(0, 1)==1) || (b.getPieceStatus(1, 1)==1 && b.getPieceStatus(2, 0)==1)) && b.getPieceStatus(0, 2)==0)
        {x=0; y=2;}
        else if (((b.getPieceStatus(0, 0)==1 && b.getPieceStatus(2, 0)==1) || (b.getPieceStatus(1, 1)==1 && b.getPieceStatus(1, 2)==1)) && b.getPieceStatus(1, 0)==0)
        {x=1; y=0;}
        else if (((b.getPieceStatus(0, 2)==1 && b.getPieceStatus(2, 1)==1) || (b.getPieceStatus(1, 0)==1 && b.getPieceStatus(1, 2)==1) || (b.getPieceStatus(0, 0)==1 && b.getPieceStatus(2, 2)==1)|| (b.getPieceStatus(0, 2)==1 && b.getPieceStatus(2, 0)==1)) && b.getPieceStatus(1, 1)==0)
        {x=1; y=1;}
        else if (((b.getPieceStatus(0, 2)==1 && b.getPieceStatus(2, 2)==1) || (b.getPieceStatus(1, 0)==1 && b.getPieceStatus(1, 1)==1)) && b.getPieceStatus(1, 2)==0)
        {x=1; y=2;}
        else if (((b.getPieceStatus(0, 0)==1 && b.getPieceStatus(1, 0)==1) || (b.getPieceStatus(2, 1)==1 && b.getPieceStatus(2, 2)==1) || (b.getPieceStatus(1, 1)==1 && b.getPieceStatus(0, 2)==1)) && b.getPieceStatus(2, 0)==0)
        {x=2; y=0;}
        else if (((b.getPieceStatus(0, 1)==1 && b.getPieceStatus(1, 1)==1) || (b.getPieceStatus(2, 0)==1 && b.getPieceStatus(2, 2)==1)) && b.getPieceStatus(2, 1)==0)
        {x=2; y=1;}
        else if (((b.getPieceStatus(0, 0)==1 && b.getPieceStatus(1, 1)==1) || (b.getPieceStatus(0, 2)==1 && b.getPieceStatus(1, 2)==1) || (b.getPieceStatus(2, 0)==1 && b.getPieceStatus(2, 1)==1)) && b.getPieceStatus(2, 2)==0)
        {x=2; y=2;}
        else {x=rand.nextInt(3); y=rand.nextInt(3);}
        return new int[] {x,y};
    }
    @Override
    public int[] hardDifficulty(int i,Board b)
    {
        int x; int y;
        switch (i) {
            case 1:
                x=1;
                y=1;
                return new int[] {x,y};
            case 3:
                if(b.getPieceStatus(0, 0)==1 || b.getPieceStatus(0, 2)==1)
                {x=0; y=1;}
                else if(b.getPieceStatus(2, 0)==1 || b.getPieceStatus(2, 2)==1)
               {x=2; y=1;}
                else if(b.getPieceStatus(0, 1)==1 || b.getPieceStatus(1, 2)==1)
                {x=0; y=2;}
                else {x=2; y=0;}
                return new int[] {x,y};
            case 5:
                if((b.getPieceStatus(0, 1)==-1 && b.getPieceStatus(2, 1)!=1) || (b.getPieceStatus(2, 0)==-1 && b.getPieceStatus(0, 2)==1 && b.getPieceStatus(1, 0)==1))
                {x=2; y=1;}
                else if((b.getPieceStatus(2, 1)==-1 && b.getPieceStatus(0, 1)!=1) || (b.getPieceStatus(0, 2)==-1 && b.getPieceStatus(2, 0)==1 && b.getPieceStatus(1, 2)==1))
                {x=0; y=1;}
                else if(b.getPieceStatus(0, 2)==-1 && b.getPieceStatus(2, 0)!=1)
                {x=2; y=0;}
                else if(b.getPieceStatus(2, 0)==-1 && b.getPieceStatus(0, 2)!=1)
                {x=0; y=2;}
                else if((b.getPieceStatus(0, 1)==-1 && b.getPieceStatus(2, 1)==1 && b.getPieceStatus(0, 0)==1) || (b.getPieceStatus(2, 1)==-1 && b.getPieceStatus(0, 1)==1 && b.getPieceStatus(2, 0)==1) || (b.getPieceStatus(2, 0)==-1 && b.getPieceStatus(0, 2)==1 && b.getPieceStatus(2, 1)==1))
                {x=1; y=0;}
                else {x=1; y=2;}
                return new int[] {x,y};
            case 7:
                if((b.getPieceStatus(0, 2)==-1 && b.getPieceStatus(0, 1)==-1 && b.getPieceStatus(0, 0)!=1) || (b.getPieceStatus(2, 0)==-1 && b.getPieceStatus(1, 0)==-1 && b.getPieceStatus(0, 0)!=1))
                {x=0; y=0;}
                else if(b.getPieceStatus(2, 0)==-1 && b.getPieceStatus(2, 1)==-1 && b.getPieceStatus(0, 2)==1 && b.getPieceStatus(1, 0)==1 && b.getPieceStatus(2, 2)==1)
                {x=0; y=1;}
                else if(((b.getPieceStatus(2, 1)==-1 || b.getPieceStatus(0, 1)==-1) && b.getPieceStatus(1, 2)==-1 && b.getPieceStatus(1, 0)!=1) || (b.getPieceStatus(0, 2)==-1 && b.getPieceStatus(1, 2)==-1 && b.getPieceStatus(2, 0)==1 && b.getPieceStatus(0, 1)==1 && b.getPieceStatus(2, 2)==1))
                {x=1; y=0;}
                else if(((b.getPieceStatus(2, 1)==-1 || b.getPieceStatus(0, 1)==-1) && b.getPieceStatus(1, 0)==-1 && b.getPieceStatus(1, 2)!=1) || (b.getPieceStatus(1, 0)==-1 && b.getPieceStatus(2, 0)==-1 && b.getPieceStatus(0, 2)==1 && b.getPieceStatus(2, 1)==1 && b.getPieceStatus(0, 0)==1))
                {x=1; y=2;}
                else if(b.getPieceStatus(2, 1)==-1 && b.getPieceStatus(1, 2)==-1 && b.getPieceStatus(0, 1)==1 && b.getPieceStatus(2, 2)==1 && b.getPieceStatus(1, 0)==1)
                {x=2; y=0;}
                else if(b.getPieceStatus(0, 2)==-1 && b.getPieceStatus(0, 1)==-1 && b.getPieceStatus(2, 0)==1 && b.getPieceStatus(1, 2)==1 && b.getPieceStatus(0, 0)==1)
                {x=2; y=1;}
                else {x=2; y=2;}
                return new int[] {x,y};
            case 9:
                if(b.getPieceStatus(0, 0)==0)
                {x=0; y=0;}
                else if(b.getPieceStatus(2, 0)==0)
                {x=2; y=0;}
                else {x=0; y=2;}
                return new int[] {x,y};
            default: return new int[] {0,0};
        }
    }
    @Override
    public int checkWinner(int x,int y,char XO) {
        int state;
        if(XO=='X')
            state =1;
        else state=-1;
        SUM_rows[x]+=state;
        if(SUM_rows[x]==3*state)
            return state;
        SUM_col[y]+=state;
        if(SUM_col[y]==3*state)
            return state;
        if(x==y)
        SUM_dgn+=state;
        if(SUM_dgn==3*state)
            return state;
        if(3-1-y == x)
        SUM_dgp+=state;
        if(SUM_dgp==3*state)
            return state;
return 0;
    }
    @Override
    public void startGamePVP() {
        Board myBoard = new Board();
        SUM_rows= new int[]{0, 0, 0}; SUM_col= new int[]{0, 0, 0}; SUM_dgn= 0; SUM_dgp=0;
        //setting players info
        System.out.println("Player 1");
        PlayerOne.setName();
        System.out.println("Player 2");
        PlayerTwo.setName();
        for (int i = 0; i < 9; i++) {
            System.out.println("Enter X,Y");
            if(i%2==0)
                System.out.println("Player 1");
                else
                System.out.println("Player 2");
            int x;x=tscan.nextInt();int y;y=tscan.nextInt();
            if(x<=2 && x>=0 && y<=2 &&y>=0 && myBoard.getPieceStatus(x, y)==0)
            {
            while(true)
            {System.out.println("Error! Please re-enter your co-ordinates");
                if(x<=2 && x>=0 && y<=2 &&y>=0 && myBoard.getPieceStatus(x, y)==0)
                break;
                x=tscan.nextInt();
                y=tscan.nextInt();
            }}
            if(i%2==0)
            {
                myBoard.setPiece(x,y,'X');
                myBoard.getBoardX();
                if(checkWinner(x,y,'X')==1)
                {
                    System.out.println(PlayerOne.getName() + " wins..");
                    break;
                }
            }
            else {
                myBoard.setPiece(x, y, 'O');
                myBoard.getBoardX();
                if(checkWinner(x,y,'O')==-1)
                {
                    System.out.println(PlayerTwo.getName() + " wins..");
                    break;
                }
            }
        }
        //for loop i(9)
        myBoard.getBoardX();
    }
    @Override
    public void startGamePVE() {
        int diff;
        System.out.println("Choose your difficulty\n1.Easy\n2.Medium\n3.Hard");
        diff=tscan.nextInt();
        while (diff>3 || diff <1)   {
            System.out.println("Error! Please choose a difficulty");
            diff=tscan.nextInt();   }
        Board myBoard = new Board();
        SUM_rows= new int[]{0, 0, 0}; SUM_col= new int[]{0, 0, 0}; SUM_dgn= 0; SUM_dgp=0;
        for (int j = 0; j < 9; j++) {
            int x; int y;int i;
            if (diff==3) {
                i=j+1;
                if(j==9)
                    break; }
            else i=j;
            if(i%2==0)
            {   System.out.println("Enter X,Y");
                x=tscan.nextInt(); y=tscan.nextInt();}
            else
            {
                switch (diff) {
                    case 1:
                        x=easyDifficulty(rand)[0];
                        y=easyDifficulty(rand)[1];
                        break;
                    case 2:
                        x=midDifficulty(myBoard, rand)[0];
                        y=midDifficulty(myBoard, rand)[1];
                        break;
                    default:
                        x=hardDifficulty(i,myBoard)[0];
                        y=hardDifficulty(i,myBoard)[1];
                        break;
                }
            }
            if(x>2 || y>2 || x<0 || y<0 || myBoard.getPieceStatus(x, y)!=0)
            {
            while(true)
            {
                if(x<=2 && x>=0 && y<=2 &&y>=0 && myBoard.getPieceStatus(x, y)==0)
                break;
                if(i%2==0)
                {   System.out.println("Error! Please re-enter your co-ordinates");
                    x=tscan.nextInt();
                    y=tscan.nextInt(); }
                else
                {
                    switch (diff) {
                        case 1:
                            x=easyDifficulty(rand)[0];
                            y=easyDifficulty(rand)[1];
                            break;
                        case 2:
                            x=midDifficulty(myBoard, rand)[0];
                            y=midDifficulty(myBoard, rand)[1];
                            break;
                        default:
                            x=hardDifficulty(i,myBoard)[0];
                            y=hardDifficulty(i,myBoard)[1];
                            break;
                    }
                }
            }}
            if(i%2==0)
            {
                myBoard.setPiece(x,y,'X');
                if(checkWinner(x,y,'X')==1)
                {
                    myBoard.getBoardX();
                    System.out.println("You win..");
                    break;
                }
            }
            else {
                myBoard.setPiece(x, y, 'O');
                if(checkWinner(x,y,'O')==-1)
                {
                    myBoard.getBoardX();
                    System.out.println("You Lose..");
                    break;
                }
                else myBoard.getBoardX();
            }
        }
    }
    boolean player_turn = false;

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {

            if (e.getSource() == buttons[i]) {
                if (player_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.BLACK);
                        buttons[i].setText("O");
                        player_turn = false;
                        //

                        textfield.setText("Player " + PlayerTwo.name +" Turn" );
                        //textfield.setText("Player 2 Turn" );

                        //
                        int row = (i) / 3;
                        int col = 22;
                        //
                        if (((i + 1) % 3) == 1)
                            col = 0;
                        if (((i + 1) % 3) == 2)
                            col = 1;
                        if (((i + 1) % 3) == 0)
                            col = 2;

                        myBoard.setPiece(row, col, 'O');
                        myBoard.getBoardX();
                        System.out.println(" ");

                        if (checkWinner(row, col, 'O') == -1) {
                            System.out.println("O WINSS");
                            textfield.setText("Player " + PlayerTwo.name + " WINS");
                            //textfield.setText("Player 2 WINS");
                            break;

                        }
                        //
                        textfield.setText("Player " + PlayerOne.name +" Turn" );
                        //textfield.setText("Player 1 Turn" );
                        //

                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.BLACK);
                        buttons[i].setText("X");
                        player_turn = true;
                        //
                        textfield.setText("Player " + PlayerOne.name +" Turn" );
                        // textfield.setText("Player 1 Turn" );
                        //
                        int row = (i) / 3;
                        int col = 22;
                        //
                        if (((i + 1) % 3) == 1)
                            col = 0;
                        if (((i + 1) % 3) == 2)
                            col = 1;
                        if (((i + 1) % 3) == 0)
                            col = 2;

                        myBoard.setPiece(row, col, 'X');
                        myBoard.getBoardX();
                        System.out.println(" ");
                        if (checkWinner(row, col, 'X') == 1) {
                            System.out.println("X WINSS");
                            textfield.setText("Player " + PlayerOne.name + " WINS");
                            //textfield.setText("Player 1 WINS");
                            break;

                        }
                        //
                        textfield.setText("Player " + PlayerTwo.name +" Turn" );
                        //textfield.setText("Player 2 Turn" );
                        //

                    }
                }
            }
        }

    }
}