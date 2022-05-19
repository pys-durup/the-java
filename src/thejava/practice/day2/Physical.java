package thejava.practice.day2;

public class Physical {
    private Integer benchpress;
    private Integer deadLift;
    private Integer squat;

    public Physical(Integer benchpress, Integer deadLift, Integer squat) {
        this.benchpress = benchpress;
        this.deadLift = deadLift;
        this.squat = squat;
    }

    public Integer getBenchpress() {
        return benchpress;
    }

    public void setBenchpress(Integer benchpress) {
        this.benchpress = benchpress;
    }

    public Integer getDeadLift() {
        return deadLift;
    }

    public void setDeadLift(Integer deadLift) {
        this.deadLift = deadLift;
    }

    public Integer getSquat() {
        return squat;
    }

    public void setSquat(Integer squat) {
        this.squat = squat;
    }
}
