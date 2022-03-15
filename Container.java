import java.util.Enumeration;


public interface Container extends Comparable{
  int getCount();
  boolean isEmpty();
  boolean isFull();
  void purge();
  void accept(Visitor visitor);
  Enumeration getEnumeration();
}


// // exemplo de implementação do métdo accept em uma classe concreta (SomeContainer)
// class SomeContainer implements Container{
//   //...
//   public void accept(Visitor visitor){
//     for each Object i in this container{
//       visitor.visit(i);
//     }
//   }
// }


// class PrintingVisitor implements Visitor{
//   // ...
//   boolean done = false;
//   public void visit(Object obj){
//     System.out.println(obj);
//     done = true;
//   }
//   public boolean isDone(){
//     return done;
//   }

// }

// public static void main(String[] args){
//   // Exemplo de uso do Container e do Enumeration
//   Container c = new SomeContainer();
//   // ...
//   Enumeration e = c.getEnumeration();
//   while(e.hasMoreElements()){
//     Object obj = e.nextElement();
//     // do something with 'obj' - maybe using a cast
//     System.out.println(obj);
//   }