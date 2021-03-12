/**
 *  Package of classes that are only meant to be data structures
 */
package dataStructures;

/**
 * Palet class :
 * Stores a palet for the web designer application.
 * Each color is stored as an hexadecimal string
 * @author T4ouf
 */
public class Palet {
	
	public int id; //Should be const
	public String name;

	public String colorMain1;
	public String colorMain2;
	public String colorMain3;
	
	public String color1Var1;
	public String color2Var1;
	public String color3Var1;
	
	public String color1Var2;
	public String color2Var2;
	public String color3Var2;
	
	@Override
	public String toString() {
		return "Palet [id=" + id + ", name=" + name + 
				"]:\n\tcolorMain1=" + colorMain1 + ", colorMain2=" + colorMain2	+ ", colorMain3=" + colorMain3 + 
				"\n\tcolor1Var1=" + color1Var1 + ", color2Var1=" + color2Var1 + ", color3Var1=" + color3Var1 + 
				"\n\tcolor1Var2=" + color1Var2 + ", color2Var2=" + color2Var2 + ", color3Var2=" + color3Var2;
	}
	
	//TODO : DECISION : better to stay public ? Or private with validity checks ?

	
	
}
