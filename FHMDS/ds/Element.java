package FHMDS.ds;


/**
 * This class represents an Element of a utility list as used by the HUI-Miner algorithm.
 * 
 * @see AlgoHUIMiner
 * @see UtilityList
 * @author Philippe Fournier-Viger
 */
class Element {
	// The three variables as described in the paper:
	/** transaction id */
	final int tid ;   
	/** itemset utility */
	final float iutils; 
	/** remaining utility */
	final float rutils; 
	
	/**
	 * Constructor.
	 * @param tid  the transaction id
	 * @param iutils  the itemset utility
	 * @param rutils  the remaining utility
	 */
	public Element(int tid, float iutils, float rutils){
		this.tid = tid;
		this.iutils = iutils;
		this.rutils = rutils;
	}
}
