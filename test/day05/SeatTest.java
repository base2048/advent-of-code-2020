package day05;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SeatTest {

    @Test
    void decodePassCodeToSeatId() {
        assertEquals(357, Seat.decodePassCodeToSeatId("FBFBBFFRLR"));
        assertEquals(567, Seat.decodePassCodeToSeatId("BFFFBBFRRR"));
        assertEquals(119, Seat.decodePassCodeToSeatId("FFFBBBFRRR"));
        assertEquals(820, Seat.decodePassCodeToSeatId("BBFFBBFRLL"));
    }
}
