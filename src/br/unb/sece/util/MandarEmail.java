
package br.unb.sece.util;

import java.net.MalformedURLException;  
import java.net.URL;  
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
  
import org.apache.commons.mail.EmailAttachment;  
import org.apache.commons.mail.EmailException;  
import org.apache.commons.mail.HtmlEmail;  
import org.apache.commons.mail.MultiPartEmail;  
import org.apache.commons.mail.SimpleEmail;  

import br.unb.sece.model.Aluno;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Responsavel;
  
public class MandarEmail { 
	
	private String e_mail, destinatario,nomeAluno;
	private Aluno aluno;
	private Responsavel responsavael;
	private Calendar data;
	private Disciplina disciplina;
      
    public MandarEmail(String e_mail, String destinatario, String nomeAluno) throws EmailException, MalformedURLException {  
        this.e_mail = e_mail;
        this.destinatario = destinatario;
        this.nomeAluno = nomeAluno;
        enviaEmailSimples();  
        //enviaEmailComAnexo();  
        //enviaEmailFormatoHtml();  
    }  
    
    public MandarEmail(Aluno aluno, Responsavel responsavel, Disciplina disciplina, Calendar data) throws EmailException, MalformedURLException {  
        this.e_mail = responsavel.getEmail();
        this.destinatario = "Grupo SECE";
        this.aluno = aluno;
        this.data = data;
        this.responsavael = responsavel;
        this.data = data;
        this.disciplina = disciplina;
        enviaEmailSimples();  
        //enviaEmailComAnexo();  
        //enviaEmailFormatoHtml();  
    }  
      
    /** 
     * envia email simples(somente texto) 
     * @throws EmailException 
     */  
    public void enviaEmailSimples() throws EmailException {  
          
        SimpleEmail email = new SimpleEmail();  
        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail  
        email.addTo(this.e_mail, destinatario);
       //destinatário  
        email.setFrom("gruposece@gmail.com", "SECE"); // remetente  
        email.setSubject("Aviso de ausência escolar"); // assunto do e-mail  
        email.setMsg(this.getMensagem()); //conteudo do e-mail  
        email.setAuthentication("gruposece@gmail.com", "gppmds2012");  
        email.setSmtpPort(465);  
        email.setSSL(true);  
        email.setTLS(true);  
        email.send();     
    }  
    
    public String getMensagem(){
    	SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    	Date data = this.data.getTime();
    	String texto =
    			this.responsavael.getPronomeTratamento()+this.responsavael.getNome()+", o "+this.aluno.getPronomePossessivo()+" filho(a) "+ this.aluno.getNome()+
    			" não esteve presente na aula do dia: "+formatador.format(data) + "  da displina de: "+this.disciplina.getNome()+". \nAtt, Grupo Sece. ";
    	return texto;
    }
      
      
    /** 
     * envia email com arquivo anexo 
     * @throws EmailException 
     */  
    public void enviaEmailComAnexo() throws EmailException{  
          
        // cria o anexo 1.  
        EmailAttachment anexo1 = new EmailAttachment();  
        anexo1.setPath("teste/teste.txt"); //caminho do arquivo (RAIZ_PROJETO/teste/teste.txt)  
        anexo1.setDisposition(EmailAttachment.ATTACHMENT);  
        anexo1.setDescription("Exemplo de arquivo anexo");  
        anexo1.setName("teste.txt");          
          
        // cria o anexo 2.  
        EmailAttachment anexo2 = new EmailAttachment();  
        anexo2.setPath("teste/teste2.jsp"); //caminho do arquivo (RAIZ_PROJETO/teste/teste2.jsp)  
        anexo2.setDisposition(EmailAttachment.ATTACHMENT);  
        anexo2.setDescription("Exemplo de arquivo anexo");  
        anexo2.setName("teste2.jsp");         
          
        // configura o email  
        MultiPartEmail email = new MultiPartEmail();  
        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail  
        email.addTo("teste@gmail.com", "Guilherme"); //destinatário  
        email.setFrom("teste@gmail.com", "Eu"); // remetente  
        email.setSubject("Teste -> Email com anexos"); // assunto do e-mail  
        email.setMsg("Teste de Email utilizando commons-email"); //conteudo do e-mail  
        email.setAuthentication("teste", "xxxxx");  
        email.setSmtpPort(465);  
        email.setSSL(true);  
        email.setTLS(true);  
          
        // adiciona arquivo(s) anexo(s)  
        email.attach(anexo1);  
        email.attach(anexo2);  
        // envia o email  
        email.send();  
    }  
      
      
    /** 
     * Envia email no formato HTML 
     * @throws EmailException  
     * @throws MalformedURLException  
     */  
    public void enviaEmailFormatoHtml() throws EmailException, MalformedURLException {  
          
        HtmlEmail email = new HtmlEmail();  
          
        // adiciona uma imagem ao corpo da mensagem e retorna seu id  
        URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");  
        String cid = email.embed(url, "Apache logo");     
          
        // configura a mensagem para o formato HTML  
        email.setHtmlMsg("<html>Logo do Apache - <img ></html>");  
  
        // configure uma mensagem alternativa caso o servidor não suporte HTML  
        email.setTextMsg("Seu servidor de e-mail não suporta mensagem HTML");  
          
        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail  
        email.addTo("teste@gmail.com", "Guilherme"); //destinatário  
        email.setFrom("teste@gmail.com", "Eu"); // remetente  
        email.setSubject("Teste -> Html Email"); // assunto do e-mail  
        email.setMsg("Teste de Email HTML utilizando commons-email"); //conteudo do e-mail  
        email.setAuthentication("teste", "xxxxx");  
        email.setSmtpPort(465);  
        email.setSSL(true);  
        email.setTLS(true);  
        // envia email  
        email.send();  
    }  
      
      
    /** 
     * @param args 
     * @throws EmailException  
     * @throws MalformedURLException  
     */  
   /* public static void main(String[] args) throws EmailException, MalformedURLException {  
        new MandarEmail();  
    }  */
  

}  