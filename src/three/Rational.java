package three;
//201621123029董明超
public class Rational {
    private int v1;
    private int v2;
    void InitRational(int v1, int v2){
        this.v1=v1;
        this.v2=v2;
    }//初始化有理数分子，分母
    Rational Add(Rational T1, Rational T2){
        Rational T3 = new Rational();
        int t;
        T3.v2=T1.v2*T2.v2;
        T3.v1=T1.v1*T2.v2+T2.v1*T1.v2;
        t=Gcd(T3.v2,T3.v1);
        T3.v2/=t;
        T3.v1/=t;
        return T3;
    }//有理数相加函数
    Rational Minus(Rational T1, Rational T2){
        Rational T3 = new Rational();
        int t;
        T3.v2=T1.v2*T2.v2;
        T3.v1=T1.v1*T2.v2-T2.v1*T1.v2;
        t=Gcd(T3.v2,T3.v1);
        T3.v2/=t;
        T3.v1/=t;
        return  T3;
    }//有理数相减
    Rational Multiply(Rational T1, Rational T2){
        Rational T3 = new Rational();
        int t;
        T3.v2=T1.v2*T2.v2;
        T3.v1=T1.v1*T2.v1;
        t=Gcd(T3.v2,T3.v1);
        T3.v2/=t;
        T3.v1/=t;
        return T3;
    }//有理数相乘
    Rational Divide(Rational T1, Rational T2){
        Rational T3 = new Rational();
        T3.v2=T1.v1*T2.v2;
        T3.v1=T1.v2*T2.v1;
        int t;
        t=Gcd(T3.v2,T3.v1);
        T3.v2/=t;
        T3.v1/=t;
        return T3;
    }//有理数相除
    int Gcd(int m,int n){
        int t;
        while(m%n!=0)
        {
            t=n;
            n=m%n;
            m=t;
        }
        return n;
    }//求两个数最大公约数以便约分
    int GetRational(Rational T,int i){
        if(i==1)
            return T.v1;
        else
            return T.v2;
    }//获得有理数的分子或者分母
}
