import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shadrach.jabonir on 9/3/2017.
 */
public class MazeBfs {
    private static char[][] maze;
    private static int startX,finishX, startY,finishY;
    private final char VISIT = '*';

    public MazeBfs(char[][] maze){
        this.maze = maze;
    }

    public void scanMaze(){
        for( int y =0; y<maze.length;y++){
            for( int x=0; x<maze[0].length;x++){
                if(maze[y][x]=='S'){
                    startX = x;
                    startY = y;
                }
                if(maze[y][x]=='E'){
                    finishX = x;
                    finishY = y;
                }
                System.out.print(maze[y][x] + " ");
            }
            System.out.println("");
        }
    }

    private char[][] cloneMaze(){
        char [][] newMaze = new char[maze.length][maze[0].length];
        for(int y = 0;y<maze.length;y++){
            for(int x =0; x<maze[0].length;x++){
                newMaze[y][x] = maze[y][x];
            }
        }
        return newMaze;
    }

    private void restart(char[][] maze){
        for(int y=0;y<this.maze.length;y++){
            for(int x=0;x<this.maze[0].length;x++){
                this.maze[y][x] = maze[y][x];
            }
        }
    }

    public void getScanResult(){
        System.out.println("\nStarting Coordinates: " + startX + " " + startY);
        System.out.println("Exit Coordinates: " + finishX + " " + finishY);
    }

    private char visit(Pos pos, char x){
        char temp = this.maze[pos.y][pos.x];
        this.maze[pos.y][pos.x] = x;
        return temp;
    }

    private boolean isVisited(Pos pos){
        if(this.maze[pos.y][pos.x] != VISIT && this.maze[pos.y][pos.x]!='X'){
            return true;
        }else{
            return false;
        }
    }

    private boolean hasEscaped(Pos pos){
        if(pos.y==finishY && pos.x== finishX){
            return true;
        }else{
            return false;
        }
    }

    public void run(){
        char[][] clone = cloneMaze();
        Queue<Pos> mazeQueue = new LinkedList<Pos>();
        mazeQueue.add(new Pos(startX,startY));
        Pos nextPos,curPos;
        while(!mazeQueue.isEmpty()){
            curPos = mazeQueue.remove();
            if(hasEscaped(curPos)){
                visit(curPos,VISIT);
                System.out.println("escaped");
                scanMaze();
                break;
            }
            visit(curPos,VISIT);
            nextPos = curPos.up();
            if(isVisited(nextPos))
                mazeQueue.add(nextPos);
            nextPos = curPos.down();
            if(isVisited(nextPos))
                mazeQueue.add(nextPos);
            nextPos = curPos.right();
            if(isVisited(nextPos))
                mazeQueue.add(nextPos);
            nextPos = curPos.left();
            if(isVisited(nextPos))
                mazeQueue.add(nextPos);
            scanMaze();
            System.out.println("");
        }
        restart(cloneMaze());
    }
}
