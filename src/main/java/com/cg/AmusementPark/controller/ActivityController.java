package com.cg.AmusementPark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.AmusementPark.entities.Activity;
import com.cg.AmusementPark.exception.ActivityExistsException;
import com.cg.AmusementPark.exception.ActivityNotFoundException;
import com.cg.AmusementPark.exception.CustomerExistsException;
import com.cg.AmusementPark.exception.CustomerNotFoundException;
import com.cg.AmusementPark.service.ActivityService;

@RestController
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	@PostMapping(path = "/activity")
	public Activity insertActivity(@RequestBody Activity activity) throws ActivityExistsException {
		if(activityService.insertActivity(activity)==null)
		{
			ActivityExistsException activityException = new ActivityExistsException("you are trying to insert is already exists");
			throw activityException; 
		}
		return activityService.insertActivity(activity);
	}

	@PutMapping(path = "/activity")
	public Activity updateActivity(@RequestBody Activity activity) throws ActivityNotFoundException{
		Activity activityToUpdate = activityService.updateActivity(activity);
		if (activityToUpdate == null) {
			ActivityNotFoundException activityException = new ActivityNotFoundException(
					"Activity you are trying to update is not found or invalid");
			throw activityException;
		}
		
		return activityToUpdate;
	}

	@DeleteMapping(path = "/activity/{id}")
	public Activity deleteActivity(@PathVariable("id") int activityId) throws ActivityNotFoundException{
		Activity activityToDelete = activityService.deleteActivity(activityId);
		if (activityToDelete == null) {
			ActivityNotFoundException activityException = new ActivityNotFoundException(
					"Activity you are trying to delete is not found or invalid");
			throw activityException;
		}
		return activityToDelete;
	}

	@GetMapping(path = "/activity/{amount}")
	public List<Activity> viewActivitiesOfCharges(@PathVariable("amount") float charges) throws ActivityNotFoundException{
		
		List<Activity> activities= activityService.viewActivitiesOfCharges(charges);
		if(activities.size()==0){
			throw new ActivityNotFoundException("No Activity Found for this charges");
		}
		return activities;
	}

	@GetMapping(path = "/activity/count/{amount}")
	public int countActivitiesOfCharges(@PathVariable("amount") float charges) throws ActivityNotFoundException {
		
		int activityCount= activityService.countActivitiesOfCharges(charges);
		if(activityCount==0){
			throw new ActivityNotFoundException("No Activity is Found for this charges");
		}
		return activityCount;
	}

}
