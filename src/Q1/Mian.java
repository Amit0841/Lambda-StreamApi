package Q1;

import java.util.*;

interface HumanOperations {
    void computeBMI(List<Human> human);

    void printRemark(List<Human> human);
}

public class Mian {
    public static void main(String[] args) {
        List<Human> hl = new ArrayList<>();
        hl.add(new Human(65, 1.7));
        hl.add(new Human(75, 1.6));
        hl.add(new Human(45, 1.4));
        hl.add(new Human(45, 1.7));
        hl.add(new Human(48, 1.2));
        hl.add(new Human(92, 1.6));
        hl.add(new Human(116, 1.65));

        HumanOperations operations = new HumanOperations() {
            @Override
            public void computeBMI(List<Human> human1) {
                for (Human human : human1) {
                    double bmi = human.getWeight() / (human.getHeight() * human.getHeight());
                    bmi = Math.round(bmi * 10) / 10.0;
                    human.setBodyMassIndex(bmi);
                }
            }
            @Override
            public void printRemark(List<Human> human2) {
                for (Human human : human2) {
                    double b = human.getBodyMassIndex();
                    String remark;
                    if (b < 18.5) {
                        remark = "underweight";
                    } else if (b >= 18.5 && b <= 24.9) {
                        remark = "normal";
                    } else if (b >= 25.0 && b <= 29.9) {
                        remark = "overweight";
                    } else if (b >= 30.0 && b <= 34.9) {
                        remark = "obese";
                    } else {
                        remark = "extreme obese";
                    }
                    System.out.println(remark + " bmi is " + b);
                }
            }
        };
        operations.computeBMI(hl);
        operations.printRemark(hl);
    }
}

