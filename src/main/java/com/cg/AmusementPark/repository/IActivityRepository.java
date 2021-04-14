package com.cg.AmusementPark.repository;

import java.util.List;

import com.cg.AmusementPark.entities.Activity;

public interface IActivityRepository {

	public int countActivitiesOfCharges(float charges);

	public List<Activity> viewActivitiesOfCharges(float charges);

}
