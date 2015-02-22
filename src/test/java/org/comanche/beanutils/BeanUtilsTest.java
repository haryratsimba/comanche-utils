package test.java.org.comanche.beanutils;

import static main.java.org.comanche.beanutils.BeanUtils.get;

import org.junit.Test;

public class BeanUtilsTest {

	@Test
	public void test() {
		CompositeObject co = new CompositeObject("co prop", new InternalComposite(1, new InternalComposite(8, null)));
		Integer prop = get(co, "innerProp", "innerProp", "prop");
		System.out.println(prop);
	}
	
}

class CompositeObject {
	
	private String prop;
	
	private InternalComposite innerProp;

	public CompositeObject(String prop, InternalComposite innerProp) {
		super();
		this.prop = prop;
		this.innerProp = innerProp;
	}

	public String getProp() {
		return prop;
	}

	public void setProp(String prop) {
		this.prop = prop;
	}

	public InternalComposite getInnerProp() {
		return innerProp;
	}

	public void setInnerProp(InternalComposite innerProp) {
		this.innerProp = innerProp;
	}

	@Override
	public String toString() {
		return "CompositeObject [prop=" + prop + ", innerProp=" + innerProp
				+ ", hashCode()=" + hashCode() + "]";
	}
	
}

class InternalComposite {
	
	private Integer prop;
	
	private InternalComposite innerProp;

	public InternalComposite(Integer prop, InternalComposite innerProp) {
		super();
		this.prop = prop;
		this.innerProp = innerProp;
	}

	public Integer getProp() {
		return prop;
	}

	public void setProp(Integer prop) {
		this.prop = prop;
	}

	public InternalComposite getInnerProp() {
		return innerProp;
	}

	public void setInnerProp(InternalComposite innerProp) {
		this.innerProp = innerProp;
	}
}