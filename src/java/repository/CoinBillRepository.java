package repository;

import model.Entity.CoinBill;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CoinBillRepository {

    boolean checkMGD(String mgd, HttpServletRequest request);

    void addBill(float amount, String mgd , int UserID);

    List<CoinBill> getDepositHistory(int UserID);

}
