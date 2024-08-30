package org.example.designPatterns.behavioral.ObservarDesignPattern.observers;

public class MobileNotificationObserverImpl implements StockObserver {
    String mobileNo;
    public MobileNotificationObserverImpl(String mobileNo){
        this.mobileNo = mobileNo;
    }
    @Override
    public void update() {
        sendMsg(mobileNo);
    }

    private void sendMsg(String mobileNo) {
        System.out.println("Sending message to "+mobileNo);
    }
}
