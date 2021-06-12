package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule207 {

	private String name = "207. Course Schedule";
	private String url = "https://leetcode.com/problems/course-schedule/";
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		Set<Integer> qualifiedCourses = new HashSet<>();
		Map<Integer, Set<Integer>> requiredCourses = new HashMap<>();
		for(int[] require : prerequisites) {
			if(!requiredCourses.containsKey(require[0])) {
				requiredCourses.put(require[0], new HashSet<>());
			}
			requiredCourses.get(require[0]).add(require[1]);
		}
		for(int i=0; i<numCourses; i++) {
			if(!canFinishHelper(i, qualifiedCourses, new HashSet<>(), requiredCourses))
				return false;
		}
		return true;
    }
	
	public static boolean canFinishHelper(int number, Set<Integer> qualifiedCourses, Set<Integer> visitedCourses, 
			Map<Integer, Set<Integer>> requiredCourses) {
		if(qualifiedCourses.contains(number))
			return true;
		if(!requiredCourses.containsKey(number)) {
			qualifiedCourses.add(number);
			return true;
		}
		if(visitedCourses.contains(number))
			return false;
		Set<Integer> newVisitedCourses = new HashSet<Integer>(visitedCourses);
		newVisitedCourses.add(number);
		for(Integer course : requiredCourses.get(number)) {
			if(!canFinishHelper(course, qualifiedCourses, newVisitedCourses, requiredCourses))
				return false;
		}
		qualifiedCourses.add(number);
		return true;
	}
}
