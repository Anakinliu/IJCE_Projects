
class m {//-----------可能是雷！！！！
    int rindex;
    int cindex;
    int value;
    boolean is = false;//-------------如果是雷则设为true
    m(int r, int c, int val) {
        rindex = r;
        cindex = c;
        value = val;
    }
    m lu; //----左上
    m u;  //----正上
    m ru; //----右上
    m r;  //----正右
    m l;  //----正左
    m ld; //----左下
    m d;  //----正下
    m rd; //----右下
}

//class realM extends m {
//    public realM(int r, int c, int val) {
//        super(r, c, val);
//    }
//    boolean is = true;
//}
public class BuLei {//布雷

    //   static int[][] mine;
    int row;
    int col;
    int mines;
    m[][] mine;
    //---------------------------------------------
    BuLei (int r, int c, int ms) {
        row = r;
        col = c;
        mines = ms;
    }
    //-----------------------------------------
    public void setNet() {
        //--------------------------------------------建立网格
        if (mines <= 0 || mines >= row * col * 0.75) {
            System.out.println("雷数无效。");
            return;
        }

        if (row < 2 || col < 2) {
            System.out.println("行（列）数太少。");
            return;
        }
        //-----------------

        mine = new m[row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                mine[i][j] = new m(i,j,0);
            }
        }//----初始化

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (i<=0) {
                    if (j==0) {
                        mine[i][j].lu = null;
                        mine[i][j].u = null;
                        mine[i][j].ru = null;
                        mine[i][j].l = null;
                        mine[i][j].ld = null;
                        mine[i][j].d = mine[i+1][j];//下
                        mine[i][j].rd = mine[i+1][j+1];//右下
                        mine[i][j].r = mine[i][j+1];//右
                    }
                    else if (j>0&&j<col - 1) {
                        mine[i][j].lu = null;
                        mine[i][j].u = null;
                        mine[i][j].ru = null;
                        mine[i][j].l = mine[i][j-1].r;//左
                        mine[i][j].ld = mine[i+1][j-1];//左下
                        mine[i][j].d = mine[i+1][j];//下
                        mine[i][j].rd = mine[i+1][j+1];//右下
                        mine[i][j].r = mine[i][j+1];//右
                    }
                    else if (j == col - 1) {
                        mine[i][j].lu = null;
                        mine[i][j].u = null;
                        mine[i][j].ru = null;
                        mine[i][j].r = null;
                        mine[i][j].rd = null;
                        mine[i][j].l = mine[i][j-1].r;//左
                        mine[i][j].ld = mine[i+1][j-1];//左下
                        mine[i][j].d = mine[i+1][j];//下
                    }
                }
                else if (i>0 &&i<row-1 && j==0) {//------------------
                    mine[i][j].ru = mine[i-1][j+1];//右上
                    mine[i][j].u = mine[i-1][j];//上
                    mine[i][j].lu = null;//左上
                    mine[i][j].l = null;//左
                    mine[i][j].ld = null;//左下
                    mine[i][j].d = mine[i+1][j];//下
                    mine[i][j].rd = mine[i+1][j+1];//右下
                    mine[i][j].r = mine[i][j+1];//右
                }
                else if (i>0 &&i<row-1 && j==col-1) {//-------------
                    mine[i][j].ru = null;//右上
                    mine[i][j].u = mine[i-1][j];//上
                    mine[i][j].lu = mine[i-1][j-1];//左上
                    mine[i][j].l = mine[i][j-1].r;//左
                    mine[i][j].ld = mine[i+1][j-1];//左下
                    mine[i][j].d = mine[i+1][j];//下
                    mine[i][j].rd = null;//右下
                    mine[i][j].r = null;//右
                }
                else if (i<row-1 && j<col-1 && j>0) {//-------------
                    mine[i][j].ru = mine[i-1][j+1];//右上
                    mine[i][j].u = mine[i-1][j];//上
                    mine[i][j].lu = mine[i-1][j-1];//左上
                    mine[i][j].l = mine[i][j-1].r;//左
                    mine[i][j].ld = mine[i+1][j-1];//左下
                    mine[i][j].d = mine[i+1][j];//下
                    mine[i][j].rd = mine[i+1][j+1];//右下
                    mine[i][j].r = mine[i][j+1];//右
                }
                else if (i==row - 1) {
                    if (j==0) {
                        mine[i][j].ru = mine[i-1][j+1];//右上
                        mine[i][j].u = mine[i-1][j];//上
                        mine[i][j].lu = null;//左上
                        mine[i][j].l = null;//左
                        mine[i][j].ld = null;//左下
                        mine[i][j].d = null;//下
                        mine[i][j].rd = null;//右下
                        mine[i][j].r = mine[i][j+1];//右
                    }
                    else if (j>0&&j<col - 1) {
                        mine[i][j].ru = mine[i-1][j+1];//右上
                        mine[i][j].u = mine[i-1][j];//上
                        mine[i][j].lu = mine[i-1][j-1];//左上
                        mine[i][j].l = mine[i][j-1].r;//左
                        mine[i][j].ld = null;//左下
                        mine[i][j].d = null;//下
                        mine[i][j].rd = null;//右下
                        mine[i][j].r = mine[i][j+1];//右
                    }
                    else if (j == col - 1) {
                        mine[i][j].ru = null;//右上
                        mine[i][j].u = mine[i-1][j];//上
                        mine[i][j].lu = mine[i-1][j-1];//左上
                        mine[i][j].l = mine[i][j-1].r;//左
                        mine[i][j].ld = null;//左下
                        mine[i][j].d = null;//下
                        mine[i][j].rd = null;//右下
                        mine[i][j].r = null;//右
                    }
                }
            }
        }
    }
    //-----------------------------------------
    public  void setMine() {
        //----------------放置雷！！！
        setNet();

        int currentMines = 0;

        while (currentMines < mines) {
            int r = (int)(Math.random() * row);
            int c = (int)(Math.random() * col);
            if (mine[r][c].value != -1) {
                mine[r][c].value = -1;
                mine[r][c].is = true;
                currentMines++;
            }
        }
    }
    //------------------------------------------
    public  void print() {
        for (int i=0; i < row; i++) {
            for (int j=0; j < col; j++) {
                System.out.print(mine[i][j].value + "\t");
            }
            System.out.println();
        }
    }
    //--------------------------------------------
    public void countsAroundMines() {
        for (int i = 0; i < row; i++) {
            for (int j=0; j < col; j++) {
                if (mine[i][j].value != -1) {
                    if (mine[i][j].ru!=null && mine[i][j].is) {
                        mine[i][j].value ++;
                    }
                    if (mine[i][j].u != null && mine[i][j].is) {
                        mine[i][j].value ++;
                    }
                    if (mine[i][j].lu != null && mine[i][j].is) {
                        mine[i][j].value ++;
                    }
                    if (mine[i][j].l != null && mine[i][j].l.is){
                        mine[i][j].value ++;
                    }
                    if (mine[i][j].r != null && mine[i][j].r.is) {
                        mine[i][j].value ++;
                    }
                    if (mine[i][j].ld != null && mine[i][j].ld.is){
                        mine[i][j].value ++;
                    }
                    if (mine[i][j].d != null && mine[i][j].d.is){
                        mine[i][j].value ++;
                    }
                    if (mine[i][j].rd != null && mine[i][j].rd.is){
                        mine[i][j].value ++;
                    }
                }


            }
        }

    }
