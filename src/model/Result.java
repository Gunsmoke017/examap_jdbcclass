package model;

public class Result {
    private String email;
    private int Math;
    private int English;
    private int Chemistry;
    private int Physics;
    private int total;

    public Result(String email, int math, int english, int chemistry, int physics, int total) {
        this.email = email;
        Math = math;
        English = english;
        Chemistry = chemistry;
        Physics = physics;
        this.total = total;
    }

    public Result() {
    }

    @Override
    public String toString() {
        return "Result{" +
                "email='" + email + '\'' +
                ", Math=" + Math +
                ", English=" + English +
                ", Chemistry=" + Chemistry +
                ", Physics=" + Physics +
                ", total=" + total +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMath() {
        return Math;
    }

    public void setMath(int math) {
        Math = math;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int english) {
        English = english;
    }

    public int getChemistry() {
        return Chemistry;
    }

    public void setChemistry(int chemistry) {
        Chemistry = chemistry;
    }

    public int getPhysics() {
        return Physics;
    }

    public void setPhysics(int physics) {
        Physics = physics;
    }
}
