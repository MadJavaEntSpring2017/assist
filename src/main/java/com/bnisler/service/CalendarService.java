package com.bnisler.service;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import com.google.calendar.service.GoogleCalendarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CalendarService extends GoogleCalendarService {

    private Calendar calendarService;

    public CalendarService() throws IOException {
        calendarService = getCalendarService();
    }

    public List<Event> findAllCalendarEvents() throws IOException {
        // List the next 10 events from the primary calendar.
        DateTime now = new DateTime(System.currentTimeMillis());
        Events events =
                calendarService.events().list("primary")
                        .setMaxResults(10)
                        .setTimeMin(now)
                        .setOrderBy("startTime")
                        .setSingleEvents(true)
                        .execute();
        return events.getItems();
    }

    public List<CalendarListEntry> findAllCalendarListEntries() throws IOException {
        CalendarList calendarList =
                calendarService.calendarList().list()
                        .execute();
        return calendarList.getItems();
    }
}
