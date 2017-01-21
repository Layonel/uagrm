import javax.swing.JTextArea;
import javax.swing.JOptionPane;

class Arbol
 {
        private Nodo raiz;

        public Arbol() {
           raiz = null;
        }
        private boolean esHoja(Nodo pr) {
            return pr.getHI() == null && pr.getHD() == null;
        }     

        public void insertar(int x)
        {
            Nodo q = new Nodo(x);
            if (raiz == null){
                raiz = q;
                return;
            }
            Nodo pr=raiz; 
            Nodo ant=null;
            while (pr != null){
                ant=pr;
                if (x < pr.getElem())
                    pr = pr.getHI();
                else
                    if (x > pr.getElem())
                       pr = pr.getHD();
                    else
                        return ;
            }
            if (x < ant.getElem())
                ant.setHI(q);
            else
                ant.setHD(q);
        }
        
             
        

        private void preOrden(Nodo pr,JTextArea rt)
        {
            if (pr != null) {
                rt.append( String.valueOf(pr.getElem() + "  ") );
                preOrden(pr.getHI(),rt);
                preOrden(pr.getHD(),rt);
            }
        }

        public void preOrden(JTextArea rt) {
            preOrden(raiz,rt);
        }

        private void InOrden(Nodo pr, JTextArea rt)
        {
            if (pr != null)  {
                InOrden(pr.getHI(),rt);
                rt.append(String.valueOf(pr.getElem() + "  "));
                InOrden(pr.getHD(),rt);
            }
        }

        public void InOrden(JTextArea rt)
        {
            InOrden(raiz,rt);
        }

        private void PostOrden(Nodo pr, JTextArea rt)
        {
            if (pr != null)
            {
                PostOrden(pr.getHI(),rt);
                PostOrden(pr.getHD(),rt);
                rt.append(String.valueOf(pr.getElem() + "  "));
            }
        }

        public void PostOrden(JTextArea rt)
        {
           PostOrden(raiz,rt);
        }
        public void nietosArbol(int x, JTextArea jta){
            jta.setText("");
            if (raiz==null){
                JOptionPane.showMessageDialog(null,"No tiene nietos");
                return ;
            }
            if (esHoja(raiz)){
                 JOptionPane.showMessageDialog(null,"No tiene nietos");
                return ;
            }
            Nodo aux = raiz;
            while (aux.getElem()!=x){
                aux=x<aux.getElem()?aux.getHI():aux.getHD();
                if (aux==null){
                    JOptionPane.showMessageDialog(null,"El Elemento no existe");
                    return ;
                }
            }
            if (!esHoja(aux)){
            if (aux.getHI()!=null){
            if (aux.getHI().getHI()!=null){
                jta.setText(jta.getText()+" "+String.valueOf(aux.getHI().getHI().getElem())+ " ");
            }
            if (aux.getHI().getHD()!=null){
                jta.setText(jta.getText()+" "+String.valueOf(aux.getHI().getHD().getElem())+ " ");
            }
            }
            if (aux.getHD()!=null){
            if (aux.getHD().getHI()!=null){
                jta.setText(jta.getText()+" "+String.valueOf(aux.getHD().getHI().getElem())+" ");
            }
            if (aux.getHD().getHD()!=null){
                jta.setText(jta.getText()+" "+String.valueOf(aux.getHD().getHD().getElem())+" ");
            }
            }
            if (jta.getText().length()<2){
                JOptionPane.showMessageDialog(null,"No tiene nietos");
            }
            }else JOptionPane.showMessageDialog(null,"No tiene nietos");
            return ;
        }//end nietos
       private int altura(Nodo p){
           if (p==null) return 0;
           if (esHoja(p)) return 1;
           int ai=altura(p.getHI());
           int ad=altura(p.getHD());
           if (ai>ad) return ai+1; else return ad+1;
       }
       public int altura(){
           return altura(raiz);
       }
       private int cant(Nodo p){
           if (p==null) return 0;
           if (esHoja(p)) return 1;
           int ai=cant(p.getHI());
           int ad=cant(p.getHD());
           return ai+ad+1;
           
       }
       public int cant(){
           return cant(raiz);
       }
       public boolean iguales(Arbol a){
           Nodo aux = a.raiz, aux2=raiz;
          boolean b;
          if (altura()!=a.altura()){
              return false;
          }
          if (cant()!=a.cant()){
              return false;
          }
           b = dentro(raiz,a)==cant();
           if (b==false) return false;
           return true;
       }
        private int dentro(Nodo p, Arbol a){
           if (p==null) return 0;
           if (esHoja(p)) return a.existe(p.getElem())?1:0;
//           boolean ai=dentro(p.getHI(),a);
//           boolean ad=dentro(p.getHD(),a);
//           return a.existe(p.getElem());
           int ai=dentro(p.getHI(),a);
           int ad=dentro(p.getHD(),a);
           if (a.existe(p.getElem())){
               return ai+ad+1;
           }else{
               return ai+ad;
           }
}
       public boolean existe(int x){
           Nodo aux = raiz;
            while (aux.getElem()!=x){
                aux=x<aux.getElem()?aux.getHI():aux.getHD();
                if (aux==null){
                    return false;
                }
            }
            return true;
       }
       
//        public boolean sonIguales(Arbol a2){
//            Nodo aux= a2.raiz,aux2=raiz;
//            
//        }
  }//end class


        