package Q5;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    	
        List<Trainee> list = new ArrayList<>();
        
        list.add(new Trainee("T001", "Ajay", 4.75));
        list.add(new Trainee("T002", "Zakir", 4.25));
        list.add(new Trainee("T003", "Nayan", 2.25));
        list.add(new Trainee("T004", "Abhishek", 3.25));
        list.add(new Trainee("T005", "Neha", 3.75));

        List<Manager> ml = list.stream().filter(t->t.getRating()>=3.0).map(tr->{
                    String mId =tr.getTraineeId().replace("T", "M");
                    String des = null;
                    String loc = null;
                    if(tr.getRating()>=4.5){
                        des = "People manager";
                        loc = "Headquarter";
                    }else if(tr.getRating()>= 3.5){
                        des = "Branch manager";
                        loc = "Branch Office";
                    }else if(tr.getRating()>=3.0){
                        des = "Junior manager";
                        loc = "Kiosk";
                    }
                    return new Manager(mId, tr.getName(), des, loc);
                }).collect(Collectors.toList());
                
        
        ml.forEach(System.out::println);
        
        System.out.println();
        Consumer<Manager>m =man ->{
            String loc = man.getLocation();
            if (loc.equals("Headquarter") || loc.equals("Kiosk")){
                System.out.println(man.getName() + " id is " +man.getManagerId() +" is in " +loc);
            }
        };
        ml.forEach(m);
        List<String> em=ml.stream().map(e ->e.getManagerId()).collect(Collectors.toList());
        
        Consumer<Trainee> b=a->{
      	  if(!em.contains(a.getTraineeId())){
      		  System.out.println(a.getTraineeId());
      	  }
        };
        System.out.println("not be promoted");
        List<Trainee> s=list.stream().filter(a -> a.getRating()<3.0).toList();
        s.forEach(a-> System.out.println(a.getTraineeId()));
    }
}
