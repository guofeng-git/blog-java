package com.sjf.form;
import java.io.Serializable;

import org.apache.ibatis.type.Alias;
/**
 * */
@Alias("storage")
public class Storage  implements Serializable {
	
	private String articleId;
	
	private String title;
	
	private String topic;
	
	private String createTime;
	
	private String updateTime;
	
	private String createUser;
	
	private String classify;
	
	private String content;
	
	private Storage me;
	public Storage getMe() {
		return me;
	}
	public void setMe(Storage me) {
		this.me = me;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
