package Multithreading;

import java.util.concurrent.ThreadLocalRandom;

public class Notify {

    public static void main(String[] args) {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }

    public static class Receiver implements Runnable {
        private final Data load;

        public Receiver(Data load) {
            this.load = load;
        }

        public void run() {
            for (String receivedMessage = load.receive();
                 !"End".equals(receivedMessage);
                 receivedMessage = load.receive()) {

                System.out.println(receivedMessage);

                //Thread.sleep() to mimic heavy server-side processing
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread Interrupted");
                }
            }
        }
    }

    public static class Sender implements Runnable {
        private final Data data;

        public Sender(Data data) {
            this.data = data;
        }

        public void run() {
            String[] packets = {
                    "First packet",
                    "Second packet",
                    "Third packet",
                    "Fourth packet",
                    "End"
            };

            for (String packet : packets) {
                data.send(packet);

                // Thread.sleep() to mimic heavy server-side processing
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread Interrupted");
                }
            }
        }
    }

    public static class Data {
        private String packet;

        // True if receiver should wait
        // False if sender should wait
        private boolean transfer = true;

        public synchronized String receive() {
            while (transfer) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread Interrupted");
                }
            }
            transfer = true;

            String returnPacket = packet;
            notifyAll();
            return returnPacket;
        }

        public synchronized void send(String packet) {
            while (!transfer) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread Interrupted");
                }
            }
            transfer = false;

            this.packet = packet;
            notifyAll();
        }
    }


}
