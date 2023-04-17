package Multithreading;

import javax.swing.plaf.TableHeaderUI;

public class StringPool {

    public static void main(String[] args) throws InterruptedException {
        SharedProps sharedProps = new SharedProps("Sayu");

        new Thread(() -> {
            try {
                sharedProps.fOne();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            sharedProps.setField("New Sayu");
            try {
                sharedProps.fOne();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


    }

    static class SharedProps {
        String field;

        public void setField(String field) {
            this.field = field;
        }

        public SharedProps(String field) {
            this.field = field;
        }

        private void fOne() throws InterruptedException {
            synchronized (this.field) { // Can Change to Sunil as well.
                System.out.println("Inside Sync");
                System.out.println(field);
                Thread.sleep(10000);
            }
        }
    }

}
