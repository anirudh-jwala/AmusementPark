package com.cg.AmusementPark.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.AmusementPark.entities.Activity;
import com.cg.AmusementPark.entities.Customer;
import com.cg.AmusementPark.repository.ActivityRepository;

@Service
public class ActivityService implements IActivityService {

	@Autowired
	private ActivityRepository activityRepository;

	/**
	 * TODO: Exception handling of AcitivityExistException
	 */
	@Override
	public Activity insertActivity(Activity activity) {
		
		Optional<Activity> searchedActivity = activityRepository.findById(activity.getActivityId());
		
		if (searchedActivity.isPresent()) {
			return null;
		}
		return activityRepository.save(activity);
	}

	/**
	 * TODO: Exception handling of AcitivityDoesNotExist
	 */
	@Override
	public Activity updateActivity(Activity activity) {

		Optional<Activity> searchedActivity = activityRepository.findById(activity.getActivityId());

		if (searchedActivity.isPresent()) {
			return activityRepository.save(activity);
		} else {
			return null;
		}

	}

	/**
	 * TODO: Exception handling of AcitivityDoesNotExist
	 */
	@Override
	public Activity deleteActivity(int activityId) {

		Optional<Activity> searchedActivity = activityRepository.findById(activityId);

		if (searchedActivity.isPresent()) {
			activityRepository.delete(searchedActivity.get());
			return searchedActivity.get();
		} else {
			return null;
		}

	}

	@Override
	public List<Activity> viewActivitiesOfCharges(float charges) {
		return activityRepository.viewActivitiesOfCharges(charges);
	}

	@Override
	public int countActivitiesOfCharges(float charges) {
		return activityRepository.countActivitiesOfCharges(charges);
	}

}
