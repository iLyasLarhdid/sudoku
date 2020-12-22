package soduko_solver;


public class AiPlayer {
	public static int x;
	public static int y;
	public static int backtracks;
	public static boolean findNextCell(int[][] tab){
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				if(tab[i][j] == 0){
					x=i;
					y=j;
					//System.out.println("x = "+x+"\ty = "+y);
					return true;
				}
		
		return false;
		
	}
	public static boolean isValid(int[][] tab,int x, int y,int e){
		//System.out.println("x="+x+"\ty="+y);
		for(int i = 0 ; i<9 ; i++){
			
			if(tab[i][y]==e){
				//System.out.println("problem in Y"+e);
				return false;}
		
			if(tab[x][i]==e){
				//System.out.println("problem in X"+e);
				return false;}
			
		}
		
		int startX = (x/3)*3;
		int startY = (y/3)*3;
		
		for(int i = startX ; i < startX+3 ; i++)
			for(int j = startY ; j < startY+3 ; j++)
				if(tab[i][j]==e){
					//System.out.println("problem in box"+e);
					return false;}
		
		//System.out.println("true");
		return true;
	}
		
		
		
	public static void undoImplications(){
		
	}
	
	public static boolean solveIt(int[][] tab,int i, int j){
		if(findNextCell(tab)){
			i=x;
			j=y;
			for(int e=1;e<=9;e++)
				if(isValid(tab,i,j,e)){
					//tab[i][j]=e;
					//System.out.println("im in "+e+"\n");
					if(solveIt(tab,i,j))
						return true;}
			
				
				tab[i][j]=0;
				backtracks++;
				//System.out.println("im out ");
				return false;
				
			}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		//post your sudoku here
			
		int sudoku[][] ={
				{5,1,7,6,0,0,0,3,4},
				{2,8,9,0,0,4,0,0,0},
				{3,4,6,2,0,5,0,9,0},
				{6,0,2,0,0,0,0,1,0},
				{0,3,8,0,0,6,0,4,7},
				{0,0,0,0,0,0,0,0,0},
				{0,9,0,0,0,0,0,7,8},
				{7,0,3,4,0,0,5,6,0},
				{0,0,0,0,0,0,0,0,0}
				};
		
		int hard[][] ={
				{9,0,5,0,0,0,0,0,8},
				{4,0,0,5,7,0,1,0,6},
				{0,2,7,6,0,0,0,4,0},
				{0,9,6,0,0,3,5,1,2},
				{7,0,4,0,1,0,3,0,0},
				{2,1,0,9,8,0,0,0,4},
				{0,8,1,0,0,4,0,9,0},
				{3,0,0,8,0,0,0,5,1},
				{0,0,2,0,0,7,0,6,0}
				};
		
		if(solveIt(sudoku,0,0))
			System.out.println("worked");
		else
			System.out.println("unsolvable");
		
		System.out.println("backtracks : "+backtracks);
		
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++)
				System.out.print(sudoku[i][j]+",");
			System.out.println();
		}
		
		if(solveIt(hard,0,0))
			System.out.println("worked");
		else
			System.out.println("unsolvable");
		
		System.out.println("backtracks : "+backtracks);
		
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++)
				System.out.print(hard[i][j]+",");
			System.out.println();
		
	
	}
	
	

}
}




