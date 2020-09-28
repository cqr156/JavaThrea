/**
 * Created on 2020/9/26.
 * @author CQR
 */
public abstract class AbstractShape {
     AbstractShape(){

     }
     protected String ShapeName;

     AbstractShape(String shapeName){
        ShapeName = shapeName;
     }


    public String getShapeName() {
        return ShapeName;
    }
}

class  Circle extends AbstractShape implements Circumference,Space{
    public float R;
    public float Pi = (float) 3.14;
    public Circle(){
        super();
    }

    public Circle(int R){
        this.R = R;
    }

    public String getShapeName(){
        return "circle";
    }

    public float getR(){

        return this.R;
    }


    @Override
    public float getCircumferences() {
        return Pi*R*2;
    }
    @Override
    public float getSpace() {
        return Pi*R*R;
    }
    public static void main(String[] args) {
        Circle circle = new Circle(1);
        System.out.println(circle.getShapeName());
        System.out.println(circle.getCircumferences());
        System.out.println(circle.getSpace());
    }


}
interface Circumference{
    public float getCircumferences();
}

interface Space{
    public float getSpace();
}