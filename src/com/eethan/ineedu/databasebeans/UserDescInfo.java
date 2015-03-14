package com.eethan.ineedu.databasebeans;

public class UserDescInfo {
	
	public int id;
	public int userId;
	public String diploma;
	public String description;
	public String emotion;
	public String birthday;
	public String hometown;
	public String  likefood;
	public String likeplace;
	public String likegift;
	public String likefilm;
	public String likemusic;
	public String likebook;
	
	public UserDescInfo(){}
	public UserDescInfo(int id, int userId,String diploma, String description, String emotion,
			String birthday, String hometown, String likefood,
			String likeplace, String likegift, String likefilm,
			String likemusic, String likebook) {
		super();
		this.id = id;
		this.userId = userId;
		this.diploma = diploma;
		this.description = description;
		this.emotion = emotion;
		this.birthday = birthday;
		this.hometown = hometown;
		this.likefood = likefood;
		this.likeplace = likeplace;
		this.likegift = likegift;
		this.likefilm = likefilm;
		this.likemusic = likemusic;
		this.likebook = likebook;
	}
	public String getDiploma() {
		return diploma;
	}
	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmotion() {
		return emotion;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getLikefood() {
		return likefood;
	}
	public void setLikefood(String likefood) {
		this.likefood = likefood;
	}
	public String getLikeplace() {
		return likeplace;
	}
	public void setLikeplace(String likeplace) {
		this.likeplace = likeplace;
	}
	public String getLikegift() {
		return likegift;
	}
	public void setLikegift(String likegift) {
		this.likegift = likegift;
	}
	public String getLikefilm() {
		return likefilm;
	}
	public void setLikefilm(String likefilm) {
		this.likefilm = likefilm;
	}
	public String getLikemusic() {
		return likemusic;
	}
	public void setLikemusic(String likemusic) {
		this.likemusic = likemusic;
	}
	public String getLikebook() {
		return likebook;
	}
	public void setLikebook(String likebook) {
		this.likebook = likebook;
	}

}