//-----------------------------------------------
//    public void counts() {
//        for (int i = 0; i < row; i++) {
//            for (int j=0; j < col; j++) {
//                if (mine[i][j].value == -1) {
//                    if (mine[i][j].ru != null) {
//
//                    }
//                }
//
//
//                //int number;
//
//                //左上角
//                if (i - 1 >= 0 && j - 1 >=0 && mine[i][j] != -1) {
//                    mine[i - 1][j - 1] ++;
//                }
//
//                //正上
//                if (i - 1 >= 0&& mine[i - 1][j] != -1) {
//                    mine[i - 1][j] ++;
//                }
//
//                //右上
//                if (i - 1>= 0&&j + 1 < mine[i].length&&mine[i-1][j+1] != -1) {
//                    mine[i-1][j+1]++;
//                }
//
//                //正左
//                if (j - 1 >=0 && mine[i][j-1] != -1) {
//                    mine[i][j-1] ++;
//                }
//
//                //正右
//                if (j + 1 < mine[i].length && mine[i][j+1] != -1) {
//                    mine[i][j+1] ++;
//                }
//
//                //左下角
//                if (i + 1 < mine.length && j - 1 >=0 && mine[i+1][j-1] != -1) {
//                    mine[i+1][j-1] ++;
//                }
//
//                //正下
//                if (i +1 < mine.length && mine[i+1][j] != -1) {
//                    mine[i+1][j] ++;
//                }
//
//                if (i + 1 < mine.length && j+1 <mine.length && mine[i+1][j+1] != -1) {
//                    mine[i+1][j+1] ++;
//                }
//            }
//        }
//    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BuLei bl = new BuLei(10,10,10);
        bl.setMine();
        bl.countsAroundMines();
        bl.print();

    }

}
