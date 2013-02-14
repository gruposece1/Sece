package br.unb.sece.util;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.TreeSet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gustavo
 */
public class Pesquisa extends javax.swing.JFrame {
    //constante para identificar a ordem crescente
    public final char K_ORDEM_CRESCENTE = 'C';
    //constante para identificar a ordem decrescente
    public final char K_ORDEM_DECRESCENTE = 'D';
    
    //objeto que sera retornado apos a busca
    private Object retorno;
    //atributo para armazenar a ordem;
    private char ordem = K_ORDEM_CRESCENTE;
    //atributo para armazena a tabela
    private Object[][] dadosTabela;
    //atributo para armazenar os dados da busca
    private Object[][] dadosPesquisa;
    //titulos da tabela
    private Object[] titulos;
    //campo que é considerado na ordenacao
    private String campoOrdenacao = "";
    
    /**
     * Creates new form Teste
     */
    public Pesquisa(Collection lista,Map camposTabela) {
        //this.camposTabela = camposTabela;
        //this.lista = lista;
        initComponents();
        this.dadosTabela = this.dados(lista, camposTabela);
        this.titulos = this.titulos(camposTabela);
        this.dadosTabela = this.ordenarDados();
        this.dados.setModel(new javax.swing.table.DefaultTableModel(this.dadosTabela,this.titulos));
    }
    
    /**
     * Creates new form Teste
     */
    public Pesquisa(Collection lista,Collection camposTabela) {
        //this.camposTabela = camposTabela;
        //this.lista = lista;
        initComponents();
        this.dadosTabela = this.dados(lista, camposTabela);
        this.titulos = this.titulos(camposTabela);
        this.dadosTabela = this.ordenarDados();
        this.dados.setModel(new javax.swing.table.DefaultTableModel(this.dadosTabela,this.titulos));
    }
    
    private void pesquisar(String busca){
        Object[][] c = null;
        int campoPesquisa = 0;
        ArrayList pesquisa = new ArrayList();
        if(this.titulos.length > 0 && !this.campoOrdenacao.isEmpty()){
            for(int i= 0; i < this.titulos.length; i++){
                if(this.campoOrdenacao.equals(this.titulos[i])){
                    campoPesquisa = i;
                    break;
                }
            }
        } 
        for(Object[] d : this.dadosTabela){
            String ob =(String) d[campoPesquisa];
            if(ob.contentEquals(busca)){
                pesquisa.add(d);
            }
        }
        Iterator iterator = pesquisa.iterator();
        int i = 0;
        while(iterator.hasNext()){
            c[i] = (Object[]) iterator.next();
        }
        this.dados.setModel(new javax.swing.table.DefaultTableModel(c,this.titulos));
    }

    public String getCampoOrdenacao() {
        return campoOrdenacao;
    }

    public void setCampoOrdenacao(String campoOrdenacao) {
        this.campoOrdenacao = campoOrdenacao;
        this.dadosTabela = this.ordenarDados();
        this.dados.setModel(new javax.swing.table.DefaultTableModel(this.dadosTabela,this.titulos));
    }

    public char getOrdem() {
        return ordem;
    }

    public void setOrdem(char ordem) {
        this.ordem = ordem;
        this.dadosTabela = this.ordenarDados();
        this.dados.setModel(new javax.swing.table.DefaultTableModel(this.dadosTabela,this.titulos));
    }
    
    
    //ordenacao dos dados
    private Object[][] ordenarDados(){
        int campoOrdenar = 0;
        if(this.titulos.length > 0 && !this.campoOrdenacao.isEmpty()){
            for(int i= 0; i < this.titulos.length; i++){
                if(this.campoOrdenacao.equals(this.titulos[i])){
                    campoOrdenar = i;
                    break;
                }
            }
        }
        ArrayList ordenar = new ArrayList();
        for(Object[] d : this.dadosTabela ){
            int i = 0;
            for(Object b: d){
                if(i == campoOrdenar){
                    ordenar.add(b);
                }
                i++;
            }
        }
        if(this.ordem == this.K_ORDEM_CRESCENTE){
            Collections.sort(ordenar); 
        }else if(this.ordem == this.K_ORDEM_DECRESCENTE){
            Collections.sort(ordenar);
            ArrayList ordenarNovo = new ArrayList();
            for(int i = ordenar.size() - 1;i >= 0; i--){
                ordenarNovo.add(ordenar.get(i));
            }
            ordenar = ordenarNovo;
        }
        Object[][] ordenado = new Object[this.dadosTabela.length][0];
        for(int i = 0; i < ordenar.size();i++){
            Object or = ordenar.get(i);
            int j = 0;
            for(Object[] d : this.dadosTabela ){
                if(d != null){
                    Object ob = d[campoOrdenar];
                    if(ob.equals(or)){
                        ordenado[i] = d;
                        this.dadosTabela[j] = null;
                        break;

                    }
                }
                j++;
            }
            
        }
        
        return ordenado;
        
    }
   //titulos
    private Object[] titulos(Collection camposTabela){
        Object[] titulos = null;
        if(camposTabela.size() > 0){
            //contador
            int i = 0;
            //array de Object com os titulos
            titulos = new Object[camposTabela.size()];
            
            
             Iterator iColunas = camposTabela.iterator();
             //while para resgatar as chaves
             while(iColunas.hasNext()){
                 ColunaPesquisa cP = (ColunaPesquisa)iColunas.next();
                 titulos[i] = cP.getColuna();
                 i++;
             }
        }
        
        return titulos;
    }
    //titulos
    private Object[] titulos(Map camposTabela){
        Object[] titulos = null;
        if(camposTabela.size() > 0){
            //contador
            int i = 0;
            //array de Object com os titulos
            titulos = new Object[camposTabela.size()];
            //chaves do map
             Set setColunas = camposTabela.keySet();
             TreeSet<String> t = new TreeSet<String>(setColunas);
            Object[] teste = setColunas.toArray();
             //iterator para as chaves
             Iterator iColunas = setColunas.iterator();
             //while para resgatar as chaves
             while(iColunas.hasNext()){
                 titulos[i] = (String)iColunas.next();
                 i++;
             }
        }
        
        return titulos;
    }
   
