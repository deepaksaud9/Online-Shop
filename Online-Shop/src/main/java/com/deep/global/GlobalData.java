package com.deep.global;

import java.util.ArrayList;
import java.util.List;

import com.deep.model.Product;

public class GlobalData {
	public static List<Product> cart;
	static {
		cart= new ArrayList<Product>();
		
	}

}
