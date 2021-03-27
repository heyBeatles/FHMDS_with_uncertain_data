package FHMDS.ds;


import java.util.HashMap;



/**
 * This class represents a UtilityList as used by the HUI-Miner algorithm.
 *
 * @see AlgoHUIMiner
 * @see Element
 * @author Philippe Fournier-Viger
 */
class UtilityList {
	int item;  // the item
	//test git
	float sumIutils = 0;  // the sum of item utilities
	float sumRutils = 0;  // the sum of remaining utilities
	//List<Element> elements = new ArrayList<Element>();  // the elements
	HashMap<Integer,Batch> batches = new HashMap<Integer,Batch>();
	/**
	 * Constructor.
	 * @param item the item that is used for this utility list
	 */
	public UtilityList(int item){
		this.item = item;	
	}
	public UtilityList(int item,int winSize){
		this.item = item;
		for(int i=1;i<=winSize;i++)
		{
			Batch b=new Batch(i,0,0);
			batches.put(i,b);
		}
	}
	
	public UtilityList(int item,int winSize,int win_number){
		this.item = item;
		for(int i=0;i<winSize;i++)
		{
			Batch b=new Batch(win_number+i,0,0);
			batches.put(win_number+i, b);
		}

	}
/*	public UtilityList(int item,int batch,int winSize){
		this.item = item;

		Batch b=new Batch(batch,0,0);
		batches.put(batch,b);
		
		for(int i=1;i<winSize;i++)
		{
			Batch b_previous=new Batch(batch-i,0,0);
			batches.put(batch-i, b_previous);
		}
	}*/
	
	/**
	 * Method to add an element to this utility list and update the sums at the same time.
	 */
	public void addElement(Element element,int winSize,int number_transactions){
		sumIutils += element.iutils;
		sumRutils += element.rutils;
		int batch_number=0;
		
		if (element.tid%number_transactions==0)
			batch_number=element.tid/number_transactions;
		else
			batch_number=element.tid/number_transactions+1;
		try {
			
			batches.get(batch_number).elements.add(element);
			batches.get(batch_number).sum_batch_iutils+=element.iutils;
			batches.get(batch_number).sum_batch_rutils+=element.rutils;
			
		}catch(Exception e)
		{
			System.out.println("Exception in add Element");
		}
		
	}
}
