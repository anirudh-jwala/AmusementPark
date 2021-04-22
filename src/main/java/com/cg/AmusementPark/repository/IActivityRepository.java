package com.cg.AmusementPark.repository;

import java.util.List;

import com.cg.AmusementPark.entities.Activity;

public interface IActivityRepository {

    List<Activity> viewActivitiesOfCharges(float charges);

    int countActivitiesOfCharges(float charges);

}
