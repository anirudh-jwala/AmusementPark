package com.cg.AmusementPark.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.AmusementPark.entities.Activity;

/**
 * User defined repository functions for activity repository
 */
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

	/**
	 * Get a single activity based on activity name
	 */
	@Query("SELECT a FROM Activity a WHERE a.activityName = ?1")
	Activity findByActivityName(String activityName);

	/**
	 * Get list of all activities based on the provided charges
	 */
	@Query("SELECT a FROM Activity a where a.charges = ?1")
	List<Activity> viewActivitiesOfCharges(float charges);

	/**
	 * Get count of all activities based on the provided charges
	 */
	@Query("SELECT COUNT(a) FROM Activity a where a.charges = ?1")
	int countActivitiesOfCharges(float charges);

}
