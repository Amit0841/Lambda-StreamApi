package Q3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
public static void main(String[] args) {
	List <Player> list=new ArrayList<>();
	list.add(new Player(23, 56.75f, "ABC"));
	list.add(new Player(24, 60.75f, "BCD"));
	list.add(new Player(32, 62.75f, "CDE"));
	list.add(new Player(21, 51.75f, "DEF"));
	list.add(new Player(35, 72.75f, "EFG"));
	list.add(new Player(38, 74.75f, "FGH"));
	list.add(new Player(39, 65.25f, "GHI"));
	list.add(new Player(42, 74.42f, "HIJ"));
	list.add(new Player(18, 55.56f, "IJK"));
	list.add(new Player(18, 55.56f, "IJK"));
	
	Predicate<Float> check= i-> {
		if(i < 50.00f){
			return true;
		}
		return false;
	};
  System.out.println(list.stream().map(w -> w.getWeight()).anyMatch(check)?"One or more player is underweight":"All players are fit");
    
  System.out.println(list.stream().mapToDouble(Player::getWeight).average());
  
  System.out.println(list.stream().mapToInt(Player::getAge).reduce(0,Integer::sum));
  
  System.out.println(list.stream().sorted((a,b)-> a.getWeight()>b.getWeight()?-1:1).skip(2).limit(4).toList());
	Predicate<Integer> age= j-> {
		if(j >= 18 && j <= 60){
			return false;
		}
		return true;
	};
  System.out.println(list.stream().map(w -> w.getAge()).anyMatch(age)?"Team contains kids or old":"Team contains young and middle aged");
}
}
