public class TikTak {
    public static volatile boolean isStopped = false;
    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        Thread.sleep(2000);
        isStopped = true;
        System.out.println("Clock has to be stopped");
        Thread.sleep(1000);
        System.out.println("Double-check");
    }
    public static class Clock extends Thread {
        public Clock() {
            setPriority(MAX_PRIORITY);
            start();
        }

        @Override
        public void run() {
            try {
                while (!isStopped){
                    printTikTak();
                }
            }catch (InterruptedException e){

            }
        }

        public void printTikTak() throws InterruptedException {
            System.out.println("Tik");
            Thread.sleep(500);
            System.out.println("Tak");
            Thread.sleep(500);
        }
    }
}
