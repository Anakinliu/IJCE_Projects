
class m {//-----------�������ף�������
    int rindex;
    int cindex;
    int value;
    boolean is = false;//-------------�����������Ϊtrue
    m(int r, int c, int val) {
        rindex = r;
        cindex = c;
        value = val;
    }
    m lu; //----����
    m u;  //----����
    m ru; //----����
    m r;  //----����
    m l;  //----����
    m ld; //----����
    m d;  //----����
    m rd; //----����
}

//class realM extends m {
//    public realM(int r, int c, int val) {
//        super(r, c, val);
//    }
//    boolean is = true;
//}
public class BuLei {//����

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
        //--------------------------------------------��������
        if (mines <= 0 || mines >= row * col * 0.75) {
            System.out.println("������Ч��");
            return;
        }

        if (row < 2 || col < 2) {
            System.out.println("�У��У���̫�١�");
            return;
        }
        //-----------------

        mine = new m[row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                mine[i][j] = new m(i,j,0);
            }
        }//----��ʼ��

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (i<=0) {
                    if (j==0) {
                        mine[i][j].lu = null;
                        mine[i][j].u = null;
                        mine[i][j].ru = null;
                        mine[i][j].l = null;
                        mine[i][j].ld = null;
                        mine[i][j].d = mine[i+1][j];//��
                        mine[i][j].rd = mine[i+1][j+1];//����
                        mine[i][j].r = mine[i][j+1];//��
                    }
                    else if (j>0&&j<col - 1) {
                        mine[i][j].lu = null;
                        mine[i][j].u = null;
                        mine[i][j].ru = null;
                        mine[i][j].l = mine[i][j-1].r;//��
                        mine[i][j].ld = mine[i+1][j-1];//����
                        mine[i][j].d = mine[i+1][j];//��
                        mine[i][j].rd = mine[i+1][j+1];//����
                        mine[i][j].r = mine[i][j+1];//��
                    }
                    else if (j == col - 1) {
                        mine[i][j].lu = null;
                        mine[i][j].u = null;
                        mine[i][j].ru = null;
                        mine[i][j].r = null;
                        mine[i][j].rd = null;
                        mine[i][j].l = mine[i][j-1].r;//��
                        mine[i][j].ld = mine[i+1][j-1];//����
                        mine[i][j].d = mine[i+1][j];//��
                    }
                }
                else if (i>0 &&i<row-1 && j==0) {//------------------
                    mine[i][j].ru = mine[i-1][j+1];//����
                    mine[i][j].u = mine[i-1][j];//��
                    mine[i][j].lu = null;//����
                    mine[i][j].l = null;//��
                    mine[i][j].ld = null;//����
                    mine[i][j].d = mine[i+1][j];//��
                    mine[i][j].rd = mine[i+1][j+1];//����
                    mine[i][j].r = mine[i][j+1];//��
                }
                else if (i>0 &&i<row-1 && j==col-1) {//-------------
                    mine[i][j].ru = null;//����
                    mine[i][j].u = mine[i-1][j];//��
                    mine[i][j].lu = mine[i-1][j-1];//����
                    mine[i][j].l = mine[i][j-1].r;//��
                    mine[i][j].ld = mine[i+1][j-1];//����
                    mine[i][j].d = mine[i+1][j];//��
                    mine[i][j].rd = null;//����
                    mine[i][j].r = null;//��
                }
                else if (i<row-1 && j<col-1 && j>0) {//-------------
                    mine[i][j].ru = mine[i-1][j+1];//����
                    mine[i][j].u = mine[i-1][j];//��
                    mine[i][j].lu = mine[i-1][j-1];//����
                    mine[i][j].l = mine[i][j-1].r;//��
                    mine[i][j].ld = mine[i+1][j-1];//����
                    mine[i][j].d = mine[i+1][j];//��
                    mine[i][j].rd = mine[i+1][j+1];//����
                    mine[i][j].r = mine[i][j+1];//��
                }
                else if (i==row - 1) {
                    if (j==0) {
                        mine[i][j].ru = mine[i-1][j+1];//����
                        mine[i][j].u = mine[i-1][j];//��
                        mine[i][j].lu = null;//����
                        mine[i][j].l = null;//��
                        mine[i][j].ld = null;//����
                        mine[i][j].d = null;//��
                        mine[i][j].rd = null;//����
                        mine[i][j].r = mine[i][j+1];//��
                    }
                    else if (j>0&&j<col - 1) {
                        mine[i][j].ru = mine[i-1][j+1];//����
                        mine[i][j].u = mine[i-1][j];//��
                        mine[i][j].lu = mine[i-1][j-1];//����
                        mine[i][j].l = mine[i][j-1].r;//��
                        mine[i][j].ld = null;//����
                        mine[i][j].d = null;//��
                        mine[i][j].rd = null;//����
                        mine[i][j].r = mine[i][j+1];//��
                    }
                    else if (j == col - 1) {
                        mine[i][j].ru = null;//����
                        mine[i][j].u = mine[i-1][j];//��
                        mine[i][j].lu = mine[i-1][j-1];//����
                        mine[i][j].l = mine[i][j-1].r;//��
                        mine[i][j].ld = null;//����
                        mine[i][j].d = null;//��
                        mine[i][j].rd = null;//����
                        mine[i][j].r = null;//��
                    }
                }
            }
        }
    }
    //-----------------------------------------
    public  void setMine() {
        //----------------�����ף�����
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
//                //���Ͻ�
//                if (i - 1 >= 0 && j - 1 >=0 && mine[i][j] != -1) {
//                    mine[i - 1][j - 1] ++;
//                }
//
//                //����
//                if (i - 1 >= 0&& mine[i - 1][j] != -1) {
//                    mine[i - 1][j] ++;
//                }
//
//                //����
//                if (i - 1>= 0&&j + 1 < mine[i].length&&mine[i-1][j+1] != -1) {
//                    mine[i-1][j+1]++;
//                }
//
//                //����
//                if (j - 1 >=0 && mine[i][j-1] != -1) {
//                    mine[i][j-1] ++;
//                }
//
//                //����
//                if (j + 1 < mine[i].length && mine[i][j+1] != -1) {
//                    mine[i][j+1] ++;
//                }
//
//                //���½�
//                if (i + 1 < mine.length && j - 1 >=0 && mine[i+1][j-1] != -1) {
//                    mine[i+1][j-1] ++;
//                }
//
//                //����
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
