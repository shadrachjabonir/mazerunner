/**
 * Created by shadrach.jabonir on 9/3/2017.
 */
public class Pos {
    int x,y;
    public Pos(int x,int y){
        this.x = x;
        this.y = y;
    }
    public Pos up(){return new Pos(x,y-1);}
    public Pos down(){return new Pos(x,y+1);}
    public Pos left(){return new Pos(x-1,y);}
    public Pos right(){return new Pos(x+1,y);}
}
