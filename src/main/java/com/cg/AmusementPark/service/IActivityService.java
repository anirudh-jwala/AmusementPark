package com.cg.AmusementPark.service;

import java.util.List;

import com.cg.AmusementPark.entities.Activity;
import com.cg.AmusementPark.exception.ActivityExistsException;
import com.cg.AmusementPark.exception.ActivityNotFoundException;

public interface IActivityService {

	public Activity insertActivity(Activity activity) throws ActivityExistsException;

	public Activity updateActivity(Activity activity) throws ActivityNotFoundException;

	public Activity deleteActivity(int activityId) throws ActivityNotFoundException;

	public List<Activity> viewActivitiesOfCharges(float charges) throws ActivityNotFoundException;

	public int countActivitiesOfCharges(float charges) throws ActivityNotFoundException;

}
