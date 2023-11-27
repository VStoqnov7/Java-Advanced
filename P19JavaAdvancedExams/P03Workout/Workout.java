package JavaAdvanced.P19JavaAdvancedExams.P03Workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {

    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void addExercise(Exercise exercise){

        if (exercises.size() < exerciseCount){
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name,String muscle){

        for (Exercise item : exercises) {
            if (item.getName().equals(name) && item.getMuscle().equals(muscle)){
                exercises.remove(item);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle){
        for (Exercise item : exercises) {
            if (item.getName().equals(name) && item.getMuscle().equals(muscle)){
                return item;
            }
        }
        return null;
    }


    public Exercise getMostBurnedCaloriesExercise(){
        if (exercises.isEmpty()){
            return null;
        }
        int calories = 0;
        Exercise max = null;
        for (Exercise item : exercises) {
            if (item.getBurnedCalories() > calories){
                calories = item.getBurnedCalories();
                max = item;
            }
        }
        return max;
    }

    public int getExerciseCount() {
        return exerciseCount;
    }

    public String getStatistics(){

        StringBuilder sb = new StringBuilder();
        sb.append("Workout type: ").append(type).append("\n");

        for (Exercise item : exercises) {
            sb.append(item).append("\n");
        }

        return sb.toString();
    }
}
