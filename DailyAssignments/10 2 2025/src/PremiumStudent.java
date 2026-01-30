public class PremiumStudent extends Student {
    private String subscriptionEndDate;

    public void accessPremiumContent() {
        System.out.printf("Premium Student %s accessed premium content\n", name);
    }

    public void setSubscriptionEndDate(String date) {
        subscriptionEndDate = date;
    }

    public void showSubscriptionEnd() {
        System.out.printf("Subscription ends on: %s\n", subscriptionEndDate);
    }
}
