package incubator.weldGae;

import javax.inject.Named;

/**
 * 
 * @author m.schuetz
 *
 */
@Named
public class HelloWorld
{
   public String getMessage()
   {
      return "Hello, World 2010";
   }
}