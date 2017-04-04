package com.bnisler.controller;

import com.bnisler.service.CalendarService;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import com.google.calendar.service.GoogleCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/calendar")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @RequestMapping(value = "/events", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<Event> getAllCalendarEvents() throws IOException {
        return calendarService.findAllCalendarEvents();
    }

    @RequestMapping(value = "/calendarListEntries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<CalendarListEntry> getAllCalendarListEntries() throws IOException {
        return calendarService.findAllCalendarListEntries();
    }

}
