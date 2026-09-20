// Abstract Products
interface TransportTicket {
    void useTicket();
}

interface HotelAccommodation {
    void checkIn();
}

// Concrete Products - Family 1 (Traditional Japan)
class ShinkansenPass implements TransportTicket {
    @Override
    public void useTicket() {
        System.out.println("JR Pass activated: Boarded the Shinkansen train.");
    }
}

class TraditionalRyokan implements HotelAccommodation {
    @Override
    public void checkIn() {
        System.out.println("Checked in at Traditional Japanese Ryokan hotel.");
    }
}

// Concrete Products - Family 2 (Modern Tokyo)
class TokyoMetroPass implements TransportTicket {
    @Override
    public void useTicket() {
        System.out.println("Activated 3-day Tokyo Metro Unlimited Pass.");
    }
}

class CapsuleHotel implements HotelAccommodation {
    @Override
    public void checkIn() {
        System.out.println("Checked in at Modern Capsule Hotel in Tokyo.");
    }
}

// Abstract Factory
interface JapanTripFactory {
    TransportTicket createTransportTicket();
    HotelAccommodation createAccommodation();
}

// Concrete Factories
class TraditionalJapanTripFactory implements JapanTripFactory {
    @Override
    public TransportTicket createTransportTicket() {
        return new ShinkansenPass();
    }

    @Override
    public HotelAccommodation createAccommodation() {
        return new TraditionalRyokan();
    }
}

class ModernTokyoTripFactory implements JapanTripFactory {
    @Override
    public TransportTicket createTransportTicket() {
        return new TokyoMetroPass();
    }

    @Override
    public HotelAccommodation createAccommodation() {
        return new CapsuleHotel();
    }
}

// Client Class
class JapanTripClient {
    private final TransportTicket ticket;
    private final HotelAccommodation accommodation;

    // Clean Code: Validated Construction
    public JapanTripClient(JapanTripFactory factory) {
        if (factory == null) {
            throw new IllegalArgumentException("Trip factory cannot be null!");
        }
        this.ticket = factory.createTransportTicket();
        this.accommodation = factory.createAccommodation();
    }

    public void bookAndStartTrip() {
        accommodation.checkIn();
        ticket.useTicket();
    }
}

// Main Execution
public class PartB {
    public static void main(String[] args) {
        System.out.println(" PART B: Abstract Factory Demo ");

        System.out.println("\n  Booking Traditional Japan Trip ");
        JapanTripFactory traditionalFactory = new TraditionalJapanTripFactory();
        JapanTripClient client1 = new JapanTripClient(traditionalFactory);
        client1.bookAndStartTrip();

        System.out.println("\n  Booking Modern Tokyo Trip ");
        JapanTripFactory modernFactory = new ModernTokyoTripFactory();
        JapanTripClient client2 = new JapanTripClient(modernFactory);
        client2.bookAndStartTrip();
    }
}