package com.cg.AmusementPark.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.AmusementPark.entities.Activity;
import com.cg.AmusementPark.exception.ActivityExistsException;
import com.cg.AmusementPark.exception.ActivityNotFoundException;
import com.cg.AmusementPark.exception.InvalidActivityException;
import com.cg.AmusementPark.service.ActivityService;

@RestController
@RequestMapping("/api/activity")
@CrossOrigin("*")
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Inserting an activity to database
	 */
	@PostMapping
	public ResponseEntity<Activity> insertActivity(@Valid @RequestBody Activity activity, BindingResult bindingResult)
			throws ActivityExistsException, InvalidActivityException {

		logger.info("Called POST mapping insertActivity() method");

		if (bindingResult.hasErrors()) {
			throw new InvalidActivityException("Activity detials are not valid");
		}

		return new ResponseEntity<>(activityService.insertActivity(activity), HttpStatus.CREATED);

	}

	/**
	 * Update existing record of activity in database, else throw
	 * ActivityNotFoundException
	 */
	@PutMapping
	public ResponseEntity<Activity> updateActivity(@Valid @RequestBody Activity activity, BindingResult bindingResult)
			throws ActivityNotFoundException, InvalidActivityException {

		logger.info("Called PUT mapping updateActivity() method");

		if (bindingResult.hasErrors()) {
			throw new InvalidActivityException("Activity detials are not valid");
		}

		return new ResponseEntity<>(activityService.updateActivity(activity), HttpStatus.OK);

	}

	/**
	 * Remove an existing activity from database, else throw
	 * ActivityNotFoundException
	 */
	@DeleteMapping(path = "/{activityId}")
	public ResponseEntity<Activity> deleteActivity(@PathVariable("activityId") int activityId)
			throws ActivityNotFoundException {

		logger.info("Called DELETE mapping deleteActivity() method");

		return new ResponseEntity<>(activityService.deleteActivity(activityId), HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<Activity>> viewAllActivities() throws ActivityNotFoundException {
		logger.info("Called GET mapping viewAllActivities() method");

		return new ResponseEntity<>(activityService.viewAllActivities(), HttpStatus.OK);
	}

	/**
	 * Get list of all activities based on the amount provided
	 */
	@GetMapping(path = "/{charges}")
	public ResponseEntity<List<Activity>> viewActivitiesOfCharges(@PathVariable("charges") float charges)
			throws ActivityNotFoundException {

		logger.info("Called GET mapping viewActivitiesOfCharges() method");

		return new ResponseEntity<>(activityService.viewActivitiesOfCharges(charges), HttpStatus.OK);

	}

	/**
	 * Get the total count of activity records available for provided amount
	 */
	@GetMapping(path = "/count/{charges}")
	public ResponseEntity<Integer> countActivitiesOfCharges(@PathVariable("charges") float charges)
			throws ActivityNotFoundException {

		logger.info("Called GET mapping countActivitiesOfCharges() method");

		return new ResponseEntity<>(activityService.countActivitiesOfCharges(charges), HttpStatus.OK);

	}

}
