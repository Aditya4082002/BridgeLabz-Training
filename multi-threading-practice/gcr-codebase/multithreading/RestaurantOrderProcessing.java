package multithreading;

class Chef extends Thread {

    private String dish;
    private int preparationTimeMillis;

    public Chef(String name, String dish, int preparationTimeMillis) {
        super(name);
        this.dish = dish;
        this.preparationTimeMillis = preparationTimeMillis;
    }

    @Override
    public void run() {

        System.out.println(getName() + " started preparing " + dish);

        int stepTime = preparationTimeMillis / 4;

        for (int i = 1; i <= 4; i++) {
            try {
                Thread.sleep(stepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int progress = i * 25;
            System.out.println(getName() + " preparing " + dish + ": " 
                    + progress + "% complete");
        }

        System.out.println(getName() + " completed " + dish);
    }
}

public class RestaurantOrderProcessing {

    public static void main(String[] args) throws InterruptedException {

        Chef chef1 = new Chef("Chef-1", "Pizza", 3000);
        Chef chef2 = new Chef("Chef-2", "Pasta", 2000);
        Chef chef3 = new Chef("Chef-3", "Salad", 1000);
        Chef chef4 = new Chef("Chef-4", "Burger", 2500);

        chef1.start();
        chef2.start();
        chef3.start();
        chef4.start();

        // Manager waits for all chefs
        chef1.join();
        chef2.join();
        chef3.join();
        chef4.join();

        System.out.println("Kitchen closed - All orders completed");
    }
}
