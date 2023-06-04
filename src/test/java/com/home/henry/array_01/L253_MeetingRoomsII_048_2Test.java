package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L253_MeetingRoomsII_048_2Test {

    private L253_MeetingRoomsII_048_2 l253MeetingRoomsII0482UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l253MeetingRoomsII0482UnderTest = new L253_MeetingRoomsII_048_2();
    }

    @Test
    void testMinMeetingRooms() {
        assertEquals(2, l253MeetingRoomsII0482UnderTest.minMeetingRooms(
                new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
        assertEquals(1, l253MeetingRoomsII0482UnderTest.minMeetingRooms(new int[][] { { 7, 10 }, { 2, 4 } }));
        assertEquals(1, l253MeetingRoomsII0482UnderTest.minMeetingRooms(
                new int[][] { { 15, 16 }, { 10, 15 }, { 16, 25 } }));
        assertEquals(2, l253MeetingRoomsII0482UnderTest.minMeetingRooms(new int[][] { { 1, 5 }, { 4, 7 } }));
        assertEquals(1, l253MeetingRoomsII0482UnderTest.minMeetingRooms(new int[][] { { 1, 5 }, { 5, 7 } }));
    }
}
