// Product Interface
interface JapanTourTransport {
    void startTour();
}

// Concrete Products
class ShinkansenTrain implements JapanTourTransport {
    @Override
    public void startTour() {
        System.out.println("Intercity tour started with Shinkansen Bullet Train.");
    }
}

class KyotoTourBus implements JapanTourTransport {
    @Override
    public void startTour() {
        System.out.println("City sight-seeing tour started with Kyoto Tour Bus.");
    }
}

// Creator
abstract class TourLogistics {
    // Factory Method
    public abstract JapanTourTransport createTransport();

    public void executeTour() {
        JapanTourTransport transport = createTransport();
        transport.startTour();
    }
}

// Concrete Creators
class RailTourLogistics extends TourLogistics {
    @Override
    public JapanTourTransport createTransport() {
        return new ShinkansenTrain();
    }
}

class BusTourLogistics extends TourLogistics {
    @Override
    public JapanTourTransport createTransport() {
        return new KyotoTourBus();
    }
}

// Main Execution
public class PartA {
    public static void main(String[] args) {
        System.out.println(" PART A: Factory Method Demo ");

        TourLogistics railTour = new RailTourLogistics();
        railTour.executeTour();

        TourLogistics busTour = new BusTourLogistics();
        busTour.executeTour();
    }
}