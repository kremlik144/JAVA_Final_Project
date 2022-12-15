import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
    + 1. Подумать над структурой класса Ноутбук для магазина техники - выделить
    поля и методы. Реализовать в java. 

    + 2. Создать множество ноутбуков.

    +- 3. Написать метод, который будет запрашивать у пользователя критерий
    (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
    Критерии фильтрации можно хранить в Map. Например:

    +- 4. Далее нужно запросить минимальные значения для указанных 
    критериев - сохранить параметры фильтрации можно также в Map.

    5. Отфильтровать ноутбуки их первоначального множества и вывести 
    проходящие по условиям.
*/

class Main
{
    // запрос параметров фильтрации и их значения у пользователя
    public static Map<String, String> filterGet() 
    {
        String [] filterOptions = {"ПРОИЗВОДИТЕЛЬ", "ОПЕРАТИВНАЯ ПАМЯТЬ", "ОБЬЕМ ЖД", 
                                  "ОПЕРАЦИОННАЯ СИСТЕМА", "ЦВЕТ"};
        Scanner scan = new Scanner(System.in);
        Map<String, String> selectedFilters = new LinkedHashMap<>();
        String[] categor = {"producer", "ramPc", "hardDiskCapacity", "ocPc", "color"};
        int count = 0;

        for(String filter: filterOptions)
        {
            System.out.printf("Сортировать по %s y/n: ", filter);
            String parametr1 = scan.nextLine();

            if(parametr1.equals("y"))
            {
                System.out.printf("Укажите %s: ", filter);
                String parametr2 = scan.nextLine();
                selectedFilters.put(categor[count], parametr2);
            }
            count++;
        } 
        scan.close();
        return selectedFilters;
    }

    public static void filterPc(Map<String, String> criteria, Set<Laptop> laptops)
    {
        List<Laptop> filtred = new ArrayList<>();

        if(criteria.size() == 0)
        {
            System.out.println("Все компьютеры: ");
            for(Laptop laptop: laptops) System.out.println("\t" + laptop.fullInfo());
            return;
        }

        for(Laptop laptop: laptops)
        {
            if(criteria.containsKey("producer") && !laptop.equalsStr(laptop.getProducer(), criteria.get("producer")))
                continue;
            if(criteria.get("ramPc") != null && !laptop.equalsInt(laptop.getRamPc(), criteria.get("ramPc")))
                continue;
            if(criteria.get("hardDiskCapacity") != null && !laptop.equalsInt(laptop.getHardDiskCapacity(), criteria.get("hardDiskCapacity")))
                continue;
            if(criteria.containsKey("ocPc") && !laptop.equalsStr(laptop.getOcPc(), criteria.get("ocPc")))
                continue;
            if(criteria.containsKey("color") && !laptop.equalsStr(laptop.getColor(), criteria.get("color")))
                continue;

            filtred.add(laptop);
        }

        if(filtred.size() == 0)
        {
            System.out.println("Нет Ноутбуков, которые бы соответствовали выбранным параметрам");
            return;
        }

        System.out.println("Соответствующие компьютеры: ");
            for(Laptop pc: filtred) System.out.println("\t" + pc.fullInfo());
            return;
      
    }


    public static void main(String[] args) 
    {
        Set<Laptop> laptops = new HashSet<Laptop>();

        laptops.add(new Laptop("Acer", 16, 256, "Windows 10", "white"));
        laptops.add(new Laptop("Lenova", 8, 512, "Windows 7", "green"));
        laptops.add(new Laptop("HP", 4, 256, "Windows 8", "red"));
        laptops.add(new Laptop("Acer", 32, 512, "Windows 11", "blue"));
        laptops.add(new Laptop("Macbook air", 16, 512, "Mac OS", "dark"));
    
        Map<String, String> filteringCriteria = filterGet();
        filterPc(filteringCriteria, laptops);
        
    }
    
}