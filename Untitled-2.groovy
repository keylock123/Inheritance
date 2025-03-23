// 父类StoreToRent
class StoreToRent {
    // 定义常量表示利率
    private final double INTEREST_RATE = 0.25;
    // 表示是否需要贷款
    private boolean loanRequired;
    // 贷款金额
    private double loanAmount;
    // 贷款还款期限
    private int loanPaymentTerm;

    // 构造函数，初始化贷款相关属性
    public StoreToRent(boolean loanRequired, double loanAmount, int loanPaymentTerm) {
        this.loanRequired = loanRequired;
        this.loanAmount = loanAmount;
        this.loanPaymentTerm = loanPaymentTerm;
    }

    // 获取利率的方法
    public double getINTEREST_RATE() {
        return INTEREST_RATE;
    }

    // 获取是否需要贷款的方法
    public boolean isLoanRequired() {
        return loanRequired;
    }

    // 获取贷款金额的方法
    public double getLoanAmount() {
        return loanAmount;
    }

    // 获取贷款还款期限的方法
    public int getLoanPaymentTerm() {
        return loanPaymentTerm;
    }

    // 计算贷款融资的方法
    public double calculateLoanFinancing() {
        if (loanRequired) {
            return (loanAmount * (1 + INTEREST_RATE)) / loanPaymentTerm;
        } else {
            return 0;
        }
    }

    // 默认的toString方法
    @Override
    public String toString() {
        return "This is parent class toString()";
    }
}

// 子类StoreOneA继承自StoreToRent
class StoreOneA extends StoreToRent {
    // 表示是否为特殊客户
    private boolean specialCustomer;
    // 每月还款金额
    private double monthlyPayment;
    // 定义折扣率
    private static final double DISCOUNT_RATE = 0.1;

    // 构造函数，初始化父类属性和子类特有的属性
    public StoreOneA(boolean loanRequired, double loanAmount, int loanPaymentTerm, boolean specialCustomer) {
        super(loanRequired, loanAmount, loanPaymentTerm);
        this.specialCustomer = specialCustomer;
    }

    // 展示店铺信息的方法
    public void showStoreInfo() {
        System.out.println(toString());
    }

    // 重写toString方法，组合父类和子类的信息
    @Override
    public String toString() {
        double parentLoanAmount = getLoanAmount();
        int parentLoanPaymentTerm = getLoanPaymentTerm();
        double interestRate = getINTEREST_RATE();
        String loanDetails = "LOAN DETAILS (if applicable):\n";
        loanDetails += "Loan Amount: " + parentLoanAmount + "\n";
        loanDetails += "Loan Payment Term: " + parentLoanPaymentTerm + "\n";
        loanDetails += "Interest Rate: " + interestRate + "\n";
        loanDetails += "Special Customer: " + specialCustomer + "\n";
        loanDetails += "Monthly Loan Payment: " + calculateLoanFinancing();
        return "Combining parent toString() \n" + super.toString() + "\n and \n" + loanDetails;
    }

    // 重写计算贷款融资的方法，增加特殊客户的逻辑
    @Override
    public double calculateLoanFinancing() {
        monthlyPayment = super.calculateLoanFinancing();
        if (specialCustomer) {
            monthlyPayment -= (monthlyPayment * DISCOUNT_RATE);
        }
        return monthlyPayment;
    }
}

// 主类Main
public class Main {
    public static void main(String[] args) {
        // 创建StoreOneA对象并调用相关方法
        StoreOneA storeOneA = new StoreOneA(true, 100000, 12, true);
        storeOneA.enterStoreDetails();
        storeOneA.showStoreInfo();
    }
}