package com.foodApp.DaoImpl;



import java.util.HashMap;
import java.util.Map;

import com.foodApp.modules.CartItem;

public class Cart {
	HashMap<Integer,CartItem>items=new HashMap<Integer,CartItem>();
	public void addItem(CartItem item) {
		
		if(items.containsKey(item.getItemId())) {
			CartItem cartItem = items.get(item);
			cartItem.setQuantity(cartItem.getQuantity()+item.getQuantity());
		}else {
			int itemId = item.getItemId();
			items.put(itemId, item);
		}
	}
	
	public void updateItem(int itemId,int quantity) {
		if(items.containsKey(itemId)) {
			if(quantity<=0) {
				items.remove(itemId);
			}else {
				items.get(itemId).setQuantity(quantity);
			}
		}
	}
	public void removeItem(int itemId) {
		items.remove(itemId);
	}
	public Map<Integer,CartItem> getItems(){
		return items;
	}
	public void clear() {
		items.clear();
	}

}