package com.cg.AmusementPark.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.AmusementPark.entities.Activity;
import com.cg.AmusementPark.repository.ActivityRepository;

@Service
public class ActivityService implements IActivityService {

	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public Activity insertActivity(Activity activity) {

		Activity searchedActivity = activityRepository.findByActivityName(activity.getActivityName());

		if (searchedActivity != null && activity.getActivityName().equals(searchedActivity.getActivityName())) {
			return null;
		}

		return activityRepository.save(activity);

	}

	@Override
	public Activity updateActivity(Activity activity) {

		Optional<Activity> searchedActivity = activityRepository.findById(activity.getActivityId());

		if (searchedActivity.isPresent()) {
			return activityRepository.save(activity);
		}

		return null;

	}

	@Override
	public Activity deleteActivity(int activityId) {

		Optional<Activity> searchedActivity = activityRepository.findById(activityId);

		if (searchedActivity.isPresent()) {
			activityRepository.delete(searchedActivity.get());
			return searchedActivity.get();
		}

		return null;

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
