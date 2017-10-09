package org.javacream.training;

public class SimpleBusiness3 {
	private SimpleBusinessDelegate sbd;
	
	public void setSbd(SimpleBusinessDelegate sbd) {
		this.sbd = sbd;
	}

	public void initTheSimpleBusiness3() {
		sbd.doSimpleBusiness("aSimpleBusiness3");
	}
}
