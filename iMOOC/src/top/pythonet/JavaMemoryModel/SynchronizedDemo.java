package top.pythonet.JavaMemoryModel;

/*
    AUTHOR: linux
    TIME: 2018/5/11
    GOOD LUCK AND NO BUG.
*/
public class SynchronizedDemo {
    //�������
    private boolean ready = false;
    //�������
    private int result = 0;
    //�������
    private int number = 1;

    /*
     TODO 1.X��2.X, 1.1��1.2, 2.1��2.2֮�䶼�п��ܻᷢ��ָ��������!!!
     TODO �����������ս��resultֵ�Ĳ�ȷ����!
     TODO ��Ȼ������synchronizedҲ���пɼ���, �����޷��ٷ�֮�ٱ�֤!
     0��6�Ľ����Ҳ�����Ƕ��̺߳�д�߳�start��˭�ȱ�cpu��������ġ�
     ����ֻ��synchronized���ܿ���0��6�Ľ������Ҫ�����߳�ͬ����֪ʶ�������
     ��sleep�Ǹ��������߳������ķ�ʽ����Σ�ա��Ǹ�sleep��ȫ�Ǿ���ֵ��
     ���д�̱߳���������ִ��ʱ����ʱ����sleepʱ�����ʱ������������ֻ����ˡ�
      */
    //д����
    public synchronized void write(){
        ready = true;	      				 //1.1
        number = 2;		                    //1.2
    }
    //������
    public synchronized void read(){
        if(ready){						     //2.1
            result = number*3;	 	//2.2
        }
        System.out.println("resultֵΪ: " + result);
    }

    //�ڲ��߳���
    private class ReadWriteThread extends Thread {
        //flag����ȷ����д���Ƕ�
        private boolean flag;
        public ReadWriteThread(boolean flag){
            this.flag = flag;
        }
        @Override
        public void run() {
            if(flag){
                //?
                write();
            }else{
                //
                read();
            }
        }
    }

    // TODO ִ�м��κ�, �ػᷢ��result��ֵ��0��6���߼�Ʈ������!!
    /*
    ��Ϊ�̵߳�ִ�б�����ǲ�ȷ���ģ�����synchronized�ؼ���ֻ��
    ȷ�����������δ����Լ������Ŀɼ��ԣ�
    ��ĳ�߳����޸Ĺ��������ͨ���Լ��Ĺ����ڴ����޸ģ�ʱ��
    �����������߳��޷���ù����������Ϣ��
    ����synchronized�����ܱ�֤�����ִ��˳��
    ���Լ�ʹ����synchronizedҲ���ܻ����0��˳��������ģ���jVM�ڴ��Լ�CUP�ĵ����ˡ�
     */
    public static void main(String[] args)  {
        SynchronizedDemo synDemo = new SynchronizedDemo();
        //ʵ�����ڲ��߳���, ע���ڲ����ʵ����
        // ִ��write
        synDemo.new ReadWriteThread(true).start();  //trueִ��write

        // TODO ����Ϊ�����߱�֤�������ȡ
        // �������߳��Ա�������write()�߳�, ʹ�ù���������Ը��µ����ڴ�
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //ִ��read, �����ڴ��ȡ��������������ڴ�
        synDemo.new ReadWriteThread(false).start();

    }
}