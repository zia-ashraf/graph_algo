public class knightTour {
    public static void main(String args[]){
        int r=5;
        int c=5;
        int[][] chess=new int[r][c];
        
        printKnightsTour(chess, 2, 0, 1);

    }
    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        if(r<0 || c<0 || r>=chess.length || c>=chess[0].length){
            return;
        }
        if(chess[r][c]!=0){
            return;
        }
        // System.out.println("skldfslkj");
        // System.out.println("skldfslkj");
        
        chess[r][c]=upcomingMove;
        if(upcomingMove==chess.length*chess[0].length)//KICK :)
        {
            displayBoard(chess);
        }

        printKnightsTour(chess,r-2,c+1,upcomingMove+1);
        printKnightsTour(chess,r-1,c+2,upcomingMove+1);
        printKnightsTour(chess,r+1,c+2,upcomingMove+1);
        printKnightsTour(chess,r+2,c+1,upcomingMove+1);
        printKnightsTour(chess,r+2,c-1,upcomingMove+1);
        printKnightsTour(chess,r+1,c-2,upcomingMove+1);
        printKnightsTour(chess,r-1,c-2,upcomingMove+1);
        printKnightsTour(chess,r-2,c-1,upcomingMove+1);
        chess[r][c]=0;  //important
    }
    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
    
}
