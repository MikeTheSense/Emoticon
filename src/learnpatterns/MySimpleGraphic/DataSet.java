package learnpatterns.MySimpleGraphic;

import learnpatterns.MySimpleGraphic.CustomExceptions.DuplicateValueException;

import java.util.HashMap;
import java.util.Map;

public class DataSet  {
    private HashMap<Double,Double> points;
    private final String myFunction = "hyperbole";
    private final double a=5;
    private final double b=-100;
    public DataSet(HashMap<Double, Double> points) {
        this.points = points;
    }
    public HashMap<Double, Double> getPoints() {
        return points;
    }
    public void addPoint(Double x)
    {
        points.put(x,a-(b/x));
    }
    public void addPoint(Object x)
    {
        Double value = 0.0;
        try
        {
            value = Double.parseDouble(x.toString());
        }
        catch (NumberFormatException e)
        {
            System.out.println("Сделал 0");
        }
        points.put(value,a-(b/value));
    }
    public Double addPointGet(Object x) throws NumberFormatException,NullPointerException, DuplicateValueException
    {
        var value = Double.parseDouble(x.toString());
        if (Math.abs(value) < 0.0001) throw new NumberFormatException();
        else if ((points.get(value)!=null)) throw new DuplicateValueException("Duplicate name");
        points.put(value,a-(b/value));
        return points.get(value);
    }
    public void removePoint(Object x)
    {
        try {
            var value = Double.parseDouble(x.toString());
            if ((points.get(value)!=null)) points.remove(value);
        }
        catch (Exception ex) {ex.printStackTrace();}
    }

    public void removePointByY(Object y)
    {
        if (points.containsValue(Double.parseDouble(y.toString())))
        {
            var entries = points.entrySet();
            var result = points
                    .entrySet()
                    .stream()
                    .filter(l->l.getValue()==y)
                    .findFirst();
            points.remove(result.get().getKey());
        }
    }

}
