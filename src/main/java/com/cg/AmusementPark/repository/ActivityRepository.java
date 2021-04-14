package com.cg.AmusementPark.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.AmusementPark.entities.Activity;

@Repository
public interface ActivityRepository extends IActivityRepository, JpaRepository<Activity, Integer> {

	@Query("SELECT a FROM Activity a WHERE a.activityName = ?1")
	public Activity findByActivityName(String activityName);

	@Query("SELECT a FROM Activity a where a.charges = ?1")
	public List<Activity> viewActivitiesOfCharges(float charges);

	@Query("SELECT COUNT(a) FROM Activity a where a.charges = ?1")
	public int countActivitiesOfCharges(float charges);

}
