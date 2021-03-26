package FHMDS.ds;

import java.util.ArrayList;
import java.util.List;

public class Batch {

	int bid;
	float sum_batch_iutils=0;
	float sum_batch_rutils=0;
	List<Element> elements = new ArrayList<Element>();
	/**
	 * Constructor.
	 * @param bid  the batch id
	 * @param iutils  the itemset utility
	 * @param rutils  the remaining utility
	 */
	public Batch(int bid, float iutils, float rutils){
		this.bid = bid;
		this.sum_batch_iutils = iutils;
		this.sum_batch_rutils = rutils;
	}
}
