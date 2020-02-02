package Data;

import java.util.Comparator;

public class CompararObjetos implements Comparator<Productos>{
    
    @Override
    public int compare(Productos p1, Productos p2){
       if(p1.getPrecio()>p2.getPrecio()){
           return -1;
       }else if(p1.getPrecio()>p2.getPrecio()){
           return 0;
       }else{
           return 1;
       }
   }
    
    
}