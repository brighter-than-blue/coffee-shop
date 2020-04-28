/**
 * 
 */
package com.brighterthanblue.coffeeshop.basket;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import com.brighterthanblue.coffeeshop.customer.Item;

/**
 * @author blidgey
 *
 */
public class Basket {

	@Override
	public String toString() {
		return "Basket [items=" + items + "]";
	}

	private Collection<Item> items = new HashSet<>();

	public void addItem(Item i) {
		items.add(i);
	}

	public void empty() {
		items = new HashSet<>();
	}

	public Collection<Item> getItems() {
		return items;
	}

	public Integer getTotalPrice() {
		Integer totalPrice = 0;
		for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();) {
			Item item = iterator.next();
			totalPrice += item.getPriceInPence();
		}
		return totalPrice;
	}
}
