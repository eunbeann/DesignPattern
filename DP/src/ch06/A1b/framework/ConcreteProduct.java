package ch06.A1b.framework;


//프로덕트 구현해줌
public abstract class ConcreteProduct implements Product {
    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
