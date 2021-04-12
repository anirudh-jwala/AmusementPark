package com.cg.AmusementPark.service;

import java.util.List;

import com.cg.AmusementPark.entities.Activity;

public interface IActivityService {

	public Activity insertActivity(Activity activity);

	public Activity updateActivity(Activity activity);

	public Activity deleteActivity(int activityId);

	public List<Activity> viewActivitiesOfCharges(float charges);

	public int countActivitiesOfCharges(float charges);

}
