package com.eethan.ineedu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.security.InvalidKeyException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.eethan.ineedu.constant.Constant;
import com.eethan.ineedu.constant.MatchCondition;
import com.eethan.ineedu.constant.NotificationType;
import com.eethan.ineedu.constant.UserFlag;
import com.eethan.ineedu.databasebeans.Album;
import com.eethan.ineedu.databasebeans.City;
import com.eethan.ineedu.databasebeans.College;
import com.eethan.ineedu.databasebeans.Contact;
import com.eethan.ineedu.databasebeans.FlowerFan;
import com.eethan.ineedu.databasebeans.LovePopularityIncrease;
import com.eethan.ineedu.databasebeans.Molest;
import com.eethan.ineedu.databasebeans.Mood;
import com.eethan.ineedu.databasebeans.MoodComment;
import com.eethan.ineedu.databasebeans.Need;
import com.eethan.ineedu.databasebeans.NeedComment;
import com.eethan.ineedu.databasebeans.NeedReport;
import com.eethan.ineedu.databasebeans.Notification;
import com.eethan.ineedu.databasebeans.Plays;
import com.eethan.ineedu.databasebeans.PlaysComment;
import com.eethan.ineedu.databasebeans.PlaysParticipant;
import com.eethan.ineedu.databasebeans.PourListenNoSex;
import com.eethan.ineedu.databasebeans.Pourlisten;
import com.eethan.ineedu.databasebeans.PourlistenComment;
import com.eethan.ineedu.databasebeans.Province;
import com.eethan.ineedu.databasebeans.School;
import com.eethan.ineedu.databasebeans.TakePhotos;
import com.eethan.ineedu.databasebeans.TakePhotosComment;
import com.eethan.ineedu.databasebeans.TakePhotosPraise;
import com.eethan.ineedu.databasebeans.User;
import com.eethan.ineedu.databasebeans.UserDescInfo;
import com.eethan.ineedu.databasebeans.UserDetailInfo;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.databasebeans.UserLocation;
import com.eethan.ineedu.databasebeans.WakeUp;
import com.eethan.ineedu.databasebeans.Wish;
import com.eethan.ineedu.databasebeans.WishComment;
import com.eethan.ineedu.databasebeans.WishFlower;
import com.eethan.ineedu.databasebeans.WishPicker;
import com.eethan.ineedu.databasebeans.WishWithWannaNum;
import com.eethan.ineedu.databasedao.AlbumDAO;
import com.eethan.ineedu.databasedao.CityDAO;
import com.eethan.ineedu.databasedao.CollegeDAO;
import com.eethan.ineedu.databasedao.ContactDAO;
import com.eethan.ineedu.databasedao.FlowerFansDAO;
import com.eethan.ineedu.databasedao.LovePopularityIncreaseDAO;
import com.eethan.ineedu.databasedao.MolestDAO;
import com.eethan.ineedu.databasedao.MoodCommentDAO;
import com.eethan.ineedu.databasedao.MoodDAO;
import com.eethan.ineedu.databasedao.NeedCommentDAO;
import com.eethan.ineedu.databasedao.NeedDAO;
import com.eethan.ineedu.databasedao.NeedReportDAO;
import com.eethan.ineedu.databasedao.NotificationDAO;
import com.eethan.ineedu.databasedao.PlaysCommentDAO;
import com.eethan.ineedu.databasedao.PlaysDAO;
import com.eethan.ineedu.databasedao.PlaysParticipantDAO;
import com.eethan.ineedu.databasedao.PourlistenCommentDAO;
import com.eethan.ineedu.databasedao.PourlistenDAO;
import com.eethan.ineedu.databasedao.ProvinceDAO;
import com.eethan.ineedu.databasedao.SchoolDAO;
import com.eethan.ineedu.databasedao.TakePhotosCommentDAO;
import com.eethan.ineedu.databasedao.TakePhotosDAO;
import com.eethan.ineedu.databasedao.TakePhotosPraiseDAO;
import com.eethan.ineedu.databasedao.UserDAO;
import com.eethan.ineedu.databasedao.UserDescInfoDAO;
import com.eethan.ineedu.databasedao.UserDetailInfoDAO;
import com.eethan.ineedu.databasedao.UserInfoDAO;
import com.eethan.ineedu.databasedao.UserLocationDAO;
import com.eethan.ineedu.databasedao.WakeUpDAO;
import com.eethan.ineedu.databasedao.WishCommentDAO;
import com.eethan.ineedu.databasedao.WishDAO;
import com.eethan.ineedu.databasedao.WishFlowerDAO;
import com.eethan.ineedu.databasedao.WishPickersDao;
import com.eethan.ineedu.encrypt.RsaKey;
import com.eethan.ineedu.jackson.AllNotificationsJsonObject;
import com.eethan.ineedu.jackson.ContactsJsonObject;
import com.eethan.ineedu.jackson.DetailMoodJsonObject;
import com.eethan.ineedu.jackson.DetailNeedJsonObject;
import com.eethan.ineedu.jackson.DetailPhotosJsonObject;
import com.eethan.ineedu.jackson.DetailPlaysJsonObject;
import com.eethan.ineedu.jackson.DetailPourlistenJsonObject;
import com.eethan.ineedu.jackson.DetailWishJsonObject;
import com.eethan.ineedu.jackson.FlowerFansJsonObject;
import com.eethan.ineedu.jackson.JacksonUtil;
import com.eethan.ineedu.jackson.JsonObject;
import com.eethan.ineedu.jackson.LoginJsonObject;
import com.eethan.ineedu.jackson.MolestJsonObject;
import com.eethan.ineedu.jackson.NearUserJsonObject;
import com.eethan.ineedu.jackson.NotificationJsonObject;
import com.eethan.ineedu.jackson.ProCityColSchJsonObject;
import com.eethan.ineedu.jackson.RankJsonObject;
import com.eethan.ineedu.jackson.RefreshMoodJsonObject;
import com.eethan.ineedu.jackson.RefreshNeedJsonObject;
import com.eethan.ineedu.jackson.RefreshPhotosJsonObject;
import com.eethan.ineedu.jackson.RefreshPlaysJsonObject;
import com.eethan.ineedu.jackson.RefreshPourlistenJsonObject;
import com.eethan.ineedu.jackson.RefreshWishJsonObject;
import com.eethan.ineedu.jackson.RegisterJsonObject;
import com.eethan.ineedu.jackson.SearchUserJsonObject;
import com.eethan.ineedu.jackson.StringArrayJsonObject;
import com.eethan.ineedu.jackson.UserDetailJsonObject;
import com.eethan.ineedu.jackson.WakeUpJsonObject;
import com.eethan.ineedu.jackson.WakeUpMatchJsonObject;
import com.eethan.ineedu.util.WebImageSaver;
import com.opensymphony.xwork2.ActionSupport;

