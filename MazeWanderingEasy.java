public class MazeWanderingEasy {
	int flg[][] = new int[51][51];
	int tmp[][] = new int[51][51];
	Boolean f=false;
	int cnt=0;
	int lim=0;
	
	public int decisions(String[] maze) {
		int map[][] = new int[maze.length][maze[0].length()];
		int x=0, y=0, gx=0, gy=0;
		int ans=0;
		
		for(int i=0; i<51; i++){
			for(int j=0; j<51; j++){
				flg[i][j]=0;
			}
		}

		
		for(int i=0; i<maze.length; i++){
			for(int j=0; j<maze[0].length(); j++){
				
				if(maze[i].charAt(j)=='.'){
					map[i][j]=0;
				}
				
				if(maze[i].charAt(j)=='X'){
					map[i][j]=1;
				}
				
				if(maze[i].charAt(j)=='*'){
					map[i][j]=2;
					gx=j;
					gy=i;
				}
				
				if(maze[i].charAt(j)=='M'){
					map[i][j]=3;
					x=j;
					y=i;
				}
			}
		}
		
		flg[y][x]=1;
		tmp[y][x]=1;
		ans=count(map, x, y, gx, gy, ans);
		return cnt;

	}
	
	private int count(int[][] map, int x, int y, int gx, int gy, int ans){

		if(x==gx&&y==gy){
			cnt=ans;
			return ans;
		}
		
		ans+=isP(map,  x,  y);
		
		if(x+1<map[0].length&&flg[y][x+1]==0&&map[y][x+1]!=1){
			flg[y][x+1]=1;
			count(map, x+1, y, gx, gy, ans);
		}
		
		if(x-1!=-1&&flg[y][x-1]==0&&map[y][x-1]!=1){
			flg[y][x-1]=1;

			count(map, x-1, y, gx, gy, ans);
		}

		if(y+1<map.length&&flg[y+1][x]==0&&map[y+1][x]!=1){
			
			flg[y+1][x]=1;
			count(map, x, y+1, gx, gy, ans);
		}

		if(y-1!=-1&&flg[y-1][x]==0&&map[y-1][x]!=1){
			flg[y-1][x]=1;
			count(map, x, y-1, gx, gy, ans);
		}
		
		return 0;
	}
	
	private int isP(int[][] map, int x, int y){
		int c=0;
		
		if(x+1<map[0].length&&tmp[y][x+1]==0&&map[y][x+1]!=1){
			tmp[y][x+1]=1;
			c++;
		}
		
		if(x-1!=-1&&tmp[y][x-1]==0&&map[y][x-1]!=1){
			tmp[y][x-1]=1;
			c++;
		}

		if(y+1<map.length&&tmp[y+1][x]==0&&map[y+1][x]!=1){
			tmp[y+1][x]=1;
			c++;
		}

		if(y-1!=-1&&tmp[y-1][x]==0&&map[y-1][x]!=1){
			tmp[y-1][x]=1;
			c++;
		}
		
		return c>1? 1:0;
	}
}
