package advprogproject2;

import java.util.Scanner;

enum TYPE{Human,Computer}
public class Player {
    String name;
    int num;
    TYPE type;
    public Player(int num)
    {
        this.num=num;
    }
    Scanner scp =new Scanner(System.in);
    public void setName() {
        System.out.println("Enter player name");
        this.name =scp.next();
    }
    public String getName() {
        return name;
    }
}