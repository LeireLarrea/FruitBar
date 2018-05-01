import java.util.*;


/**
 * A class which simulates a juice bar that keeps a record of handmade fruit juices using a map, 
 * where the keys of the map are Strings, each representing the name of the juice. 
 * The values of the map are Sets of Strings, each representing the ingredients that make the juice. 
 * 
 * @author (Leire Larrea Casado - OU Student E1662175 - M250 – TMA03 - Question 3) 
 * @version (24th April 2017)
 */
public class FruitBar
{
   /* Instance variables */
   Map<String, Set<String>> juiceMap;
   Set<String> ingredients;
   
   
   
   /**
    * Creates a Map which keys are strings (JuiceNameMap) 
    * and its values are a Set of Strings (inredients).
    * The map is then populated with test data.
    */
   public FruitBar()
   {
      juiceMap = new HashMap<String, Set<String>>();
      ingredients = new HashSet<String>();
      addTestData();

   }

   /* Instance methods */
   /**
    * Populates the map with some test data.
    * 
    */
   public void addTestData()
   {
      ingredients.add("Apple");
      ingredients.add("Kiwi");
      ingredients.add("Pear");
      juiceMap.put("Health Booster", ingredients);   
      
      ingredients = new HashSet<String>();
      ingredients.add("Blueberry");
      ingredients.add("Strawberry");
      ingredients.add("Mango");
      juiceMap.put("Antioxidant Supreme", ingredients);
      
      ingredients = new HashSet<String>();
      ingredients.add("Apple");
      ingredients.add("Peach");
      ingredients.add("Green Grapes");
      juiceMap.put("Sweet Spring", ingredients);
   }
     
   /**
    * Prints out the map's contents.
    * 
    */
   public void printMap()
   {
      Set <String> juiceName = juiceMap.keySet();
      String juiceIngredients = "";
      
      for (String eachJuice : juiceMap.keySet()) 
      { 
         juiceName = juiceMap.get(eachJuice);
         System.out.println(eachJuice + " is made of: ");
         for (String eachIngredient: juiceName)
         {
            System.out.println(eachIngredient);
         }
      }
   }
   
    /**
    * If the argument taken is a Key in the map 
    * it prints a message saying the argument is on the Map
    * otherwise it prints a message saying the argument is not on the Map
    * 
    * @param aKey, a String to compare with the Keys of the Map
    */
   public void printMapValue(String aKeyToSearch)
   {
      if (juiceMap.containsKey(aKeyToSearch))
      {
         System.out.println(aKeyToSearch + " is already a key in the map and its values / ingredients are:");
        
         for (String eachIngredient: juiceMap.get(aKeyToSearch))
         {
            System.out.println(eachIngredient);
         }
      }
      else
      {
         System.out.println(aKeyToSearch + " is not in the map");
      }
   }
   
    /**
    * Adds keys and values to the Map.
    * 
    * @param ajuiceMapKey, a String to be the new key for the Map.
    * @param aSetOfIngredients, a Set of Strings to be the new values for the new key for the Map. 
    */
   public void addMapEntry(String ajuiceMapKey, Set aSetOfIngredients )
   {
       juiceMap.put(ajuiceMapKey, aSetOfIngredients); 
   }
   
    /**
    * Checks if the key provided exists on the Map.
    * If it does, it delets it and its values and returns true
    * otherwise it returns false.
    * 
    * @param aKeyToDelete, a String representing the key to delete of the Map.
    * @returns boolean, true if key is successfully found and deleted, false if not found.
    * 
    */
   public boolean deleteEntry(String aKeyToDelete)
   {
      if (juiceMap.containsKey(aKeyToDelete))
      {
         juiceMap.remove(aKeyToDelete);
         return true;
      }
      else
      {
         return false;
      }
   }
   
    /**
    * Checks if a Value / ingredient is present in the Keys of the Map,
    * if present, it returns a Set of Strings with the Keys that contain that value.
    * 
    * 
    * @param aValueContained, a String representing the value / ingredient to be checked
    * that the different keys / juices of the map can have
    * @returns Set < String> containing all the keys / juices that contain that value / ingredient
    * 
    */
   public Set <String> selectKeys(String aValueContained)
   {
      Set <String> juiceName = new HashSet<String>();
      Set <String> juicesThatContainIngredient = new HashSet<String>();
      
      for (String eachJuice : juiceMap.keySet()) 
      { 
         juiceName = juiceMap.get(eachJuice);
         for (String eachIngredient : juiceName) 
         {
            if(eachIngredient.equals(aValueContained))
            {
               juicesThatContainIngredient.add(eachJuice);
            }
         }
      }
      return juicesThatContainIngredient;
   }
   
    /**
    * Adds a String to the Set of Strings for a particular key.
    * 
    * 
    * @param aJuiceKey, a String representing the Key where to add the new String.
    * @param newIngredient, a String representing the new Value to add to the Set of Strings.
    * 
    */
   public void addValue(String aJuiceKey, String newIngredient)
   {
      Set<String> ingredients = new HashSet<String>(juiceMap.get(aJuiceKey));
      ingredients.add(newIngredient);
      juiceMap.put(aJuiceKey, ingredients);
   }
   
   /**
    * Deletes an existing String from the Set of Strings for a particular key.
    * 
    * 
    * @param aJuiceKey, a String representing the Key where to remove the existing String.
    * @param ingredientToRemove, a String representing the new Value to add to the Set of Strings.
    * 
    */
   public void removeValue(String aJuiceKey, String ingredientToRemove)
   {
      Set<String> ingredients = new HashSet<String>(juiceMap.get(aJuiceKey));
      ingredients.remove(ingredientToRemove);
      juiceMap.put(aJuiceKey, ingredients);
   }
   
   }
      
          


   
   

