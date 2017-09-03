public class Main {
    public static void main(String[] args) {

        char[][] Maze =
                {
                        {'X','X','X','X','X','X','X','X','X'},
                        {'X','X','X','X','X','X','S','X','X'},
                        {'X',' ',' ',' ',' ',' ',' ',' ','X'},
                        {'X',' ','X','X','X','X','X',' ','X'},
                        {'X',' ',' ',' ',' ','X','X',' ','X'},
                        {'X','X','X','X',' ','X',' ','X','X'},
                        {'X','X',' ',' ',' ',' ',' ','X','X'},
                        {'X','X','X','X','X','X','E','X','X'},
                };

        char[][] Maze2 =
                {
                        {'X','X','X','X','X','X','X','X','X'},
                        {'X','S','X','X','X','X',' ','X','X'},
                        {'X',' ',' ',' ',' ',' ',' ',' ','X'},
                        {'X',' ','X','X','X','X','X',' ','E'},
                        {'X',' ',' ',' ',' ','X','X',' ','X'},
                        {'X','X','X','X',' ','X',' ','X','X'},
                        {'X','X',' ',' ',' ',' ',' ','X','X'},
                        {'X','X','X','X','X','X','X','X','X'},
                };

        MazeBfs mazeBfs = new MazeBfs(Maze);
        mazeBfs.scanMaze();
        mazeBfs.getScanResult();
        mazeBfs.run();
        System.out.println("");
        System.out.println("finish maze 1");
        mazeBfs = new MazeBfs(Maze2);
        mazeBfs.scanMaze();
        mazeBfs.getScanResult();
        mazeBfs.run();
        System.out.println("");
        System.out.println("finish maze 2");
    }
}