public class Action extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String data;
	public boolean isEncrypt;// 接受的数据时候被加密(兼容新老版本)

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	private ProvinceDAO provinceDAO = new ProvinceDAO();
	private CityDAO cityDAO = new CityDAO();
	private CollegeDAO collegeDAO = new CollegeDAO();
	private SchoolDAO schoolDAO = new SchoolDAO();

	private UserDAO userDAO = new UserDAO();
	private UserInfoDAO userInfoDAO = new UserInfoDAO();
	private UserDetailInfoDAO userDetailInfoDAO = new UserDetailInfoDAO();
	private UserLocationDAO userLocationDAO = new UserLocationDAO();
	private NeedDAO needDAO = new NeedDAO();
	private NeedCommentDAO needCommentDAO = new NeedCommentDAO();
	private NeedReportDAO needReportDAO = new NeedReportDAO();
	private NotificationDAO notificationDAO = new NotificationDAO();
	private PourlistenDAO pourlistenDAO = new PourlistenDAO();
	private MoodDAO moodDAO = new MoodDAO();
	private PourlistenCommentDAO pourlistenCommentDAO = new PourlistenCommentDAO();
	private LovePopularityIncreaseDAO lovePopularityIncreaseDAO = new LovePopularityIncreaseDAO();
	private PlaysDAO playsDAO = new PlaysDAO();
	private PlaysCommentDAO playsCommentDAO = new PlaysCommentDAO();
	private PlaysParticipantDAO playsParticipantDAO = new PlaysParticipantDAO();
	private TakePhotosDAO takePhotosDAO = new TakePhotosDAO();
	private TakePhotosCommentDAO takePhotosCommentDAO = new TakePhotosCommentDAO();
	private MoodCommentDAO moodCommentDAO = new MoodCommentDAO();
	private TakePhotosPraiseDAO takePhotosPraiseDAO = new TakePhotosPraiseDAO();
	private WishDAO wishDAO = new WishDAO();
	private WishPickersDao wishPickersDao = new WishPickersDao();
	private WishCommentDAO wishCommentDAO = new WishCommentDAO();
	private WishFlowerDAO wishFlowerDAO = new WishFlowerDAO();
	private WakeUpDAO wakeUpDAO = new WakeUpDAO();
	private ContactDAO contactDAO = new ContactDAO();
	private AlbumDAO albumDAO = new AlbumDAO();
	private UserDescInfoDAO userDescInfoDAO = new UserDescInfoDAO();
	private MolestDAO molestDAO = new MolestDAO();

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void test() {

	}

	/**
	 * 响应操作:用户登录
	 */
	static int count = 0;

	public void login() throws InvalidKeyException, Exception {
		System.out.println("开始登录");
		count++;
		long time1 = new Date().getTime();
		getClientData();
		System.out.println("");
		User user = JacksonUtil.json().fromJsonToObject(data, User.class);

		UserInfo userInfo = new UserInfo();
		LoginJsonObject loginJsonObject = new LoginJsonObject();

		List<User> check;
		check = userDAO.findByProperty(UserDAO.TELE, user.getTele());
		if (check.size() == 0)
			check = userDAO.findByProperty(UserDAO.EMAIL, user.getEmail());

		if (check.size() != 0
				&& check.get(0).getPassword().equals(user.getPassword())) {
			user = check.get(0);
			userInfo = userInfoDAO.findByProperty(UserInfoDAO.USERID,
					check.get(0).getId()).get(0);
			loginJsonObject.setUser(user);
			loginJsonObject.setUserInfo(userInfo);
			loginJsonObject.setResult(true);

			long time = new Date().getTime() - time1;
			System.out.println("登录" + count + "用时" + time + "ms");
		} else {
			loginJsonObject.setResult(false);
			System.out.println("登录失败");
		}

		outToClient(loginJsonObject);
	}

	public void getProCityCoSchool() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int flag = jsonObject.getInt1();
		int id = jsonObject.getInt2();
		switch (flag) {
		case Constant.GET_PROVINCE:
			try {
				List<Province> resList = provinceDAO.exeRawQuery("");
				outToClient(new ProCityColSchJsonObject(resList, null, null,
						null));
			} catch (Exception e) {
				outToClient(null);
			}
			break;
		case Constant.GET_CITY:
			try {
				List<City> resList = cityDAO.findByProperty(CityDAO.PROVINCEID,
						id);
				outToClient(new ProCityColSchJsonObject(null, resList, null,
						null));
			} catch (Exception e) {
				outToClient(null);
			}
			break;
		case Constant.GET_COLLEGE:
			try {
				List<College> resList = collegeDAO.findByProperty(
						CollegeDAO.PROVINCEID, id);
				outToClient(new ProCityColSchJsonObject(null, null, resList,
						null));
			} catch (Exception e) {
				outToClient(null);
			}
			break;
		case Constant.GET_SCHOOL:
			try {
				List<School> resList = schoolDAO.findByProperty(
						SchoolDAO.COLLEGEID, id);
				outToClient(new ProCityColSchJsonObject(null, null, null,
						resList));
			} catch (Exception e) {
				outToClient(null);
			}
			break;
		default:
			break;
		}
	}

	/**
	 * 响应操作:QQ登陆
	 */
	public void qqLogin() throws InvalidKeyException, Exception {

		getClientData();
		RegisterJsonObject registerJsonObject = JacksonUtil.json()
				.fromJsonToObject(data, RegisterJsonObject.class);
		User user = registerJsonObject.getUser();
		UserInfo userInfo = registerJsonObject.getUserInfo();
		UserDetailInfo userDetailInfo = registerJsonObject.getUserDetailInfo();
		UserLocation userLocation = registerJsonObject.getUserLocation();

		String uid = user.getUid();
		List<User> users = userDAO.findByProperty(UserDAO.UID, uid);

		boolean is_first = false;
		if (users.size() == 0)// 第一次使用QQ第三方登陆
		{
			// 保存信息
			is_first = true;
			userDAO.save(user);
			user = userDAO.findByProperty(UserDAO.UID, uid).get(0);
			userInfo.setUserId(user.getId());
			userDetailInfo.setUserId(user.getId());
			userLocation.setUserId(user.getId());
			userInfoDAO.save(userInfo);
			userDetailInfoDAO.save(userDetailInfo);
			userLocationDAO.save(userLocation);
			LovePopularityIncrease lovePopularityIncrease = new LovePopularityIncrease(
					-1, user.getId(), 0, 0, 0, 0);
			lovePopularityIncreaseDAO.save(lovePopularityIncrease);
		} else {
			// 更新信息
			user = (User) userDAO.findByProperty(UserDAO.UID, uid).get(0);
			userInfo.setUserId(user.getId());
			userDetailInfo.setUserId(user.getId());
			userLocation.setUserId(user.getId());
			userInfoDAO.update(userInfo);
			userDetailInfoDAO.update(userDetailInfo);
			userLocationDAO.update(userLocation);
		}
		users = userDAO.findByProperty(UserDAO.UID, uid);
		user = (User) users.get(0);
		final int userId = user.getId();
		final String imageUrl = user.getImageUrl();

		final String pathAndName = ServletActionContext.getServletContext()
				.getRealPath("/") + "head/head_big_" + userId + ".png";
		System.out.println("PathAndName:" + pathAndName);
		// 头像保存到服务器
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					WebImageSaver.save(imageUrl, pathAndName);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		userInfo.setUserId(user.getId());
		outToClient(new LoginJsonObject(user, userInfo, is_first));
	}

	/**
	 * 响应操作:用户注册
	 */
	public void register() {

		System.out.println("开始注册");
		getClientData();
		RegisterJsonObject registerJsonObject = JacksonUtil.json()
				.fromJsonToObject(data, RegisterJsonObject.class);
		User user = registerJsonObject.getUser();
		UserInfo userInfo = registerJsonObject.getUserInfo();
		UserDetailInfo userDetailInfo = registerJsonObject.getUserDetailInfo();
		UserLocation userLocation = registerJsonObject.getUserLocation();

		List<User> check1;
		List<User> check2;
		check1 = userDAO.findByProperty(UserDAO.TELE, user.getTele());
		check2 = userDAO.findByProperty(UserDAO.EMAIL, user.getEmail());

		if (check2.size() != 0 || check1.size() != 0) {
			return;
		}

		userDAO.save(user);

		user = userDAO.findByProperty(UserDAO.TELE, user.getTele()).get(0);
		userInfo.setUserId(user.getId());
		userDetailInfo.setUserId(user.getId());
		userLocation.setUserId(user.getId());
		userInfoDAO.save(userInfo);
		userDetailInfoDAO.save(userDetailInfo);
		userLocationDAO.save(userLocation);

		LovePopularityIncrease lovePopularityIncrease = new LovePopularityIncrease(
				-1, user.getId(), 0, 0, 0, 0);
		lovePopularityIncreaseDAO.save(lovePopularityIncrease);
		System.out.println("注册");

		outToClient(new LoginJsonObject(user, userInfo, true));

	}

	/**
	 * 响应操作:检查注册时的用户名是否可用
	 */
	public void checkRegister() {
		getClientData();
		User user = JacksonUtil.json().fromJsonToObject(data, User.class);

		List<User> check1;
		List<User> check2;
		check1 = userDAO.findByProperty(UserDAO.TELE, user.getTele());
		check2 = userDAO.findByProperty(UserDAO.EMAIL, user.getEmail());

		if (check2.size() != 0) {
			outToClient("emailRepetition");
		} else if (check1.size() != 0) {
			outToClient("phoneRepetition");
		} else {
			outToClient("checkPass");
		}
	}

	/**
	 * 响应操作:发布需求
	 */
	public void commitNeed() {
		getClientData();
		Need need = JacksonUtil.json().fromJsonToObject(data, Need.class);
		needDAO.save(need);
		outToClient(true);
		int needUserId = need.getUserId();
		System.out.println("发布Need成功");
		List<UserInfo> needusers = userInfoDAO.findByProperty("userId",
				needUserId);
		String needsex = "";
		if (needusers != null && needusers.size() == 1) {
			needsex = needusers.get(0).getSex();
		}
		if (needsex != null && needsex.equals("男")) {
			needsex = "女";
		} else if (needsex != null && needsex.equals("女")) {
			needsex = "男";
		} else
			needsex = "";
		List<Need> needs = needDAO.findByProperty("time", need.getTime());
		if (needs != null && needs.size() == 1) {
			List<UserInfo> userInfos = new ArrayList<UserInfo>();
			List<UserLocation> userLocations = new ArrayList<UserLocation>();
			userInfoDAO.getNearUser(need.getLng(), need.getLat(),
					need.getUserId(), 0, needsex, 3000, userInfos,
					userLocations);
			int num = userInfos.size();
			for (int i = 0; i < num; i++) {
				notificationDAO.save(new Notification(needs.get(0).getId(),
						need.getUserId(), userInfos.get(i).getUserId(), need
								.getTime(), NotificationType.NEED_NOTIFY_WAIT));
			}
			List<Notification> notifications = notificationDAO.findByProperty(
					"noticeFlag", -14);
			if (notifications != null) {
				for (int i = 0; i < notifications.size(); i++) {
					notificationDAO.delete(notifications.get(i));
				}
			}
		}

	}

	/**
	 * 响应操作:刷新附近需求
	 */
	public void refreshNeed() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		double lng = jsonObject.getDouble1();
		double lat = jsonObject.getDouble2();
		int type = jsonObject.getInt1();
		String sex = jsonObject.getString1();
		double distance = Double.parseDouble(jsonObject.getString2());

		List<Need> needs = needDAO.getNearNeed(lng, lat, type, sex, distance,
				0, 10, false);
		List<UserInfo> userInfos = getUserInfosFromNeeds(needs);
		List<UserInfo> solveUserInfos = getSolveUserInfosFromNeeds(needs);
		List<UserDetailInfo> userDetailInfos = getUserDetailInfosFromUserInfos(userInfos);
		int lastNum = 0;
		if (needs.size() > 0) {
			lastNum = needs.get(needs.size() - 1).getId();
		}

		RefreshNeedJsonObject refreshNeedJsonObject = new RefreshNeedJsonObject(
				needs, userInfos, solveUserInfos, userDetailInfos, lastNum);

		outToClient(refreshNeedJsonObject);
	}

	/**
	 * 响应操作:加载所有某人发布的需求
	 */
	public void getAllNeeds() {
		getClientData();
		int userId = JacksonUtil.json().fromJsonToObject(data, int.class);

		List<Need> allNeeds = needDAO.getAllNeeds(userId, 0, 10, false);
		List<UserInfo> userInfos = getUserInfosFromNeeds(allNeeds);
		List<UserInfo> solveUserInfos = getSolveUserInfosFromNeeds(allNeeds);
		List<UserDetailInfo> userDetailInfos = getUserDetailInfosFromUserInfos(userInfos);
		int lastNum = 0;
		if (allNeeds.size() > 0) {
			lastNum = allNeeds.get(allNeeds.size() - 1).getId();
		}
		RefreshNeedJsonObject refreshNeedJsonObject = new RefreshNeedJsonObject(
				allNeeds, userInfos, solveUserInfos, userDetailInfos, lastNum);

		outToClient(refreshNeedJsonObject);
	}

	/**
	 * 响应操作:加载更多附近需求
	 */
	public void getMoreNeed() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		double lng = jsonObject.getDouble1();
		double lat = jsonObject.getDouble2();
		int type = jsonObject.getInt1();
		String sex = jsonObject.getString1();
		double distance = Double.parseDouble(jsonObject.getString2());
		int start = jsonObject.getInt2();

		List<Need> needs = needDAO.getNearNeed(lng, lat, type, sex, distance,
				start, 10, true);
		List<UserInfo> userInfos = getUserInfosFromNeeds(needs);
		List<UserInfo> solveUserInfos = getSolveUserInfosFromNeeds(needs);
		List<UserDetailInfo> userDetailInfos = getUserDetailInfosFromUserInfos(userInfos);
		int lastNum = start;
		if (needs.size() > 0) {
			lastNum = needs.get(needs.size() - 1).getId();
		}
		RefreshNeedJsonObject refreshNeedJsonObject = new RefreshNeedJsonObject(
				needs, userInfos, solveUserInfos, userDetailInfos, lastNum);

		outToClient(refreshNeedJsonObject);
	}

	/**
	 * 响应操作:加载更多 所有需求
	 */
	public void getMoreAllNeeds() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);

		int userId = jsonObject.getInt1();
		int start = jsonObject.getInt2();
		List<Need> allNeeds = needDAO.getAllNeeds(userId, start, 10, true);
		List<UserInfo> userInfos = getUserInfosFromNeeds(allNeeds);
		List<UserInfo> solveUserInfos = getSolveUserInfosFromNeeds(allNeeds);
		List<UserDetailInfo> userDetailInfos = getUserDetailInfosFromUserInfos(userInfos);
		int lastNum = start;
		if (allNeeds.size() > 0) {
			lastNum = allNeeds.get(allNeeds.size() - 1).getId();
		}

		RefreshNeedJsonObject refreshNeedJsonObject = new RefreshNeedJsonObject(
				allNeeds, userInfos, solveUserInfos, userDetailInfos, lastNum);

		outToClient(refreshNeedJsonObject);
	}

	/**
	 * 响应操作:查看需求的详细信息
	 */
	public void showNeedDetail() {
		getClientData();

		int needId = JacksonUtil.json().fromJsonToObject(data, int.class);
		List<Need> needs = needDAO.findByProperty(NeedDAO.ID, needId);
		if (needs.size() == 0)// Need不存在或者已删除
		{
			outToClient(new DetailNeedJsonObject());
			return;
		}
		Need need = (Need) needs.get(0);

		UserInfo myUserInfo = (UserInfo) userInfoDAO.findByProperty(
				UserInfoDAO.USERID, need.getUserId()).get(0);
		UserInfo solveUserInfo = null;
		if (need.getSolveId() != -1) {
			solveUserInfo = (UserInfo) userInfoDAO.findByProperty(
					UserInfoDAO.USERID, need.getSolveId()).get(0);
		}

		List<NeedComment> needComments = needCommentDAO.findByProperty(
				NeedCommentDAO.NEEDID, needId);

		List<UserInfo> otherUserInfos = getUserInfosFromNeedComments(needComments);
		List<UserLocation> otherUserLocations = getUserLocationsFromUserInfos(otherUserInfos);
		UserDetailInfo userDetailInfo = userDetailInfoDAO.findByProperty(
				UserDetailInfoDAO.USERID, myUserInfo.getUserId()).get(0);
		DetailNeedJsonObject detailNeedJsonObject = new DetailNeedJsonObject(
				need, myUserInfo, otherUserInfos, otherUserLocations,
				needComments, solveUserInfo, userDetailInfo);
		outToClient(detailNeedJsonObject);
	}

	/**
	 * 响应操作:需求的评论
	 */
	public void commentNeed() {
		getClientData();
		NeedComment needComment = JacksonUtil.json().fromJsonToObject(data,
				NeedComment.class);
		needCommentDAO.save(needComment);

		int needId = needComment.getNeedId();

		Need need = (Need) needDAO.findByProperty(NeedDAO.ID, needId).get(0);
		need.setCommentNum(need.getCommentNum() + 1);
		needDAO.update(need);

		int needUserId = need.getUserId();// 主人
		int noticeUserId = needComment.getUserId();// 评论者
		int noticedUserId = needComment.getCommentedUserId();// 当回复评论时此项用来存放Comment的Id
																// 被评论者

		int beCommentedManId = -1;
		if (noticedUserId != -1) {
			NeedComment comment = (NeedComment) needCommentDAO.findByProperty(
					NeedCommentDAO.ID, noticedUserId).get(0);
			beCommentedManId = comment.getUserId();
		}
		long time = needComment.getTime();

		if (noticedUserId == -1) {// 仅回复Need或Pourlisten
			if (noticeUserId != needUserId) // 自己是主人不发送通知
				notificationDAO.save(new Notification(needId, noticeUserId,
						needUserId, time, NotificationType.NEED_COMMENT_WAIT));

		} else {// 对评论的回复
			if (noticeUserId != needUserId) {
				notificationDAO.save(new Notification(needId, noticeUserId,
						beCommentedManId, time,
						NotificationType.NEED_COMMENT_WAIT));
				if (noticeUserId != needUserId
						&& noticeUserId != beCommentedManId)
					notificationDAO.save(new Notification(needId, noticeUserId,
							needUserId, time,
							NotificationType.NEED_COMMENT_WAIT));
			}
		}
		outToClient(true);
	}

	/**
	 * 响应操作:需求的举报
	 */
	public void reportNeed() {
		getClientData();
		NeedReport needReport = JacksonUtil.json().fromJsonToObject(data,
				NeedReport.class);

		if (needReportDAO.check(needReport)) {
			needReportDAO.save(needReport);

			Need need = (Need) needDAO.findByProperty(NeedDAO.ID,
					needReport.getNeedId()).get(0);
			need.setReportNum(need.getReportNum() + 1);
			needDAO.update(need);
			outToClient(true);
		} else {
			outToClient(false);
		}
	}

	public void updateLoveNum() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int userId = jsonObject.getInt1();
		int increaseNum = jsonObject.getInt2();

		UserInfo userInfo = (UserInfo) userInfoDAO.findByProperty(
				UserInfoDAO.USERID, userId).get(0);
		userInfo.setLoveNum(userInfo.getLoveNum() + increaseNum);
		userInfoDAO.update(userInfo);
		outToClient(true);
	}

	/**
	 * 响应操作:选择感谢对象
	 */
	public void thank() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int userId = jsonObject.getInt1();
		int solveUserId = jsonObject.getInt2();
		int needId = jsonObject.getInt3();
		long time = jsonObject.getLong1();

		UserInfo solveUserInfo = (UserInfo) userInfoDAO.findByProperty(
				UserInfoDAO.USERID, solveUserId).get(0);
		solveUserInfo.setLoveNum(solveUserInfo.getLoveNum() + 1);
		userInfoDAO.update(solveUserInfo);

		Need need = (Need) needDAO.findByProperty(NeedDAO.ID, needId).get(0);
		need.setSolveId(solveUserId);
		needDAO.update(need);

		LovePopularityIncrease increase = (LovePopularityIncrease) lovePopularityIncreaseDAO
				.findByProperty(LovePopularityIncreaseDAO.USERID, solveUserId)
				.get(0);
		increase.setOldLoveNum(solveUserInfo.getLoveNum());
		increase.setIncreaseLoveNum(increase.getIncreaseLoveNum() + 1);
		lovePopularityIncreaseDAO.update(increase);

		notificationDAO.save(new Notification(needId, userId, solveUserId,
				time, NotificationType.NEED_COMMENT_WAIT));

		outToClient(true);
	}

	/**
	 * 响应操作:刷新附近的人
	 */
	public void refreshNearUser() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		double myLng = jsonObject.getDouble1();
		double myLat = jsonObject.getDouble2();
		int myUserId = jsonObject.getInt1();
		String sex = jsonObject.getString1();
		double distance = Double.parseDouble(jsonObject.getString2());

		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		List<UserLocation> userLocations = new ArrayList<UserLocation>();

		int lastNum = userInfoDAO.getNearUser(myLng, myLat, myUserId, 0, sex,
				distance, userInfos, userLocations);
		List<UserDetailInfo> userDetailInfos = getUserDetailInfosFromUserInfos(userInfos);
		outToClient(new NearUserJsonObject(userInfos, userLocations,
				userDetailInfos, lastNum));
	}

	/**
	 * 响应操作:加载更多附近的人
	 */
	public void getMoreNearUser() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		double myLng = jsonObject.getDouble1();
		double myLat = jsonObject.getDouble2();
		int myUserId = jsonObject.getInt1();
		int start = jsonObject.getInt2();
		String sex = jsonObject.getString1();
		double distance = Double.parseDouble(jsonObject.getString2());

		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		List<UserLocation> userLocations = new ArrayList<UserLocation>();

		int lastNum = userInfoDAO.getNearUser(myLng, myLat, myUserId, start,
				sex, distance, userInfos, userLocations);
		List<UserDetailInfo> userDetailInfos = getUserDetailInfosFromUserInfos(userInfos);
		outToClient(new NearUserJsonObject(userInfos, userLocations,
				userDetailInfos, lastNum));
	}

	/**
	 * 响应操作:查看用户详细资料
	 */
	public void showUserDetailInfo() {
		getClientData();
		int userId = JacksonUtil.json().fromJsonToObject(data, int.class);
		System.out.println("userId" + userId);
		User user = userDAO.findByProperty(UserDAO.ID, userId).get(0);
		UserInfo userInfo = (UserInfo) userInfoDAO.findByProperty(
				UserInfoDAO.USERID, userId).get(0);
		UserDetailInfo userDetailInfo = (UserDetailInfo) userDetailInfoDAO
				.findByProperty(UserDetailInfoDAO.USERID, userId).get(0);
		UserLocation userLocation = userLocationDAO.findByProperty(
				UserLocationDAO.USERID, userId).get(0);

		RegisterJsonObject jsonObject = new RegisterJsonObject(user, userInfo,
				userDetailInfo, userLocation);
		outToClient(jsonObject);
	}

	/**
	 * 响应操作:查看用户详细资料
	 */
	public void showUserDetailInfoNew() {
		getClientData();
		int userId = JacksonUtil.json().fromJsonToObject(data, int.class);
		System.out.println("userId" + userId);
		User user = userDAO.findByProperty(UserDAO.ID, userId).get(0);
		UserInfo userInfo = (UserInfo) userInfoDAO.findByProperty(
				UserInfoDAO.USERID, userId).get(0);
		UserDetailInfo userDetailInfo = (UserDetailInfo) userDetailInfoDAO
				.findByProperty(UserDetailInfoDAO.USERID, userId).get(0);
		UserLocation userLocation = userLocationDAO.findByProperty(
				UserLocationDAO.USERID, userId).get(0);
		ArrayList<Album> albums = (ArrayList<Album>) albumDAO.findByProperty(
				AlbumDAO.USERID, userId);
		List<UserDescInfo> lists = userDescInfoDAO.findByProperty(
				UserDescInfoDAO.USERID, userId);
		UserDescInfo userdesc = null;
		if (lists != null && lists.size() == 1) {
			userdesc = lists.get(0);
		}

		UserDetailJsonObject jsonObject = new UserDetailJsonObject(user,
				userInfo, userDetailInfo, userLocation, userdesc, albums);
		outToClient(jsonObject);
	}

	/**
	 * 响应操作:刷新爱心排名
	 */
	public void refreshLoveRank() {
		getClientData();

		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		double myLng = jsonObject.getDouble1();
		double myLat = jsonObject.getDouble2();
		double distance = Double.parseDouble(jsonObject.getString1());

		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		List<UserLocation> userLocations = new ArrayList<UserLocation>();
		userInfoDAO.getLoveRank(myLng, myLat, distance, userInfos,
				userLocations);

		List<UserInfo> icreaseUserInfos = new ArrayList<UserInfo>();
		List<UserLocation> icreaseuserLocations = new ArrayList<UserLocation>();
		List<LovePopularityIncrease> lovePopularityIncreases = new ArrayList<LovePopularityIncrease>();
		userInfoDAO
				.getLoveIncreaseRank(myLng, myLat, distance, icreaseUserInfos,
						icreaseuserLocations, lovePopularityIncreases);

		RankJsonObject rankJsonObject = new RankJsonObject(userInfos,
				userLocations, icreaseUserInfos, icreaseuserLocations,
				lovePopularityIncreases);

		outToClient(rankJsonObject);
	}

	/**
	 * 响应操作:刷新人气排名
	 */
	public void refreshPopularityRank() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		double myLng = jsonObject.getDouble1();
		double myLat = jsonObject.getDouble2();
		double distance = Double.parseDouble(jsonObject.getString1());

		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		List<UserLocation> userLocations = new ArrayList<UserLocation>();
		userInfoDAO.getPopularityRank(myLng, myLat, distance, userInfos,
				userLocations);

		List<UserInfo> icreaseUserInfos = new ArrayList<UserInfo>();
		List<UserLocation> icreaseuserLocations = new ArrayList<UserLocation>();
		List<LovePopularityIncrease> lovePopularityIncreases = new ArrayList<LovePopularityIncrease>();
		userInfoDAO
				.getPopularityIncreaseRank(myLng, myLat, distance,
						icreaseUserInfos, icreaseuserLocations,
						lovePopularityIncreases);

		RankJsonObject rankJsonObject = new RankJsonObject(userInfos,
				userLocations, icreaseUserInfos, icreaseuserLocations,
				lovePopularityIncreases);

		outToClient(rankJsonObject);
	}

	/**
	 * 响应操作:送人气
	 */
	public void givePopularity() {
		getClientData();
		String dd = data;
		JsonObject jsonObject;
		FlowerFan flowerFan = new FlowerFan();
		int sendManId, beSendManId, needId;
		long time;
		if (isEncrypt)// 新版本
		{
			jsonObject = JacksonUtil.json().fromJsonToObject(data,
					JsonObject.class);
			sendManId = jsonObject.getInt1();
			beSendManId = jsonObject.getInt2();
			needId = jsonObject.getInt3();
			time = jsonObject.getLong1();
			flowerFan.setFansid(sendManId);
			flowerFan.setOwnerid(beSendManId);
			notificationDAO.save(new Notification(needId, sendManId,
					beSendManId, time, NotificationType.FLOWER_WAIT));
		} else {
			jsonObject = JacksonUtil.json().fromJsonToObject(data,
					JsonObject.class);
			sendManId = jsonObject.getInt1();
			beSendManId = jsonObject.getInt2();
			needId = jsonObject.getInt3();
			time = jsonObject.getLong1();
			flowerFan.setFansid(sendManId);
			flowerFan.setOwnerid(beSendManId);
			notificationDAO.save(new Notification(needId, sendManId,
					beSendManId, time, NotificationType.FLOWER_WAIT));
		}

		UserInfo userInfo = (UserInfo) userInfoDAO.findByProperty(
				UserInfoDAO.USERID, beSendManId).get(0);
		userInfo.setPopularityNum(userInfo.getPopularityNum() + 1);
		userInfoDAO.update(userInfo);

		LovePopularityIncrease increase = (LovePopularityIncrease) lovePopularityIncreaseDAO
				.findByProperty(LovePopularityIncreaseDAO.USERID, beSendManId)
				.get(0);
		increase.setOldPopularityNum(userInfo.getPopularityNum());
		increase.setIncreasePopularityNum(increase.getIncreasePopularityNum() + 1);
		lovePopularityIncreaseDAO.update(increase);

		lovePopularityIncreaseDAO.addToFlowerFans(flowerFan);
		outToClient(true);
	}

	/**
	 * 响应操作:查找用户
	 */
	public void searchUser() {
		getClientData();
		String searchString = JacksonUtil.json().fromJsonToObject(data,
				String.class);
		if (searchString.equals("")) {
			outToClient(new SearchUserJsonObject(null, false));
			return;
		}

		List<UserInfo> userInfos = userInfoDAO.searchUser(searchString);
		List<UserLocation> userLocations = new ArrayList<UserLocation>();
		SearchUserJsonObject searchUserJsonObject = new SearchUserJsonObject();
		if (userInfos.size() > 0) {
			userLocations = getUserLocationsFromUserInfos(userInfos);
			searchUserJsonObject.setResult(true);
			searchUserJsonObject.setUserInfos(userInfos);
			searchUserJsonObject.setUserLocations(userLocations);
		} else {
			searchUserJsonObject.setResult(false);
		}
		outToClient(searchUserJsonObject);
	}
	
	/**
	 * 响应操作:查找用户
	 */
	public void searchUserNew() {
		getClientData();
		String searchString = JacksonUtil.json().fromJsonToObject(data,
				String.class);
		if (searchString.equals("")) {
			outToClient(new SearchUserJsonObject(null, false));
			return;
		}

		List<UserInfo> userInfos = userInfoDAO.searchUser(searchString);
		List<UserLocation> userLocations = new ArrayList<UserLocation>();
		NearUserJsonObject searchUserJsonObject = new NearUserJsonObject();
		List<UserDetailInfo> userDetailInfos = new ArrayList<UserDetailInfo>();
		if (userInfos.size() > 0) {
			userLocations = getUserLocationsFromUserInfos(userInfos);
			userDetailInfos = getUserDetailInfosFromUserInfos(userInfos);
			searchUserJsonObject.setUserLocations(userLocations);
			searchUserJsonObject.setUserInfos(userInfos);
			searchUserJsonObject.setUserDetailInfos(userDetailInfos);
		} 
		outToClient(searchUserJsonObject);
	}

	/**
	 * 响应操作:修改密码
	 */
	public void updatePassword() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int userId = jsonObject.getInt1();
		String password = jsonObject.getString1();
		User user = (User) userDAO.findByProperty(UserDAO.ID, userId).get(0);
		user.setPassword(password);
		userDAO.update(user);
		outToClient(true);
	}

	public void updateAllUserInfo() {
		getClientData();
		UserDetailJsonObject userDetailJsonObject = JacksonUtil.json()
				.fromJsonToObject(data, UserDetailJsonObject.class);

		UserInfo userInfo = userInfoDAO.findByProperty(UserInfoDAO.USERID,
				userDetailJsonObject.getUserInfo().getUserId()).get(0);
		userInfo.setNickName(userDetailJsonObject.getUserInfo().getNickName());
		userInfo.setRealName(userDetailJsonObject.getUserInfo().getRealName());
		userInfo.setSex(userDetailJsonObject.getUserInfo().getSex());
		userInfoDAO.update(userInfo);

		UserDetailInfo userDetailInfo = userDetailInfoDAO.findByProperty(
				UserDetailInfoDAO.USERID,
				userDetailJsonObject.getUserDetailInfo().getUserId()).get(0);
		userDetailInfo.setAcademy(userDetailJsonObject.getUserDetailInfo()
				.getAcademy());
		userDetailInfo.setGrade(userDetailJsonObject.getUserDetailInfo()
				.getGrade());
		userDetailInfo.setSchool(userDetailJsonObject.getUserDetailInfo()
				.getSchool());
		userDetailInfo.setSignature(userDetailJsonObject.getUserDetailInfo()
				.getSignature());
		userDetailInfoDAO.update(userDetailInfo);

		boolean isHasIt = true;

		UserDescInfo userDescInfo;

		List<UserDescInfo> llDescInfos = userDescInfoDAO.findByProperty(
				UserDescInfoDAO.USERID, userDetailJsonObject.getUserDescInfo()
						.getUserId());
		if (llDescInfos == null || llDescInfos.size() == 0) {
			isHasIt = false;
			userDescInfo = new UserDescInfo();
			userDescInfo.setUserId(userDetailJsonObject.getUserDescInfo()
					.getUserId());
		} else {
			userDescInfo = llDescInfos.get(0);
			if (userDescInfo == null) {
				isHasIt = false;
				userDescInfo = new UserDescInfo();
				userDescInfo.setUserId(userDetailJsonObject.getUserDescInfo()
						.getUserId());
			}
		}

		userDescInfo.setBirthday(userDetailJsonObject.getUserDescInfo()
				.getBirthday());
		userDescInfo.setDescription(userDetailJsonObject.getUserDescInfo()
				.getDescription());
		userDescInfo.setDiploma(userDetailJsonObject.getUserDescInfo()
				.getDiploma());
		userDescInfo.setEmotion(userDetailJsonObject.getUserDescInfo()
				.getEmotion());
		userDescInfo.setHometown(userDetailJsonObject.getUserDescInfo()
				.getHometown());
		userDescInfo.setLikebook(userDetailJsonObject.getUserDescInfo()
				.getLikebook());
		userDescInfo.setLikefilm(userDetailJsonObject.getUserDescInfo()
				.getLikefilm());
		userDescInfo.setLikefood(userDetailJsonObject.getUserDescInfo()
				.getLikefood());
		userDescInfo.setLikegift(userDetailJsonObject.getUserDescInfo()
				.getLikegift());
		userDescInfo.setLikemusic(userDetailJsonObject.getUserDescInfo()
				.getLikemusic());
		userDescInfo.setLikeplace(userDetailJsonObject.getUserDescInfo()
				.getLikeplace());
		if (isHasIt) {
			userDescInfoDAO.update(userDescInfo);
		} else {
			userDescInfoDAO.save(userDescInfo);
		}

		outToClient(true);
	}

	/**
	 * 响应操作:修改昵称
	 */
	public void updateNickName() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int userId = jsonObject.getInt1();
		String nickName = jsonObject.getString1();
		UserInfo userInfo = (UserInfo) userInfoDAO.findByProperty(
				UserInfoDAO.USERID, userId).get(0);
		userInfo.setNickName(nickName);
		userInfoDAO.update(userInfo);
		outToClient(true);
	}

	/**
	 * 响应操作:修改真实姓名
	 */
	public void updateRealName() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int userId = jsonObject.getInt1();
		String realName = jsonObject.getString1();
		UserInfo userInfo = (UserInfo) userInfoDAO.findByProperty(
				UserInfoDAO.USERID, userId).get(0);
		userInfo.setRealName(realName);
		userInfoDAO.update(userInfo);
		outToClient(true);
	}

	/**
	 * 响应操作:修改个性签名
	 */
	public void updateSignature() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int userId = jsonObject.getInt1();
		String signature = jsonObject.getString1();
		UserDetailInfo userDetailInfo = (UserDetailInfo) userDetailInfoDAO
				.findByProperty(UserDetailInfoDAO.USERID, userId).get(0);
		userDetailInfo.setSignature(signature);
		userDetailInfoDAO.update(userDetailInfo);
		outToClient(true);
	}

	/**
	 * 响应操作:修改学校
	 */
	public void updateSchool() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int userId = jsonObject.getInt1();
		String school = jsonObject.getString1();
		UserDetailInfo userDetailInfo = (UserDetailInfo) userDetailInfoDAO
				.findByProperty(UserDetailInfoDAO.USERID, userId).get(0);
		userDetailInfo.setSchool(school);
		userDetailInfoDAO.update(userDetailInfo);
		outToClient(true);
	}

	/**
	 * 响应操作:修改学院
	 */
	public void updateAcademy() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int userId = jsonObject.getInt1();
		String academy = jsonObject.getString1();
		UserDetailInfo userDetailInfo = (UserDetailInfo) userDetailInfoDAO
				.findByProperty(UserDetailInfoDAO.USERID, userId).get(0);
		userDetailInfo.setAcademy(academy);
		userDetailInfoDAO.update(userDetailInfo);
		outToClient(true);
	}

	/**
	 * 响应操作:修改年级
	 */
	public void updateGrade() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int userId = jsonObject.getInt1();
		String grade = jsonObject.getString1();
		UserDetailInfo userDetailInfo = (UserDetailInfo) userDetailInfoDAO
				.findByProperty(UserDetailInfoDAO.USERID, userId).get(0);
		userDetailInfo.setGrade(grade);
		userDetailInfoDAO.update(userDetailInfo);
		outToClient(true);
	}

	/**
	 * 响应操作:检查有没有自己的通知
	 */
	public void checkNotification() {
		getClientData();
		int userId = JacksonUtil.json().fromJsonToObject(data, int.class);
		List<Notification> notifications = notificationDAO.findByProperty(
				NotificationDAO.NOTICEDID, userId);
		List<Notification> tmps = new ArrayList<Notification>();// 用来存放需要发送的notification
		if (notifications.size() > 0) {
			for (Notification notification : notifications) {
				if (notification.getNoticeFlag() > 0) {
					tmps.add(notification);
				}
			}
			outToClient(new NotificationJsonObject(tmps, true));
			for (Notification notification : tmps) {
				notification// 令Flag变成负值表示已经通知
						.setNoticeFlag(notification.getNoticeFlag() * -1);
				notificationDAO.update(notification);
			}
		} else {
			outToClient(new NotificationJsonObject(null, false));
		}
	}

	/**
	 * 响应操作:获取所有消息通知
	 */
	public void getAllNotifications() {
		getClientData();
		int userId = JacksonUtil.json().fromJsonToObject(data, int.class);
		List<Notification> notifications = notificationDAO.getAllNotification(
				userId, 0, 10, false);
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		List<String> comments = new ArrayList<String>();

		if (notifications.size() > 0)
			for (Notification notification : notifications) {
				int theManId = notification.getUserId();// 回复者的ID
				UserInfo userInfo = (UserInfo) userInfoDAO.findByProperty(
						UserInfoDAO.USERID, theManId).get(0);
				userInfos.add(userInfo);

				int type = Math.abs(notification.getNoticeFlag());
				switch (type) {
				case NotificationType.NEED_COMMENT_WAIT:
					List<NeedComment> tmp = needCommentDAO.findByProperty(
							NeedCommentDAO.TIME, notification.getTime());
					if (tmp.size() != 0 && tmp != null) {
						String content = (tmp.get(0)).getComment();
						comments.add(content);
					}
					break;
				case NotificationType.POURLISTEN_COMMENT_WAIT:
					List<PourlistenComment> tmp2 = pourlistenCommentDAO
							.findByProperty(PourlistenCommentDAO.TIME,
									notification.getTime());
					if (tmp2.size() != 0 && tmp2 != null) {
						String content = (tmp2.get(0)).getComment();
						comments.add(content);
					}
					break;
				case NotificationType.FLOWER_WAIT:
					comments.add("");
					break;
				case NotificationType.PHOTO_COMMENT_WAIT:
					long tt = notification.getTime();
					List<TakePhotosComment> tmp3 = takePhotosCommentDAO
							.findByProperty(TakePhotosCommentDAO.TIME,
									notification.getTime());
					if (tmp3 != null && tmp3.size() != 0) {
						String content = (tmp3.get(0)).getContent();
						comments.add(content);
					} else {
						comments.add("");
					}
					break;
				case NotificationType.PHOTO_PRAISE_WAIT:
					comments.add("");
					break;
				case NotificationType.PHOTO_TRANSMIT_WAIT:
					comments.add("");
					break;
				case NotificationType.PLAY_COMMENT_WAIT:
					List<PlaysComment> tmp4 = playsCommentDAO.findByProperty(
							PlaysCommentDAO.TIME, notification.getTime());
					if (tmp4.size() != 0 && tmp4 != null) {
						String content = (tmp4.get(0)).getContent();
						comments.add(content);
					}
					break;
				case NotificationType.PARTICIPATE_WAIT:
					comments.add("");
					break;
				case NotificationType.NEED_NOTIFY_WAIT:
					comments.add("");
					break;
				case NotificationType.WISH_NOTIFY_WAIT:
					comments.add("");
					break;
				case NotificationType.WISH_ACCEPT_WAIT:
					ArrayList<User> users = (ArrayList<User>) userDAO
							.findByProperty("id", userInfo.getUserId());
					if (users != null && users.size() == 1) {
						comments.add("他的电话是：" + users.get(0).getTele());
					}
					break;
				case NotificationType.WISH_TO_BOY_WAIT:
					ArrayList<User> users1 = (ArrayList<User>) userDAO
							.findByProperty("id", userInfo.getUserId());
					if (users1 != null && users1.size() == 1) {
						comments.add("她的电话是：" + users1.get(0).getTele());
					}
					break;
				case NotificationType.WISH_COMMENT_WAIT:
					comments.add("");
					break;
				case NotificationType.WISH_JOIN_WAIT:
					comments.add(userInfo.getNickName() + "想实现你的心愿");
					break;
				default:
					break;
				}
			}

		int lastNum = 0;
		if (notifications.size() > 0) {
			lastNum = notifications.get(notifications.size() - 1).getId();
		}
		if (notifications.size() > 0) {
			outToClient(new AllNotificationsJsonObject(notifications,
					userInfos, comments, true, lastNum));
		} else {
			outToClient(new AllNotificationsJsonObject(null, null, null, false,
					lastNum));
		}
	}

	public void getMoreAllNotifications() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int userId = jsonObject.getInt1();
		int start = jsonObject.getInt2();

		List<Notification> notifications = notificationDAO.getAllNotification(
				userId, start, 10, true);
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		List<String> comments = new ArrayList<String>();
		if (notifications.size() == 0) {
			outToClient(new AllNotificationsJsonObject(notifications,
					userInfos, comments, false, start));
			return;
		}

		for (Notification notification : notifications) {
			int theManId = notification.getUserId();// 回复者的ID
			UserInfo userInfo = (UserInfo) userInfoDAO.findByProperty(
					UserInfoDAO.USERID, theManId).get(0);
			userInfos.add(userInfo);

			int type = notification.getNoticeFlag();
			if (type == 1 || type == -1)// Need
			{
				List<NeedComment> tmp = needCommentDAO.findByProperty(
						NeedCommentDAO.TIME, notification.getTime());
				if (tmp.size() != 0 && tmp != null) {
					String content = (tmp.get(0)).getComment();
					comments.add(content);
				}
			} else if (type == 2 || type == -2) {// Pourlisten
				List<PourlistenComment> tmp = pourlistenCommentDAO
						.findByProperty(PourlistenCommentDAO.TIME,
								notification.getTime());
				if (tmp.size() != 0 && tmp != null) {
					String content = (tmp.get(0)).getComment();
					comments.add(content);
				}

			} else {// 点赞
				comments.add("");
			}
		}

		int lastNum = start;
		lastNum = notifications.get(notifications.size() - 1).getId();

		outToClient(new AllNotificationsJsonObject(notifications, userInfos,
				comments, true, lastNum));
	}

	/**
	 * 响应操作:更新自己的地理位置
	 */
	public void updateUserLocation() {
		getClientData();
		UserLocation userLocation = JacksonUtil.json().fromJsonToObject(data,
				UserLocation.class);
		int userId = userLocation.getUserId();
		double lng = userLocation.getLng();
		double lat = userLocation.getLat();

		if (userId == -1) {
			outToClient(false);
			return;
		}
		List<UserLocation> tmp = userLocationDAO.findByProperty(
				UserLocationDAO.USERID, userId);
		if (tmp == null || tmp.size() == 0) {
			outToClient(false);
			return;
		}
		UserLocation userLocation2 = (UserLocation) tmp.get(0);
		userLocation2.setLat(lat);
		userLocation2.setLng(lng);
		userLocation2.setTime(userLocation.getTime());
		userLocationDAO.update(userLocation2);

		outToClient(true);
	}

	/**
	 * 响应操作:刷新附近倾诉倾听
	 */
	public void refreshPourlisten() {
		getClientData();

		List<PourListenNoSex> pourListenNoSexs = pourlistenDAO
				.getNearPourlisten(0, false);

		List<Pourlisten> pourlistens = new ArrayList<Pourlisten>();
		for (PourListenNoSex pourlistenNoSex : pourListenNoSexs) {
			Pourlisten pourlisten = new Pourlisten();
			pourlisten.setCommentNum(pourlistenNoSex.getCommentNum());
			pourlisten.setContent(pourlistenNoSex.getContent());
			pourlisten.setId(pourlistenNoSex.getId());
			pourlisten.setImageUrl(pourlistenNoSex.getImageUrl());
			pourlisten.setLat(pourlistenNoSex.getLat());
			pourlisten.setLng(pourlistenNoSex.getLng());
			pourlisten.setTime(pourlistenNoSex.getTime());
			pourlisten.setUserId(pourlistenNoSex.getUserId());
			pourlistens.add(pourlisten);
		}

		if (pourlistens != null) {
			int num = pourlistens.size();
			List<UserInfo> tmpList;
			for (int i = 0; i < num; i++) {
				tmpList = userInfoDAO.findByProperty("userId",
						pourlistens.get(i).getUserId());
				if (tmpList != null && tmpList.size() == 1) {
					pourlistens.get(i).setSex(tmpList.get(0).getSex());
				}
			}
		}
		outToClient(new RefreshPourlistenJsonObject(pourlistens));
	}

	/**
	 * 响应操作:刷新附近倾诉倾听
	 */
	public void refreshMood() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		List<Mood> moods = moodDAO.getNearMood(jsonObject.getDouble2(),
				jsonObject.getDouble1(), jsonObject.getString1(),
				jsonObject.getDouble3(), 0, 10, false);
		int lastNum = moods.get(moods.size() - 1).getId();
		if (moods != null) {
			int num = moods.size();
			List<UserInfo> tmpList = new ArrayList<UserInfo>();
			List<UserInfo> atusInfos = new ArrayList<UserInfo>();
			for (int i = 0; i < num; i++) {
				tmpList.add(userInfoDAO.findByProperty("userId",
						moods.get(i).getUserId()).get(0));
				if (moods.get(i).getFlag() == Constant.MOOD_FLAG_POUR) {
					List<PourListenNoSex> pourlistens = pourlistenDAO
							.findByProperty(PourlistenDAO.TIME, moods.get(i)
									.getTime());
					int theid = pourlistens.get(0).getId();
					moods.get(i).setId(theid);
				}
				if (moods.get(i).getFlag() == Constant.MOOD_FLAG_PHOTO) {
					int theid = takePhotosDAO
							.findByProperty(TakePhotosDAO.TIME,
									moods.get(i).getTime()).get(0).getId();
					moods.get(i).setId(theid);
					if (moods.get(i).getTransmitFrom() > 0) {
						atusInfos.add(userInfoDAO.findByProperty(
								UserInfoDAO.USERID,
								moods.get(i).getTransmitFrom()).get(0));
						continue;
					}
				}

				atusInfos.add(new UserInfo());

			}
			List<UserLocation> userLocations = getUserLocationsFromUserInfos(tmpList);
			List<UserDetailInfo> userDetailInfos = getUserDetailInfosFromUserInfos(tmpList);

			outToClient(new RefreshMoodJsonObject(moods, userDetailInfos,
					tmpList, atusInfos, userLocations, lastNum));
		}

	}

	/**
	 * 响应操作:刷新附近倾诉倾听
	 */
	public void getMoreMood() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		List<Mood> moods = moodDAO.getNearMood(jsonObject.getDouble2(),
				jsonObject.getDouble1(), jsonObject.getString1(),
				jsonObject.getDouble3(), jsonObject.getInt1(), 10, true);
		int lastNum = moods.get(moods.size() - 1).getId();
		if (moods != null) {
			int num = moods.size();
			List<UserInfo> tmpList = new ArrayList<UserInfo>();
			List<UserInfo> atusInfos = new ArrayList<UserInfo>();
			for (int i = 0; i < num; i++) {
				tmpList.add(userInfoDAO.findByProperty("userId",
						moods.get(i).getUserId()).get(0));
				if (moods.get(i).getFlag() == Constant.MOOD_FLAG_POUR) {
					List<PourListenNoSex> pourlistens = pourlistenDAO
							.findByProperty(PourlistenDAO.TIME, moods.get(i)
									.getTime());
					int theid = pourlistens.get(0).getId();
					moods.get(i).setId(theid);
				}
				if (moods.get(i).getFlag() == Constant.MOOD_FLAG_PHOTO) {
					int theid = takePhotosDAO
							.findByProperty(TakePhotosDAO.TIME,
									moods.get(i).getTime()).get(0).getId();
					moods.get(i).setId(theid);
					if (moods.get(i).getTransmitFrom() > 0) {
						atusInfos.add(userInfoDAO.findByProperty(
								UserInfoDAO.USERID,
								moods.get(i).getTransmitFrom()).get(0));
						continue;
					}
				}
				atusInfos.add(new UserInfo());

			}
			List<UserLocation> userLocations = getUserLocationsFromUserInfos(tmpList);
			List<UserDetailInfo> userDetailInfos = getUserDetailInfosFromUserInfos(tmpList);

			outToClient(new RefreshMoodJsonObject(moods, userDetailInfos,
					tmpList, atusInfos, userLocations, lastNum));
		}

	}

	/**
	 * 响应操作:加载更多附近倾诉倾听
	 */
	public void getMorePourlisten() {
		getClientData();
		int start = JacksonUtil.json().fromJsonToObject(data, int.class);

		List<PourListenNoSex> pourListenNoSexs = pourlistenDAO
				.getNearPourlisten(start, true);

		List<Pourlisten> pourlistens = new ArrayList<Pourlisten>();
		for (PourListenNoSex pourlistenNoSex : pourListenNoSexs) {
			Pourlisten pourlisten = new Pourlisten();
			pourlisten.setCommentNum(pourlistenNoSex.getCommentNum());
			pourlisten.setContent(pourlistenNoSex.getContent());
			pourlisten.setId(pourlistenNoSex.getId());
			pourlisten.setImageUrl(pourlistenNoSex.getImageUrl());
			pourlisten.setLat(pourlistenNoSex.getLat());
			pourlisten.setLng(pourlistenNoSex.getLng());
			pourlisten.setTime(pourlistenNoSex.getTime());
			pourlisten.setUserId(pourlistenNoSex.getUserId());
			pourlistens.add(pourlisten);
		}

		outToClient(new RefreshPourlistenJsonObject(pourlistens));
	}

	public void getFlowerFans() {
		// String dataString = request.getParameter("data");
		getClientData();
		JsonObject dataJsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int userId = dataJsonObject.getInt1();
		int lastNum = dataJsonObject.getInt2();
		FlowerFansDAO flowerFansDAO = new FlowerFansDAO(userId);
		List<FlowerFan> reslFans = flowerFansDAO.findByProperty("ownerid",
				userId, lastNum);
		ArrayList<Integer> idList = new ArrayList<Integer>();
		List<UserInfo> fansInfos = new ArrayList<UserInfo>();
		if (reslFans != null && reslFans.size() > 0) {
			int num = reslFans.size();
			for (int i = 0; i < num; i++) {
				idList.add(reslFans.get(i).getFansid());
			}
			fansInfos = flowerFansDAO.getFansInfo(idList);
		}
		FlowerFansJsonObject jsonObject = new FlowerFansJsonObject();
		jsonObject.setFanslist(fansInfos);
		jsonObject.setLastNum(lastNum + fansInfos.size());
		outToClient(jsonObject);
	}

	/**
	 * 响应操作:查看倾诉倾听的详细信息
	 */
	public void showPourlistenDetail() {
		getClientData();

		int pourlistenId = JacksonUtil.json().fromJsonToObject(data, int.class);
		List<PourListenNoSex> pourlistens = pourlistenDAO.findByProperty(
				PourlistenDAO.ID, pourlistenId);
		if (pourlistens.size() == 0) {
			outToClient(new DetailPourlistenJsonObject());
			return;
		}
		PourListenNoSex pourlistenNoSex = pourlistens.get(0);
		Pourlisten pourlisten = new Pourlisten();
		pourlisten.setCommentNum(pourlistenNoSex.getCommentNum());
		pourlisten.setContent(pourlistenNoSex.getContent());
		pourlisten.setId(pourlistenNoSex.getId());
		pourlisten.setImageUrl(pourlistenNoSex.getImageUrl());
		pourlisten.setLat(pourlistenNoSex.getLng());
		pourlisten.setLng(pourlistenNoSex.getLat());
		pourlisten.setTime(pourlistenNoSex.getTime());
		pourlisten.setUserId(pourlistenNoSex.getUserId());
		List<PourlistenComment> pourlistenComments = pourlistenCommentDAO
				.findByProperty(PourlistenCommentDAO.POURLISTENID, pourlistenId);
		List<Integer> commuserids = new ArrayList<Integer>();
		for (int i = 0; i < pourlistenComments.size(); i++) {
			commuserids.add(pourlistenComments.get(i).getUserId());
		}
		List<UserInfo> commUserInfos = getUserInfosFromUserIds(commuserids);
		List<UserLocation> commUserLocations = getUserLocationsFromUserInfos(commUserInfos);

		DetailPourlistenJsonObject detailNeedJsonObject = new DetailPourlistenJsonObject(
				pourlisten, pourlistenComments, commUserInfos,
				commUserLocations);

		outToClient(detailNeedJsonObject);
	}

	/**
	 * 响应操作:发布倾诉倾听
	 */
	public void commitPourlisten() {
		getClientData();
		Pourlisten pourlisten = JacksonUtil.json().fromJsonToObject(data,
				Pourlisten.class);
		PourListenNoSex pourListenNoSex = new PourListenNoSex();
		pourListenNoSex.setCommentNum(pourlisten.getCommentNum());
		pourListenNoSex.setContent(pourlisten.getContent());
		pourListenNoSex.setId(pourlisten.getId());
		pourListenNoSex.setImageUrl(pourlisten.getImageUrl());
		pourListenNoSex.setLat(pourlisten.getLat());
		pourListenNoSex.setLng(pourlisten.getLng());
		pourListenNoSex.setTime(pourlisten.getTime());
		pourListenNoSex.setUserId(pourlisten.getUserId());
		pourlistenDAO.save(pourListenNoSex);
		outToClient(true);
	}

	/**
	 * 响应操作:倾诉倾听的评论
	 */
	public void commentPourlisten() {
		getClientData();
		PourlistenComment pourlistenComment = JacksonUtil.json()
				.fromJsonToObject(data, PourlistenComment.class);
		pourlistenCommentDAO.save(pourlistenComment);

		int pourlistenId = pourlistenComment.getPourlistenId();

		PourListenNoSex pourlisten = pourlistenDAO.findByProperty(
				PourlistenDAO.ID, pourlistenId).get(0);

		PourListenNoSex pourListenNoSex = new PourListenNoSex();
		pourListenNoSex.setCommentNum(pourlisten.getCommentNum() + 1);
		pourListenNoSex.setContent(pourlisten.getContent());
		pourListenNoSex.setId(pourlisten.getId());
		pourListenNoSex.setImageUrl(pourlisten.getImageUrl());
		pourListenNoSex.setLat(pourlisten.getLat());
		pourListenNoSex.setLng(pourlisten.getLng());
		pourListenNoSex.setTime(pourlisten.getTime());
		pourListenNoSex.setUserId(pourlisten.getUserId());

		pourlistenDAO.update(pourListenNoSex);

		Mood mood = moodDAO.findByProperty(MoodDAO.TIME,
				pourListenNoSex.getTime()).get(0);
		mood.setCommentNum(pourListenNoSex.getCommentNum());
		moodDAO.update(mood);

		int pourlistenUserId = pourlisten.getUserId();
		int noticeUserId = pourlistenComment.getUserId();
		int noticedUserId = pourlistenComment.getCommentedUserId();

		int beCommentedManId = -1;
		if (noticedUserId != -1) {
			PourlistenComment comment = (PourlistenComment) pourlistenCommentDAO
					.findByProperty(PourlistenCommentDAO.ID, noticedUserId)
					.get(0);
			beCommentedManId = comment.getUserId();
		}
		long time = pourlistenComment.getTime();

		if (noticedUserId == -1) {// 仅回复Need或Pourlisten
			if (noticeUserId != pourlistenUserId) // 回复自己不发送通知
				notificationDAO.save(new Notification(pourlistenId,
						noticeUserId, pourlistenUserId, time,
						NotificationType.POURLISTEN_COMMENT_WAIT));

		} else {// 对评论的回复
			if (noticeUserId != pourlistenUserId) {
				notificationDAO.save(new Notification(pourlistenId,
						noticeUserId, beCommentedManId, time,
						NotificationType.POURLISTEN_COMMENT_WAIT));
				if (noticeUserId != pourlistenUserId
						&& noticeUserId != beCommentedManId)
					notificationDAO.save(new Notification(pourlistenId,
							noticeUserId, pourlistenUserId, time,
							NotificationType.POURLISTEN_COMMENT_WAIT));
			}
		}

		outToClient(true);
	}

	/**
	 * 响应操作:获取BG URL
	 * 
	 */
	public void getBackground() {
		getClientData();
		// 暂时没有数据
		File f = new File(ServletActionContext.getServletContext().getRealPath(
				"/")
				+ "background/");
		String[] s = f.list();
		for (int i = 0; i < s.length; i++)
			System.out.println(s[i]);
		System.out.println(s.length);
		if (data.equals("\"new version\""))
			outToClient(new StringArrayJsonObject(s));
		else
			outToClient(s.length);
	}

	/**
	 * 响应操作:获取默认头像 URL
	 * 
	 */
	public void getDefaultHead() {
		getClientData();
		// 暂时没有数据
		File f = new File(ServletActionContext.getServletContext().getRealPath(
				"/")
				+ "default_head/");
		String[] s = f.list();
		if (data.equals("new version"))
			outToClient(s.length);
		else
			outToClient(new StringArrayJsonObject(s));
	}

	/**
	 * 响应操作:使用默认头像
	 * 
	 */
	public void useDefaultHead() {
		getClientData();
		// 暂时没有数据
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int userId = jsonObject.getInt1();
		String imageName = jsonObject.getString1();

		File file = new File(ServletActionContext.getServletContext()
				.getRealPath("/") + "default_head/" + imageName);
		File targetFile = new File(ServletActionContext.getServletContext()
				.getRealPath("/") + "head/" + "head_big_" + userId + ".png");
		fileChannelCopy(file, targetFile);
		outToClient(true);
	}

	/**
	 * 响应操作:删除Need
	 * 
	 */
	public void deleteNeed() {
		getClientData();
		int needId = JacksonUtil.json().fromJsonToObject(data, int.class);
		Need need = (Need) needDAO.findByProperty(NeedDAO.ID, needId).get(0);
		if (needDAO.delete(need) != 0)
			outToClient(true);
		else
			outToClient(false);
	}

	/**
	 * 响应操作:删除Pourlisten
	 * 
	 */
	public void deletePourlisten() {
		getClientData();
		int pourlistenId = JacksonUtil.json().fromJsonToObject(data, int.class);
		if (pourlistenDAO.delete(pourlistenId) != 0)
			outToClient(true);
		else
			outToClient(false);
	}

	/**
	 * 响应操作:删除用户
	 * 
	 */
	public void deleteEmptyUser() {
		getClientData();
		String email = JacksonUtil.json().fromJsonToObject(data, String.class);
		List<User> users = userDAO.findByProperty(UserDAO.EMAIL, email);
		if (users == null || users.size() == 0) {
			outToClient("empty");
			return;
		}

		User user = (User) users.get(0);
		if (userDAO.deleteEmptyUser(user) != 0)
			outToClient(true);
		else
			outToClient(false);
	}

	/**
	 * 响应操作:添加我要拍
	 * 
	 */
	public void commitPhotos() {
		getClientData();
		TakePhotos takePhotos = JacksonUtil.json().fromJsonToObject(data,
				TakePhotos.class);
		takePhotosDAO.save(takePhotos);

		outToClient(true);
	}

	public void commitAlbum() {
		getClientData();
		Album album = JacksonUtil.json().fromJsonToObject(data, Album.class);
		albumDAO.save(album);

		outToClient(true);
	}

	public void commitMood() {
		getClientData();
		Mood mood = JacksonUtil.json().fromJsonToObject(data, Mood.class);
		int theid = 0;

		if (mood.getFlag() == Constant.MOOD_FLAG_PHOTO) {
			TakePhotos takePhotos = new TakePhotos();
			takePhotos.setContent(mood.getContent());
			takePhotos.setLat(mood.getLat());
			takePhotos.setLng(mood.getLng());
			takePhotos.setTime(mood.getTime());
			takePhotos.setTransmitFrom(mood.getTransmitFrom());
			takePhotos.setTransmitId(mood.getTransmitId());
			takePhotos.setUserId(mood.getUserId());
			takePhotos.imageUrl = mood.getImageUrl();
			takePhotosDAO.save(takePhotos);
			// theid = takePhotosDAO.findByProperty(TakePhotosDAO.TIME,
			// takePhotos.getTime()).get(0).getId();

		} else if (mood.getFlag() == Constant.MOOD_FLAG_POUR) {
			PourListenNoSex pourlisten = new PourListenNoSex();
			pourlisten.setContent(mood.getContent());
			pourlisten.setImageUrl(mood.getImageUrl());
			pourlisten.setLat(mood.getLat());
			pourlisten.setLng(mood.getLng());
			pourlisten.setTime(Long.parseLong(mood.getTime()));
			pourlisten.setUserId(mood.getUserId());
			pourlistenDAO.save(pourlisten);
			// Pourlisten pourlisten2 = (Pourlisten)
			// pourlistenDAO.findByProperty(PourlistenDAO.TIME,
			// pourlisten.getTime()).get(0);
			// theid = pourlisten2.getId();
		}

		moodDAO.save(mood);

		outToClient(true);
	}

	/**
	 * 响应操作:添加我要玩
	 * 
	 */
	public void commitPlays() {
		getClientData();
		Plays play = JacksonUtil.json().fromJsonToObject(data, Plays.class);
		playsDAO.save(play);
		outToClient(true);
	}

	public void getWishPickers() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		List<WishPicker> wishPickers = wishPickersDao.findByProperty(
				WishPickersDao.WISHID, jsonObject.getInt1());
		List<Integer> userids = new ArrayList<Integer>();
		for (int i = 0; i < wishPickers.size(); i++)
			userids.add(wishPickers.get(i).getUserId());
		List<UserInfo> pickerInfos = getUserInfosFromUserIds(userids);
		List<UserDetailInfo> userDetailInfos = getUserDetailInfosFromUserInfos(pickerInfos);
		List<UserLocation> userLocations = getUserLocationsFromUserInfos(pickerInfos);
		NearUserJsonObject nearUserJsonObject = new NearUserJsonObject(
				pickerInfos, userLocations, userDetailInfos, 0);
		outToClient(nearUserJsonObject);
	}

	/**
	 * 响应操作:添加女生心愿墙
	 * 
	 */
	public void commitWish() {
		getClientData();
		Wish wish = JacksonUtil.json().fromJsonToObject(data, Wish.class);
		wishDAO.save(wish);
		outToClient(true);

		int userid = wish.getUserId();
		long timeline = 1000 * 24 * 60 * 60 * 3;
		long commitTime = Long.parseLong(wish.getTime());
		long timedead = commitTime - timeline;
		ArrayList<UserInfo> userInfos = new ArrayList<UserInfo>();
		ArrayList<UserLocation> userLocations = new ArrayList<UserLocation>();

		ArrayList<Wish> savedWishs = (ArrayList<Wish>) wishDAO.findByProperty(
				"time", wish.getTime());
		int toSaveId = 0;
		if (savedWishs != null && savedWishs.size() == 1) {
			toSaveId = savedWishs.get(0).getId();
		}

		userInfoDAO.getNearSomeCountUser(wish.getLng(), wish.getLat(), userid,
				0, "男", 3000, userInfos, userLocations, 100,
				String.valueOf(timedead));
		int num = userInfos.size();
		for (int i = 0; i < num; i++) {
			notificationDAO.save(new Notification(toSaveId, userid, userInfos
					.get(i).getUserId(), Long.parseLong(wish.getTime()),
					NotificationType.WISH_NOTIFY_WAIT));
		}
		List<Notification> notifications = notificationDAO.findByProperty(
				"noticeFlag", -15);
		int num2 = notifications.size();
		for (int i = 0; i < num2; i++) {
			notificationDAO.delete(notifications.get(i));
		}
	}

	public void joinPickers() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		if (wishPickersDao.isExist(jsonObject.getInt3(), jsonObject.getInt1())) {
			outToClient(0);
		} else {
			WishPicker wishPicker = new WishPicker(0, jsonObject.getInt1(),
					jsonObject.getInt3(), jsonObject.getInt2());
			wishPickersDao.save(wishPicker);
			notificationDAO.save(new Notification(jsonObject.getInt1(),
					jsonObject.getInt3(), jsonObject.getInt2(), new Date()
							.getTime(), NotificationType.WISH_JOIN_WAIT));
			outToClient(1);
		}

	}

	/**
	 * 响应操作:刷新我要拍
	 * 
	 */
	public void refreshPhotos() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		double lng = jsonObject.getDouble1();
		double lat = jsonObject.getDouble2();
		double distance = jsonObject.getDouble3();
		String sex = jsonObject.getString1();

		List<TakePhotos> takePhotos = takePhotosDAO.getNearPhotos(lng, lat,
				sex, distance, 0, 10, false);

		List<Integer> userIds = new ArrayList<Integer>();

		List<Integer> beAtUserIds = new ArrayList<Integer>();
		for (TakePhotos takePhotos2 : takePhotos) {
			userIds.add(takePhotos2.getUserId());
			beAtUserIds.add(takePhotos2.getTransmitFrom());
		}

		List<UserInfo> userInfos = getUserInfosFromUserIds(userIds);
		List<UserInfo> beAtManUserInfos = getUserInfosFromUserIds(beAtUserIds);
		List<UserDetailInfo> userDetailInfos = getUserDetailInfosFromUserInfos(userInfos);
		int lastNum = 0;
		if (takePhotos.size() > 0) {
			lastNum = takePhotos.get(takePhotos.size() - 1).getId();
		}

		RefreshPhotosJsonObject refreshPhotosJsonObject = new RefreshPhotosJsonObject(
				takePhotos, userInfos, beAtManUserInfos, userDetailInfos,
				lastNum);

		outToClient(refreshPhotosJsonObject);
	}

	/**
	 * 响应操作:刷新我要玩
	 * 
	 */
	public void refreshPlays() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		double lng = jsonObject.getDouble1();
		double lat = jsonObject.getDouble2();
		double distance = jsonObject.getDouble3();

		List<Plays> plays = playsDAO.getNearDatas(lng, lat, distance, "", 0,
				10, false);

		List<Integer> userIds = new ArrayList<Integer>();
		for (Plays play : plays) {
			userIds.add(play.getUserId());
		}

		List<UserInfo> userInfos = getUserInfosFromUserIds(userIds);

		int lastNum = 0;
		if (plays.size() > 0) {
			lastNum = ((Plays) plays.get(plays.size() - 1)).getId();
		}

		RefreshPlaysJsonObject refreshPhotosJsonObject = new RefreshPlaysJsonObject(
				plays, userInfos, lastNum);
		outToClient(refreshPhotosJsonObject);
	}

	/**
	 * 响应操作:刷新心愿墙
	 * 
	 */
	public void refreshWish() {
		System.out.println("refreshWish");
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		double lng = jsonObject.getDouble1();
		double lat = jsonObject.getDouble2();
		double distance = jsonObject.getDouble3();

		List<Wish> wishs = wishDAO.getNearDatas(lng, lat, distance, "", 0, 10,
				false);
		List<Integer> userIds = new ArrayList<Integer>();
		for (Wish wish : wishs)
			userIds.add(wish.getUserId());

		List<UserInfo> userInfos = getUserInfosFromUserIds(userIds);

		int lastNum = 0;
		if (wishs.size() > 0) {
			lastNum = wishs.get(wishs.size() - 1).getId();
		}
		List<UserDetailInfo> userDetailInfos = getUserDetailInfosFromUserInfos(userInfos);
		RefreshWishJsonObject jsonObjectSend = new RefreshWishJsonObject(wishs,
				userInfos, userDetailInfos, lastNum);
		outToClient(jsonObjectSend);
	}

	/**
	 * 响应操作:刷新心愿墙
	 * 
	 */
	public void refreshWishNew() {
		System.out.println("refreshWish");
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		double lng = jsonObject.getDouble1();
		double lat = jsonObject.getDouble2();
		double distance = jsonObject.getDouble3();

		List<Wish> wishs = wishDAO.getNearDatas(lng, lat, distance, "", 0, 10,
				false);
		List<Integer> userIds = new ArrayList<Integer>();
		List<WishWithWannaNum> wishList = new ArrayList<WishWithWannaNum>();

		for (Wish wish : wishs) {
			userIds.add(wish.getUserId());
			int n = wishPickersDao.getPickerCount(wish.getId());
			WishWithWannaNum wishWithWannaNum = new WishWithWannaNum(wish.getId(),
					wish.getUserId(), wish.getContent(), wish.getAuth(),
					wish.getTime(), wish.getLng(), wish.getLat(),
					wish.getFlowerNum(), wish.getCommentNum(), n,
					wish.getSolveId(), wish.getImageUrl());
			wishList.add(wishWithWannaNum);
		}
		List<UserInfo> userInfos = getUserInfosFromUserIds(userIds);

		int lastNum = 0;
		if (wishs.size() > 0) {
			lastNum = wishs.get(wishs.size() - 1).getId();
		}
		List<UserDetailInfo> userDetailInfos = getUserDetailInfosFromUserInfos(userInfos);

		RefreshWishJsonObject jsonObjectSend = new RefreshWishJsonObject(
				userInfos, userDetailInfos, lastNum, wishList);
		outToClient(jsonObjectSend);
	}

	/**
	 * 响应操作:GetMore心愿墙
	 * 
	 */
	public void getMoreWish() {
		System.out.println("getmorewish");
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		double lng = jsonObject.getDouble1();
		double lat = jsonObject.getDouble2();
		double distance = jsonObject.getDouble3();

		int start = jsonObject.getInt1();

		List<Wish> wishs = wishDAO.getNearDatas(lng, lat, distance, "", start,
				10, true);

		List<Integer> userIds = new ArrayList<Integer>();
		for (Wish wish : wishs)
			userIds.add(wish.getUserId());

		List<UserInfo> userInfos = getUserInfosFromUserIds(userIds);

		int lastNum = start;
		if (wishs.size() > 0) {
			lastNum = wishs.get(wishs.size() - 1).getId();
		}
		List<UserDetailInfo> userDetailInfos = getUserDetailInfosFromUserInfos(userInfos);
		RefreshWishJsonObject jsonObjectSend = new RefreshWishJsonObject(wishs,
				userInfos, userDetailInfos, lastNum);
		outToClient(jsonObjectSend);
	}

	/**
	 * 响应操作:GetMore心愿墙
	 * 
	 */
	public void getMoreWishNew() {
		System.out.println("getmorewish");
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		double lng = jsonObject.getDouble1();
		double lat = jsonObject.getDouble2();
		double distance = jsonObject.getDouble3();

		int start = jsonObject.getInt1();

		List<Wish> wishs = wishDAO.getNearDatas(lng, lat, distance, "", start,
				10, true);
		List<Integer> userIds = new ArrayList<Integer>();
		List<WishWithWannaNum> wishList = new ArrayList<WishWithWannaNum>();

		for (Wish wish : wishs) {
			userIds.add(wish.getUserId());
			int n = wishPickersDao.getPickerCount(wish.getId());
			WishWithWannaNum wishWithWannaNum = new WishWithWannaNum(wish.getId(),
					wish.getUserId(), wish.getContent(), wish.getAuth(),
					wish.getTime(), wish.getLng(), wish.getLat(),
					wish.getFlowerNum(), wish.getCommentNum(), n,
					wish.getSolveId(), wish.getImageUrl());
			wishList.add(wishWithWannaNum);
		}

		List<UserInfo> userInfos = getUserInfosFromUserIds(userIds);

		int lastNum = start;
		if (wishs.size() > 0) {
			lastNum = wishs.get(wishs.size() - 1).getId();
		}
		List<UserDetailInfo> userDetailInfos = getUserDetailInfosFromUserInfos(userInfos);
		RefreshWishJsonObject jsonObjectSend = new RefreshWishJsonObject(
				userInfos, userDetailInfos, lastNum, wishList);
		outToClient(jsonObjectSend);
	}

	/**
	 * 响应操作:GetMore我要拍
	 * 
	 */
	public void getMorePhotos() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		double lng = jsonObject.getDouble1();
		double lat = jsonObject.getDouble2();
		double distance = jsonObject.getDouble3();
		String sex = jsonObject.getString1();

		int start = jsonObject.getInt1();

		List<TakePhotos> takePhotos = takePhotosDAO.getNearPhotos(lng, lat,
				sex, distance, start, 10, true);

		List<Integer> userIds = new ArrayList<Integer>();
		List<Integer> beAtUserIds = new ArrayList<Integer>();
		for (TakePhotos takePhotos2 : takePhotos) {
			userIds.add(takePhotos2.getUserId());
			beAtUserIds.add(takePhotos2.getTransmitFrom());
		}

		List<UserInfo> userInfos = getUserInfosFromUserIds(userIds);
		List<UserInfo> beAtManUserInfos = getUserInfosFromUserIds(beAtUserIds);
		List<UserDetailInfo> userDetailInfos = getUserDetailInfosFromUserInfos(userInfos);
		int lastNum = start;
		if (takePhotos.size() > 0) {
			lastNum = takePhotos.get(takePhotos.size() - 1).getId();
		}

		RefreshPhotosJsonObject refreshPhotosJsonObject = new RefreshPhotosJsonObject(
				takePhotos, userInfos, beAtManUserInfos, userDetailInfos,
				lastNum);

		outToClient(refreshPhotosJsonObject);
	}

	/**
	 * 响应操作:GetMore我要玩
	 * 
	 */
	public void getMorePlays() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		double lng = jsonObject.getDouble1();
		double lat = jsonObject.getDouble2();
		double distance = jsonObject.getDouble3();
		int start = jsonObject.getInt1();

		List<Plays> plays = playsDAO.getNearDatas(lng, lat, distance, "",
				start, 10, true);

		List<Integer> userIds = new ArrayList<Integer>();
		for (Plays play : plays) {
			userIds.add(play.getUserId());
		}

		List<UserInfo> userInfos = getUserInfosFromUserIds(userIds);

		int lastNum = start;
		if (plays.size() > 0) {
			lastNum = plays.get(plays.size() - 1).getId();
		}

		RefreshPlaysJsonObject refreshPhotosJsonObject = new RefreshPlaysJsonObject(
				plays, userInfos, lastNum);
		outToClient(refreshPhotosJsonObject);
	}

	/**
	 * 响应操作:转发我要拍
	 * 
	 */
	public void transmitPhotos() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int photosId = jsonObject.getInt1();
		int transmitorId = jsonObject.getInt2();// 转发者ID
		double lng = jsonObject.getDouble1();
		double lat = jsonObject.getDouble2();
		long time = jsonObject.getLong1();
		String content = jsonObject.getString1();

		TakePhotos takePhotos = (TakePhotos) takePhotosDAO.findByProperty(
				TakePhotosDAO.ID, photosId).get(0);
		int oritransNum = takePhotos.getTransmitNum();
		String oritime = takePhotos.getTime();
		takePhotos.setTransmitNum(oritransNum + 1);
		takePhotosDAO.update(takePhotos);
		int ownerId = takePhotos.getUserId();// 主人的ID
		int photoId = takePhotos.getId();

		takePhotos.setId(0);
		takePhotos.setContent(content);
		if (takePhotos.getTransmitFrom() == -1)// 这个人是最初的主人
			takePhotos.setTransmitFrom(ownerId);
		takePhotos.setUserId(transmitorId);
		takePhotos.setTime(time + "");
		if (takePhotos.getTransmitId() == -1)
			takePhotos.setTransmitId(photoId);
		takePhotos.setLng(lng);
		takePhotos.setLat(lat);
		takePhotos.setCommentNum(0);
		takePhotos.setTransmitNum(0);
		// 给主人发送通知
		notificationDAO.save(new Notification(photosId, transmitorId, ownerId,
				time, NotificationType.PHOTO_TRANSMIT_WAIT));

		takePhotosDAO.save(takePhotos);

		Mood oriMood = moodDAO.findByProperty(MoodDAO.TIME, oritime).get(0);
		oriMood.setTransmitNum(oriMood.getTransmitNum() + 1);
		moodDAO.update(oriMood);

		Mood mood = new Mood();
		mood.setCommentNum(takePhotos.getCommentNum());
		mood.setContent(takePhotos.getContent());
		mood.setFlag(Constant.MOOD_FLAG_PHOTO);
		mood.setTransmitFrom(takePhotos.getTransmitFrom());
		mood.setTransmitId(takePhotos.getTransmitId());
		mood.setTransmitNum(0);
		mood.setImageUrl(takePhotos.imageUrl);
		mood.setLat(takePhotos.getLat());
		mood.setLng(takePhotos.getLng());
		mood.setPraiseNum(takePhotos.getPraiseNum());
		mood.setTime(takePhotos.getTime());
		mood.setUserId(takePhotos.getUserId());
		moodDAO.save(mood);
	}

	/**
	 * 响应操作:评论我要拍
	 * 
	 */
	public void commentPhotos() {
		getClientData();
		TakePhotosComment takePhotosComment = JacksonUtil.json()
				.fromJsonToObject(data, TakePhotosComment.class);
		takePhotosCommentDAO.save(takePhotosComment);
		// 发送通知
		int photosId = takePhotosComment.getPhotoId();

		TakePhotos photo = (TakePhotos) takePhotosDAO.findByProperty(
				TakePhotosDAO.ID, photosId).get(0);
		photo.setCommentNum(photo.getCommentNum() + 1);
		takePhotosDAO.update(photo);
		Mood mood = moodDAO.findByProperty(MoodDAO.TIME, photo.getTime())
				.get(0);
		mood.setCommentNum(photo.getCommentNum());
		moodDAO.update(mood);

		int ownerId = photo.getUserId();// 主人
		int noticeUserId = takePhotosComment.getUserId();// 评论者
		int noticedUserId = takePhotosComment.getCommentedUserId();// 当回复评论时此项用来存放Comment的Id
																	// 被评论者

		int beCommentedManId = -1;

		if (noticedUserId != -1) {
			TakePhotosComment comment = (TakePhotosComment) takePhotosCommentDAO
					.findByProperty(TakePhotosCommentDAO.ID, noticedUserId)
					.get(0);
			beCommentedManId = comment.getUserId();
		}
		long time = Long.parseLong(takePhotosComment.getTime());

		if (noticedUserId == -1) {// 仅回复Need或Pourlisten
			if (noticeUserId != ownerId) // 给主人发送通知
				notificationDAO.save(new Notification(photosId, noticeUserId,
						ownerId, time, NotificationType.PHOTO_COMMENT_WAIT));

		} else {// 对评论的回复
			if (noticeUserId != ownerId) {
				notificationDAO.save(new Notification(photosId, noticeUserId,
						beCommentedManId, time,
						NotificationType.PHOTO_COMMENT_WAIT));
				if (noticeUserId != ownerId && noticeUserId != beCommentedManId)
					notificationDAO.save(new Notification(photosId,
							noticeUserId, ownerId, time,
							NotificationType.PHOTO_COMMENT_WAIT));
			}
		}
		outToClient(true);
	}

	/**
	 * 响应操作:评论我要拍
	 * 
	 */
	public void commentMood() {
		getClientData();
		MoodComment moodComment = JacksonUtil.json().fromJsonToObject(data,
				MoodComment.class);
		moodCommentDAO.save(moodComment);
		// 发送通知
		int moodid = moodComment.getMoodId();

		Mood mood = (Mood) moodDAO.findByProperty(MoodDAO.ID, moodid).get(0);
		mood.setCommentNum(mood.getCommentNum() + 1);
		moodDAO.update(mood);

		int ownerId = mood.getUserId();// 主人
		int noticeUserId = moodComment.getUserId();// 评论者
		int noticedUserId = moodComment.getCommentedUserId();// 当回复评论时此项用来存放Comment的Id
																// 被评论者
		int beCommentedManId = moodComment.getCommentedUserId();
		long time = Long.parseLong(moodComment.getTime());

		if (noticedUserId == -1) {// 仅回复Need或Pourlisten
			if (noticeUserId != ownerId) // 给主人发送通知
				notificationDAO.save(new Notification(moodid, noticeUserId,
						ownerId, time, NotificationType.MOOD_COMMENT_WAIT));

		} else {// 对评论的回复
			if (noticeUserId != ownerId) {
				notificationDAO.save(new Notification(moodid, noticeUserId,
						beCommentedManId, time,
						NotificationType.MOOD_COMMENT_WAIT));
				if (noticeUserId != ownerId && noticeUserId != beCommentedManId)
					notificationDAO.save(new Notification(moodid, noticeUserId,
							ownerId, time, NotificationType.MOOD_COMMENT_WAIT));
			}
		}
		outToClient(true);
	}

	/**
	 * 响应操作:评论我要玩
	 * 
	 */
	public void commentPlays() {
		getClientData();
		PlaysComment playsComment = JacksonUtil.json().fromJsonToObject(data,
				PlaysComment.class);
		playsCommentDAO.save(playsComment);

		// 发送通知
		int playId = playsComment.getPlaysId();

		Plays play = playsDAO.findByProperty(TakePhotosDAO.ID, playId).get(0);
		play.setCommentNum(play.getCommentNum() + 1);
		playsDAO.update(play);

		int ownerId = play.getUserId();// 主人
		int noticeUserId = playsComment.getUserId();// 评论者
		int noticedUserId = playsComment.getCommentedUserId();// 当回复评论时此项用来存放Comment的Id
																// 被评论者

		int beCommentedManId = -1;

		if (noticedUserId != -1) {
			PlaysComment comment = (PlaysComment) playsCommentDAO
					.findByProperty(TakePhotosCommentDAO.ID, noticedUserId)
					.get(0);
			beCommentedManId = comment.getUserId();
		}
		long time = Long.parseLong(playsComment.getTime());

		if (noticedUserId == -1) {// 仅回复Need或Pourlisten
			if (noticeUserId != ownerId) // 给主人发送通知
				notificationDAO.save(new Notification(playId, noticeUserId,
						ownerId, time, NotificationType.PLAY_COMMENT_WAIT));

		} else {// 对评论的回复
			if (noticeUserId != ownerId) {
				notificationDAO.save(new Notification(playId, noticeUserId,
						beCommentedManId, time,
						NotificationType.PLAY_COMMENT_WAIT));
				if (noticeUserId != ownerId && noticeUserId != beCommentedManId)
					notificationDAO.save(new Notification(playId, noticeUserId,
							ownerId, time, NotificationType.PLAY_COMMENT_WAIT));
			}
		}
		outToClient(true);
	}

	/**
	 * 响应操作:评论女生心愿墙
	 * 
	 */
	public void commentWish() {
		getClientData();
		WishComment wishComment = JacksonUtil.json().fromJsonToObject(data,
				WishComment.class);
		wishCommentDAO.save(wishComment);

		// 发送通知
		int wishId = wishComment.getWishId();

		Wish wish = (Wish) wishDAO.findByProperty(WishDAO.ID, wishId).get(0);
		wish.setCommentNum(wish.getCommentNum() + 1);
		wishDAO.update(wish);

		int ownerId = wish.getUserId();// 主人
		int noticeUserId = wishComment.getUserId();// 评论者
		int noticedUserId = wishComment.getCommentedUserId();// 当回复评论时此项用来存放Comment的Id
																// 被评论者

		int beCommentedManId = -1;

		if (noticedUserId != -1) {
			WishComment comment = (WishComment) wishCommentDAO.findByProperty(
					WishCommentDAO.USERID, noticedUserId).get(0);
			beCommentedManId = comment.getUserId();
		}
		long time = Long.parseLong(wishComment.getTime());

		if (noticedUserId == -1) {// 仅回复Need或Pourlisten
			if (noticeUserId != ownerId) // 给主人发送通知
				notificationDAO.save(new Notification(wishId, noticeUserId,
						ownerId, time, NotificationType.WISH_COMMENT_WAIT));

		} else {// 对评论的回复
			if (noticeUserId != ownerId) {
				notificationDAO.save(new Notification(wishId, noticeUserId,
						beCommentedManId, time,
						NotificationType.WISH_COMMENT_WAIT));
				if (noticeUserId != ownerId && noticeUserId != beCommentedManId)
					notificationDAO.save(new Notification(wishId, noticeUserId,
							ownerId, time, NotificationType.WISH_COMMENT_WAIT));
			}
		}
		outToClient(true);
	}

	/**
	 * 响应操作:报名我要玩
	 * 
	 */
	public void participate() {
		getClientData();
		PlaysParticipant object = JacksonUtil.json().fromJsonToObject(data,
				PlaysParticipant.class);

		int ownerId = object.getOwner();
		int playId = object.getPlaysId();
		int userId = object.getUserId();
		Long time = new Date().getTime();

		if (playsParticipantDAO.isExist(userId, playId))// 判断是否已参加
		{
			outToClient(false);
			return;
		}
		playsParticipantDAO.save(object);

		// 更新参加人数
		Plays play = playsDAO.findByProperty(PlaysDAO.ID, playId).get(0);
		play.setJoinNum(play.getJoinNum() + 1);
		playsDAO.update(play);

		// 给发起者发通知
		notificationDAO.save(new Notification(playId, userId, ownerId, time,
				NotificationType.PARTICIPATE_WAIT));

		List<PlaysParticipant> participants = playsParticipantDAO
				.findByProperty(PlaysParticipantDAO.PLAYSID, playId);

		for (PlaysParticipant participant : participants)// 给每个已报名成员发通知
		{
			if (participant.getUserId() != userId)
				notificationDAO.save(new Notification(playId, userId,
						participant.getUserId(), time,
						NotificationType.PARTICIPATE_WAIT));
		}
		outToClient(true);
	}

	/**
	 * 响应操作:我要拍点赞
	 * 
	 */
	public void photoPraise() {
		getClientData();
		TakePhotosPraise takePhotosPraise = JacksonUtil.json()
				.fromJsonToObject(data, TakePhotosPraise.class);
		takePhotosPraiseDAO.save(takePhotosPraise);

		int photoId = takePhotosPraise.getPhotoId();
		int senderId = takePhotosPraise.getUserId();
		int beSenderId = takePhotosPraise.getPraisedUserId();
		Long time = new Date().getTime();

		// 点赞数增加
		TakePhotos photo = (TakePhotos) takePhotosDAO.findByProperty(
				TakePhotosDAO.ID, photoId).get(0);
		int resnum = photo.getPraiseNum() + 1;
		photo.setPraiseNum(resnum);
		takePhotosDAO.update(photo);

		Mood mood = moodDAO.findByProperty(MoodDAO.TIME, photo.getTime())
				.get(0);
		mood.setPraiseNum(resnum);
		moodDAO.update(mood);

		int transmitFrom = photo.getTransmitId();
		if (transmitFrom != -1)// 这条PHOTO是被转发的
		{
			TakePhotos photo2 = (TakePhotos) takePhotosDAO.findByProperty(
					TakePhotosDAO.ID, transmitFrom).get(0);
			beSenderId = photo2.getUserId();
			photo2.setPraiseNum(photo.getPraiseNum() + 1);
			praise(senderId, beSenderId, photoId, time,
					NotificationType.PHOTO_PRAISE_WAIT);
		} else {
			praise(senderId, beSenderId, photoId, time,
					NotificationType.PHOTO_PRAISE_WAIT);
		}

	}

	/**
	 * 响应操作:我要拍点赞
	 * 
	 */
	public void moodPraise() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);

		int moodId = jsonObject.getInt1();
		int senderId = jsonObject.getInt2();
		int beSenderId = jsonObject.getInt3();

		Mood mood = moodDAO.findByProperty(MoodDAO.ID, moodId).get(0);

		int resnum = mood.getPraiseNum() + 1;
		mood.setPraiseNum(resnum);
		moodDAO.update(mood);

		outToClient(true);
	}

	/**
	 * 心愿完成
	 * 
	 */
	public void wishComeTrue() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int girlId = jsonObject.getInt1();
		int boyId = jsonObject.getInt2();
		int wishId = jsonObject.getInt3();

		Wish wish = wishDAO.findByProperty(WishDAO.ID, wishId).get(0);
		wish.setSolveId(boyId);
		wishDAO.update(wish);

		notificationDAO.save(new Notification(wishId, boyId, girlId, new Date()
				.getTime(), NotificationType.WISH_ACCEPT_WAIT));
		notificationDAO.save(new Notification(wishId, girlId, boyId, new Date()
				.getTime(), NotificationType.WISH_TO_BOY_WAIT));
		outToClient(true);
	}

	/*
	 * 给心愿点赞
	 */
	public void wishFlower() {
		getClientData();
		WishFlower wishFlower = JacksonUtil.json().fromJsonToObject(data,
				WishFlower.class);
		wishFlowerDAO.save(wishFlower);

		int wishId = wishFlower.getWishId();
		int senderId = wishFlower.getUserId();
		int beSenderId = wishFlower.getPraisedUserId();
		Long time = new Date().getTime();
		// 点赞数增加
		Wish wish = (Wish) wishDAO.findByProperty(WishDAO.ID, wishId).get(0);
		wish.setFlowerNum(wish.getFlowerNum() + 1);
		wishDAO.update(wish);

		notificationDAO.save(new Notification(wishId, senderId, beSenderId,
				time, NotificationType.PHOTO_PRAISE_WAIT));
		outToClient(true);
	}

	/*
	 * 显示Photo详细信息
	 */
	public void showPhotoDetail() {
		getClientData();
		int photoId = JacksonUtil.json().fromJsonToObject(data, Integer.class);

		TakePhotos takePhotos = takePhotosDAO.findByProperty(TakePhotosDAO.ID,
				photoId).get(0);
		UserInfo myUserInfo = userInfoDAO.findByProperty(UserInfoDAO.USERID,
				takePhotos.getUserId()).get(0);
		List<TakePhotosComment> photosComments = takePhotosCommentDAO
				.findByProperty(TakePhotosCommentDAO.PHOTOID, photoId);

		List<Integer> userIds = new ArrayList<Integer>();
		for (TakePhotosComment comment : photosComments)
			userIds.add(comment.getUserId());
		List<UserInfo> commentUserInfos = getUserInfosFromUserIds(userIds);
		UserDetailInfo userDetailInfo = userDetailInfoDAO.findByProperty(
				UserDetailInfoDAO.USERID, takePhotos.getUserId()).get(0);
		int atWhoId = takePhotos.getTransmitFrom();
		UserInfo atWho;
		List<UserInfo> atWhos = userInfoDAO.findByProperty(UserInfoDAO.USERID,
				atWhoId);
		if (atWhos.size() == 0)
			atWho = new UserInfo();
		else
			atWho = atWhos.get(0);

		List<UserLocation> commUserLocations = getUserLocationsFromUserInfos(commentUserInfos);
		DetailPhotosJsonObject detailPhotosJsonObject = new DetailPhotosJsonObject(
				takePhotos, myUserInfo, photosComments, commentUserInfos,
				commUserLocations, userDetailInfo, atWho);
		outToClient(detailPhotosJsonObject);
	}

	/*
	 * 显示Photo详细信息
	 */
	public void showMoodDetail() {
		getClientData();
		int moodId = JacksonUtil.json().fromJsonToObject(data, Integer.class);

		Mood mood = moodDAO.findByProperty(MoodDAO.ID, moodId).get(0);
		UserInfo myUserInfo = userInfoDAO.findByProperty(UserInfoDAO.USERID,
				mood.getUserId()).get(0);
		List<MoodComment> moodComments = moodCommentDAO.findByProperty(
				MoodCommentDAO.MOODID, moodId);

		List<Integer> userIds = new ArrayList<Integer>();
		for (MoodComment comment : moodComments)
			userIds.add(comment.getUserId());
		List<UserInfo> commentUserInfos = getUserInfosFromUserIds(userIds);
		UserDetailInfo userDetailInfo = userDetailInfoDAO.findByProperty(
				UserDetailInfoDAO.USERID, mood.getUserId()).get(0);

		List<UserLocation> commUserLocations = getUserLocationsFromUserInfos(commentUserInfos);
		DetailMoodJsonObject detailPhotosJsonObject = new DetailMoodJsonObject(
				mood, myUserInfo, moodComments, commentUserInfos,
				commUserLocations, userDetailInfo);
		outToClient(detailPhotosJsonObject);
	}

	/*
	 * 显示Plays详细信息
	 */
	public void showPlayDetail() {
		getClientData();
		int playId = JacksonUtil.json().fromJsonToObject(data, Integer.class);

		Plays play = playsDAO.findByProperty(PlaysDAO.ID, playId).get(0);
		UserInfo myUserInfo = userInfoDAO.findByProperty(UserInfoDAO.USERID,
				play.getUserId()).get(0);
		List<PlaysComment> comments = playsCommentDAO.findByProperty(
				PlaysCommentDAO.PLAYSID, playId);

		List<Integer> userIds = new ArrayList<Integer>();
		for (PlaysComment comment : comments)
			userIds.add(comment.getUserId());
		List<UserInfo> commentUserInfos = getUserInfosFromUserIds(userIds);

		List<Integer> members = new ArrayList<Integer>();// 所有已报名成员的USERID
		List<PlaysParticipant> participants = playsParticipantDAO
				.findByProperty(PlaysParticipantDAO.PLAYSID, playId);
		for (PlaysParticipant participant : participants)
			members.add(participant.getUserId());

		List<UserLocation> commuserLocations = getUserLocationsFromUserInfos(commentUserInfos);

		DetailPlaysJsonObject detailPlaysJsonObject = new DetailPlaysJsonObject(
				play, myUserInfo, comments, commentUserInfos,
				commuserLocations, members);
		outToClient(detailPlaysJsonObject);
	}

	/*
	 * 显示Wish详细信息
	 */
	public void showWishDetail() {
		getClientData();
		int wishId = JacksonUtil.json().fromJsonToObject(data, Integer.class);

		Wish wish = wishDAO.findByProperty(WishDAO.ID, wishId).get(0);
		UserInfo myUserInfo = userInfoDAO.findByProperty(UserInfoDAO.USERID,
				wish.getUserId()).get(0);
		List<WishComment> comments = wishCommentDAO.findByProperty(
				WishCommentDAO.WISHID, wishId);

		List<Integer> userIds = new ArrayList<Integer>();
		for (WishComment comment : comments)
			userIds.add(comment.getUserId());
		List<UserInfo> commentUserInfos = getUserInfosFromUserIds(userIds);
		List<UserLocation> commUserLocations = getUserLocationsFromUserInfos(commentUserInfos);
		UserDetailInfo userDetailInfo = userDetailInfoDAO.findByProperty(
				UserDetailInfoDAO.USERID, myUserInfo.getUserId()).get(0);
		DetailWishJsonObject detailWishJsonObject = new DetailWishJsonObject(
				wish, myUserInfo, comments, commentUserInfos,
				commUserLocations, userDetailInfo);
		outToClient(detailWishJsonObject);
	}

	/*
	 * 加入起床困难户行列
	 */
	public void commitWakeUp() {
		getClientData();
		WakeUp wakeUp = JacksonUtil.json().fromJsonToObject(data, WakeUp.class);
		wakeUpDAO.save(wakeUp);
		outToClient(true);
	}

	/*
	 * 起床 匹配
	 */
	public void matchWakeUp() {
		getClientData();
		WakeUpMatchJsonObject jsonObject = JacksonUtil.json().fromJsonToObject(
				data, WakeUpMatchJsonObject.class);
		WakeUp wakeUp = jsonObject.wakeUp;
		wakeUpDAO.save(wakeUp);
		choose(jsonObject);
		// myWakeUp.setPairUserId(pairId);
		// pair.setPairUserId(userId);
		//
		// wakeUpDAO.update(myWakeUp);
		// wakeUpDAO.update(pair);

		// 发送通知
		// notificationDAO.save(new Notification(0, userId, pairId,
		// java.sql.Date.valueOf(wakeUp.getDate()).getTime(),
		// NotificationType.MATCH_OK_WAIT));
		// outToClient(MatchCondition.MATCH_OK);
	}

	/*
	 * 起床 选择
	 */
	public void chooseMatch()// 其实就只是比match少了一步save
	{
		getClientData();
		WakeUpMatchJsonObject jsonObject = JacksonUtil.json().fromJsonToObject(
				data, WakeUpMatchJsonObject.class);
		choose(jsonObject);
	}

	/*
	 * 起床 确认关系
	 */
	public void confirmWakeUp() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int userId = jsonObject.getInt1();
		int pairId = jsonObject.getInt2();

		WakeUp myWakeUp = getNewestWakeUp(userId);
		WakeUp pair = getNewestWakeUp(pairId);

		myWakeUp.setPairUserId(pairId);
		pair.setPairUserId(userId);

		wakeUpDAO.update(myWakeUp);
		wakeUpDAO.update(pair);

		// 发送通知
		notificationDAO.save(new Notification(0, userId, pairId, java.sql.Date
				.valueOf(myWakeUp.getDate()).getTime(),
				NotificationType.MATCH_OK_WAIT));
		outToClient(MatchCondition.MATCH_OK);
	}

	/*
	 * 起床 解除关系
	 */
	public void removeWakeUp() {
		getClientData();
		int userId = JacksonUtil.json().fromJsonToObject(data, int.class);
		List<WakeUp> wakeUps = wakeUpDAO.findByProperty(WakeUpDAO.USERID,
				userId);
		Iterator<WakeUp> i = wakeUps.iterator();
		List<WakeUp> oldWakeUps = new ArrayList<WakeUp>();
		while (i.hasNext()) {
			WakeUp wakeUp = i.next();
			if (wakeUp.getPairUserId() <= 0)
				oldWakeUps.add(wakeUp);
		}
		wakeUps.removeAll(oldWakeUps);

		if (wakeUps.size() == 0) {
			outToClient(false);
			return;
		}
		WakeUp wakeUp = wakeUps.get(0);
		int pairId = wakeUp.getPairUserId();
		wakeUp.setPairUserId(wakeUp.getPairUserId() * -1);
		wakeUpDAO.update(wakeUp);
		// 两个人都要更新
		wakeUp = wakeUpDAO.findByProperty(WakeUpDAO.USERID, pairId).get(0);
		wakeUp.setPairUserId(wakeUp.getPairUserId() * -1);
		wakeUpDAO.update(wakeUp);

		outToClient(true);
	}

	public void addChatContact() {
		getClientData();
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
				JsonObject.class);
		int userid = jsonObject.getInt1();
		int contactid = jsonObject.getInt2();
		ArrayList<Contact> list1 = (ArrayList<Contact>) contactDAO.getContacts(
				userid, contactid);
		ArrayList<Contact> list2 = (ArrayList<Contact>) contactDAO.getContacts(
				contactid, userid);
		if (list1 != null && list1.size() > 0) {
			long otime = Long.parseLong(list1.get(list1.size() - 1).time);
			long ntime = Long.parseLong(jsonObject.getString1());
			if (ntime - otime < 3600000) {
				contactDAO.deleteARecord(userid, contactid);
			}
		}
		if (list2 != null && list2.size() > 0) {
			long otime = Long.parseLong(list2.get(list2.size() - 1).time);
			long ntime = Long.parseLong(jsonObject.getString1());
			if (ntime - otime < 3600000) {
				contactDAO.deleteARecord(contactid, userid);
			}
		}
		contactDAO.save(new Contact(contactid, userid, jsonObject.getInt3(),
				jsonObject.getString1()));
		contactDAO.save(new Contact(userid, contactid, jsonObject.getInt3(),
				jsonObject.getString1()));
		outToClient(true);
	}

	/*
	 * 起床 解除关系
	 */
	public void showWakeUp() {
		getClientData();
		int userId = JacksonUtil.json().fromJsonToObject(data, int.class);

		int boyNum = wakeUpDAO.count(WakeUpDAO.BOY);
		int girlNum = wakeUpDAO.count(WakeUpDAO.GIRL);
		int totalNum = wakeUpDAO.count();

		WakeUp wakeUp = null;
		List<WakeUp> wakeUps = wakeUpDAO.findByProperty(WakeUpDAO.USERID,
				userId);
		boolean havePair = false;
		boolean isWait = false;
		for (WakeUp obj : wakeUps)// 包含曾经参与的匹配 需要剔除掉
		{
			if (obj.getPairUserId() > 0)// pairId大于0 则表示已经成功匹配
			{
				havePair = true;
				wakeUp = obj;
			}
			if (obj.getPairUserId() == 0)// pairId为0 则为正在等待
				isWait = true;
		}
		if (!isWait && !havePair)// 不等待不成功就是还没有匹配
		{
			outToClient(new WakeUpJsonObject(boyNum, girlNum, totalNum, 0, 0,
					MatchCondition.NOT_MATCH, "", "", ""));
			return;
		}
		if (isWait) {
			outToClient(new WakeUpJsonObject(boyNum, girlNum, totalNum, 0, 0,
					MatchCondition.MATCH_CHOOSE, "", "", ""));
			return;
		}

		int pairId = wakeUp.getPairUserId();
		WakeUp pairWakeUp = wakeUpDAO.findByProperty(WakeUpDAO.USERID, pairId)
				.get(0);
		String require = pairWakeUp.getAquirement();
		User pairUser = userDAO.findByProperty(UserDAO.ID, pairId).get(0);
		UserInfo pairUserInfo = userInfoDAO.findByProperty(UserInfoDAO.ID,
				pairId).get(0);
		String sex = pairUserInfo.getSex();
		String pairTele = pairUser.getTele();
		outToClient(new WakeUpJsonObject(boyNum, girlNum, totalNum, pairId,
				pairWakeUp.getAuth(), MatchCondition.MATCH_OK, sex, require,
				pairTele));

	}

	/*
	 * 刷新我的联系人
	 */
	public void refreshContact() {
		getClientData();
		int userId = JacksonUtil.json().fromJsonToObject(data, int.class);
		List<UserInfo> recentUserInfos = new ArrayList<UserInfo>();
		List<UserInfo> generalUserInfos = new ArrayList<UserInfo>();

		List<Contact> recentContacts = contactDAO.getRecentContacts(userId, 10);
		List<Contact> generalContacts = contactDAO.getGeneralContacts(userId,
				10);

		for (Contact contact : recentContacts)
			recentUserInfos.add(userInfoDAO.findByProperty(UserInfoDAO.USERID,
					contact.contactId).get(0));
		for (Contact contact : generalContacts)
			generalUserInfos.add(userInfoDAO.findByProperty(UserInfoDAO.USERID,
					contact.contactId).get(0));
		outToClient(new ContactsJsonObject(generalContacts, generalUserInfos,
				recentContacts, recentUserInfos));
	}

	/*
	 * 开始调戏
	 */
	public void commitMolest() {
		System.out.println("Commit Molest Now!");
		getClientData();
		Molest molest = JacksonUtil.json().fromJsonToObject(data, Molest.class);
		molestDAO.save(molest);
		outToClient(true);
	}

	/*
	 * 首次进入显示的Molest
	 */
	public void showMolest() {
		System.out.println("Show Molest Now!");
		getClientData();
		// JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
		// JsonObject.class);
		List<Molest> molests = molestDAO.getLastMolests(20, 0, false);
		List<Integer> userIds = new ArrayList<Integer>();
		List<Integer> commetedUserIds = new ArrayList<Integer>();
		for (Molest molest : molests) {
			userIds.add(molest.userId);
			commetedUserIds.add(molest.commentedUserId);
		}
		List<UserInfo> userInfos = getUserInfosFromUserIds(userIds);
		List<UserInfo> commentedUserInfos = getUserInfosFromUserIds(commetedUserIds);

		int lastNum = 0;
		if (molests.size() != 0)
			lastNum = molests.get(molests.size() - 1).mid;
		outToClient(new MolestJsonObject(molests, userInfos,
				commentedUserInfos, lastNum));

	}

	/*
	 * 上拉加载更多Molest
	 */
	public void getMoreMolest() {
		System.out.println("Get More Molest Now!");
		getClientData();
		// JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(data,
		// JsonObject.class);
		int lastNum = JacksonUtil.json().fromJsonToObject(data, int.class);
		List<Molest> molests = molestDAO.getLastMolests(20, lastNum, true);
		if (molests.size() == 0) {
			outToClient(new MolestJsonObject(new ArrayList<Molest>(),
					new ArrayList<UserInfo>(), new ArrayList<UserInfo>(),
					lastNum));
			return;
		}
		List<Integer> userIds = new ArrayList<Integer>();
		List<Integer> commetedUserIds = new ArrayList<Integer>();
		for (Molest molest : molests) {
			userIds.add(molest.userId);
			commetedUserIds.add(molest.commentedUserId);
		}
		List<UserInfo> userInfos = getUserInfosFromUserIds(userIds);
		List<UserInfo> commentedUserInfos = getUserInfosFromUserIds(commetedUserIds);

		if (molests.size() != 0)
			lastNum = molests.get(molests.size() - 1).mid;
		outToClient(new MolestJsonObject(molests, userInfos,
				commentedUserInfos, lastNum));

	}

	/*
	 * 请求加入被调戏行列...
	 */
	public void applyMolest() {
		getClientData();
		int userId = JacksonUtil.json().fromJsonToObject(data, int.class);
		UserInfo userInfo = userInfoDAO.findByProperty(UserInfoDAO.USERID,
				userId).get(0);
		userInfo.flag = UserFlag.MOLEST;
		userInfoDAO.update(userInfo);
		outToClient(true);
	}

	// 起床 匹配
	public void choose(WakeUpMatchJsonObject jsonObject) {
		double lng = jsonObject.lng;
		double lat = jsonObject.lat;
		WakeUp wakeUp = jsonObject.wakeUp;
		String scope = wakeUp.getScope();
		String sex = wakeUp.getSex();
		int userId = wakeUp.getUserId();

		double distance = 3000;
		String sexMatch;
		if (sex.equals("男"))
			sexMatch = "女";
		else
			sexMatch = "男";
		List<WakeUp> wakeUps = wakeUpDAO.match(lng, lat, distance, sexMatch,
				userId);
		if (wakeUps.size() == 0) {
			outToClient(new WakeUpMatchJsonObject(new WakeUp(), "",
					MatchCondition.MATCHING, 0, 0));
			// outToClient(MatchCondition.MATCHING);
			return;
		}
		int size = wakeUps.size();
		int random;
		if (size == 1)
			random = 0;
		else
			random = new Random(new Date().getTime()).nextInt(size);
		int pairId = wakeUps.get(random).getUserId();// 匹配到的对象的Id
		// WakeUp myWakeUp = getNewestWakeUp(userId);
		WakeUp pair = getNewestWakeUp(pairId);
		User pairUser = userDAO.findByProperty(UserDAO.ID, pairId).get(0);
		String tele = pairUser.getTele();

		outToClient(new WakeUpMatchJsonObject(pair, tele,
				MatchCondition.MATCH_CHOOSE, 0, 0));
	}

	public WakeUp getNewestWakeUp(int userId) {
		List<WakeUp> wakeUps = // 匹配到的这个人的所有记录
		wakeUpDAO.findByProperty(WakeUpDAO.USERID, userId);
		List<WakeUp> oldRecord = new ArrayList<WakeUp>();// 以前的老记录
		for (WakeUp obj : wakeUps)
			if (obj.getPairUserId() < 0)
				oldRecord.add(obj);
		wakeUps.removeAll(oldRecord);
		if (wakeUps.size() == 0)
			return null;
		WakeUp wakeUp = wakeUps.get(0);
		return wakeUp;
	}

	// 增加人气和人气榜数据
	public void praise(int senderId, int beSenderId, int eventId, Long time,
			int flag) {
		notificationDAO.save(new Notification(eventId, senderId, beSenderId,
				time, flag));
		UserInfo userInfo = (UserInfo) userInfoDAO.findByProperty(
				UserInfoDAO.USERID, beSenderId).get(0);
		userInfo.setPopularityNum(userInfo.getPopularityNum() + 1);
		userInfoDAO.update(userInfo);

		LovePopularityIncrease increase = (LovePopularityIncrease) lovePopularityIncreaseDAO
				.findByProperty(LovePopularityIncreaseDAO.USERID, beSenderId)
				.get(0);
		increase.setOldPopularityNum(userInfo.getPopularityNum());
		increase.setIncreasePopularityNum(increase.getIncreasePopularityNum() + 1);
		lovePopularityIncreaseDAO.update(increase);
	}

	// 文件复制 s to t
	public void fileChannelCopy(File s, File t) {

		FileInputStream fi = null;

		FileOutputStream fo = null;

		FileChannel in = null;

		FileChannel out = null;

		try {

			fi = new FileInputStream(s);

			fo = new FileOutputStream(t);

			in = fi.getChannel();// 得到对应的文件通道

			out = fo.getChannel();// 得到对应的文件通道

			in.transferTo(0, in.size(), out);// 连接两个通道，并且从in通道读取，然后写入out通道

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				fi.close();

				in.close();

				fo.close();

				out.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}

	/**
	 * 响应操作:通过userId得到UserInfo
	 */
	public void getUserInfoFromUserId() {
		getClientData();
		int userId = JacksonUtil.json().fromJsonToObject(data, int.class);
		UserInfo userInfo = (UserInfo) userInfoDAO.findByProperty(
				UserInfoDAO.USERID, userId).get(0);
		outToClient(userInfo);
	}

	private List<UserInfo> getSolveUserInfosFromNeeds(List<Need> needs) {
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		for (Need need : needs) {
			if (need.getSolveId() != -1) {
				userInfos.add((UserInfo) userInfoDAO.findByProperty(
						UserInfoDAO.USERID, need.getSolveId()).get(0));
			} else {
				userInfos.add(new UserInfo());
			}
		}
		return userInfos;
	}

	private List<UserInfo> getUserInfosFromNeeds(List<Need> needs) {
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		for (Need need : needs) {
			userInfos.add((UserInfo) userInfoDAO.findByProperty(
					UserInfoDAO.USERID, need.getUserId()).get(0));
		}
		return userInfos;
	}

	private List<UserDetailInfo> getUserDetailInfosFromUserInfos(
			List<UserInfo> userInfos) {
		List<UserDetailInfo> userDetailInfos = new ArrayList<UserDetailInfo>();
		for (UserInfo userInfo : userInfos) {
			userDetailInfos.add(userDetailInfoDAO.findByProperty(
					UserDetailInfoDAO.USERID, userInfo.getUserId()).get(0));
		}
		return userDetailInfos;
	}

	private List<UserInfo> getUserInfosFromUserIds(List<Integer> userIds) {
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		for (int userId : userIds) {
			List<UserInfo> objects = userInfoDAO.findByProperty(
					UserInfoDAO.USERID, userId);
			if (objects == null || objects.size() == 0)
				userInfos.add(new UserInfo());
			else
				userInfos.add(objects.get(0));
		}
		return userInfos;
	}

	private List<UserInfo> getUserInfosFromNeedComments(
			List<NeedComment> needComments) {
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		for (NeedComment needComment : needComments) {
			userInfos.add((UserInfo) userInfoDAO.findByProperty(
					UserInfoDAO.USERID, needComment.getUserId()).get(0));
		}
		return userInfos;
	}

	private List<UserLocation> getUserLocationsFromUserInfos(
			List<UserInfo> userInfos) {
		List<UserLocation> userLocations = new ArrayList<UserLocation>();
		for (UserInfo userInfo : userInfos) {
			userLocations.add((UserLocation) userLocationDAO.findByProperty(
					UserLocationDAO.USERID, userInfo.getUserId()).get(0));
		}
		return userLocations;
	}

	// 包含解密过程
	private void getClientData() {
		data = request.getParameter("data");

		if (data.indexOf("EncryptByRSA://") == -1)
			isEncrypt = false;
		else
			isEncrypt = true;

		data = data.replace("EncryptByRSA://", "");
		if (isEncrypt)
			data = Decrypt(data);

		System.out.println("getFromClient:" + data);
	}

	private void outToClient(Object data) {
		// TODO Auto-generated method stub

		PrintWriter out = null;
		try {
			this.response.setContentType("text/html;charset=UTF-8");
			out = this.response.getWriter();
			String jacksonString = JacksonUtil.json().fromObjectToJson(data);
			System.out.println("outToClient:" + jacksonString);
			if (isEncrypt)
				jacksonString = Encrypt(jacksonString);// 加密
			out.write(jacksonString);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 解密
	private String Decrypt(String data) {
		try {
			return RsaKey.Decrypt(data);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 加密
	private String Encrypt(String data) {
		try {
			return RsaKey.Encrypt(data);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
