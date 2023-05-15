package Q4;

import java.util.List;

public class PlayerOperation {
	static double getPlayerWithMaximumWeight(List<Player> playerList) {
		Double high=0.0;
		for(Player s:playerList) {
			if(s.getWeight()>high) {
				high=(double) s.getWeight();
			}
		}
		return high;
	}
}
@FunctionalInterface
interface CreateObj{
	Player makeObj(int age, float weight, String name);
}
@FunctionalInterface
interface ToStringInterface{
	String toStringMet();
}
@FunctionalInterface
interface MaximumWeight{
	double MaxWeight(List<Player> pl);
}
@FunctionalInterface
interface HashP{
	int getHash(Player player);
}
