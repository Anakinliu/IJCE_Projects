package chapter1.se6;

public class Main {
    public static void main(String[] args) {
        DataSourcesLoader dataSourcesLoader = new DataSourcesLoader();
        Thread dataThread = new Thread(dataSourcesLoader, "DataLoader");
        NetworkConnectionsLoader connectionsLoader = new NetworkConnectionsLoader();
        Thread connectionThread = new Thread(connectionsLoader, "ConnectionLoader");
        dataThread.start();


        try {
            // 等待d ataThread 最多1000ms， 超过1000ms，
            // 即使dataThread 没有结束，也继续执行下面的语句
            dataThread.join(1000L);

            connectionThread.start();
            connectionThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main: All loader success.");
    }

}
