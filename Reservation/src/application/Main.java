import model.entities.Reservation;

void main() throws ParseException {

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.print("Room number: ");
    int number = sc.nextInt();
    System.out.println("Check-in date (dd/MM/yyyy): ");
    Date checkIn = sdf.parse(sc.next());
    System.out.println("Check-out date (dd/MM/yyy): ");
    Date checkOut = sdf.parse(sc.next());

    if (!checkOut.after(checkIn)) {
        System.out.println("Error in reservation: Check-out date must be after check-in date");
    } else {
        Reservation reservation = new Reservation(checkIn,checkOut, number);
        System.out.println("Reservation: " + reservation);

        System.out.println("Enter data to update the reservation: ");
        System.out.println("Check-in date (dd/MM/yyyy): ");
        checkIn = sdf.parse(sc.next());
        System.out.println("Check-out date (dd/MM/yyy): ");
        checkOut = sdf.parse(sc.next());

        Date now = new Date();
        if(checkIn.before(now) || checkOut.before((now))){
            System.out.println("Error in reservation: Reservation dates for updates must be future");
        } else if (!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            reservation.updateDates(checkIn,checkOut);
            System.out.println("Reservation: " + reservation);
        }

    }

}
