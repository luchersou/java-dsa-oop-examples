package org.example.OOP.Abstraction;

abstract class ProcessTemplate {

    // Template method (cannot be overridden)
    public final void execute() {
        start();
        process();
        finish();
    }

    protected void start() {
        System.out.println("Starting process...");
    }

    protected abstract void process();

    protected void finish() {
        System.out.println("Finishing process.");
    }
}

class PaymentProcess extends ProcessTemplate {
    @Override
    protected void process() {
        System.out.println("Processing payment...");
    }
}

class ShippingProcess extends ProcessTemplate {
    @Override
    protected void process() {
        System.out.println("Processing shipping...");
    }
}

public class Main {
    public static void main(String[] args) {
        ProcessTemplate payment = new PaymentProcess();
        payment.execute();

        ProcessTemplate shipping = new ShippingProcess();
        shipping.execute();
    }
}
