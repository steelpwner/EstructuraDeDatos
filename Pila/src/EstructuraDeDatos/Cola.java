package EstructuraDeDatos;


public class Cola <E> {
    
    private Nodo top,end;
    private int size;
    public Cola(){
        top=end=null;
        size=0;              
    }
    public void enqueue(E valor){
        Nodo <E> nodo = new Nodo(valor);
        if (top == null){
          top= end = nodo; 
         
        }else{
          this.end.setLink(nodo);
          this.end=nodo;
        }        
        this.size++;
    }
    
    public Nodo<E> dequeue(){
         if (isEmpty())
             return null;
         else {
             Nodo<E> nodo = this.top;
             this.top = this.top.getLink();
             this.size --;
             return nodo;
         }    
    }
    
    public Nodo<E> peek(){        
        return this.top;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public boolean isEmpty(){    
     return top == null;
    }
    
    
    public Nodo<E> getEnd(){
       return this.end;
    }
    
     public void display(){
       Nodo<E>   nodo =this.top;
       System.out.println("La Cola de tamaño "+this.getSize()+ " es la siguiente:");
       while (nodo != null){
           System.out.println(nodo.getValor().toString());
           nodo=nodo.getLink();
       }
    }
    
}
