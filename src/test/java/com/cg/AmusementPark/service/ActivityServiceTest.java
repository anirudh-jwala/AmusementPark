package com.cg.AmusementPark.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.AmusementPark.entities.Activity;
import com.cg.AmusementPark.exception.ActivityExistsException;
import com.cg.AmusementPark.exception.ActivityNotFoundException;
import com.cg.AmusementPark.repository.ActivityRepository;

@ExtendWith(MockitoExtension.class)
class ActivityServiceTest {

    @Mock
    private ActivityRepository activityRepository;

    @InjectMocks
    private ActivityService activityService;

    @Test
    void shouldReturnActivityNamesForCharges() throws ActivityNotFoundException {

        List<Activity> mockActivities = new ArrayList<>();
        mockActivities.add(new Activity(1, "Swimming", "Best for summer", 500.0f));
        mockActivities.add(new Activity(2, "Gaint Wheel", "Enjoy with family", 350.0f));
        mockActivities.add(new Activity(3, "Kids train", "Exclusive for kids", 350.0f));

        Mockito.when(activityRepository.viewActivitiesOfCharges(500.0f)).thenReturn(mockActivities.subList(0, 1));
        List<Activity> realActivities1 = activityService.viewActivitiesOfCharges(500.0f);
        assertEquals("Swimming", realActivities1.get(0).getActivityName());

        Mockito.when(activityRepository.viewActivitiesOfCharges(350.0f)).thenReturn(mockActivities.subList(1, 3));
        List<Activity> realActivities2 = activityService.viewActivitiesOfCharges(350.0f);
        assertEquals("Kids train", realActivities2.get(1).getActivityName());

    }

    @Test
    void shouldReturnActivityCountForCharges() throws ActivityNotFoundException {

        List<Activity> mockActivities = new ArrayList<>();
        mockActivities.add(new Activity(1, "Swimming", "Best for summer", 500.0f));
        mockActivities.add(new Activity(2, "Gaint Wheel", "Enjoy with family", 350.0f));
        mockActivities.add(new Activity(3, "Kids train", "Exclusive for kids", 350.0f));

        Mockito.when(activityRepository.countActivitiesOfCharges(350.0f)).thenReturn(2);

        int realActivityCount = activityService.countActivitiesOfCharges(350.0f);
        assertEquals(2, realActivityCount);

    }

    @Test
    void shouldAddActivity() throws ActivityExistsException {

        Activity mockActivityToAdd = new Activity(1, "Swimming", "Best for summer", 500.0f);

        Mockito.when(activityRepository.save(mockActivityToAdd)).thenReturn(mockActivityToAdd);

        Activity realActivityAdded = activityService
                .insertActivity(new Activity(1, "Swimming", "Best for summer", 500.0f));

        assertEquals("Best for summer", realActivityAdded.getDescription());
        assertEquals("Swimming", realActivityAdded.getActivityName());

    }

    @Test
    void shouldUpdateActivity() throws ActivityNotFoundException, ActivityExistsException {

        Activity mockActivityToUpdate = new Activity(1, "Swimming", "Best for summer", 500.0f);
        mockActivityToUpdate.setActivityName("Swimming Championship");

        Mockito.when(activityRepository.save(mockActivityToUpdate)).thenReturn(mockActivityToUpdate);
        Mockito.when(activityRepository.findById(1)).thenReturn(Optional.of(mockActivityToUpdate));

        activityService.insertActivity(new Activity(1, "Swimming", "Best for summer", 500.0f));
        Activity activityUpdated = activityService.findActivityById(1);
        activityUpdated.setActivityName("Swimming Championship");

        assertEquals("Swimming Championship", activityUpdated.getActivityName());

    }

}
