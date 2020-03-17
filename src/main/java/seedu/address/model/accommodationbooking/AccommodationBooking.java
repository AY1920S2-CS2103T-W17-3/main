package seedu.address.model.accommodationbooking;

import static seedu.address.commons.util.AppUtil.checkArgument;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

/**
 * Represents an AccommodationBooking in the AccommodationBookingManager.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class AccommodationBooking {

    public static final String MESSAGE_DAY_CONSTRAINTS = "Start day must come before end day.";

    // Identity fields
    private final Name name;

    // Data fields
    private final Day startDay;
    private final Day endDay;
    private final Location location;
    private final Remark remark;


    /**
     * Every field must be present and not null.
     */
    public AccommodationBooking(Name name, Location location, Day startDay, Day endDay, Remark remark) {

        requireAllNonNull(name, location, startDay, endDay, remark);
        checkArgument(isDayValid(startDay, endDay), MESSAGE_DAY_CONSTRAINTS);

        this.name = name;
        this.location = location;
        this.startDay = startDay;
        this.endDay = endDay;
        this.remark = remark;
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public Day getStartDay() {
        return startDay;
    }

    public Day getEndDay() {
        return endDay;
    }

    public Remark getRemark() {
        return remark;
    }

    /**
     * Returns true if the specified start day is before the specified end day.
     */
    public boolean isDayValid(Day startDay, Day endDay) {
        return !(Integer.parseInt(String.valueOf(endDay)) - Integer.parseInt(String.valueOf(startDay)) < 0);
    }

    /**
     * Returns true if both accommodation bookings have the same identity and data fields.
     * This defines an equality between two accommodations.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof AccommodationBooking)) {
            return false;
        }

        AccommodationBooking otherAccommodation = (AccommodationBooking) other;
        return otherAccommodation.getName().equals(getName())
                && otherAccommodation.getLocation().equals(getLocation())
                && otherAccommodation.getStartDay().equals(getStartDay())
                && otherAccommodation.getEndDay().equals(getEndDay())
                && otherAccommodation.getRemark().equals(getRemark());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, location, startDay, endDay, remark);
    }

    @Override
    public String toString() {
        return "Accommodation Booking - Name: " + getName()
                + " Location: " + getLocation()
                + " Start Day: " + getStartDay()
                + " End Day: " + getEndDay()
                + " Remark: " + getRemark();
    }

}