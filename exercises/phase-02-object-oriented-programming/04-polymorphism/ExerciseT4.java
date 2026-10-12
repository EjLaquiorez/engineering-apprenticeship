public class ExerciseT4 {
    static class Notification {
        public void send() {
            System.out.println("Sending notification.");
        }
    }

    static class EmailNotification extends Notification {

    }

    static class SMSNotification extends Notification {

    }

    static class PushNotification extends Notificatxion {

    }

    public static void main(String[] args) {
        Notification notification = new EmailNotification();
        notification.send();

        EmailNotification email = new EmailNotification();
        email.send();
    }
}
