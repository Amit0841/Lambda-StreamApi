package Q4;

import java.util.ArrayList;
import java.util.List;

public class Main {
public static void main(String[] args) {
	
	CreateObj c=Player::new;
	Player p=c.makeObj(23, 56.75f, "ABC");
	
	ToStringInterface pla = p::toString;
	System.out.println(pla.toStringMet());
	
	List <Player> list=new ArrayList<>();
	list.add(c.makeObj(24, 60.75f, "BCD"));
	list.add(c.makeObj(32, 62.75f, "CDE"));
	list.add(c.makeObj(21, 51.75f, "DEF"));
	list.add(c.makeObj(35, 72.75f, "EFG"));
	list.add(c.makeObj(38, 74.75f, "FGH"));
	list.add(c.makeObj(39, 65.25f, "GHI"));
	list.add(c.makeObj(42, 74.42f, "HIJ"));
	list.add(c.makeObj(18, 55.56f, "IJK"));
	list.add(c.makeObj(18, 55.56f, "IJK"));
	
	
	MaximumWeight play = PlayerOperation::getPlayerWithMaximumWeight;
	   
       double maxW = play.MaxWeight(list);
       
       System.out.println(maxW);

       HashP playHas =Player::hashCode;
       System.out.println();
       for (Player i :list) {
           int hashC =playHas.getHash(i);
           System.out.println( hashC);
       }
	
}
}