     private Object[][] dados(Collection lista,Map camposTabela){
        Object[][] dado = null;
        if(camposTabela.size() > 0 && lista.size() > 0){
            int linhas = 0,cols = 0;
             dado = new Object [lista.size()][camposTabela.size() + 1];
            
            //Object[] colunas = new Object[camposTabela.size()];
            Iterator i = lista.iterator();
            while(i.hasNext()){
                Object o = i.next();
                Set setColunas = camposTabela.keySet();
                Iterator iColunas = setColunas.iterator();
                cols = 0;
                while(iColunas.hasNext()){
                    String metodo = (String)camposTabela.get(iColunas.next());
                    try {
                        Class classe = o.getClass();
                        Method[] todos = classe.getMethods();
                        Method m = classe.getDeclaredMethod(metodo, null);
                        Object[] args = null ;
                        dado[linhas][cols] = m.invoke(o, args);
                        
                    } catch (Exception ex) {
                        dado[linhas][cols] = " ";
                    }
                    cols++;
                    
                }
                 dado[linhas][cols] = o;
                linhas++;
            }
        }
        
        return dado;
    }
    //retornar os dados da tabela a partir de duas listas 
     private Object[][] dados(Collection lista,Collection camposTabela){
        Object[][] dado = null;
        if(camposTabela.size() > 0 && lista.size() > 0){
            int linhas = 0,cols = 0;
             dado = new Object [lista.size()][camposTabela.size() + 1];
            
            Iterator i = lista.iterator();
            while(i.hasNext()){
                Object o = i.next();
                Iterator iColunas = camposTabela.iterator();
                cols = 0;
                while(iColunas.hasNext()){
                    ColunaPesquisa cP = (ColunaPesquisa)iColunas.next();
                    String metodo = cP.getMetodo();
                    try {
                        Class classe = o.getClass();
                        Method[] todos = classe.getMethods();
                        //Method m = classe.getDeclaredMethod(metodo, null);
                        Method m = this.getMetodo(todos, metodo);
                        Object[] args = null ;
                        dado[linhas][cols] = m.invoke(o, args);
                        
                    } catch (Exception ex) {
                        dado[linhas][cols] = " ";
                        ex.printStackTrace();
                    }
                    cols++;
                    
                }
                 dado[linhas][cols] = o;
                linhas++;
            }
        }
        
        return dado;
    }
     
     private Method getMetodo(Method[] todosMetodosDaClasse,String metodoBusca){
    	 Method metodoARetornar = null;
    	 for(Method metodo : todosMetodosDaClasse){
    		 if(metodo.getName().equals(metodoBusca)){
    			 metodoARetornar = metodo;
    		 }
    	 }
    	 return metodoARetornar;
     }
   
    public Object getRetorno() {
        return retorno;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        dados = new javax.swing.JTable();
        btnOK = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnOrdemDecrescente = new javax.swing.JButton();
        btnOrdemCrescente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        dados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Título 1", "Título 2", "Título 3"
            }
        ));
        jScrollPane1.setViewportView(dados);

        btnOK.setLabel("OK");
        btnOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOKMouseClicked(evt);
            }
        });

        jButton2.setLabel("Fechar");

       // btnOrdemDecrescente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1354368855_stock_sort-descending.png"))); // NOI18N
        btnOrdemDecrescente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrdemDecrescenteMouseClicked(evt);
            }
        });

       // btnOrdemCrescente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1354368867_stock_sort-ascending.png"))); // NOI18N
        btnOrdemCrescente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrdemCrescenteMouseClicked(evt);
            }
        });

        jLabel1.setText("Pesquisar por:");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOK)
                        .addGap(5, 5, 5)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnOrdemCrescente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOrdemDecrescente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnOrdemDecrescente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnOrdemCrescente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        btnOK.getAccessibleContext().setAccessibleName("btnOK");
        jButton2.getAccessibleContext().setAccessibleName("btnFechar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdemCrescenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdemCrescenteMouseClicked
        // TODO add your handling code here:
        this.setOrdem(this.K_ORDEM_CRESCENTE);
    }//GEN-LAST:event_btnOrdemCrescenteMouseClicked

    private void btnOrdemDecrescenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdemDecrescenteMouseClicked
        // TODO add your handling code here:
        this.setOrdem(this.K_ORDEM_DECRESCENTE);
    }//GEN-LAST:event_btnOrdemDecrescenteMouseClicked

    private void btnOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOKMouseClicked
        // TODO add your handling code here:
        if(this.dados.getSelectedRow() != -1){
            Object[] ob = this.dadosTabela[this.dados.getSelectedRow()];
            Object obj = ob[ob.length-1];
            this.retorno = obj;
            this.setVisible(false);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(rootPane, "É necessário selecionar uma linha!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnOKMouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        if(this.jTextField1.getText().isEmpty()){
            this.dadosTabela = this.ordenarDados();
            this.dados.setModel(new javax.swing.table.DefaultTableModel(this.dadosTabela,this.titulos));
        }else{
            String busca = this.jTextField1.getText();
            this.pesquisar(busca);
        }
    }//GEN-LAST:event_jTextField1KeyReleased

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnOrdemCrescente;
    private javax.swing.JButton btnOrdemDecrescente;
    private javax.swing.JTable dados;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
