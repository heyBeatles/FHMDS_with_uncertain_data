package FHMDS.ds;


import java.util.*;

public class Batch_wise_TWU_and_Pro {

    //The variable stores the complete TWU of item in the window
    float sumTWU = 0;
    float sumPro = 0;
    //This map stores the batch wise TWU of an item
    HashMap<Integer, Float> batch_twu = new HashMap<Integer, Float>();
    HashMap<Integer, Float> batch_pro = new HashMap<>();

    /**
     * The constructor constructs the respective batch numbers
     * and inserts it into batch_twu map.
     *
     * @param winSize
     * @param win_number
     */
    public Batch_wise_TWU_and_Pro(int winSize, int win_number) {

        for (int i = 0; i < winSize; i++) {
            batch_twu.put(win_number + i, 0F);
			batch_pro.put(win_number + i, 0F);
        }

    }

    /**
     * This method removes the TWU of the oldest batch from the map
     * as well as reduces it from the sumTWU variable
     *
     * @param winSize
     * @param win_number
     */
    void updateTWUandPro(int winSize, int win_number) {
        try {
            batch_twu.put(winSize + win_number - 1, 0F);
            batch_pro.put(winSize + win_number - 1, 0F);
            sumTWU = sumTWU - batch_twu.get(winSize + win_number - 1 - winSize);
            sumPro = sumPro - batch_pro.get(winSize + win_number - 1 - winSize);
            batch_twu.remove(winSize + win_number - 1 - winSize);
            batch_pro.remove(winSize + win_number - 1 - winSize);
        } catch (Exception e) {
            System.out.println("updateTWUandPro");
        }
    }

    /**
     * This method removes the TWU of the oldest batch from the map
     * as well as reduces it from the sumTWU variable
     *
     * @param winSize
     * @param win_number
     * @param batch_number
     */
    void updateTWUandPro(int winSize, int win_number, int batch_number) {
        try {

            batch_twu.put(batch_number, 0F);
            batch_pro.put(batch_number, 0F);
            sumTWU = sumTWU - batch_twu.get(winSize + win_number - 1 - winSize);
            sumPro = sumPro - batch_pro.get(winSize + win_number - 1 - winSize);
            batch_twu.remove(winSize + win_number - 1 - winSize);
            batch_pro.remove(winSize + win_number - 1 - winSize);
        } catch (Exception e) {
            System.out.println("updateTWUandPro");
        }
    }

    /**
     * This method adds the twu of new batch
     *
     * @param batch_number
     * @param twu
     */
    void addTWUandPro(int batch_number, float twu,float pro) {
        try {
            Float oldtwu = batch_twu.get(batch_number);
            batch_twu.put(batch_number, oldtwu + twu);
            Float oldpro = batch_pro.get(batch_number);
            batch_pro.put(batch_number,oldpro+pro);
            sumTWU += twu;
            sumPro += pro;
        } catch (Exception e) {
            System.out.println("Exception in addTWUandPro");
        }


    }

    /**
     * This method adds the TWU of new batch
     *
     * @param twu
     * @param tid
     * @param winSize
     * @param number_transactions
     */
    void addTWUandPro(Float twu,Float pro, int tid, int winSize, int number_transactions) {
        int batch_number = 0;

        if (tid % number_transactions == 0)
            batch_number = tid / number_transactions;
        else
            batch_number = tid / number_transactions + 1;
        try {
            Float oldtwu = batch_twu.get(batch_number);
            batch_twu.put(batch_number, oldtwu + twu);
            Float oldpro = batch_pro.get(batch_number);
            batch_pro.put(batch_number,oldpro+pro);
            sumTWU += twu;
            sumPro += pro;
        } catch (Exception e) {
            System.out.println("Exception in addTWUandPro");
        }
    }
}
