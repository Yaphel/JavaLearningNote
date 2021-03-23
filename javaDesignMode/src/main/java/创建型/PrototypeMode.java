package 创建型;
//浅拷贝实现，深拷贝需要new引用对象。
public class PrototypeMode implements Cloneable{
    public static void main(String[] args) {
        PrototypeMode prototypeMode=new PrototypeMode();
        try {
            PrototypeMode prototypeMode1 = (PrototypeMode) prototypeMode.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    PrototypeMode() {
        System.out.println("具体原型创建成功！");
    }
    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (PrototypeMode) super.clone();
    }
}

