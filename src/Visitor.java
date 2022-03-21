public interface Visitor{
    void visit(Object object);
    boolean isDone();
  }
  
  
  
  
  // exemplo de implementação de uma classe visitante -- MatchingVisitor
  // a busca é interrompida se o objeto buscado foi encontrado. 
  class MatchingVisitor implements Visitor{
    private Object target;
    private Object found;
  
      public MatchingVisitor(Object obj){
        this.target = obj;
        this.found = null;
      }
  
      public void visit(Object obj){
        if(!isDone() && obj.equals(target))
          found = obj;
      }
  
      public boolean isDone(){
        return found != null;
      }
  
  }
  
  
  