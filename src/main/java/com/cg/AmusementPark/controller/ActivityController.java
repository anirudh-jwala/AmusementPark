package com.cg.AmusementPark.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
import com.cg.AmusementPark.exception.InvalidActivityException;
import com.cg.AmusementPark.service.ActivityService;

@RestController
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	@PostMapping(path = "/activity")
	public ResponseEntity<Activity> insertActivity(@Valid @RequestBody Activity activity, BindingResult bindingResult)
			throws ActivityExistsException, InvalidActivityException {

		if (bindingResult.hasErrors()) {

			List<FieldError> errors = bindingResult.getFieldErrors();

			for (FieldError error : errors) {
				throw new InvalidActivityException(error.getDefaultMessage());
			}

		}

		return new ResponseEntity<Activity>(activityService.insertActivity(activity), HttpStatus.CREATED);

	}

	@PutMapping(path = "/activity")
	public ResponseEntity<Activity> updateActivity(@Valid @RequestBody Activity activity, BindingResult bindingResult)
			throws ActivityNotFoundException, InvalidActivityException {

		if (bindingResult.hasErrors()) {

			List<FieldError> errors = bindingResult.getFieldErrors();

			for (FieldError error : errors) {
				throw new InvalidActivityException(error.getDefaultMessage());
			}

		}

		return new ResponseEntity<Activity>(activityService.updateActivity(activity), HttpStatus.OK);

	}

	@DeleteMapping(path = "/activity/{id}")
	public ResponseEntity<Activity> deleteActivity(@PathVariable("id") int activityId)
			throws ActivityNotFoundException {

		return new ResponseEntity<Activity>(activityService.deleteActivity(activityId), HttpStatus.OK);

	}

	@GetMapping(path = "/activity/{amount}")
	public ResponseEntity<List<Activity>> viewActivitiesOfCharges(@PathVariable("amount") float charges)
			throws ActivityNotFoundException {

		return new ResponseEntity<List<Activity>>(activityService.viewActivitiesOfCharges(charges), HttpStatus.OK);

	}

	@GetMapping(path = "/activity/count/{amount}")
	public ResponseEntity<?> countActivitiesOfCharges(@PathVariable("amount") float charges)
			throws ActivityNotFoundException {

		return new ResponseEntity<>(activityService.countActivitiesOfCharges(charges), HttpStatus.OK);

	}

}
