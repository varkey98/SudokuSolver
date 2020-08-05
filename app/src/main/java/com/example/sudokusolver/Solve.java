package com.example.sudokusolver;

public class Solve {

    public static boolean flag =false;
    public static void dfs(int k,int[][] arr,int[] r,int[] c,int[] box,int count,char [][] board,int[][] index)
    {
        if(k==count)
            flag=true;
        else
        {
            int i=arr[k][0],j=arr[k][1];
            for(int n=0;n<9;++n)
            {
                int val=1<<n;
                if(((r[i]&val)==0)&&((c[j]&val)==0)&&((box[index[i][j]]&val)==0))
                {
                    r[i]|=val;
                    c[j]|=val;
                    box[index[i][j]]|=val;
                    board[i][j]=(char)('1'+n);
                    dfs(k+1,arr,r,c,box,count,board,index);
                    if(flag)
                        return;
                    r[i]&=~(val);
                    c[j]&=~(val);
                    box[index[i][j]]&=~(val);
                }
            }
        }
    }
    public static void solveSudoku(char[][] board)
    {
        int [][] index=new int[9][9];
        int[] dx= new int[] {0,3,6};
        int count=0;
        for(int r:dx)
            for(int c:dx)
            {
                for(int i=0;i<3;++i)
                    for(int j=0;j<3;++j)
                        index[r+i][c+j]=count;
                ++count;
            }
        int[] r=new int[9];
        int[] c=new int[9];
        int[] box=new int[9];
        int[][] arr=new int[81][0];
        count=0;
        for(int i=0;i<9;++i)
            for(int j=0;j<9;++j)
                if(board[i][j]!='0')
                {
                    int val=1<<(board[i][j]-'1');
                    r[i]=r[i]|val;
                    box[index[i][j]]=box[index[i][j]]|val;
                    c[j]=c[j]|val;
                }
                else
                    arr[count++]=new int[]{i,j};
        dfs(0,arr,r,c,box,count,board,index);

    }
}
