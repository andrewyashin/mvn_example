package collections;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by andrew_yashin on 1/24/17.
 */
public class Country {

    String name;
    long population;

    public Country(String name, long population) {
        super();
        this.name = name;
        this.population = population;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getPopulation() {
        return population;
    }
    public void setPopulation(long population) {
        this.population = population;
    }

    // если длина имени в объекте Country - четное число,
    // то возвращаем 31(любое случайное число), а если нечетное - 95 (любое случайное число).
    // указанный ниже метод - это не самый лучший способ генерации хеш-кода,
    // но мы воспользуемся им для более четкого понимания хеш-карт.

    @Override
    public int hashCode() {
        if(this.name.length()%2==0)
            return 31;
        else
            return 95;
    }
    @Override
    public boolean equals(Object obj) {

        Country other = (Country) obj;
        if (name.equalsIgnoreCase((other.name)))
            return true;
        return false;
    }
}

class HashMapStructure {

    /**
     * @author Arpit Mandliya
     */
    public static void main(String[] args) {

        Country india=new Country("India",1000);
        Country japan=new Country("Japan",10000);

        Country france=new Country("France",2000);
        Country russia=new Country("Russia",20000);

        HashMap<Country,String> countryCapitalMap=new HashMap<Country,String>();
        countryCapitalMap.put(india,"Delhi");
        countryCapitalMap.put(japan,"Tokyo");
        countryCapitalMap.put(france,"Paris");
        countryCapitalMap.put(russia,"Moscow");

        Iterator<Country> countryCapitalIter=countryCapitalMap.keySet().iterator();//установите
        //debug-точку на этой строке(23)
        while(countryCapitalIter.hasNext())
        {
            Country countryObj=countryCapitalIter.next();
            String capital=countryCapitalMap.get(countryObj);
            System.out.println(countryObj.getName()+"----"+capital);
        }

    }
}