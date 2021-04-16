package com.cg.AmusementPark.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
import com.cg.AmusementPark.service.ActivityService;

@RestController
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	@PostMapping(path = "/activity")
	public Activity insertActivity(@Valid @RequestBody Activity activity, BindingResult bindingResult)
			throws ActivityExistsException, Exception {

		if (bindingResult.hasErrors()) {
			throw new Exception("Activity details are not valid");
		}

		return activityService.insertActivity(activity);

	}

	@PutMapping(path = "/activity")
	public Activity updateActivity(@Valid @RequestBody Activity activity, BindingResult bindingResult)
			throws ActivityNotFoundException, Exception {

		if (bindingResult.hasErrors()) {
			throw new Exception("Activity details are not valid");
		}

		return activityService.updateActivity(activity);

	}

	@DeleteMapping(path = "/activity/{id}")
	public Activity deleteActivity(@PathVariable("id") int activityId) throws ActivityNotFoundException {

		return activityService.deleteActivity(activityId);

	}

	@GetMapping(path = "/activity/{amount}")
	public List<Activity> viewActivitiesOfCharges(@PathVariable("amount") float charges)
			throws ActivityNotFoundException {

		return activityService.viewActivitiesOfCharges(charges);

	}

	@GetMapping(path = "/activity/count/{amount}")
	public int countActivitiesOfCharges(@PathVariable("amount") float charges) throws ActivityNotFoundException {

		return activityService.countActivitiesOfCharges(charges);

	}

}
