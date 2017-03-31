package cn.edu.upc.yb.integrate.speaktoteacher.model;



import javax.persistence.*;
import java.util.Date;

/**
 * Created by wanghaojun on 2017/3/29.
 */
@Entity
@Table(name = "Stt_Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String content;
    private int yibanId;
    private Date createTime;
    private String reply;
    private Date replyTime;
    private int teacherId;

    public Message(String content, int yibanId, Date createTime, String reply, Date replyTime, int teacherId) {
        this.content = content;
        this.yibanId = yibanId;
        this.createTime = createTime;
        this.reply = reply;
        this.replyTime = replyTime;
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getYibanId() {
        return yibanId;
    }

    public void setYibanId(int yibanId) {
        this.yibanId = yibanId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }
}
