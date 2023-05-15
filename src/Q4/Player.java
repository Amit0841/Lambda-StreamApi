package Q4;

import java.util.Objects;

public class Player {
private int age ;
private float weight;
 private String name;
public Player(int age, float weight, String name) {
	super();
	this.age = age;
	this.weight = weight;
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public float getWeight() {
	return weight;
}
public void setWeight(float weight) {
	this.weight = weight;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public int hashCode() {
	return Objects.hash(age, name, weight);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Player other = (Player) obj;
	return age == other.age && Objects.equals(name, other.name)
			&& Float.floatToIntBits(weight) == Float.floatToIntBits(other.weight);
}
@Override
public String toString() {
	return "Player [age=" + age + ", weight=" + weight + ", name=" + name + "]";
}
}
