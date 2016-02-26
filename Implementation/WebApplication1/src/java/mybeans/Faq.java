/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;

/**
 *
 * @author shashi
 */
public class Faq {
    
    private String faqID;
    private String question;
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getFaqID() {
        return faqID;
    }

    public void setFaqID(String faqID) {
        this.faqID = faqID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    
}
