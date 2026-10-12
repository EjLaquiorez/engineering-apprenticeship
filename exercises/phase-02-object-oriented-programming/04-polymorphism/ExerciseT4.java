public class ExerciseT4 {
    static class Notification {
        public void send() {
            System.out.println("Sending notification.");
        }
    }

    static class EmailNotification extends Notification {
        @Override
        public void send() {
            System.out.println("Sending an email.");
        }
    }

    static class SMSNotification extends Notification {
        @Override
        public void send() {
            System.out.println("Sending an SMS.");
        }
    }

    static class PushNotification extends Notification {
        @Override
        public void send() {
            System.out.println("Sending a push notification.");
        }
    }

    public static void main(String[] args) {
        Notification notification = new EmailNotification();
        notification.send();

        EmailNotification email = new EmailNotification();
        email.send();
    }
}
