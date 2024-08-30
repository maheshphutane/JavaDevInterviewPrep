package org.example.designPatterns.behavioral.ObservarDesignPattern.observers;

public class EmailNotificationObserverImpl implements StockObserver {
    String email;
    public EmailNotificationObserverImpl(String email){
        this.email = email;
    }
    @Override
    public void update() {
        sendEmail(email);
    }
    private void sendEmail(String email) {
        System.out.println("Sending email to "+email);
    }
}
