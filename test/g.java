public class g {
    public static int sum = 0;

    public static void main(String[] args) {
        System.out.println("초기 합계: " + sum);

        Thread producer = new Thread(g::produce);
        Thread consumer = new Thread(g::consume);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("producer, consumer 스레드 실행 이후 합계: " + sum);
    }

    public static synchronized void produce() {
        for (int i = 0; i < 100000; i++) {
            sum++;
        }
    }

    public static synchronized void consume() {
        for (int i = 0; i < 100000; i++) {
            sum--;
        }
    }
}
