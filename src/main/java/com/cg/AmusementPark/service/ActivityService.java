package com.cg.AmusementPark.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Activity insertActivity(Activity activity) throws ActivityExistsException {

		logger.info("Called insertActivity() method of ActivityService");

		Activity searchedActivity = activityRepository.findByActivityName(activity.getActivityName());

		if (searchedActivity != null && activity.getActivityName().equals(searchedActivity.getActivityName())) {
			throw new ActivityExistsException("Activity you are trying to insert already exists in database");
		}

		return activityRepository.save(activity);

	}

	@Override
	public Activity updateActivity(Activity activity) throws ActivityNotFoundException {

		logger.info("Called updateActivity() method of ActivityService");

		Optional<Activity> searchedActivity = activityRepository.findById(activity.getActivityId());

		if (!searchedActivity.isPresent()) {
			throw new ActivityNotFoundException("Activity you are trying to update is not found or invalid");
		}

		return activityRepository.save(activity);

	}

	@Override
	public Activity deleteActivity(int activityId) throws ActivityNotFoundException {

		logger.info("Called deleteActivity() method of ActivityService");

		Optional<Activity> searchedActivity = activityRepository.findById(activityId);

		if (!searchedActivity.isPresent()) {
			throw new ActivityNotFoundException("Activity you are trying to delete is not found or invalid");
		}

		activityRepository.delete(searchedActivity.get());
		return searchedActivity.get();

	}

	@Override
	public List<Activity> viewAllActivities() throws ActivityNotFoundException {

		logger.info("Called viewAllActivities() method of ActivityService");

		List<Activity> activities = activityRepository.findAll();

		if (activities.isEmpty()) {
			throw new ActivityNotFoundException("No Activities are found");
		}

		return activities;

	}

	@Override
	public List<Activity> viewActivitiesOfCharges(float charges) throws ActivityNotFoundException {

		logger.info("Called viewActivitiesOfCharges() method of ActivityService");

		List<Activity> activities = activityRepository.viewActivitiesOfCharges(charges);

		if (activities.isEmpty()) {
			throw new ActivityNotFoundException("No Activity Found for this charges");
		}

		return activities;

	}

	@Override
	public int countActivitiesOfCharges(float charges) throws ActivityNotFoundException {

		logger.info("Called countActivitiesOfCharges() method of ActivityService");

		int activityCount = activityRepository.countActivitiesOfCharges(charges);

		if (activityCount == 0) {
			throw new ActivityNotFoundException("No Activity is Found for this charges");
		}

		return activityCount;

	}

	public Activity findActivityById(int activityId) throws ActivityNotFoundException {

		Optional<Activity> foundActivity = activityRepository.findById(activityId);

		if (foundActivity.isPresent())
			return foundActivity.get();
		else
			throw new ActivityNotFoundException("No Activity is Found for provided ID");
	}

}
