package com.cg.AmusementPark.service;

import java.util.List;

import com.cg.AmusementPark.entities.Activity;
import com.cg.AmusementPark.exception.ActivityExistsException;
import com.cg.AmusementPark.exception.ActivityNotFoundException;

public interface IActivityService {

	Activity insertActivity(Activity activity) throws ActivityExistsException;

	Activity updateActivity(Activity activity) throws ActivityNotFoundException;

	Activity deleteActivity(int activityId) throws ActivityNotFoundException;

	List<Activity> viewAllActivities() throws ActivityNotFoundException;

	List<Activity> viewActivitiesOfCharges(float charges) throws ActivityNotFoundException;

	int countActivitiesOfCharges(float charges) throws ActivityNotFoundException;

}
