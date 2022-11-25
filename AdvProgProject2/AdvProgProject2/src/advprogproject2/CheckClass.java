package advprogproject2;
import java.util.Random;
public interface CheckClass {
    public int checkWinner(int x,int y,char Q);
    public int[] easyDifficulty(Random rand);
    public int[] midDifficulty(Board b,Random rand);
    public int[] hardDifficulty(int i,Board b);
}
