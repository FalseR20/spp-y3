package main;

public class Calculator extends Thread {

    private final int N;
    private final int X;
    private final Controller controller;

    public Calculator(int N, int X, Controller controller) {
        this.N = N;
        this.X = X;
        this.controller = controller;
    }

    @Override
    public void run() {
        double dividend = X;
        double divisor = 1;
        double sum = X;
        synchronized (controller) {
            controller.updateResult(sum);
        }

        int i = 1;
        try {
            while (i <= N) {
                dividend *= Math.pow(X, 2);
                divisor += 2;
                sum += dividend / divisor;
                System.out.printf("%d: %f\n", i, sum);
                i++;
                synchronized (controller) {
                    controller.updateResult(sum);
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
