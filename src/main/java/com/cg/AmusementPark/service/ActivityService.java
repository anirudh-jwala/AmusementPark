package com.cg.AmusementPark.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.AmusementPark.entities.Activity;
import com.cg.AmusementPark.exception.ActivityExistsException;
import com.cg.AmusementPark.exception.ActivityNotFoundException;
import com.cg.AmusementPark.repository.ActivityRepository;

@Service
public class ActivityService implements IActivityService {

	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public Activity insertActivity(Activity activity) throws ActivityExistsException {

		Activity searchedActivity = activityRepository.findByActivityName(activity.getActivityName());

		if (searchedActivity != null && activity.getActivityName().equals(searchedActivity.getActivityName())) {
			throw new ActivityExistsException("Activity you are trying to insert already exists in database");
		}

		return activityRepository.save(activity);

	}

	@Override
	public Activity updateActivity(Activity activity) throws ActivityNotFoundException {

		Optional<Activity> searchedActivity = activityRepository.findById(activity.getActivityId());

		if (!searchedActivity.isPresent()) {
			throw new ActivityNotFoundException("Activity you are trying to update is not found or invalid");
		}

		return activityRepository.save(activity);

	}

	@Override
	public Activity deleteActivity(int activityId) throws ActivityNotFoundException {

		Optional<Activity> searchedActivity = activityRepository.findById(activityId);

		if (!searchedActivity.isPresent()) {
			throw new ActivityNotFoundException("Activity you are trying to delete is not found or invalid");
		}

		activityRepository.delete(searchedActivity.get());
		return searchedActivity.get();

	}

	@Override
	public List<Activity> viewActivitiesOfCharges(float charges) throws ActivityNotFoundException {

		List<Activity> activities = activityRepository.viewActivitiesOfCharges(charges);

		if (activities.size() == 0) {
			ActivityNotFoundException activityException = new ActivityNotFoundException(
					"No Activity Found for this charges");
			throw activityException;
		}

		return activities;

	}

	@Override
	public int countActivitiesOfCharges(float charges) throws ActivityNotFoundException {

		int activityCount = activityRepository.countActivitiesOfCharges(charges);

		if (activityCount == 0) {
			ActivityNotFoundException activityException = new ActivityNotFoundException(
					"No Activity is Found for this charges");
			throw activityException;
		}

		return activityCount;

	}

}
