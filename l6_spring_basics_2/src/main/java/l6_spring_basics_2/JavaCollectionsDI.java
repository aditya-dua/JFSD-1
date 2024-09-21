package l6_spring_basics_2;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaCollectionsDI {
	
	List addressList;
	Set citySet;
	Map productMap;
	public List getAddressList() {
		return addressList;
	}
	public void setAddressList(List addressList) {
		this.addressList = addressList;
	}
	public Set getCitySet() {
		return citySet;
	}
	public void setCitySet(Set citySet) {
		this.citySet = citySet;
	}
	public Map getProductMap() {
		return productMap;
	}
	public void setProductMap(Map productMap) {
		this.productMap = productMap;
	}
	
	

}
