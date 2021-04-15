//package com.cg.AmusementPark.repository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.cg.AmusementPark.AmusementParkApplication;
//import com.cg.AmusementPark.entities.Activity;
//
//@EntityScan("com.cg.AmusementPark")
//@EnableJpaRepositories(basePackages = { "com.cg.*" })
//@ContextConfiguration(classes = { AmusementParkApplication.class })
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//public class ActivityRepositoryTest {
//
//	// Auto wire the activity repository
//	@Autowired
//	private ActivityRepository activityRepository;
//
//	// Activity object
//	private Activity activity;
//
//	@BeforeEach
//	private void setup() {
//		// Populate activity object with data
//		activity = new Activity(1, "Swimming", "Enjoy with friends", 500.0f);
//	}
//
//	@AfterEach
//	private void tearDown() {
//
//	}
//
//	// Saving an activity to database
//	@Test
//	public void givenActivityToAddShouldReturnAddedActivity() {
//
//		activityRepository.save(activity);
//
//		Optional<Activity> fetchedActivityOpt = activityRepository.findById(activity.getActivityId());
//		Activity fetchedActivity = fetchedActivityOpt.get();
//
//		assertEquals(1, fetchedActivity.getActivityId());
//
//	}
//
//	// Get all activities from database
//	@Test
//	public void givenGetAllActivityShouldReturnListOfAllActivities() {
//
//		Activity a1 = new Activity(1, "Swimming", "Enjoy with friends", 500.0f);
//		Activity a2 = new Activity(2, "Pirate Ship", "Enjoy with friends", 1000.0f);
//
//		activityRepository.save(a1);
//		activityRepository.save(a2);
//
//		List<Activity> activityList = activityRepository.findAll();
//
//		assertEquals("Pirate Ship", activityList.get(1).getActivityName());
//
//	}
//
//	// Get activity data by ID
//	@Test
//	public void givenIdThenShouldReturnActivityOfThatId() {
//
//		Activity a1 = new Activity(1, "Swimming", "Enjoy with friends", 500.0f);
//		Activity a2 = activityRepository.save(a1);
//
//		Optional<Activity> activityOpt = activityRepository.findById(a1.getActivityId());
//
//		assertEquals(a2.getActivityId(), activityOpt.get().getActivityId());
//		assertEquals(a2.getActivityName(), activityOpt.get().getActivityName());
//
//	}
//
//	// Delete activity by ID
//	@Test
//	public void givenIdToDeleteThenShouldDeleteTheActivity() {
//
//		Activity a1 = new Activity(1, "Swimming", "Enjoy with friends", 500.0f);
//		activityRepository.save(a1);
//
//		activityRepository.deleteById(a1.getActivityId());
//
//		Optional<Activity> optionalActivity = activityRepository.findById(a1.getActivityId());
//
//		assertEquals(Optional.empty(), optionalActivity);
//
//	}
//
//}
